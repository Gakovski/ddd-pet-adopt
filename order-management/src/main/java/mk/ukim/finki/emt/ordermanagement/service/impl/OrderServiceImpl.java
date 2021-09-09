package mk.ukim.finki.emt.ordermanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.adoptermanagement.domain.exceptions.AdopterNotFoundException;
import mk.ukim.finki.emt.ordermanagement.domain.dto.OrderInfoDtoResponse;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Adopter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;


import mk.ukim.finki.emt.ordermanagement.xport.client.AdopterClient;
import mk.ukim.finki.emt.ordermanagement.xport.client.PetClient;
import mk.ukim.finki.emt.petcatalog.domain.exceptions.PetNotFoundException;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderApproved;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;
    private final PetClient petClient;
    private final AdopterClient adopterClient;

    @Override
    public List<OrderInfoDtoResponse> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderInfoDtoResponse> orderList = new ArrayList();
        for(Order order: orders){
            OrderInfoDtoResponse dto = new OrderInfoDtoResponse();
            Optional<Pet> pet = petClient.findById(order.getPetId());
            pet.ifPresent(dto::setPet);
            Optional<Adopter> adopter = adopterClient.findById(order.getAdopterId());
            adopter.ifPresent(dto::setAdopter);
            dto.setOrderId(order.getId());
            dto.setIsApproved(order.isApproved());
            orderList.add(dto);
        }
        return orderList;
    }

    @Override
    public Order placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm, "Order Form must not be null");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0){
            throw new ConstraintViolationException("The order form is not valid"
                    , constraintViolations);
        }
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
        return newOrder;
    }
    private Order toDomainObject(OrderForm orderForm){
        return new Order(orderForm.getAdopterId(), orderForm.getPetId(), false);
    }

    @Override
    public void deleteOrder(OrderId orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if(!exists){
            throw new IllegalStateException("Order do not exist");
        }
        var order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        orderRepository.deleteById(orderId);
    }

    @Override
    @Transactional
    public void approveOrder(OrderId orderId) {
        Order order = orderRepository.getById(orderId);
        order.approveOrder();

        //sega otkako kje go approveneme orderot koj shto sakame da bide approved
        //treba da gi izbrisheme site ostanati orders koi se napraveni za istoto mileniche

        List<Order> orderList = orderRepository.findAll();

        for (Order orderToBeDeleted : orderList) {
            if (!orderToBeDeleted.isApproved() && orderToBeDeleted.getPetId().equals(order.getPetId())){
                orderRepository.deleteById(orderToBeDeleted.getId());
            }
        }

        //otkakko kje gi izbrisheme site false orders
        //treba da go smenime statusot na posvoenoto mileniche od false vo true(adopted = true)
        //domainEventPublisher.publish(new OrderApproved("e49b4057-582b-42fa-beed-e3b9e6811cdc"));
        domainEventPublisher.publish(new OrderApproved(order.getPetId()));
    }

}

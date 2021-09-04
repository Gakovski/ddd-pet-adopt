package mk.ukim.finki.emt.ordermanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;


//import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderDeleted;
//import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    //private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm, "Order Form must not be null");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0){
            throw new ConstraintViolationException("The order form is not valid"
                    , constraintViolations);
        }
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
        return newOrder.getId();
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
        //domainEventPublisher.publish(new OrderDeleted(order.getPetId().getId()));
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
            if (!orderToBeDeleted.isApproved() && orderToBeDeleted.getPetId().getId().equals(order.getPetId().getId())){
                orderRepository.deleteById(orderToBeDeleted.getId());
            }
        }

    }

}

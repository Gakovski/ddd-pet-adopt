package mk.ukim.finki.emt.ordermanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;

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
//    private final PetRepository petRepository;

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
        return new Order(orderForm.getAdopterId(), orderForm.getPetId());
    }

    @Override
    public void deleteOrder(OrderId orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if(!exists){
            throw new IllegalStateException("Order do not exist");
        }
        orderRepository.deleteById(orderId);
    }

}

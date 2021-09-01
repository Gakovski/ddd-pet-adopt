package mk.ukim.finki.emt.ordermanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermanagement.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderItemForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final Validator validator;

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
        var order = new Order();
        orderForm.getItems().forEach(item->order.addItem(item.getPet(),item.getQuantity()));
        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws
            OrderIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(
                OrderIdNotExistException::new);
        order.addItem(orderItemForm.getPet(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(
                OrderIdNotExistException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }
}

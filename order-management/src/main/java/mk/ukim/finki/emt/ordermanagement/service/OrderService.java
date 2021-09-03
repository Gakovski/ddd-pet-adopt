package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;

import java.util.List;

public interface OrderService {

    OrderId placeOrder(OrderForm orderForm);
    List<Order> findAll();
//    Optional<Order> findById(OrderId orderId);
//
//    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;
//
//    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException,
//            OrderItemIdNotExistException;
}

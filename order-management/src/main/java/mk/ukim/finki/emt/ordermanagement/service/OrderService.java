package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.dto.OrderInfoDtoResponse;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;

import java.util.List;

public interface OrderService {

    Order placeOrder(OrderForm orderForm);
    List<OrderInfoDtoResponse> findAll();
    void deleteOrder(OrderId orderId);
    void approveOrder(OrderId orderId);
}

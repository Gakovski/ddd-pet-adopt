package mk.ukim.finki.emt.ordermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.dto.OrderInfoDtoResponse;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class OrderResource {
    private final OrderService orderService;

    @GetMapping
    public List<OrderInfoDtoResponse> getAll(){
        return orderService.findAll();
    }

    @PostMapping(path = "/added")
    public Order placeOrder (@RequestBody OrderForm orderForm){
       return orderService.placeOrder(orderForm);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder (@PathVariable("orderId")OrderId orderId){
        orderService.deleteOrder(orderId);
    }

    @PutMapping(path = "/approve/{orderId}")
    public void approveOrder(@PathVariable("orderId")OrderId orderId){
        orderService.approveOrder(orderId);
    }
}

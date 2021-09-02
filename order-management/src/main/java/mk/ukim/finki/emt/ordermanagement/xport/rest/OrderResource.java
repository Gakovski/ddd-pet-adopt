package mk.ukim.finki.emt.ordermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.petcatalog.services.forms.PetForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
@AllArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.findAll();
    }

    @PostMapping
    public void placeOrder (@RequestBody OrderForm orderForm){
        orderService.placeOrder(orderForm);
    }

}

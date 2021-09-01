package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

    @Valid
    @NotEmpty
    private List<OrderItemForm> items = new ArrayList<>();
}

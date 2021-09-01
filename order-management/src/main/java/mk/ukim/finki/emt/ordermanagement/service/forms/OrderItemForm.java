package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private Pet pet;

    @Min(1)
    @Max(1)
    private int quantity = 1;
}

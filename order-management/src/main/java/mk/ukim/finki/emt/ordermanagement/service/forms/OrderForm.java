package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.AdopterId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;

import javax.validation.constraints.NotNull;

@Data
public class OrderForm {

    @NotNull
    private AdopterId adopterId;

    @NotNull
    private PetId petId;

}

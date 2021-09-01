package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Pet implements ValueObject {

    private final PetId id;
    private final String name;
    private final Type petType;
    private final int quantity;

    private Pet(){
        this.id=PetId.randomId(PetId.class);
        this.name= "";
        this.petType= new Type();
        this.quantity=0;
    }

    @JsonCreator
    public Pet(PetId id, String name, Type petType, int quantity) {
        this.id = id;
        this.name = name;
        this.petType = petType;
        this.quantity = quantity;
    }
}

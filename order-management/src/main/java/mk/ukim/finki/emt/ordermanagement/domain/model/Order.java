package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.AdopterId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    @AttributeOverride(name="id",
            column = @Column(name = "adopter_id", nullable = false))
    private AdopterId adopterId;

    @AttributeOverride(name="id",
            column = @Column(name = "pet_id",nullable = false))
    private PetId petId;

    private Order(){
        super(OrderId.randomId(OrderId.class));
    }

    public Order(@NonNull AdopterId adopterId, PetId petId) {
        super(OrderId.randomId(OrderId.class));
        this.adopterId = adopterId;
        this.petId = petId;
    }

}

package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.AdopterId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private boolean isApproved;

    @AttributeOverride(name="id",
            column = @Column(name = "adopter_id", nullable = false))
    private String adopterId;

    @AttributeOverride(name="id",
            column = @Column(name = "pet_id",nullable = false))
    private String petId;

    public Order(){
        super(OrderId.randomId(OrderId.class));
    }

    public Order(@NonNull String adopterId, String petId, boolean isApproved) {
        super(OrderId.randomId(OrderId.class));
        this.adopterId = adopterId;
        this.petId = petId;
        this.isApproved = false;
    }

    public void approveOrder(){
        this.isApproved = true;
    }

}

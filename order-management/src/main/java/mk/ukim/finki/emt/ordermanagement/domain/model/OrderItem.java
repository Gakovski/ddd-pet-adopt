package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObject;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name="id",
            column = @Column(name = "pet_id",nullable = false))
    private PetId petId;

    private OrderItem(){
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull PetId petId, @NonNull int quantity){
        super(DomainObjectId.randomId(OrderItemId.class));
        this.petId = petId;
        this.quantity = quantity;
    }

}

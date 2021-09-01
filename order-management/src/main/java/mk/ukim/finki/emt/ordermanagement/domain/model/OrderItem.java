package mk.ukim.finki.emt.ordermanagement.domain.model;

import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity<OrderItemId> {

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name="id",column = @Column(name = "pet_id",nullable = false))
    private PetId petId;

}

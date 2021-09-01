package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private boolean isApproved;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

//    private Order(){
//        super(OrderId.randomId(OrderId.class));
//    }

    //Implement isApproved nekad
    public Order(){
        super(OrderId.randomId(OrderId.class));
    }

    public OrderItem addItem(@NonNull Pet pet, int qty){
        Objects.requireNonNull(pet, "Pet must not be null.");
        var item = new OrderItem(pet.getId(), qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId){
        //Implement isApproved nekogash ovde
        Objects.requireNonNull(orderItemId, "Order Item must not be null.");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }
}

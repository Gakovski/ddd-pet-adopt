package mk.ukim.finki.emt.ordermanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order extends AbstractEntity<OrderId> {

    private boolean isApproved;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    public Order(){

    }
}

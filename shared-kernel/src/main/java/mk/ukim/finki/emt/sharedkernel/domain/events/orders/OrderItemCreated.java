package mk.ukim.finki.emt.sharedkernel.domain.events.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class OrderItemCreated extends DomainEvent {

//    private String petId;
//    private int quantity;
//
//    public OrderItemCreated(String topic){
//        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
//    }
//
//    public OrderItemCreated(String petId, int quantity){
//        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
//        this.petId=petId;
//        this.quantity=quantity;
//    }
}

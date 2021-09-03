package mk.ukim.finki.emt.sharedkernel.domain.events.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class OrderItemRemoved extends DomainEvent {

//    private String petId;
//    private int quantity;
//
//    public OrderItemRemoved(String topic) {
//        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
//    }
//
//    public OrderItemRemoved(String topic, String petId, int quantity){
//        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
//        this.petId=petId;
//        this.quantity=quantity;
//    }
}

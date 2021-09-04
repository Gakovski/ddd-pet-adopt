package mk.ukim.finki.emt.sharedkernel.domain.events.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class OrderApproved extends DomainEvent {

    private final String orderId;

//    private OrderApproved(String topic){
//        super(TopicHolder.TOPIC_ORDER_APPROVED);
//    }

    public OrderApproved(String orderId){
        super(TopicHolder.TOPIC_ORDER_APPROVED);
        this.orderId=orderId;
    }
}

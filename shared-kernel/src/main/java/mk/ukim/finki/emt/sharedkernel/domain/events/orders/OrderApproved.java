package mk.ukim.finki.emt.sharedkernel.domain.events.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class OrderApproved extends DomainEvent {

    private final String orderId;

    public OrderApproved(String orderId){
        super(TopicHolder.TOPIC_ORDER_APPROVED);
        this.orderId = orderId;
    }
}

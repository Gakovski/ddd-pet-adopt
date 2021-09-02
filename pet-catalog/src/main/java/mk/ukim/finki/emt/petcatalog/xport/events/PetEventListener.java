package mk.ukim.finki.emt.petcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetEventListener {

    private final PetService petService;

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "petCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage){
        try{
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage,
                    OrderItemCreated.class);
            petService.orderItemCreated(PetId.of(event.getPetId()), event.getQuantity());
        } catch (Exception e){

        }
    }

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "petCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage){
        try{
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,
                    OrderItemRemoved.class);
            petService.orderItemRemoved(PetId.of(event.getPetId()), event.getQuantity());
        } catch (Exception e){

        }
    }


}

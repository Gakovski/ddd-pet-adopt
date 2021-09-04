package mk.ukim.finki.emt.petcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import mk.ukim.finki.emt.petcatalog.domain.repository.PetRepository;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderApproved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetEventListener {

    private final PetService petService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_APPROVED, groupId = "petCatalog")
    public void consumeOrderApproved(@Payload(required = false) String jsonMessage){
        try{
            OrderApproved event = DomainEvent.fromJson(jsonMessage, OrderApproved.class);
            petService.updatePet(event.getOrderId());
        } catch (Exception e){

        }
    }


}

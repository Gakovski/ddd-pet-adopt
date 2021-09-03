package mk.ukim.finki.emt.petcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import mk.ukim.finki.emt.petcatalog.domain.repository.PetRepository;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderDeleted;

import org.apache.kafka.common.internals.Topic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetEventListener {

    private final PetService petService;
    private final PetRepository petRepository;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_DELETED, groupId = "petCatalog")
    public void consumeOrderDeleted(String jsonMessage){
        try{
            OrderDeleted event = DomainEvent.fromJson(jsonMessage, OrderDeleted.class);
            petService.deletePetAfterOrder(PetId.of(event.getPetId()));
        } catch (Exception e){

        }
    }


}

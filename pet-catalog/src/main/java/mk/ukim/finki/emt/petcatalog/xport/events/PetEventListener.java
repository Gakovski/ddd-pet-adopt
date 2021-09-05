package mk.ukim.finki.emt.petcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetEventListener {

    private final PetService petService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_APPROVED, groupId = "petCatalog")
    public void consumeOrderApproved(String jsonMessage){
        try{
            System.out.println("Topic consumed successfully"); //Prints
            System.out.println(jsonMessage);
            //{"topic":"order-approved","orderId":"e49b4057-582b-42fa-beed-e3b9e6811cdc"}

            String[] split;
            split=jsonMessage.split(",");
            //stringot jsonMessage e podelen na pola kaj shto e zapirkata
            //split[0] = {"topic":"order-approved"
            //split[1] = "orderId":"e49b4057-582b-42fa-beed-e3b9e6811cdc"}

            String[] split2;
            split2=split[1].split(":");
            //stringot split[1] go delime na pola kaj sto ima dve tochk
            //split2[0] = "orderId"
            //split2[1] = "e49b4057-582b-42fa-beed-e3b9e6811cdc"}

            String petId = split2[1].substring(1, split2[1].length()-2);
            //stringot go secheme taka shto kje gi trgneme nepotrebnite karakteri " i "}
            //petId = e49b4057-582b-42fa-beed-e3b9e6811cdc

            System.out.println("Printing event.getOrderId(): "+ petId);
            //Printing event.getOrderId(): e49b4057-582b-42fa-beed-e3b9e6811cdc

            //ne treba ova OrderApproved event = DomainEvent.fromJson(petId, OrderApproved.class);
            petService.updatePet(petId);
            //ne treba ova System.out.println("event.getOrderId(): "+ event.getOrderId());//Doesn't print
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

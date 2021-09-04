package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class PetId extends DomainObjectId {
    public PetId(){
        super(PetId.randomId(PetId.class).getId());
    }

    public PetId(String uuid){
        super(uuid);
    }
}

package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class PetId extends DomainObjectId {
    private PetId(){
        super(PetId.randomId(PetId.class).getId());
    }

    public PetId(String uuid){
        super(uuid);
    }
}

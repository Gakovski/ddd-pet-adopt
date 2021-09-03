package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class AdopterId extends DomainObjectId {
    private AdopterId(){
        super(AdopterId.randomId(AdopterId.class).getId());
    }

    public AdopterId(String uuid){
        super(uuid);
    }
}

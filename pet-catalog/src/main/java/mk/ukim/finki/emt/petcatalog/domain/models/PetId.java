package mk.ukim.finki.emt.petcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class PetId extends DomainObjectId {
    private PetId(){
        super(PetId.randomId(PetId.class).getId());
    }

    public PetId(String uuid){
        super(uuid);
    }
}

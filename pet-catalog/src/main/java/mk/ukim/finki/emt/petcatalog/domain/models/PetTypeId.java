package mk.ukim.finki.emt.petcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class PetTypeId extends DomainObjectId {
    private PetTypeId(){
        super(PetTypeId.randomId(PetTypeId.class).getId());
    }

    public PetTypeId(String uuid){
        super(uuid);
    }
}

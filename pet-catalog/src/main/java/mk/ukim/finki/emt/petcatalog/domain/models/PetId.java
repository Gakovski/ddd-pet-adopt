package mk.ukim.finki.emt.petcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class PetId extends DomainObjectId {
    private PetId(){
        super(PetId.randomId(PetId.class).getId());
    }

    public PetId(@NonNull String uuid){
        super(uuid);
    }

    public static PetId of(String uuid){
        PetId p = new PetId(uuid);
        return p;
    }
}

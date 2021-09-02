package mk.ukim.finki.emt.adoptermanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class AdopterId extends DomainObjectId {
    private AdopterId(){
        super(AdopterId.randomId(AdopterId.class).getId());
    }

    public AdopterId(@NonNull String uuid){
        super(uuid);
    }

    public static AdopterId of(String uuid){
        AdopterId a = new AdopterId(uuid);
        return a;
    }
}

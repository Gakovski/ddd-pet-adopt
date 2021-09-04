package mk.ukim.finki.emt.petcatalog.domain.models;



import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name="pet")
@Getter
public class Pet extends AbstractEntity<PetId> {

    private String petName;
    private String petTypeName;
    private String petDescription;
    private String petBreed;
    private boolean isAdopted;

    public Pet(){
        super(PetId.randomId(PetId.class));
    }

    public static Pet build(String petName,
                            String petTypeName,
                            String petDescription,
                            String petBreed){
        Pet p = new Pet();
        p.petName = petName;
        p.petTypeName = petTypeName;
        p.petDescription = petDescription;
        p.petBreed = petBreed;
        p.isAdopted = false;
        return p;
    }

    public void addAdoptions(){
        this.isAdopted = true;
    }


}

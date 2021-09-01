package mk.ukim.finki.emt.petcatalog.domain.models;



import mk.ukim.finki.emt.petcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name="pet")
public class Pet extends AbstractEntity<PetId> {

    private String petName;
    @OneToOne
    private PetType petType;
    //private Quantity quantity;
    private int adoptions;

    private Pet(){
        super(PetId.randomId(PetId.class));
    }

    public static Pet build(String petName, PetType petType, int adoptions){
        Pet p = new Pet();
        p.petName = petName;
        p.petType = petType;
        p.adoptions = adoptions;
        return p;
    }

    public void addAdoptions(int qty){
        this.adoptions = this.adoptions - qty;
    }

    public void removeAdoptions(int qty){
        this.adoptions = this.adoptions - qty;
    }

}

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
    private Quantity quantity;

}

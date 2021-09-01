package mk.ukim.finki.emt.petcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pet_type")
public class PetType extends AbstractEntity<PetTypeId> {

    private String petTypeName;
    private String petDescription;
    private String petBreed;

}

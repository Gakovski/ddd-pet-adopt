package mk.ukim.finki.emt.petcatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.petcatalog.domain.models.PetType;

@Data
public class PetForm {

    private String petName;
    private PetType petType;
    private int adoptions;

}

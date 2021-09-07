package mk.ukim.finki.emt.petcatalog.services.forms;

import lombok.Data;

@Data
public class PetForm {

    private String petName;
    private String petImageUrl;
    private String petDescription;
    private String petBreed;
}

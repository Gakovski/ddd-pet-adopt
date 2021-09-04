package mk.ukim.finki.emt.petcatalog.services;

import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import mk.ukim.finki.emt.petcatalog.services.forms.PetForm;

import java.util.List;

public interface PetService {

    Pet findById(PetId id);
    Pet createPet(PetForm form);
    void deletePet(PetId petId);
    List<Pet> getAll();

}

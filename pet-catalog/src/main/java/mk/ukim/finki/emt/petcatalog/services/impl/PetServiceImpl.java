package mk.ukim.finki.emt.petcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.exceptions.PetNotFoundException;
import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import mk.ukim.finki.emt.petcatalog.domain.repository.PetRepository;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.petcatalog.services.forms.PetForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;


    @Override
    public Pet findById(String id) {
        PetId petId = new PetId(id);
        return petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    }

    @Override
    public Pet createPet(PetForm form) {
        Pet p = Pet.build(form.getPetName(),
                form.getPetTypeName(),
                form.getPetDescription(),
                form.getPetBreed());
        petRepository.save(p);
        return p;
    }

    @Override
    public void deletePet(PetId petId) {
        petRepository.deleteById(petId);
    }

    @Override
    @Transactional
    public void updatePet(PetId petId) {
        Pet pet = petRepository.getById(petId);
        pet.addAdoptions();
    }


    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }
}

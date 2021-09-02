package mk.ukim.finki.emt.petcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.petcatalog.services.forms.PetForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@AllArgsConstructor
public class PetResource {

    private final PetService petService;

    @GetMapping
    public List<Pet> getAll(){
        return petService.getAll();
    }

    @PostMapping
    public void addNewPet (@RequestBody PetForm petForm){
        petService.createPet(petForm);
    }

}

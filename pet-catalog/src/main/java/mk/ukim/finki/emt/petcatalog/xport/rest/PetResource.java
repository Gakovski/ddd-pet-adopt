package mk.ukim.finki.emt.petcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.petcatalog.services.forms.PetForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class PetResource {

    private final PetService petService;

    @GetMapping
    public List<Pet> getAll(){
        return petService.getAll();
    }

    @GetMapping(path = "{petId}")
    public Pet getById(@PathVariable("petId") String petId){
        return petService.findById(petId);
    }

    @PostMapping(path = "/add")
    public void addNewPet (@RequestBody PetForm petForm){
        petService.createPet(petForm);
    }

    @DeleteMapping(path = "{petId}")
    public void deletePet (@PathVariable("petId") PetId petId){
        petService.deletePet(petId);
    }

    @PutMapping(path = "updatePet/{petId}")
    public void updatePet (@PathVariable("petId") String petId,
                           @RequestBody Pet pet){
        petService.updatePet(petId);
    }
}

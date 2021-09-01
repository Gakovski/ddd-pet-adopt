package mk.ukim.finki.emt.petcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

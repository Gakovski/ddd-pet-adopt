package mk.ukim.finki.emt.adoptermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.adoptermanagement.domain.models.Adopter;
import mk.ukim.finki.emt.adoptermanagement.domain.models.AdopterId;
import mk.ukim.finki.emt.adoptermanagement.services.AdopterService;
import mk.ukim.finki.emt.adoptermanagement.services.forms.AdopterForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adopter")
@AllArgsConstructor
public class AdopterResource {

    private final AdopterService adopterService;

    @GetMapping
    public List<Adopter> getAll(){
        return adopterService.getAll();
    }

    @PostMapping
    public void addNewAdopter(@RequestBody AdopterForm adopterForm){
        adopterService.creteAdopter(adopterForm);
    }

    @DeleteMapping(path = "{adopterId}")
    public void deleteAdopter(@PathVariable("adopterId") AdopterId adopterId){
        adopterService.deleteAdopter(adopterId);
    }

}

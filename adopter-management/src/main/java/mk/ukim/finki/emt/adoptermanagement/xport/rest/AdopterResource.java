package mk.ukim.finki.emt.adoptermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.adoptermanagement.domain.models.Adopter;
import mk.ukim.finki.emt.adoptermanagement.domain.models.AdopterId;
import mk.ukim.finki.emt.adoptermanagement.services.AdopterService;
import mk.ukim.finki.emt.adoptermanagement.services.forms.AdopterForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adopter")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class AdopterResource {

    private final AdopterService adopterService;

    @GetMapping
    public List<Adopter> getAll(){
        return adopterService.getAll();
    }

    @GetMapping(path = "{adopterId}")
    public Adopter getById(@PathVariable("adopterId") String adopterId){
        return adopterService.findById(adopterId);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Adopter> addNewAdopter(@RequestBody AdopterForm adopterForm){
        Adopter temp = adopterService.creteAdopter(adopterForm);
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(path = "{adopterId}")
    public void deleteAdopter(@PathVariable("adopterId") AdopterId adopterId){
        adopterService.deleteAdopter(adopterId);
    }

}

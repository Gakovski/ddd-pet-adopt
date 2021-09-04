package mk.ukim.finki.emt.adoptermanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.adoptermanagement.domain.exceptions.AdopterNotFoundException;
import mk.ukim.finki.emt.adoptermanagement.domain.models.Adopter;
import mk.ukim.finki.emt.adoptermanagement.domain.models.AdopterId;
import mk.ukim.finki.emt.adoptermanagement.domain.repository.AdopterRepository;
import mk.ukim.finki.emt.adoptermanagement.services.AdopterService;
import mk.ukim.finki.emt.adoptermanagement.services.forms.AdopterForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AdopterServiceImpl implements AdopterService {

    private final AdopterRepository adopterRepository;


    @Override
    public Adopter creteAdopter(AdopterForm form) {
        Adopter adopter = Adopter.build(form.getName(),
                                        form.getSurname(),
                                        form.getEmail(),
                                        form.getPhone());
        adopterRepository.save(adopter);
        return adopter;
    }

    @Override
    public void deleteAdopter(AdopterId adopterId) {
        boolean exists = adopterRepository.existsById(adopterId);
        if(!exists){
            throw new IllegalStateException("Adopter not exist");
        }
        adopterRepository.deleteById(adopterId);

    }

    @Override
    public List<Adopter> getAll() {
        return adopterRepository.findAll();
    }

    @Override
    public Adopter findById(String id) {
        AdopterId adopterId = new AdopterId(id);
        return adopterRepository.findById(adopterId).orElseThrow(AdopterNotFoundException::new);
    }
}

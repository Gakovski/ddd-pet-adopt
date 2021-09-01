package mk.ukim.finki.emt.petcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.domain.repository.PetRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final PetRepository petRepository;

    @PostConstruct
    public void initData(){
        Pet p1 = Pet.build("Jimi","Machka","Mil, crn i mazen","Kozhudosho", 1);
        Pet p2 = Pet.build("Sheki","Kuche","Se smeshi, kafenkast i rovari","Kratkonozhec", 1);

        if(petRepository.findAll().isEmpty()){
            petRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}

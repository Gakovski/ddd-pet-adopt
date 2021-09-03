package mk.ukim.finki.emt.adoptermanagement.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.adoptermanagement.domain.models.Adopter;
import mk.ukim.finki.emt.adoptermanagement.domain.repository.AdopterRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataInitializerAdopter {

//    private final AdopterRepository adopterRepository;
//
//    @PostConstruct
//    public void initData(){
//        Adopter a1 = Adopter.build("David",
//                                 "Gakovski",
//                                   "david123@gmail.com",
//                                  "070123456");
//        if(adopterRepository.findAll().isEmpty()){
//            adopterRepository.save(a1);
//        }
//    }

}

package mk.ukim.finki.emt.petcatalog;

import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.services.PetService;
import mk.ukim.finki.emt.petcatalog.services.impl.PetServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PetCatalogApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Autowired
//    private PetClient petClient;

//    @Autowired
//    private PetServiceImpl petClient;
//
//    @Test
//    public void testPlaceOrderWithRealData(){
//        List<Pet> petList = petClient.getAll();
//        System.out.println(petList);
//    }

}

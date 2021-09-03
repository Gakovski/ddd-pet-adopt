package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Adopter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.ordermanagement.xport.client.AdopterClient;
import mk.ukim.finki.emt.ordermanagement.xport.client.PetClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {
    @Autowired
    private PetClient petClient;

    @Autowired
    private AdopterClient adopterClient;

    @Test
    public void testPlaceOrderWithRealData(){
        List<Pet> petList = petClient.findAll();
        System.out.println(petList.toString());
    }

    @Test
    public void testPlaceOrderWithRealData2(){
        List<Adopter> adopterList = adopterClient.findAllAdopters();
        System.out.println(adopterList.toString());
    }
}

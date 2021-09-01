package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.ordermanagement.xport.client.PetClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {
    @Autowired
    private PetClient petClient;

    @Test
    public void testPlaceOrderWithRealData(){
        List<Pet> petList = petClient.findAll();
        System.out.println(petList);
    }
}

package mk.ukim.finki.emt.ordermanagement.xport.client;


import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Adopter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.PetId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PetClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public PetClient(@Value("${app.pet-catalog.url}") String serverUrl){
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Pet> findAll(){
        try {
            return restTemplate.exchange(uri().path("/api/pet").
                    build().toUri(), HttpMethod.GET,null,
                    new ParameterizedTypeReference<List<Pet>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Optional<Pet> findById(String petId){
        try {
            return restTemplate.exchange(uri().path("/api/pet/"+petId).
                            build().toUri(), HttpMethod.GET,null,
                    new ParameterizedTypeReference<Optional<Pet>>() {
                    }).getBody();
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}

package mk.ukim.finki.emt.ordermanagement.xport.client;

import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Adopter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Pet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdopterClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public AdopterClient(@Value("http://localhost:9093") String serverUrl){
        this.serverUrl=serverUrl;
        this.restTemplate=new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri(){
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Adopter> findAllAdopters(){
        try {
            return restTemplate.exchange(uri().path("/api/adopter").
                            build().toUri(), HttpMethod.GET,null,
                    new ParameterizedTypeReference<List<Adopter>>() {
                    }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    public Optional<Adopter> findById(String adopterId){
        try {
            return restTemplate.exchange(uri().path("/api/adopter/"+adopterId).
                            build().toUri(), HttpMethod.GET,null,
                    new ParameterizedTypeReference<Optional<Adopter>>() {
                    }).getBody();
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}

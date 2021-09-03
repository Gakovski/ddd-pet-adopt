package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Adopter implements ValueObject {

    private final AdopterId id;
    private final String name;
    private final String surname;
    private final String email;
    private final String phone;

    private Adopter(){
        this.id=AdopterId.randomId(AdopterId.class);
        this.name="";
        this.surname="";
        this.email="";
        this.phone="";
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @JsonCreator
    public Adopter(@JsonProperty("id") AdopterId id,
                   @JsonProperty("adopterName") String name,
                   @JsonProperty("adopterSurname") String surname,
                   @JsonProperty("adopterEmail") String email,
                   @JsonProperty("adopterPhone") String phone){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phone=phone;
    }

}

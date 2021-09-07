package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Pet implements ValueObject {

    private final PetId id;
    private final String name;
    private final String petImageUrl;
    private final String petDescription;
    private final String petBreed;
    private Boolean isAdopted;

    private Pet(){
        this.id=PetId.randomId(PetId.class);
        this.name= "";
        this.petImageUrl="";
        this.petDescription="";
        this.petBreed="";
        this.isAdopted=false;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petImageUrl='" + petImageUrl + '\'' +
                ", petDescription='" + petDescription + '\'' +
                ", petBreed='" + petBreed + '\'' +
                ", isAdopted=" + isAdopted +
                '}';
    }

    @JsonCreator
    public Pet(@JsonProperty("id") PetId id,
               @JsonProperty("petName") String name,
               @JsonProperty("petImageUrl") String petImageUrl,
               @JsonProperty("petDescription") String petDescription,
               @JsonProperty("petBreed") String petBreed
    ) {
        this.id = id;
        this.name = name;
        this.petImageUrl = petImageUrl;
        this.petDescription = petDescription;
        this.petBreed = petBreed;
        this.isAdopted = false;
    }

    public void addAdoptions(){
        this.isAdopted = true;
    }

}

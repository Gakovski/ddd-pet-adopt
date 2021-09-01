package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Type implements ValueObject{

    private final String description;
    private final String typeName;
    private final String breed;

    protected Type(){
        this.description="";
        this.typeName="";
        this.breed="";
    }

    @JsonCreator
    public Type(String description, String typeName, String breed) {
        this.description = description;
        this.typeName = typeName;
        this.breed = breed;
    }
}

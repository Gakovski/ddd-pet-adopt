package mk.ukim.finki.emt.adoptermanagement.domain.models;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adopter")
@Getter
public class Adopter extends AbstractEntity<AdopterId> {

    private String name;
    private String surname;
    private String email;
    private String phone;


    private Adopter(){
        super(AdopterId.randomId(AdopterId.class));
    }

    public static Adopter build(String name,
                                String surname,
                                String email,
                                String phone){
        Adopter a = new Adopter();
        a.name = name;
        a.surname = surname;
        a.email = email;
        a.phone = phone;
        return a;
    }


}

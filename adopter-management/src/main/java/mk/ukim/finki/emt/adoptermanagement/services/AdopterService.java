package mk.ukim.finki.emt.adoptermanagement.services;

import mk.ukim.finki.emt.adoptermanagement.domain.models.Adopter;
import mk.ukim.finki.emt.adoptermanagement.services.forms.AdopterForm;

import java.util.List;

public interface AdopterService {

    Adopter creteAdopter(AdopterForm form);
    List<Adopter> getAll();
}

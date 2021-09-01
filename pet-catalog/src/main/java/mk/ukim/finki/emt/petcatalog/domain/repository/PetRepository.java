package mk.ukim.finki.emt.petcatalog.domain.repository;

import mk.ukim.finki.emt.petcatalog.domain.models.Pet;
import mk.ukim.finki.emt.petcatalog.domain.models.PetId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, PetId> {
}

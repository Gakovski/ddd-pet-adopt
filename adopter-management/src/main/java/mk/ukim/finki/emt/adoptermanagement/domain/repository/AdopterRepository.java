package mk.ukim.finki.emt.adoptermanagement.domain.repository;

import mk.ukim.finki.emt.adoptermanagement.domain.models.Adopter;
import mk.ukim.finki.emt.adoptermanagement.domain.models.AdopterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, AdopterId> {
}

package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Breed;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

}

package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.entity.Breed;
import ro.itschool.entity.Dog;

import java.util.List;
import java.util.Set;

@Repository
public interface DogRepository extends JpaRepository <Dog, Long> {

    Set<Dog> findDogByName (String name);

    Set<Dog> findByBreed (Breed breed);

    List<Dog> findByBreed_id(int id);
}

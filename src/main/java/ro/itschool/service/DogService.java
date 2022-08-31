package ro.itschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Dog;
import ro.itschool.repository.DogRepository;

import java.util.List;
import java.util.Optional;
@Service
public class DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }

    public void removeDogById(long id) {
        dogRepository.deleteById(id);
    }

    public Optional<Dog> getDogById(long id) {
        return dogRepository.findById(id);
    }

    public List<Dog> getAllDogByBreedId(int id) {
        return dogRepository.findByBreed_id(id);
    }


}


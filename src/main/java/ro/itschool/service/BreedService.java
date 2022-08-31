package ro.itschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Breed;
import ro.itschool.repository.BreedRepository;

import java.util.List;
import java.util.Optional;
@Service
public class BreedService {


    @Autowired(required = true)
    BreedRepository breedRepository;

    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }
    public void addBreed(Breed breed) {
        breedRepository.save(breed);
    }
    public void removeBreedById(int id){
        breedRepository.deleteById(id);
    }
    public Optional<Breed> getBreedById(int id) {
        return breedRepository.findById(id);
    }
}

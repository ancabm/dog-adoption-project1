package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.itschool.dto.DogDTO;
import ro.itschool.entity.Breed;
import ro.itschool.entity.Dog;
import ro.itschool.service.BreedService;
import ro.itschool.service.DogService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdopterController {
    public static String UploadDir = System.getProperty("user.dir") + "/src/main/resources/images";
    @Autowired
    BreedService breedService;

    @Autowired
    DogService dogService;

    @GetMapping("/peopleHome")
    public String peopleHome() {
        return "peopleHome";
    }


    @GetMapping("/people/breed")
    public String getBreed(Model model) {
        model.addAttribute("breed", breedService.getAllBreeds());
        return "breed";
    }

    @GetMapping("/people/breed/add")
    public String getBreedAdd(Model model) {
        model.addAttribute("breed", new Dog());
        return "breedAdd";
    }

    @PostMapping("/people/breed/add")
    public String postBreedAdd(@ModelAttribute("breed") Breed breed) {
        breedService.addBreed(breed);
        return "redirect:/people/breed";
    }

    @GetMapping("/people/breed/delete/{id}")
    public String deleteBreed(@PathVariable int id) {
        breedService.removeBreedById(id);
        return "redirect:/people/breed";
    }

    @GetMapping("/people/breed/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Breed> breed = breedService.getBreedById(id);
        if (breed.isPresent()) {
            model.addAttribute("breed", breed.get());
            return "breedAdd";
        } else
            return "404";
    }

    @GetMapping("/people/dog")
    public String deleteBreed(Model model) {
        model.addAttribute("dog", dogService.getAllDogs());
        return "dog";
    }

    @GetMapping("/people/dog/add")
    public String dogAddGet(Model model) {
        model.addAttribute("dogDTO", new DogDTO());
        model.addAttribute("breed", breedService.getAllBreeds());
        return "dogAdd";
    }

    @PostMapping("/people/dog/add")
    public String dogAddPost(@ModelAttribute("dogDTO") DogDTO dogDTO,
                             @RequestParam("dogImage") MultipartFile file,
                             @RequestParam("imgName") String imgName) throws IOException {
        Dog dog = new Dog();
        dog.setId(dogDTO.getId());
        dog.setName(dogDTO.getName());
        dog.setBreed(breedService.getBreedById(dogDTO.getBreedId()).get());
        dog.setAge(dogDTO.getAge());
        dog.setCity(dogDTO.getCity());
        dog.setDescription(dogDTO.getDescription());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(UploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;

        }
        dog.setImageName(imageUUID);
        dogService.addDog(dog);

        return "redirect:/people/dog";
    }

    @GetMapping("/people/dog/delete/{id}")
    public String deleteDog(@PathVariable long id) {
        dogService.removeDogById(id);
        return "redirect:/people/dog";
    }

    @GetMapping("/people/dog/update/{id}")
    public String updateDogGet(@PathVariable long id, Model model) {
        Dog dog = dogService.getDogById(id).get();
        DogDTO dogDTO = new DogDTO();
        dogDTO.setId(dog.getId());
        dogDTO.setName(dog.getName());
        dog.setAge(dog.getAge());
        dog.setCity(dog.getCity());
        dogDTO.setBreedId((dog.getBreed().getId()));
        dogDTO.setDescription(dog.getDescription());
        dogDTO.setImageName(dog.getImageName());
        model.addAttribute("breed", breedService.getAllBreeds());
        model.addAttribute("dogDTO", dogDTO);

        return "dogAdd";
    }
}

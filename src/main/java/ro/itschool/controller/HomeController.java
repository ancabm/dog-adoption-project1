package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.itschool.service.BreedService;
import ro.itschool.service.DogService;

@Controller
public class HomeController {
    @Autowired
    BreedService breedService;
    @Autowired
    DogService dogService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String Index(Model model) {
        model.addAttribute("breed", breedService.getAllBreeds());
        model.addAttribute("dog", dogService.getAllDogs());
        return "index";
    }

    @GetMapping("/index/breed/{id}")
    public String indexByCategory(Model model, @PathVariable int id) {
        model.addAttribute("breed", breedService.getAllBreeds());
        model.addAttribute("dog", dogService.getAllDogByBreedId(id));
        return "index";
    }

}
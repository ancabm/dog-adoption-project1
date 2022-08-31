package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.itschool.service.DogService;
@Controller
public class DogViewController {
    @Autowired
    DogService dogService;

    @GetMapping("/index/viewDog/{id}")
    public String viewDog (Model model , @PathVariable int id){
        model.addAttribute("dog", dogService.getDogById(id).get());
        return "viewDog";
    }
    @GetMapping("/index/contact/{id}")
    public String viewContact (Model model , @PathVariable int id){
        model.addAttribute("dog", dogService.getDogById(id).get());
        return "contact";
    }
    @GetMapping("/index/contact")
    public String contact (Model model ){
        return "contact";
    }
    @GetMapping("/index/gallery")
    public String gallery (Model model ){
        return "gallery";
    }

}

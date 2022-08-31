package ro.itschool.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ContactController {
    @RequestMapping(value = {"/contact"})
    public String gallery(){
        return "contact.html";
    }
}

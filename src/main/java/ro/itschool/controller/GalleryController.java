package ro.itschool.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class GalleryController {
    @RequestMapping(value = {"/gallery"})
    public String gallery(){
        return "gallery.html";
    }
}

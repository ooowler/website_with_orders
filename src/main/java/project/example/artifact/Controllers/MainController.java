package project.example.artifact.Controllers;
//package com.example.servingwebcontent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("titel", "some Page");
        return "home";
    }
}

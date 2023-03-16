package com.autodrenaline.autodrenalineapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HomeController {
    @GetMapping
    public String getHome(Model model) {
        return "index";
    }
}

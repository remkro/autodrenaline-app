package com.autodrenaline.autodrenalineapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/registration")
public class CustomerRegistrationController {

    @GetMapping
    public String getRegistration(Model model) {
        return "register";
    }

}

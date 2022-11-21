package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management/cars")
public class ManagementCarController {

    @GetMapping("/add")
    public String getCarAddForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add-car-form";
    }
}

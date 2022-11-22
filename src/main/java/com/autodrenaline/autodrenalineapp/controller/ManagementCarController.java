package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/management/cars")
public class ManagementCarController {

    private List<Car> cars = new ArrayList<>();

    @PostConstruct
    public void init() {
        cars.add(new Car("488 GTB", "Ferrari", (short) 2015, 50_000));
        cars.add(new Car("Huracan STO", "Lamborghini", (short) 2021, 8_000));
    }

    @GetMapping("/add")
    public String getCarAddForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add-car-form";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        cars.add(car);
        return "redirect:/management/cars/list";
    }

    @GetMapping("/list")
    public String getCarsList(Model model) {
        model.addAttribute("cars", cars);
        return "cars-list";
    }

}

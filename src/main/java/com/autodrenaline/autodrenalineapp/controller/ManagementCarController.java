package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        cars.add(new Car("Ferrari", "458 Italia", (short) 2010, 50_000));
    }

    @GetMapping("/add")
    public String getCarAddForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add-car-form";
    }

    @GetMapping("/list")
    public String getCarsList(Model model) {
        model.addAttribute("cars", cars);
        return "cars-list";
    }

}

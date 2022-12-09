package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.entity.Car;
import com.autodrenaline.autodrenalineapp.service.CarManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/management/fleet")
@RequiredArgsConstructor
public class ManagementCarController {

    private final CarManagementService carManagementService;

//    @PostConstruct
//    public void init() {
//        cars.add(new Car("Ferrari", "488 GTB", (short) 520, (short) 2015, 50_000, true));
//        cars.add(new Car("Lamborghini", "Huracan STO", (short) 580, (short) 2021, 8_000, true));
//    }

    @GetMapping("/add")
    public String getCarAddForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add-car-form";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        carManagementService.save(car);
        return "redirect:/management/fleet";
    }

    @GetMapping()
    public String getCarsList(Model model) {
        final List<Car> cars = carManagementService.getAll();
        model.addAttribute("cars", cars);
        return "fleet";
    }

}

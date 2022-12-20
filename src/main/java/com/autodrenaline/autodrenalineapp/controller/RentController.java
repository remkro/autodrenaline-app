package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.dto.CreateRentEventDto;
import com.autodrenaline.autodrenalineapp.entity.Car;
import com.autodrenaline.autodrenalineapp.entity.RentEvent;
import com.autodrenaline.autodrenalineapp.service.CarManagementService;
import com.autodrenaline.autodrenalineapp.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;
    private final CarManagementService carService;

    @GetMapping("/rent")
    public String getRentForm(Model model) {
//        if (securityService.isAuthenticated()) {
//            return "redirect:/";
//        }

        List<Car> cars = carService.getAll();

        model.addAttribute("rentForm", new CreateRentEventDto());
        model.addAttribute("cars", cars);

        return "rent-car";
    }

    @PostMapping("/rent")
    public String postRentForm(@ModelAttribute("rentForm") CreateRentEventDto createEvent, BindingResult bindingResult,
                               Principal principal) {
//        userValidator.validate(userForm, bindingResult);

//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        System.out.println(principal.getName());
        rentService.rent(createEvent, principal.getName());

        return "redirect:/rent-confirmation";
    }

    @GetMapping("/rent-confirmation")
    public String getRentConfirmation() {
        return "rent-confirmation";
    }
}

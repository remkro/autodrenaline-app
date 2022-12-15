package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.entity.RentEvent;
import com.autodrenaline.autodrenalineapp.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;

    @GetMapping("/rent")
    public String getRentForm(Model model) {
//        if (securityService.isAuthenticated()) {
//            return "redirect:/";
//        }

        model.addAttribute("rentForm", new RentEvent());

        return "rent-car";
    }

    @PostMapping("/rent")
    public String postRentForm(@ModelAttribute("rentForm") RentEvent event, Principal principal, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);

//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        System.out.println(principal.getName());
        rentService.rent(2,1);

        return "redirect:/rent-confirmation";
    }

    @GetMapping("/rent-confirmation")
    public String getRentConfirmation() {
        return "rent-confirmation";
    }
}

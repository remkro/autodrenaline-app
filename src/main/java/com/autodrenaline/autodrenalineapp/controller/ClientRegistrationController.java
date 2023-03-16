package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.service.ClientService;
import com.autodrenaline.autodrenalineapp.service.SecurityService;
import com.autodrenaline.autodrenalineapp.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ClientRegistrationController {
    private final SecurityService securityService;
    private final ClientService clientService;
    private final UserValidator userValidator;

    @GetMapping("/client/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("clientForm", new Client());

        return "client-registration";
    }

    @PostMapping("/client/registration")
    public String registration(@ModelAttribute("clientForm") Client clientForm, BindingResult bindingResult) {
        userValidator.validate(clientForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        clientService.save(clientForm);
        securityService.autoLogin(clientForm.getUsername(), clientForm.getPasswordConfirm());

        return "redirect:/welcome";
    }
}

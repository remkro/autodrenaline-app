package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.dto.ClientInfoDto;
import com.autodrenaline.autodrenalineapp.entity.Car;
import com.autodrenaline.autodrenalineapp.service.CarManagementService;
import com.autodrenaline.autodrenalineapp.service.ClientService;
import com.autodrenaline.autodrenalineapp.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminDashboardController {
    private final CarManagementService carManagementService;
    private final StatisticsService statisticsService;
    private final ClientService clientService;

    @GetMapping("/admin/dashboard/fleet/add")
    public String getCarAddForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add-car-form";
    }

    @PostMapping("/admin/dashboard/fleet/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        carManagementService.save(car);
        return "redirect:/admin/dashboard/fleet";
    }

    @GetMapping("/admin/dashboard/fleet")
    public String getCarsList(Model model) {
        final List<Car> cars = carManagementService.getAll();
        final long amount = statisticsService.getTotalCarsAmount();
        model.addAttribute("cars", cars);
        model.addAttribute("amount", amount);
        return "fleet";
    }

    @GetMapping("/admin/dashboard/clients")
    public String getClientsList(Model model) {
        final List<ClientInfoDto> clients = clientService.getAllClientsInfo();
        final long clientsAmount = statisticsService.getTotalClientsAmount();
        model.addAttribute("clients", clients);
        model.addAttribute("clientsAmount", clientsAmount);
        return "clients";
    }
}

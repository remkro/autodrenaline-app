package com.autodrenaline.autodrenalineapp.controller;

import com.autodrenaline.autodrenalineapp.dto.ClientInfoDto;
import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.service.ClientService;
import com.autodrenaline.autodrenalineapp.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/management/clients")
@RequiredArgsConstructor
public class ManagementClientController {
    private final ClientService clientService;
    private final StatisticsService statisticsService;

    @GetMapping()
    public String getClientsList(Model model) {
        final List<ClientInfoDto> clients = clientService.getAllClientsInfo();
        final long clientsAmount = statisticsService.getTotalClientsAmount();
        model.addAttribute("clients", clients);
        model.addAttribute("clientsAmount", clientsAmount);
        return "clients";
    }
}

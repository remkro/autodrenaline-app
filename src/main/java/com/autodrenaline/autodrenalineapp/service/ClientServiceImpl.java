package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.dto.ClientInfoDto;
import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.entity.Role;
import com.autodrenaline.autodrenalineapp.repository.ClientRepository;
import com.autodrenaline.autodrenalineapp.repository.RentEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final RentEventRepository rentEventRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public void save(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
//        user.setPassword(user.getPassword());
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        client.addRole(new Role("USER"));
        clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ClientInfoDto> getAllClientsInfo() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::mapClientToClientInfoDto).collect(Collectors.toList());
    }

    private ClientInfoDto mapClientToClientInfoDto(Client client) {
        ClientInfoDto clientInfoDto = new ClientInfoDto();
        clientInfoDto.setFirstName(client.getFirstName());
        clientInfoDto.setLastName(client.getLastName());
        clientInfoDto.setEmail(client.getEmail());
        clientInfoDto.setAge(Period.between(client.getBirthdayDate(), LocalDate.now()).getYears());
        clientInfoDto.setRentals(rentEventRepository.countAllByClient_Id(client.getId()));
        clientInfoDto.setDiscountRate(client.getDiscountRate());
        Double income = rentEventRepository.sumTotalRentIncomeGeneratedByCustomer(client.getId());
        if(income == null)
            income = (double) 0;
        clientInfoDto.setIncome(income);
        return clientInfoDto;
    }
}

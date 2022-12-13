package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.entity.Client;
import com.autodrenaline.autodrenalineapp.entity.Role;
import com.autodrenaline.autodrenalineapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
//        user.setPassword(user.getPassword());
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        client.addRole(new Role("USER"));
        clientRepository.save(client);
    }

}

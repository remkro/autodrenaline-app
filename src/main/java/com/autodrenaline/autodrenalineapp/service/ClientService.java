package com.autodrenaline.autodrenalineapp.service;

import com.autodrenaline.autodrenalineapp.entity.Client;

import java.util.List;

public interface ClientService {
    void save(Client client);
    List<Client> getAll();
}

package com.autodrenaline.autodrenalineapp.repository;

import com.autodrenaline.autodrenalineapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username);
}

package com.autodrenaline.autodrenalineapp.repository;

import com.autodrenaline.autodrenalineapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);
}

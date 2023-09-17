package com.rda.grud.gestionbanque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rda.grud.gestionbanque.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

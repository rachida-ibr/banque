package com.rda.grud.gestionbanque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rda.grud.gestionbanque.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}

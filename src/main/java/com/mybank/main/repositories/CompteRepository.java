package com.mybank.main.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.main.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, UUID> {

}

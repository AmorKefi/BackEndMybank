package com.mybank.main.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.main.dtos.OperationResponse;
import com.mybank.main.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

	Optional<List<OperationResponse>> findAllByNumeroCompte(UUID numeroCompte);

}

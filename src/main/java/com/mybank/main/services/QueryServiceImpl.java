package com.mybank.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mybank.main.dtos.OperationResponse;
import com.mybank.main.repositories.OperationRepository;

@Service
public class QueryServiceImpl implements QueryService {

	private final OperationRepository operationRepo;

	public QueryServiceImpl(OperationRepository operationRepo) {
		super();
		this.operationRepo = operationRepo;
	}

	@Override
	public List<OperationResponse> consulterhistorique(UUID numeroCompte) {

		return this.operationRepo.findAllByNumeroCompte(numeroCompte).orElse(new ArrayList<>());
	}

}

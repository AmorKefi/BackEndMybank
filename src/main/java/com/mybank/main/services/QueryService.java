package com.mybank.main.services;

import java.util.List;
import java.util.UUID;

import com.mybank.main.dtos.OperationResponse;

public interface QueryService {
	List<OperationResponse> consulterhistorique(UUID numeroCompte);
}

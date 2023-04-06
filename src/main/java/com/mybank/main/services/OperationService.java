package com.mybank.main.services;

import com.mybank.main.dtos.OperationRequest;

public interface OperationService {

	boolean deposer(OperationRequest depotrequest);

	boolean retirer(OperationRequest retirerRequest);
	
}

package com.mybank.main.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.main.dtos.OperationRequest;
import com.mybank.main.services.OperationService;

@RestController
@RequestMapping("/api/operation")
public class OperationsController {

	private final OperationService operationSer;

	public OperationsController(OperationService operationSer) {
		super();
		this.operationSer = operationSer;
	}

	@PostMapping("/deposer")
	public boolean deposer(OperationRequest request) {
		return this.operationSer.deposer(request);
	}

	@PostMapping("/retirer")
	public boolean retirer(OperationRequest request) {
		return this.operationSer.retirer(request);
	}
}

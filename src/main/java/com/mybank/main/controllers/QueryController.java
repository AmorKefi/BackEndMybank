package com.mybank.main.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.main.dtos.OperationResponse;

@RestController
@RequestMapping("/api/query")
public class QueryController {

	@GetMapping("/consulterhistorique/{numeroCompte}")
	public List<OperationResponse> consulter(@PathVariable UUID numeroCompte) {
		return new ArrayList<>();
	}
}

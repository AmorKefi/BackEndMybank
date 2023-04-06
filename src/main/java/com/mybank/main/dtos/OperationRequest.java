package com.mybank.main.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import com.mybank.main.enums.TypeOperation;

public record OperationRequest(UUID numeroCompte, TypeOperation typeOperation, BigDecimal montant, String parQui) {

}

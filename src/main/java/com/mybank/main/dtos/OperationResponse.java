package com.mybank.main.dtos;

import java.math.BigDecimal;
import java.sql.Date;

import com.mybank.main.enums.TypeOperation;

public record OperationResponse(Date dateOperation, BigDecimal montant, TypeOperation typeOperation, String parQui,
		BigDecimal soldeFinal) {

}

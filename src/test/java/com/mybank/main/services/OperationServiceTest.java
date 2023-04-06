package com.mybank.main.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybank.main.exceptions.InsufficientFundsException;

@SpringBootTest
public class OperationServiceTest {

	@Mock
	@Autowired
	private OperationServiceImpl operationSer;


	@BeforeEach
	void Init() {

	}

	@Test
	void shouldthrowExceptionWhenfundisInsuffisant() {

		Exception exception = assertThrows(InsufficientFundsException.class, () -> {
			this.operationSer.canWithdrow(new BigDecimal(100), new BigDecimal(1000), new BigDecimal(300));
		});
		assertTrue(exception.getMessage().contentEquals("vous avez dépasser votre seuil de retrait"));

	}
	@Test
	void shouldReturnTrueWhendepositAmountIsNegativInsuffisant() {
		assertTrue(this.operationSer.isPositiv(new BigDecimal("-500")));
	}
	
	@Test
	void shouldReturnfalseWhendepositAmountIsPostivInsuffisant() {
		assertFalse(this.operationSer.isPositiv(new BigDecimal("500")));
	}
	
}

package com.mybank.main.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mybank.main.enums.TypeOperation;

@Entity
@Table(name = "operations")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOperation;

	private UUID numeroCompte;

	private Enum<TypeOperation> typeOperation;

	private BigDecimal montant;

	private Date dateOperation;

	private String parQui;

	private BigDecimal soldeFinal;

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Integer idOperation, UUID numeroCompte, Enum<TypeOperation> typeOperation, BigDecimal montant,
			Date dateOperation, String parQui, BigDecimal soldeFinal) {
		super();
		this.idOperation = idOperation;
		this.numeroCompte = numeroCompte;
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.dateOperation = dateOperation;
		this.parQui = parQui;
		this.soldeFinal = soldeFinal;
	}

	public Integer getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}

	public UUID getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(UUID numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Enum<TypeOperation> getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(Enum<TypeOperation> typeOperation) {
		this.typeOperation = typeOperation;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getParQui() {
		return parQui;
	}

	public void setParQui(String parQui) {
		this.parQui = parQui;
	}

	public BigDecimal getSoldeFinal() {
		return soldeFinal;
	}

	public void setSoldeFinal(BigDecimal soldeFinal) {
		this.soldeFinal = soldeFinal;
	}

}

package com.mybank.main.entities;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte {

	@Id
	private UUID numeroCompte;

	private String nomClient;

	private String prenomClient;

	private BigDecimal solde;

	private BigDecimal seuilDecouvert;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(UUID numeroCompte, String nomClient, String prenomClient, BigDecimal solde,
			BigDecimal seuilDecouvert) {
		super();
		this.numeroCompte = numeroCompte;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.solde = solde;
		this.seuilDecouvert = seuilDecouvert;
	}

	public UUID getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(UUID numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public BigDecimal getSeuilDecouvert() {
		return seuilDecouvert;
	}

	public void setSeuilDecouvert(BigDecimal seuilDecouvert) {
		this.seuilDecouvert = seuilDecouvert;
	}

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", solde=" + solde + ", seuilDecouvert=" + seuilDecouvert + "]";
	}

}

package com.mybank.main.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mybank.main.dtos.OperationRequest;
import com.mybank.main.entities.Compte;
import com.mybank.main.entities.Operation;
import com.mybank.main.enums.TypeOperation;
import com.mybank.main.exceptions.InsufficientFundsException;
import com.mybank.main.repositories.CompteRepository;
import com.mybank.main.repositories.OperationRepository;

@Service
public class OperationServiceImpl implements OperationService {

	Logger log = LoggerFactory.getLogger(OperationServiceImpl.class);

	private final CompteRepository compteRepo;

	private final OperationRepository operationRepo;

	public OperationServiceImpl(CompteRepository compteRepo, OperationRepository operationRepo) {
		super();
		this.compteRepo = compteRepo;
		this.operationRepo = operationRepo;
	}

	@Override
	@Transactional
	public boolean deposer(OperationRequest depotrequest) {
		Compte compteDeDepot = this.compteRepo.findById(depotrequest.numeroCompte()).get();
		try {
			Operation operationDepot = new Operation();
			LocalDate dateActuelle = LocalDate.now();
			Date dateoperation = Date.valueOf(dateActuelle);
			operationDepot.setDateOperation(dateoperation);
			operationDepot.setMontant(depotrequest.montant());
			operationDepot.setNumeroCompte(depotrequest.numeroCompte());
			operationDepot.setParQui(depotrequest.parQui());
			operationDepot.setTypeOperation(TypeOperation.DEPOT);
			if (this.isPositiv(depotrequest.montant())) {
				log.error("le montant doit être positif");
				return false;
			}
			operationDepot.setSoldeFinal(compteDeDepot.getSolde().add(depotrequest.montant()));
			compteDeDepot.setSolde(operationDepot.getSoldeFinal());
			this.compteRepo.save(compteDeDepot);
			this.operationRepo.save(operationDepot);
			return true;
		} catch (Exception e) {
			log.error("l'operation a échoué :" + e.getMessage());
			return false;
		}
	}

	@Override
	@Transactional
	public boolean retirer(OperationRequest retirerRequest) throws InsufficientFundsException {
		Compte compteDeDepot = this.compteRepo.findById(retirerRequest.numeroCompte()).get();
		this.canWithdrow(compteDeDepot.getSolde(), retirerRequest.montant(), compteDeDepot.getSeuilDecouvert());
		try {
			Operation operationDepot = new Operation();
			LocalDate dateActuelle = LocalDate.now();
			Date dateoperation = Date.valueOf(dateActuelle);
			operationDepot.setDateOperation(dateoperation);
			operationDepot.setMontant(retirerRequest.montant());
			operationDepot.setNumeroCompte(retirerRequest.numeroCompte());
			operationDepot.setParQui(retirerRequest.parQui());
			operationDepot.setTypeOperation(TypeOperation.RETRAIT);
			if (this.isPositiv(retirerRequest.montant())) {
				log.error("le montant doit être positif");
				return false;
			}
			operationDepot.setSoldeFinal(compteDeDepot.getSolde().subtract(retirerRequest.montant()));
			compteDeDepot.setSolde(operationDepot.getSoldeFinal());
			this.compteRepo.save(compteDeDepot);
			this.operationRepo.save(operationDepot);
			return true;
		} catch (Exception e) {
			log.error("l'operation a échoué :" + e.getMessage());
			return false;
		}
	}

	public void canWithdrow(BigDecimal solde, BigDecimal montantretirer, BigDecimal seuilDecouvert) {
		if (montantretirer.compareTo(solde.subtract(seuilDecouvert)) > 0) {
			throw new InsufficientFundsException("vous avez dépasser votre seuil de retrait");
		}
	}

	public boolean isPositiv(BigDecimal montant) {
		return montant.compareTo(BigDecimal.ZERO) < 0;
	}
}

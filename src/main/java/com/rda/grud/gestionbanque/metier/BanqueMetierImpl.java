package com.rda.grud.gestionbanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rda.grud.gestionbanque.model.Compte;
import com.rda.grud.gestionbanque.model.CompteCourant;
import com.rda.grud.gestionbanque.model.Operation;
import com.rda.grud.gestionbanque.model.Retrait;
import com.rda.grud.gestionbanque.model.Versement;
import com.rda.grud.gestionbanque.repository.CompteRepository;
import com.rda.grud.gestionbanque.repository.OperationRepository;

@Service
@Transactional
public class BanqueMetierImpl implements IBanque {
	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCpt) {
		// TODO Auto-generated method stub
		Compte cp = compteRepository.getOne((codeCpt));
		if (cp == null)
			throw new RuntimeException("compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpt, double montant) {
		Compte cp = consulterCompte(codeCpt);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpt, double montant) {
		Compte cp = consulterCompte(codeCpt);
		double facilitesCaisse = 0;
		if (cp instanceof CompteCourant)
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		if (cp.getSolde() + facilitesCaisse < montant)
			throw new RuntimeException("solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);

	}

	@Override
	public Page<Operation> listeOperation(String codeCpt, int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size);
		return operationRepository.listeOperation(codeCpt, pageable);
	}

	@Override
	public void virement(String codeCpt1, String codeCpt2, double montant) {
		retirer(codeCpt1, montant);
		verser(codeCpt2, montant);

	}

}

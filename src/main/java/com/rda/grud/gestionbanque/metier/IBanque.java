package com.rda.grud.gestionbanque.metier;

import org.springframework.data.domain.Page;

import com.rda.grud.gestionbanque.model.Compte;
import com.rda.grud.gestionbanque.model.Operation;

public interface IBanque {
	public Compte consulterCompte(String codeCpt);

	public void verser(String codeCpt, double montant);

	public void retirer(String codeCpt, double montant);

	public void virement(String codeCpt1, String codeCpt2, double montant);

	public Page<Operation> listeOperation(String codeCpt, int page, int size);
}

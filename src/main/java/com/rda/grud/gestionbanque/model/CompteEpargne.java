package com.rda.grud.gestionbanque.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double tauxInteret;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String codeCpt, Date dateCreation, double solde, Client client, double tauxInteret) {
		super(codeCpt, dateCreation, solde, client);
		this.tauxInteret = tauxInteret;
	}

}

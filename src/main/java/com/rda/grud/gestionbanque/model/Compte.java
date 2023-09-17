package com.rda.grud.gestionbanque.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Compte implements Serializable {
	@Id
	private String codeCpt;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name = "CODE_CLT")
	private Client client;
	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private Collection<Operation> operation;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String codeCpt, Date dateCreation, double solde, Client client) {
		this.codeCpt = codeCpt;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public String getCodeCpt() {
		return codeCpt;
	}

	public void setCodeCpt(String codeCpt) {
		this.codeCpt = codeCpt;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operation> getOperation() {
		return operation;
	}

	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}

}

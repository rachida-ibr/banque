package com.rda.grud.gestionbanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rda.grud.gestionbanque.metier.IBanque;
import com.rda.grud.gestionbanque.model.Client;
import com.rda.grud.gestionbanque.model.Compte;
import com.rda.grud.gestionbanque.model.CompteCourant;
import com.rda.grud.gestionbanque.model.CompteEpargne;
import com.rda.grud.gestionbanque.model.Retrait;
import com.rda.grud.gestionbanque.model.Versement;
import com.rda.grud.gestionbanque.repository.ClientRepository;
import com.rda.grud.gestionbanque.repository.CompteRepository;
import com.rda.grud.gestionbanque.repository.OperationRepository;

@SpringBootApplication
public class GestionBanqueApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(GestionBanqueApplication.class, args);
		System.out.println("bien");
	}

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanque banqueRepositoty;

	@Override
	public void run(String... args) throws Exception {

		// TODO Auto-generated method stub

		Client c1 = clientRepository.save(new Client("Rachid", "rachida@gmail.com"));
		Client c2 = clientRepository.save(new Client("Oumar", "oumar@gmail.com"));
		Compte cpt1 = compteRepository.save(new CompteCourant("c1", new Date(), 10000, c1, 800));
		Compte cpt2 = compteRepository.save(new CompteEpargne("c2", new Date(), 20000, c2, 5.5));

		Versement v1 = operationRepository.save(new Versement(new Date(), 5000, cpt1));
		Versement v2 = operationRepository.save(new Versement(new Date(), 5000, cpt1));
		Retrait R = operationRepository.save(new Retrait(new Date(), 20000, cpt1));

		Versement v3 = operationRepository.save(new Versement(new Date(), 15000, cpt2));
		Versement v4 = operationRepository.save(new Versement(new Date(), 5000, cpt2));
		Retrait R2 = operationRepository.save(new Retrait(new Date(), 20000, cpt2));

		// banqueRepositoty.retirer("c2", 20350);
	}

}

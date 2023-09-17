package com.rda.grud.gestionbanque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rda.grud.gestionbanque.metier.IBanque;
import com.rda.grud.gestionbanque.model.Compte;

@Controller
public class BanqueController {
	@RequestMapping(value = "/operation")
	public String operation() {
		return "compte";
	}

	@Autowired
	private IBanque banqueRepository;

	@RequestMapping(value = "/consulterCompte")
	public String consulterCompte(Model model, String codeCpt) {
		try {
			Compte cp = banqueRepository.consulterCompte(codeCpt);
			model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}

		return "compte";
	}
}

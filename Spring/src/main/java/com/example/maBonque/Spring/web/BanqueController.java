package com.example.maBonque.Spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.maBonque.Spring.entity.Compte;
import com.example.maBonque.Spring.entity.Operation;
import com.example.maBonque.Spring.metier.IBanqueMetier;

import javassist.NotFoundException;

@Controller
public class BanqueController {
	@Autowired
private IBanqueMetier banqueMetier;
	@RequestMapping("/operations")
	public String Index() {
		return"template1.html";
	}
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,String codeCompte,double montant,String codeCompte2) {
		try {
			if(typeOperation.equals("VERS")) {
				
				banqueMetier.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("RETE")) {
				banqueMetier.retirer(codeCompte, montant);
				
			}
			else if(typeOperation.equals("VIR")){
				banqueMetier.viremen(codeCompte, codeCompte2, montant);
				
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return"redirect:/consultercompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
		
		
		
		return"redirect:/consultercompte?codeCompte="+codeCompte;
	}
	@RequestMapping("/consultercompte")
	public String consulter(Model model,String codeCompte,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) throws NotFoundException {
	    model.addAttribute("codeCompte", codeCompte);
		try {
	    	Compte cp=banqueMetier.consulterCompte(codeCompte);
	    	Page<Operation> pageOperations=banqueMetier.listOperation(codeCompte, page, size);
			model.addAttribute("listOperations", pageOperations.getContent());
	    	int[] pages=new int[pageOperations.getTotalPages()];
	    	model.addAttribute("pages", pages);
			model.addAttribute("compte", cp);
			
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
		
		return"template1";
	}
}

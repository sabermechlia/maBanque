/**
 * 
 */
package com.example.maBonque.Spring.metier;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.maBonque.Spring.dao.CompteRepository;
import com.example.maBonque.Spring.dao.OperationRepository;
import com.example.maBonque.Spring.entity.Compte;
import com.example.maBonque.Spring.entity.CompteCourant;
import com.example.maBonque.Spring.entity.Operation;
import com.example.maBonque.Spring.entity.Retait;
import com.example.maBonque.Spring.entity.Versment;

import javassist.NotFoundException;


/**
 * @author acer
 *
 */
@Service
@Transactional
public class BanqueMetierImpli implements IBanqueMetier {
   @Autowired
	private CompteRepository compteRepository;
   @Autowired
   private OperationRepository operationRepository;
   @Override 
   public Compte consulterCompte(String code) throws NotFoundException {
	    java.util.Optional<Compte> cp = compteRepository.findById(code);
	    return cp.orElseThrow(
	        () ->  new NotFoundException("Compte introvable  ")
	    );  
	}

	@Override
	public void verser(String codeCpte, double montant) throws NotFoundException {
		// TODO Auto-generated method stub
		Compte cp=consulterCompte(codeCpte);
		Versment v=new Versment(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) throws NotFoundException {
		// TODO Auto-generated method stub
		Compte cp=consulterCompte(codeCpte);
		double facilitesCaisse=0;
		if(cp instanceof CompteCourant)
			facilitesCaisse=((CompteCourant)cp).getDecouvert();
		if(cp.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("solde insuffisant");
		Retait r=new Retait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void viremen(String codeCpte1, String codeCpte2, double montant) throws NotFoundException {
		// TODO Auto-generated method stub
		if(codeCpte1.equals(codeCpte2))
			throw new RuntimeException("Impossible virement sur le meme compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	
	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stub
		
		return operationRepository.listOperation(codeCpte, new PageRequest(page, size));
	}

}

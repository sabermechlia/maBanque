package com.example.maBonque.Spring.metier;

import org.springframework.data.domain.Page;

import com.example.maBonque.Spring.entity.Compte;
import com.example.maBonque.Spring.entity.Operation;

import javassist.NotFoundException;



public interface IBanqueMetier {
public Compte consulterCompte(String codeCpte) throws NotFoundException;
public void verser(String codeCpte,double montant) throws NotFoundException;
public void retirer(String codeCpte,double montant) throws NotFoundException;
public void viremen(String codeCpte1,String codeCpte2,double montant) throws NotFoundException;
public Page<Operation> listOperation(String codeCpte,int page,int size);

}

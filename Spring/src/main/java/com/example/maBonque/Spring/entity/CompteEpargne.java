/**
 * 
 */
package com.example.maBonque.Spring.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author acer
 *
 */
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
private double taux;

/**
 * 
 */
public CompteEpargne() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @param codeCompte
 * @param dateCreation
 * @param solde
 * @param client
 * @param taux
 */
public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
	super(codeCompte, dateCreation, solde, client);
	this.taux = taux;
}

/**
 * @return the taux
 */
public double getTaux() {
	return taux;
}

/**
 * @param taux the taux to set
 */
public void setTaux(double taux) {
	this.taux = taux;
}
}

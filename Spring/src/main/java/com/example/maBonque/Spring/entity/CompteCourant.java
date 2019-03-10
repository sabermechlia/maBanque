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
@DiscriminatorValue("cc")
public class CompteCourant extends  Compte {
private double decouvert;

/**
 * 
 */
public CompteCourant() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @param codeCompte
 * @param dateCreation
 * @param solde
 * @param client
 * @param decouvert
 */
public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, double decouvert) {
	super(codeCompte, dateCreation, solde, client);
	this.decouvert = decouvert;
}

/**
 * @return the decouvert
 */
public double getDecouvert() {
	return decouvert;
}

/**
 * @param decouvert the decouvert to set
 */
public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

}

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
@DiscriminatorValue("V")
public class Versment extends Operation{

	/**
	 * 
	 */
	public Versment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOperation
	 * @param montant
	 * @param compte
	 */
	public Versment(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}

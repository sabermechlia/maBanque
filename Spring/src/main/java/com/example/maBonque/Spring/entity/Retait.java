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
@DiscriminatorValue("R")
public class Retait  extends Operation{

	/**
	 * 
	 */
	public Retait() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOperation
	 * @param montant
	 * @param compte
	 */
	public Retait(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}

}

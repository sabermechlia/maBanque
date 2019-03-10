package com.example.maBonque.Spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable{
@Id
@GeneratedValue
	private Long numero;
private Date dateOperation;
private double montant;
@ManyToOne
@JoinColumn(name="CODE_CPTE")
private Compte compte;
/**
 * 
 */
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param dateOperation
 * @param montant
 * @param compte
 */
public Operation(Date dateOperation, double montant, Compte compte) {
	super();
	this.dateOperation = dateOperation;
	this.montant = montant;
	this.compte = compte;
}
/**
 * @return the numero
 */
public Long getNumero() {
	return numero;
}
/**
 * @param numero the numero to set
 */
public void setNumero(Long numero) {
	this.numero = numero;
}
/**
 * @return the dateOperation
 */
public Date getDateOperation() {
	return dateOperation;
}
/**
 * @param dateOperation the dateOperation to set
 */
public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}
/**
 * @return the montant
 */
public double getMontant() {
	return montant;
}
/**
 * @param montant the montant to set
 */
public void setMontant(double montant) {
	this.montant = montant;
}
/**
 * @return the compte
 */
public Compte getCompte() {
	return compte;
}
/**
 * @param compte the compte to set
 */
public void setCompte(Compte compte) {
	this.compte = compte;
}

}

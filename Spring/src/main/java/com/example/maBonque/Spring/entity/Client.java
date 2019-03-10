/**
 * 
 */
package com.example.maBonque.Spring.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author acer
 *
 */
@Entity
public class Client implements Serializable{
	@Id @GeneratedValue
	private Long code;
	private String nom;
	private String email;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	/**
	 * @param nom
	 * @param email
	 */
	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}
	/**
	 * 
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the comptes
	 */
	public Collection<Compte> getComptes() {
		return comptes;
	}
	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

}

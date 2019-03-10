/**
 * 
 */
package com.example.maBonque.Spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.maBonque.Spring.entity.Compte;



/**
 * @author acer
 *
 */
public interface CompteRepository extends JpaRepository<Compte, String>{
    @Query("select c from Compte c where c.codeCompte = :cpte ")
	public Compte findByID(@Param("cpte") String codeCpte) ;
}

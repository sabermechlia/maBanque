/**
 * 
 */
package com.example.maBonque.Spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maBonque.Spring.entity.Client;

/**
 * @author acer
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}

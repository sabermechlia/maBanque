package com.example.maBonque.Spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.maBonque.Spring.dao.ClientRepository;
import com.example.maBonque.Spring.dao.CompteRepository;
import com.example.maBonque.Spring.dao.OperationRepository;
import com.example.maBonque.Spring.entity.Client;
import com.example.maBonque.Spring.entity.Compte;
import com.example.maBonque.Spring.entity.CompteCourant;
import com.example.maBonque.Spring.entity.CompteEpargne;
import com.example.maBonque.Spring.entity.Retait;
import com.example.maBonque.Spring.entity.Versment;
import com.example.maBonque.Spring.metier.IBanqueMetier;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
    private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	Client c1=	clientRepository.save(new Client("Saber", "sabeur.ben.mechlia@gmail.com"));
	Client c2=clientRepository.save(new Client("ali","ali@gmail.com"));
	
	Compte cp1=compteRepository.save(new CompteCourant("c1",new Date(), 9000, c1, 6000));
	Compte cp2=compteRepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5));
	
	operationRepository.save(new Versment(new Date(), 9000, cp1));
	operationRepository.save(new Versment(new Date(), 6000, cp1));
	operationRepository.save(new Versment(new Date(), 2300, cp1));
	operationRepository.save(new Retait(new Date(), 9000, cp1));
	
	
	
	operationRepository.save(new Versment(new Date(), 2300, cp2));
	operationRepository.save(new Versment(new Date(), 6000, cp2));
	operationRepository.save(new Versment(new Date(), 2300, cp2));
	operationRepository.save(new Retait(new Date(), 9000, cp2));
	
	
	banqueMetier.verser("c1", 1111111);
	banqueMetier.viremen(cp1.getCodeCompte(), cp2.getCodeCompte(), 20);
	
	
	}
}

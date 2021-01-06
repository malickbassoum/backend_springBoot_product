package com.sigi.sigicmudeploiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sigi.sigicmudeploiement.dao.ProduitRepository;
import com.sigi.sigicmudeploiement.entities.Produit;

@SpringBootApplication
public class SigicmudeploiementApplication implements CommandLineRunner{
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(SigicmudeploiementApplication.class, args);
		
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"onduleur",6700,3));
		produitRepository.save(new Produit(null,"imprimante samsung",4590,5));
		produitRepository.save(new Produit(null,"telephone techno",2367,4));
		
		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
	}

}

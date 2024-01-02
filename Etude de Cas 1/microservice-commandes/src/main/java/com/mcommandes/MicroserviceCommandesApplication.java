package com.mcommandes;

import com.mcommandes.dao.CommandeDao;
import com.mcommandes.model.Commande;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MicroserviceCommandesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommandesApplication.class, args);
	}

    /*
	@Bean
    public CommandLineRunner demo(CommandeDao commandeDao) {
        return (args) -> {
            // Creating sample Commande instances
            List<Commande> commandes = Arrays.asList(
                    new Commande(1,"Description 1", 5.0, "2023-12-26", 100.0),
                    new Commande(2,"Description 2", 8.0, "2023-12-27", 150.0),
                    new Commande(3,"Description 3", 3.0, "2023-12-28", 75.0)
                    // Add more Commande objects as needed
            );

            // Save the Commande instances to the database
            commandes.forEach(commandeDao::save);

            System.out.println("Sample Commande data inserted.");

           // Fetch all commandes and print them
            List<Commande> allCommandes = commandeDao.findAll();
            System.out.println("All Commandes:");
            allCommandes.forEach(System.out::println);
        };
    }

     */
}

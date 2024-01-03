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
// pour Spring Cloud Config
@EnableConfigurationProperties
// pour Eureka Client
@EnableDiscoveryClient
public class MicroserviceCommandesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommandesApplication.class, args);
	}
}

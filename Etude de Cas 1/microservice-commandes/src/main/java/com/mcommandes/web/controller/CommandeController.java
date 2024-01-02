package com.mcommandes.web.controller;


import com.mcommandes.configurations.ApplicationPropertiesConfiguration;
import com.mcommandes.dao.CommandeDao;
import com.mcommandes.model.Commande;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController implements HealthIndicator {
    @Autowired
    CommandeDao commandeDao;
    @Autowired
    ApplicationPropertiesConfiguration appProperties;

    // Affiche la liste de toutes les commandes
    @GetMapping(value = "/Commandes")
    public List<Commande> listeCommandes() {
        System.out.println(" ********* CommandeController listeDesCommandes() " + appProperties.getcommandesLast());
        List<Commande> commandes = commandeDao.findAll();
        if (commandes.isEmpty())
            throw new CommandeNotFoundException("Aucune commande trouvée");
        List<Commande> listeLimitee = commandes.subList(0, appProperties.getcommandesLast());
        return listeLimitee;
    }

    // Récuperer commande par id
    @GetMapping(value = "/Commandes/{id}")
    public Optional<Commande> recupererCommande(@PathVariable int id) {
        System.out.println(" ********* CommandeController recupererUneCommande(@PathVariable int id) ");
        Optional<Commande> commande = commandeDao.findById(id);
        if (!commande.isPresent())
            throw new CommandeNotFoundException("La commande correspondant à l'id "+ id + " n'existe pas");

        return commande;
    }


    @Override
    public Health health() {
        System.out.println("****** Actuator : ProductController health() ");
        List<Commande> products = commandeDao.findAll();
        if (products.isEmpty()) {
            return Health.down().build();
        }
        return Health.up().build();
    }
}

package com.mcommandes.web.controller;


import com.mcommandes.configurations.ApplicationPropertiesConfiguration;
import com.mcommandes.dao.CommandeDao;
import com.mcommandes.model.Commande;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.*;
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

    // Créer une nouvelle commande
    @PostMapping(value = "/Commandes")
    public Commande creerCommande(@RequestBody Commande nouvelleCommande) {
        System.out.println(" ********* CommandeController creerCommande(@RequestBody Commande nouvelleCommande) ");
        return commandeDao.save(nouvelleCommande);
    }

    // Modifier une commande par son id
    @PutMapping(value = "/Commandes/{id}")
    public Commande modifierCommande(@PathVariable int id, @RequestBody Commande commandeModifiee) {
        System.out.println(" ********* CommandeController modifierCommande(@PathVariable int id, @RequestBody Commande commandeModifiee) ");
        Optional<Commande> commandeOptional = commandeDao.findById(id);
        if (!commandeOptional.isPresent())
            throw new CommandeNotFoundException("La commande correspondant à l'id " + id + " n'existe pas");

        Commande commandeExistante = commandeOptional.get();
        commandeExistante.setDescription(commandeModifiee.getDescription());
        commandeExistante.setQuantite(commandeModifiee.getQuantite());
        commandeExistante.setDate(commandeModifiee.getDate());
        commandeExistante.setMontant(commandeModifiee.getMontant());
        commandeExistante.setProduct_id(commandeModifiee.getProduct_id());

        return commandeDao.save(commandeExistante);
    }

    // Supprimer un Commande par son id
    @DeleteMapping(value = "/Commandes/{id}")
    public void supprimerCommandes(@PathVariable int id) throws CommandeNotFoundException {
        System.out.println(" ********* CommandeController supprimerCommande(@PathVariable int id) ");
        Optional<Commande> commande = commandeDao.findById(id);
        if (!commande.isPresent())
            throw new CommandeNotFoundException("Le Commande correspondant à l'id " + id + " n'existe pas");

        commandeDao.deleteById(id);
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

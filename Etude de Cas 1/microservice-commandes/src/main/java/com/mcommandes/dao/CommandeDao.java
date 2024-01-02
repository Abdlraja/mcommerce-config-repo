package com.mcommandes.dao;

import com.mcommandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeDao extends JpaRepository<Commande, Integer> {
}

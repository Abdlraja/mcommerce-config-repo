package com.mcommandes.dao;

import com.mcommandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CommandeDao extends JpaRepository<Commande, Integer> {
}

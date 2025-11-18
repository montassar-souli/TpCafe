package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;

import java.time.LocalDate;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

    Commande findByDateCommande(LocalDate dateCommande);
}

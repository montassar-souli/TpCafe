package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemontassarsouli.entities.DetailCommande;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande,Long> {
}

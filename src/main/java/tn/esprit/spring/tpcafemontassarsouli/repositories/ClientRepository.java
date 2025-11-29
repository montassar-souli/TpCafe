package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByNomAndPrenom(String nom, String prenom);
    List<Client> findByDateNaissance(LocalDate date);
}

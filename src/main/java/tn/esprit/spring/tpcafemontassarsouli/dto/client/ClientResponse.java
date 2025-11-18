package tn.esprit.spring.tpcafemontassarsouli.dto.client;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientResponse {
    long idClient;
    String nom;
    String prenom;
    LocalDate dateNaissance;
    Adresse adresse;
    CarteFidelite carteFidelite;
    List<Commande> commande;
}

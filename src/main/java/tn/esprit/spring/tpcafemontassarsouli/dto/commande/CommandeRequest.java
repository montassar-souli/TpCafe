package tn.esprit.spring.tpcafemontassarsouli.dto.commande;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.entities.DetailCommande;
import tn.esprit.spring.tpcafemontassarsouli.entities.StatusCommande;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandeRequest {
    LocalDate dateCommande;
    float totalCommande;
    @Enumerated(EnumType.STRING)
    StatusCommande statusCommande;
    Client client;
    List<DetailCommande> detailCommande;
}

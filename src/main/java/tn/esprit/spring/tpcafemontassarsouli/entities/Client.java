package tn.esprit.spring.tpcafemontassarsouli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClient;
    String nom;
    String prenom;
    LocalDate dateNaissance;
    @OneToOne
    Adresse adresse;
    @OneToOne
    CarteFidelite carteFidelite;
    @OneToMany(mappedBy = "client")
    List<Commande> commande;
}

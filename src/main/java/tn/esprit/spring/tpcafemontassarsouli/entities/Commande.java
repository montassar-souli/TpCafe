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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCommande;
    LocalDate dateCommande;
    float totalCommande;
    @Enumerated(EnumType.STRING)
    StatusCommande statusCommande;
    @ManyToOne
    Client client;
    @OneToMany(mappedBy = "commande")
    List<DetailCommande> detailCommande;
}

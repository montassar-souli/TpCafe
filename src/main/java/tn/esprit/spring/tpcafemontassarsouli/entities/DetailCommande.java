package tn.esprit.spring.tpcafemontassarsouli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Detail_Commande")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idDetailCommande;
    int quantiteArticle;
    float sousTotalArticle;
    float sousTotalArticleApresPromo;
    @ManyToOne
    Commande commande;
    @ManyToOne
    Article article;
}

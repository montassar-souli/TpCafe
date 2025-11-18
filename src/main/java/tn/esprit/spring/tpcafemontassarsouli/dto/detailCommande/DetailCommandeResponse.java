package tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailCommandeResponse {
    long idDetailCommande;
    int quantiteArticle;
    float sousTotalArticle;
    float sousTotalArticleApresPromo;
    Commande commande;
    Article article;
}

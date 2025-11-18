package tn.esprit.spring.tpcafemontassarsouli.dto.article;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafemontassarsouli.entities.DetailCommande;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;
import tn.esprit.spring.tpcafemontassarsouli.entities.TypeArticle;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleResponse {
    long idArticle;
    String nomArticle;
    float prixArticle;
    TypeArticle typeArticle;
    List<DetailCommande> detailCommande;
    List<Promotion> promotion;
}

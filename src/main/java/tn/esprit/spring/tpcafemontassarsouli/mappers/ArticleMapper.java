package tn.esprit.spring.tpcafemontassarsouli.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article fromDTOToEntity(ArticleRequest a);
    ArticleResponse fromEntityToDTO(Article a);

    List<Article> fromListDTOToListEntity(List<ArticleRequest> a);
    List<ArticleResponse> fromListEntityToListDTO(List<Article> a);
}

package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;

import java.util.List;

public interface IArticleService {
    Article addArticle(Article a);
    ArticleResponse saveArticleDTO(ArticleRequest a);

    List<Article> saveArticle(List<Article> articles);
    List<ArticleResponse> saveListArticlesDTO(List<ArticleRequest> a);

    Article selectArticleByIdWithGet(long id);
    ArticleResponse getArticleByIdDTO(long id);

    Article selectArticleByIdWithOrElse(long id);

    List<Article> selectAllArticle();
    List<ArticleResponse> getAllArticlesDTO();

    void deleteArticle(Article a);
    void deleteAllArticle();
    void deleteArticleById(long id);
    long countingArticle();
    boolean verifArticleById(long id);

    void ajouterArticleEtPromotionsCascade(Article article);
    void supprimerArticleEtPromotionsCascade(Article article);

    List<Article> getArticlesEnPromotion();
}

package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT a FROM Article a WHERE a.nomArticle = ?1")
    List<Article> getArticlesByNomJPQL(String nom);

    @Query("SELECT a FROM Article a WHERE a.typeArticle = ?1")
    List<Article> getArticlesByTypeJPQL(String type);

    @Query("SELECT a FROM Article a WHERE a.prixArticle = ?1")
    List<Article> getArticlesByPrixJPQL(float prix);

//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Article a WHERE a.typeArticle = ?1")
//    boolean existsByNomArticle(String nom);

    @Query("SELECT COUNT(a) FROM Article a WHERE a.typeArticle = ?1")
    long countByTypeArticle(String type);

    @Query("SELECT a FROM Article a WHERE a.nomArticle LIKE %?1% AND a.typeArticle= ?2") //////
    List<Article> getArticlesByNomAndType(String nom,String type);

    @Query("SELECT a FROM Article a WHERE a.prixArticle BETWEEN ?1 AND ?2 AND a.typeArticle = ?3") //////
    List<Article> getArticlesByPrixAndType(float min,float max,String type);

//    @Query("SELECT a FROM Article a WHERE LOWER(a.nomArticle) LIKE CONCAT(LOWER(?1), '%') ORDER BY a.prixArticle ASC")
//    List<Article> getArticlesByNomStartsWithOrderByPrix(String nom);

    //@Query("")
//12

}

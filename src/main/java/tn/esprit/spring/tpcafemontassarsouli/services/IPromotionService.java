package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface IPromotionService {
    Promotion addPromotion(Promotion a);
    PromotionResponse savePromotionDTO(PromotionRequest p);

    List<Promotion> savePromotion(List<Promotion> promotions);
    List<PromotionResponse> saveListPromotionsDTO(List<PromotionRequest> p);

    Promotion selectPromotionByIdWithGet(long id);
    PromotionResponse getPromotionByIdDTO(long id);

    Promotion selectPromotionByIdWithOrElse(long id);
    List<Promotion> selectAllPromotion();
    List<PromotionResponse> getAllPromotionsDTO();

    void deletePromotion(Promotion a);
    void deleteAllPromotion();
    void deletePromotionById(long id);
    long countingPromotion();
    boolean verifPromotionById(long id);


    void affecterPromotionAArticle(long idPromotion, long idArticle);
    void desaffecterPromotionAArticle(long idPromotion, long idArticle);

    //keyword
    List<Promotion> keywordFindByPourcentagePromo(String promo);
    List<Promotion> keywordFindByDateDebutPromo(LocalDate date);
    List<Promotion> keywordFindByDateFinPromo(LocalDate date);

    boolean keywordExistsByPourcentagePromo(String promo);
    long keywordCountByDateDebutPromoAfter(LocalDate date);
    List<Promotion> keywordFindByArticleIsNotEmpty();
    List<Promotion> keywordFindByPourcentagePromoAndDateDebutPromoBetween(String promo, LocalDate start, LocalDate end);

    List<Promotion> keywordFindByPourcentagePromoOrderByDateDebutPromo(String promo);
    List<Promotion> keywordFindByArticleNotEmptyOrderByPourcentagePromo();
    List<Promotion> keywordFindByDateFinPromoIsNull();
    List<Promotion> keywordFindByPourcentagePromoIsNotNull();
    List<Promotion> keywordFindByDateFinPromoBefore(LocalDate date);
    void ajouterPromotionEtAffecterAArticle(Promotion promo,long idArticle);

}

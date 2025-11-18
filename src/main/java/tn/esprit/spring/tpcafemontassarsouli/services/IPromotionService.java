package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;

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
}

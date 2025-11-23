package tn.esprit.spring.tpcafemontassarsouli.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;
import tn.esprit.spring.tpcafemontassarsouli.mappers.PromotionMapper;
import tn.esprit.spring.tpcafemontassarsouli.repositories.ArticleRepository;
import tn.esprit.spring.tpcafemontassarsouli.repositories.PromotionRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class PromotionService implements IPromotionService{
    PromotionRepository repo;
    PromotionMapper mapper;
    ArticleRepository articleRepo;
    @Override
    public Promotion addPromotion(Promotion a) {
        return repo.save(a);
    }

    @Override
    public PromotionResponse savePromotionDTO(PromotionRequest p) {
        return mapper.fromEntityToDTO(repo.save(mapper.fromDTOToEntity(p)));
    }

    @Override
    public List<Promotion> savePromotion(List<Promotion> promotions) {
        return repo.saveAll(promotions);
    }

    @Override
    public List<PromotionResponse> saveListPromotionsDTO(List<PromotionRequest> p) {
        return mapper.fromListEntityToDTO(repo.saveAll(mapper.fromListDTOToListEntity(p)));
    }

    @Override
    public Promotion selectPromotionByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public PromotionResponse getPromotionByIdDTO(long id) {
        return mapper.fromEntityToDTO(repo.findById(id).get());
    }

    @Override
    public Promotion selectPromotionByIdWithOrElse(long id) {
        Promotion fakePromotion = Promotion.builder()
                .pourcentagePromo("0%")
                .dateDebutPromo(null)
                .dateFinPromo(null)
                .build();
        return repo.findById(id).orElse(fakePromotion);
    }

    @Override
    public List<Promotion> selectAllPromotion() {
        return repo.findAll();
    }

    @Override
    public List<PromotionResponse> getAllPromotionsDTO() {
        return mapper.fromListEntityToDTO(repo.findAll());
    }

    @Override
    public void deletePromotion(Promotion a) {
        repo.delete(a);
    }

    @Override
    public void deleteAllPromotion() {
        repo.deleteAll();
    }

    @Override
    public void deletePromotionById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingPromotion() {
        return repo.count();
    }

    @Override
    public boolean verifPromotionById(long id) {
        return repo.existsById(id);
    }

    @Override
    public void affecterPromotionAArticle(long idPromotion, long idArticle) {
        // 1- Recuperer les objets
        Article article = articleRepo.findById(idArticle).get();
        Promotion promotion = repo.findById(idPromotion).get();
        // 2- Affecter la promotion a l'article
        article.getPromotion().add(promotion);
        // 3- Sauvegarder l'article mis a jour
        articleRepo.save(article);
    }

    @Override
    public void desaffecterPromotionAArticle(long idPromotion, long idArticle) {
        Article article = articleRepo.findById(idArticle).get();
        Promotion promotion = repo.findById(idPromotion).get();
        article.getPromotion().remove(promotion);
        articleRepo.save(article);
    }

    // keyword

    @Override
    public List<Promotion> keywordFindByPourcentagePromo(String promo) {
        return repo.findByPourcentagePromo(promo);
    }
    @Override
    public List<Promotion> keywordFindByDateDebutPromo(LocalDate date) {
        return repo.findByDateDebutPromo(date);
    }
    @Override
    public List<Promotion> keywordFindByDateFinPromo(LocalDate date) {
        return repo.findByDateFinPromo(date);
    }
    @Override
    public boolean keywordExistsByPourcentagePromo(String promo) {
        return repo.existsByPourcentagePromo(promo);
    }
    @Override
    public long keywordCountByDateDebutPromoAfter(LocalDate date) {
        return repo.countByDateDebutPromoAfter(date);
    }
    @Override
    public List<Promotion> keywordFindByArticleIsNotEmpty() {
        return repo.findByArticleEmpty();
    }
    @Override
    public List<Promotion> keywordFindByPourcentagePromoAndDateDebutPromoBetween(String promo, LocalDate start, LocalDate end) {
        return repo.findByPourcentagePromoAndDateDebutPromoBetween(promo, start, end);
    }
    @Override
    public List<Promotion> keywordFindByPourcentagePromoOrderByDateDebutPromo(String promo) {
        return repo.findByPourcentagePromoOrderByDateDebutPromo(promo);
    }
    @Override
    public List<Promotion> keywordFindByArticleNotEmptyOrderByPourcentagePromo() {
        return repo.findByArticleNotEmptyOrderByPourcentagePromo();
    }
    @Override
    public List<Promotion> keywordFindByDateFinPromoIsNull() {
        return repo.findByDateFinPromoIsNull();
    }
    @Override
    public List<Promotion> keywordFindByPourcentagePromoIsNotNull() {
        return repo.findByPourcentagePromoIsNotNull();
    }
    @Override
    public List<Promotion> keywordFindByDateFinPromoBefore(LocalDate date) {
        return repo.findByDateFinPromoBefore(date);
    }
}

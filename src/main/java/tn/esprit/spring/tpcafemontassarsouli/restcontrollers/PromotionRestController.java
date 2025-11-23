package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;
import tn.esprit.spring.tpcafemontassarsouli.services.IPromotionService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("promotion")
public class PromotionRestController {
    IPromotionService service;

    @PostMapping("savePromotionDTO")
    public PromotionResponse savePromotionDTO(@RequestBody PromotionRequest p){
        return service.savePromotionDTO(p);
    }

    @PostMapping("saveListPromotionsDTO")
    public List<PromotionResponse> saveListPromotionsDTO(@RequestBody List<PromotionRequest> p){
        return service.saveListPromotionsDTO(p);
    }

    @GetMapping("getPromotionByIdDTO/{id}")
    public PromotionResponse getPromotionByIdDTO(@PathVariable("id") long id) {
        return service.getPromotionByIdDTO(id);
    }

    @GetMapping("getAllPromotionsDTO")
    public List<PromotionResponse> getAllPromotionsDTO() {
        return service.getAllPromotionsDTO();
    }

    @PutMapping("affecterPromotionAArticle")
    public void affecterPromotionAArticle(@RequestParam long idPromotion,@RequestParam long idArticle){
        service.affecterPromotionAArticle(idPromotion, idArticle);
    }

    @PutMapping("desaffecterPromotionAArticle")
    public void desaffecterPromotionAArticle(@RequestParam long idPromotion,@RequestParam long idArticle){
        service.desaffecterPromotionAArticle(idPromotion, idArticle);
    }

    // Rest Keywords
    @GetMapping("keywordFindByPourcentagePromo")
    List<Promotion> keywordFindByPourcentagePromo(@RequestParam String promo){
        return service.keywordFindByPourcentagePromo(promo);
    }    @GetMapping("keywordFindByDateDebutPromo")
    List<Promotion> keywordFindByDateDebutPromo(@RequestParam LocalDate date){
        return service.keywordFindByDateDebutPromo(date);
    }    @GetMapping("keywordFindByDateFinPromo")
    List<Promotion> keywordFindByDateFinPromo(@RequestParam LocalDate date){
        return service.keywordFindByDateFinPromo(date);
    }
    @GetMapping("/keywordExistsByPourcentagePromo")
    public boolean keywordExistsByPourcentagePromo(@RequestParam String promo) {
        return service.keywordExistsByPourcentagePromo(promo);
    }
    @GetMapping("/keywordCountByDateDebutPromoAfter")
    public long keywordCountByDateDebutPromoAfter(@RequestParam LocalDate date) {
        return service.keywordCountByDateDebutPromoAfter(date);
    }
    @GetMapping("/keywordFindByArticleIsNotEmpty")
    public List<Promotion> keywordFindByArticleIsNotEmpty() {
        return service.keywordFindByArticleIsNotEmpty();
    }
    @GetMapping("/keywordFindByPourcentagePromoAndDateDebutPromoBetween")
    public List<Promotion> keywordFindByPourcentagePromoAndDateDebutPromoBetween(
            @RequestParam String promo,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.keywordFindByPourcentagePromoAndDateDebutPromoBetween(promo, start, end);
    }
    @GetMapping("/keywordFindByPourcentagePromoOrderByDateDebutPromo")
    public List<Promotion> keywordFindByPourcentagePromoOrderByDateDebutPromo(@RequestParam String promo) {
        return service.keywordFindByPourcentagePromoOrderByDateDebutPromo(promo);
    }
    @GetMapping("/keywordFindByArticleIsNotEmptyOrderByPourcentagePromo")
    public List<Promotion> keywordFindByArticleIsNotEmptyOrderByPourcentagePromo() {
        return service.keywordFindByArticleNotEmptyOrderByPourcentagePromo();
    }
    @GetMapping("/keywordFindByDateFinPromoIsNull")
    public List<Promotion> keywordFindByDateFinPromoIsNull() {
        return service.keywordFindByDateFinPromoIsNull();
    }
    @GetMapping("/keywordFindByPourcentagePromoIsNotNull")
    public List<Promotion> keywordFindByPourcentagePromoIsNotNull() {
        return service.keywordFindByPourcentagePromoIsNotNull();
    }
    @GetMapping("/keywordFindByDateFinPromoBefore")
    public List<Promotion> keywordFindByDateFinPromoBefore(@RequestParam LocalDate date) {
        return service.keywordFindByDateFinPromoBefore(date);
    }

}

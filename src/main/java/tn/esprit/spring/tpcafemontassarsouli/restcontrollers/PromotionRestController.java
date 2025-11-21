package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionResponse;
import tn.esprit.spring.tpcafemontassarsouli.services.IPromotionService;

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
    public void desaffecterPromotionAArticle(long idPromotion, long idArticle){
        service.desaffecterPromotionAArticle(idPromotion, idArticle);
    }
}

package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleResponse;
import tn.esprit.spring.tpcafemontassarsouli.services.IArticleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("article")
public class ArticleRestController {
    IArticleService service;

    @PostMapping("saveArticleDTO")
    public ArticleResponse saveArticleDTO(@RequestBody ArticleRequest a){
        return service.saveArticleDTO(a);
    }

    @PostMapping("saveListArticlesDTO")
    public List<ArticleResponse> saveListArticlesDTO(@RequestBody List<ArticleRequest> a){
        return service.saveListArticlesDTO(a);
    }

    @GetMapping("getArticleByIdDTO/{id}")
    public ArticleResponse getArticleByIdDTO(@PathVariable("id") long id){
        return service.getArticleByIdDTO(id);
    }

    @GetMapping("getAllArticlesDTO")
    public List<ArticleResponse> getAllArticlesDTO(){
        return service.getAllArticlesDTO();
    }



}

package tn.esprit.spring.tpcafemontassarsouli.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.article.ArticleResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;
import tn.esprit.spring.tpcafemontassarsouli.entities.TypeArticle;
import tn.esprit.spring.tpcafemontassarsouli.mappers.ArticleMapper;
import tn.esprit.spring.tpcafemontassarsouli.repositories.ArticleRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ArticleService implements IArticleService{
    ArticleRepository repo;
    ArticleMapper mapper;
    @Override
    public Article addArticle(Article a) {
        return repo.save(a);
    }

    @Override
    public ArticleResponse saveArticleDTO(ArticleRequest a) {
        return mapper.fromEntityToDTO(repo.save(mapper.fromDTOToEntity(a)));
    }

    @Override
    public List<Article> saveArticle(List<Article> articles) {
        return repo.saveAll(articles);
    }

    @Override
    public List<ArticleResponse> saveListArticlesDTO(List<ArticleRequest> a) {
        return mapper.fromListEntityToListDTO(repo.saveAll(mapper.fromListDTOToListEntity(a)));
    }

    @Override
    public Article selectArticleByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public ArticleResponse getArticleByIdDTO(long id) {
        return mapper.fromEntityToDTO(repo.findById(id).get());
    }

    @Override
    public Article selectArticleByIdWithOrElse(long id) {
        Article fakeArticle = Article.builder()
                .nomArticle("cake")
                .prixArticle(100)
                .typeArticle(TypeArticle.SNACK)
                .build();
        return repo.findById(id).orElse(fakeArticle);
    }

    @Override
    public List<Article> selectAllArticle() {
        return repo.findAll();
    }

    @Override
    public List<ArticleResponse> getAllArticlesDTO() {
        return mapper.fromListEntityToListDTO(repo.findAll());
    }

    @Override
    public void deleteArticle(Article a) {
        repo.delete(a);
    }

    @Override
    public void deleteAllArticle() {
        repo.deleteAll();
    }

    @Override
    public void deleteArticleById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingArticle() {
        return repo.count();
    }

    @Override
    public boolean verifArticleById(long id) {
        return repo.existsById(id);
    }
}

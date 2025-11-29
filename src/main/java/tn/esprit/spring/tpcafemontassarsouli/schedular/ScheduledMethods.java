package tn.esprit.spring.tpcafemontassarsouli.schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.tpcafemontassarsouli.entities.Article;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.services.IArticleService;
import tn.esprit.spring.tpcafemontassarsouli.services.ICarteFideliteService;
import tn.esprit.spring.tpcafemontassarsouli.services.IClientService;

@Component
@AllArgsConstructor
@Slf4j
public class ScheduledMethods {
    IClientService clientService;
    IArticleService articleService;
    // fixedRate(ms) par periode (peut avoir 2 exec sumultané de meme method)
    // fixedDelay(ms) par delai (attend la fin de la 1ere exec avant de lancer la 2eme)
    // Cron (* * * * * *)
    @Scheduled(fixedRate = 2000)
    public void method1(){
        log.info("Ceci est un message");
    }

    @Scheduled(fixedDelay = 4000)
    public void method2(){
        log.warn("Ceci est un message 2");
    }

    // Implimenter la methode qui incremente les points de fidlite des client dont la date systeme correspond
    // a la date d'anniversaire (+10%) cette methode se declenche chaque jour a 00h00m00s utiliser SLFuJ pour afficher les client concernes

//    @Scheduled(cron = "0 0 0 * * *")
//    public void method3(){
//        service.incrementerPointsFidelite();
//    }
    @Scheduled(cron = "0 0 0 * * *")
    public void method3(){
        for (Client client: clientService.incrementerPts()){
            log.info("Client" + client.getNom() + " " + client.getPrenom());
        }
    }

    // 2 - Implementer une methode qui se declanche chaque debut du mois ,qui affiche les articles en promo de ce mois
    @Scheduled(cron = "0 0 0 1 * *")
    public void method4() {
        for (Article article : articleService.getArticlesEnPromotion()){
            log.info("Articles en promo : "  + article.getNomArticle());
        }
    }

}

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

    @Scheduled(cron = "0 0 0 * * *")// chaque jour a minuit
    public void method3(){
        for (Client client: clientService.incrementerPts()){
            log.info("Client" + client.getNom() + " " + client.getPrenom());
        }
    }

    // 2 - Implementer une methode qui se declanche chaque debut du mois ,qui affiche les articles en promo de ce mois
    @Scheduled(cron = "0 0 0 1 * *")// 1er jour de chaque mois a minuit
    public void method4() {
        for (Article article : articleService.getArticlesEnPromotion()){
            log.info("Articles en promo : "  + article.getNomArticle());
        }
    }
    // 1s = 1000ms
    // 1m = 60000ms
    // 1h = 3600000ms

    // exemple temps maintenant 08h15m05s
    // (cron = "15 * * * * *") // chaque minute a la 15eme seconde -->08h15m15s , 08h16m15s ...
    // (cron = "*/15 * * * * *") // chaque 15 secondes --> 08h15m20s , 08h15m35s ...
    // (cron = "0/15 * * * * *") // chaque minute a partir de la 0eme seconde chaque 15 secondes --> 08h15m15s , 08h15m30s ...
    // (cron = "0 0/30 11 * * *") // chaque heure entre 11h00 et 11h59 chaque 30 minutes --> 11h00m00s , 11h30m00s
    // (cron = "0 0 12 * * ?") // chaque jour a 12h00
    // (cron = "0 0 0 ? 4 ?") ou (cron = "0 0 0 * 4 *") // chaque jour a minuit au mois d'avril
    // (cron = "0 0 9 14 2 SUN,TUE") // chaque 14 fevrier a 9h00 si c'est un dimanche ou mardi
    // (cron = "0 0 9 14 2 SUN-TUE") // chaque 14 fevrier a 9h00 si c'est un dimanche , lundi ou mardi

    // cron 1er * : secondes            0->59
    // cron 2eme * : minutes            0->59
    // cron 3eme * : heures             0->23
    // cron 4eme * : jour du mois       1->31
    // cron 5eme * : mois               1->12
    // cron 6eme * : jour de la semaine 0->6 (0=dimanche) ou
    // SUN(dimanche), MON(lundi), TUE(mardi), WED(mercredi), THU(jeudi), FRI(vendredi), SAT(samedi)
}

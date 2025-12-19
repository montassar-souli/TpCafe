package tn.esprit.spring.tpcafemontassarsouli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;
import tn.esprit.spring.tpcafemontassarsouli.repositories.AdresseRepository;

import java.util.List;

@EnableScheduling // Enable the scheduling feature
@SpringBootApplication
@Slf4j
public class TpCafeMontassarSouliApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpCafeMontassarSouliApplication.class, args);
    }

    @Bean
    CommandLineRunner testRepositoryMethods(AdresseRepository adresseRepository) {
        return args -> {
            // Test findByCodePostalBetween
            List<Adresse> adresses = adresseRepository.findByCodePostalBetween(1000, 2000);
            log.info("Adresses with code postal between 1000 and 2000: {}", adresses);

            // Test JPQL method
            List<Adresse> jpqlResults = adresseRepository.recupJPQL("Rue de la Paix");
            log.info("JPQL results: {}", jpqlResults);

            // Test SQL method
            List<Adresse> sqlResults = adresseRepository.recupSQL("Rue de la Paix");
            log.info("SQL results: {}", sqlResults);

            // Test other methods
            List<Adresse> byRue = adresseRepository.findByRueLike("%ben%");
            log.info("Rue containing 'ben': {}", byRue);
        };
    }
}

package tn.esprit.spring.tpcafemontassarsouli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // Enable the scheduling feature
@SpringBootApplication
public class TpCafeMontassarSouliApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpCafeMontassarSouliApplication.class, args);
    }

}

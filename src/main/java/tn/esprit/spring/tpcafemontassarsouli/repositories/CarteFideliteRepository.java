package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite,Long> {
    // 1-
    List<CarteFidelite> getByPointAccumules(int points);
    // 2-
    List<CarteFidelite> getByDateCreatingEquals(LocalDate date);
    // 3-
    long countByPointAccumulesGreaterThan(int points);
    // 4-
    void deleteByDateCreatingBefore(LocalDate date);
    // 5-
    List<CarteFidelite> getByPointAccumulesBetweenAndDateCreatingAfter(int min,int max,LocalDate date);
    // 6-
    List<CarteFidelite> getByPointAccumulesGreaterThanOrderByDateCreating(int points);
    // 7-
    List<CarteFidelite> getByDateCreatingBetween(LocalDate min,LocalDate max);
    // 8-
    List<CarteFidelite> getByPointAccumulesLessThanOrderByDateCreating(int points);
    // 9-
    CarteFidelite getFirstByOrderByPointAccumulesDesc();
    // 10-
    List<CarteFidelite> getByDateCreatingIsNull();
    //11-
    List<CarteFidelite> getByPointAccumulesIsNotNull();
    //12-
    List<CarteFidelite> getByClientNomAndClientPrenom(String nom,String prenom);
    @Query("SELECT carte FROM CarteFidelite carte WHERE carte.client.nom = ?1 AND carte.client.prenom = ?2")
    CarteFidelite findClientByNomAndPrenomJPQL(String n,String p);
    //13-
    List<CarteFidelite> getTop5ByOrderByPointAccumulesDesc();

}

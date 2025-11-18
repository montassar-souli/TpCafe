package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite,Long> {

    List<CarteFidelite> getByPointAccumules(int points);
    List<CarteFidelite> getByDateCreatingEquals(LocalDate date);
    long countByPointAccumulesGreaterThan(int points);
    void deleteByDateCreatingBefore(LocalDate date);
    List<CarteFidelite> getByPointAccumulesBetweenAndDateCreatingAfter(int min,int max,LocalDate date);
    List<CarteFidelite> getByPointAccumulesGreaterThanOrderByDateCreating(int points);
    List<CarteFidelite> getByDateCreatingBetween(LocalDate min,LocalDate max);
    List<CarteFidelite> getByPointAccumulesLessThanOrderByDateCreating(int points);
    CarteFidelite getFirstByOrderByPointAccumulesDesc();
    List<CarteFidelite> getByDateCreatingIsNotNull();

    List<CarteFidelite> getByClientNomAndClientPrenom(String nom,String prenom);
    @Query("SELECT carte FROM CarteFidelite carte WHERE carte.client.nom = ?1 AND carte.client.prenom = ?2")
    CarteFidelite findClientByNomAndPrenomJPQL(String n,String p);

    List<CarteFidelite> getTop5ByOrderByPointAccumulesDesc();

}

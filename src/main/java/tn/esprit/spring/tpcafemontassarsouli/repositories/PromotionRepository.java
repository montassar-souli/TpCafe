package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {

    // 1. Trouver les promotions par pourcentage exact
    List<Promotion> findByPourcentagePromo(String p);
    // 2. Trouver les promotions par date de début
    List<Promotion> findByDateDebutPromo(LocalDate date);
    // 3. Trouver les promotions par date de fin
    List<Promotion> findByDateFinPromo(LocalDate date);
    // 4. Vérifier l'existence d'une promotion par pourcentage
    boolean existsByPourcentagePromo(String promo);
    // 5. Compter les promotions débutant après une date
    long countByDateDebutPromoAfter(LocalDate date);
    // 6. Trouver les promotions actives à une date donnée
    List<Promotion> findByArticleEmpty();
    // 7. Trouver les promotions avec un pourcentage spécifique débutant dans une période
    List<Promotion> findByPourcentagePromoAndDateDebutPromoBetween(String promo,LocalDate min,LocalDate max);
    // 8. Trouver les promotions valides à une date spécifique (valide ?)

    // 9. Trouver les promotions avec certains pourcentages, triées par date de début
    List<Promotion> findByPourcentagePromoOrderByDateDebutPromo(String promo);
    // 10. Trouver les promotions actives triées par pourcentage
    List<Promotion> findByArticleNotEmptyOrderByPourcentagePromo();
    // 11. Trouver les promotions sans date de fin
    List<Promotion> findByDateFinPromoIsNull();
    // 12. Trouver les promotions avec un pourcentage renseigné (renseigné ?)
    List<Promotion> findByPourcentagePromoIsNotNull();
    // 13. Trouver les promotions avec leurs articles associés
    // 14. Trouver les promotions expirées
    List<Promotion> findByDateFinPromoBefore(LocalDate date);

}

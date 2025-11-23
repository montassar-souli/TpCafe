package tn.esprit.spring.tpcafemontassarsouli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;

import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse,Long> {

    //select * from Adress where rue
    Adresse findByRue(String rue);
    List<Adresse> getByRue(String rue);
    List<Adresse> searchByRue(String rue);
    List<Adresse> readByRue(String rue);
    List<Adresse> queryByRue(String rue);

    //select * from Adress where rue=Soukra ou rue=SOUKRA
    List<Adresse> findByRueIgnoreCase(String rue);

    //select * from Adress where rue= .... and ....
    List<Adresse> findByRueAndVille(String rue,String ville);
    //select * from Adress where rue= .... or ....
    List<Adresse> findByRueOrVille(String rue,String ville);

    //select * from Adress where rue=%ben%
    List<Adresse> findByRueLike(String chaine);
    List<Adresse> findByRueContains(String chaine);
    List<Adresse> findByRueContaining(String chaine);

    List<Adresse> findByRueStartingWith(String c);
    List<Adresse> findByRueStartsWith(String c);
    List<Adresse> findByRueIsStartingWith(String c);

    List<Adresse> findByRueEndingWith(String c);
    List<Adresse> findByRueEndsWith(String c);
    List<Adresse> findByRueIsEndingWith(String c);


    // select * from Adress where codePostal < ...
    List<Adresse> findByCodePostalLessThan(int c);
    // select * from Adress where codePostal < ...
    List<Adresse> findByCodePostalLessThanEqual(int c);
    // select * from Adress where codePostal < ...
    List<Adresse> findByCodePostalGreaterThanAndCodePostalLessThan(int min,int max);
    // select * from Adress where codePostal < ...
    List<Adresse> findByCodePostalBetween(int min,int max);

    @Query("SELECT a FROM Adresse a WHERE a.rue = ?1")
    List<Adresse> recupJPQL(String rue);

    @Query(value = "SELECT * FROM adresse WHERE rue =:r",nativeQuery = true)
    List<Adresse> recupSQL(@Param("r")String rue);

    @Query("SELECT a FROM Adresse a WHERE a.rue = ?2 AND a.ville = ?1")
    List<Adresse> recupJPQL1(String ville,String rue);

    @Query(value = "SELECT * FROM adresse WHERE rue =:r AND ville =:v",nativeQuery = true)
    List<Adresse> recupSQL1(@Param("r")String rue, @Param("v")String ville);

}

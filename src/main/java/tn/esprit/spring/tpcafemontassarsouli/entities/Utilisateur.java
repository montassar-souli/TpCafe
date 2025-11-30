package tn.esprit.spring.tpcafemontassarsouli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity // Pour definir que Utilisateur est en entité JPA
@Table(name="user") // personnaliser le nom de la table dans la BD
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private long id;

    @Column(name="lastName") // personnaliser le nom de la colonne dans la BD
    private String nom;

    @Column(name ="firstName")
    private  String prenom;

    //@Enumerated  tinyint @Enumerated(EnumType.ORDINAL) => 0,1,2
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Sexe sexe;

    @Column(unique = true) // contrainte d'unicité
    private long cin;

    private LocalDate dateNaissance; //localTime localDateTime

    @Temporal(TemporalType.DATE) // Pour stocker uniquement la date (sans l'heure)
    private Date dateAjout;

    @Transient // ignorer cet attribut dans la BD
    private int age;
}

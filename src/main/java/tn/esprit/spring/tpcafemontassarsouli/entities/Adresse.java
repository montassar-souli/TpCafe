package tn.esprit.spring.tpcafemontassarsouli.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAdresse;
    //@NonNull
    String rue;
    String ville;
    //@JsonIgnore
    int codePostal;

}

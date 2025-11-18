package tn.esprit.spring.tpcafemontassarsouli.dto.adresse;

import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdresseResponse {
    long idAdresse;
    String rue;
    String ville;
    int codePostal;
}

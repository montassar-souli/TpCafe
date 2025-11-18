package tn.esprit.spring.tpcafemontassarsouli.dto.adresse;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.Mapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdresseRequest {
    String rue;
    String ville;
    int codePostal;
}

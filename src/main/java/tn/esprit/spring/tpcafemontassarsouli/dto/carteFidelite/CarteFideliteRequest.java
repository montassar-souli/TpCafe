package tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFideliteRequest {
    long idCarteFidilite;
    int pointAccumules;
    LocalDate dateCreating;
    Client client;
}

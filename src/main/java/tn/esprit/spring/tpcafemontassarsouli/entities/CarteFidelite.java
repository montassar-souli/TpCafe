package tn.esprit.spring.tpcafemontassarsouli.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCarteFidilite;
    int pointAccumules;
    LocalDate dateCreating;
    @OneToOne(mappedBy = "carteFidelite")
    Client client;
}

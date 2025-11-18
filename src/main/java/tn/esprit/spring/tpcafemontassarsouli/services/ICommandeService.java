package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface ICommandeService {
    Commande addCommande(Commande a);
    CommandeResponse saveCommandeDTO(CommandeRequest c);

    List<Commande> saveCommande(List<Commande> commandes);
    List<CommandeResponse> saveListCommandesDTO(List<CommandeRequest> c);

    Commande selectCommandeByIdWithGet(long id);
    CommandeResponse getCommandeByIdDTO(long id);

    Commande selectCommandeByIdWithOrElse(long id);
    List<Commande> selectAllCommande();
    List<CommandeResponse> getAllCommandesDTO();

    void deleteCommande(Commande a);
    void deleteAllCommande();
    void deleteCommandeById(long id);
    long countingCommande();
    boolean verifCommandeById(long id);

    void affecterCommandeAClient(long idCommande, long idClient);
    void affecterCommandeAClient(LocalDate dateCommande,String nomClient, String prenomClient);
    void desaffecterCommandeDeClient(long idCommande);
}

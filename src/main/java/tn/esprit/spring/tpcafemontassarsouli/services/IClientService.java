package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;

import java.util.List;

public interface IClientService {
    Client addClient(Client a);
    ClientResponse saveClientDTO(ClientRequest c);

    List<Client> saveClient(List<Client> clients);
    List<ClientResponse> saveListClientsDTO(List<ClientRequest> c);

    Client selectClientByIdWithGet(long id);
    ClientResponse getClientByIdDTO(long id);

    Client selectClientByIdWithOrElse(long id);
    List<Client> selectAllClient();
    List<ClientResponse> getAllClientsDTO();

    void deleteClient(Client a);
    void deleteAllClient();
    void deleteClientById(long id);
    long countingClient();
    boolean verifClientById(long id);
    void ajouterClient(Client c);

    void ajouterCommandeEtAffecterAClient(Commande c, String nomClient, String prenomClient);
    void ajouterEtAffecterAdresseAClient(Adresse adresse, Client client);
    void ajoutClientEtCarteFidelite(CarteFidelite carte);
    void ajouterClientEtCarteFideliteCascade(Client client);
    void supprimerClientEtCarteFideliteCascade(Client client);
    void addClientEtCarteFidelite(Client client);
    List <Client> incrementerPts();
}

package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;

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
}

package tn.esprit.spring.tpcafemontassarsouli.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;
import tn.esprit.spring.tpcafemontassarsouli.mappers.ClientMapper;
import tn.esprit.spring.tpcafemontassarsouli.repositories.AdresseRepository;
import tn.esprit.spring.tpcafemontassarsouli.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafemontassarsouli.repositories.ClientRepository;
import tn.esprit.spring.tpcafemontassarsouli.repositories.CommandeRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class ClientService implements IClientService{
    ClientRepository repo;
    CommandeRepository commandeRepo;
    AdresseRepository adresseRepo;
    CarteFideliteRepository carteFideliteRepo;
    ClientMapper mapper;
    @Override
    public Client addClient(Client a) {
        return repo.save(a);
    }

    @Override
    public ClientResponse saveClientDTO(ClientRequest c) {
        return mapper.fromEntityToDTO(repo.save(mapper.fromDTOToEntity(c)));
    }

    @Override
    public List<Client> saveClient(List<Client> clients) {
        return repo.saveAll(clients);
    }

    @Override
    public List<ClientResponse> saveListClientsDTO(List<ClientRequest> c) {
        return mapper.fromListEntityToDTO(repo.saveAll(mapper.fromListDTOToListEntity(c)));
    }

    @Override
    public Client selectClientByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public ClientResponse getClientByIdDTO(long id) {
        return mapper.fromEntityToDTO(repo.findById(id).get());
    }

    @Override
    public Client selectClientByIdWithOrElse(long id) {
        Client fakeClient = Client.builder()
                .idClient(-1L)
                .nom("Fake")
                .prenom("Fake")
                .dateNaissance(null)
                .build();
        return repo.findById(id).orElse(fakeClient);
    }

    @Override
    public List<Client> selectAllClient() {
        return repo.findAll();
    }

    @Override
    public List<ClientResponse> getAllClientsDTO() {
        return mapper.fromListEntityToDTO(repo.findAll());
    }

    @Override
    public void deleteClient(Client a) {
        repo.delete(a);
    }

    @Override
    public void deleteAllClient() {
        repo.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingClient() {
        return repo.count();
    }

    @Override
    public boolean verifClientById(long id) {
        return repo.existsById(id);
    }

    @Override
    public void ajouterClient(Client c) {
        repo.save(c);
    }

    @Override
    public void ajouterCommandeEtAffecterAClient(Commande c, String nomClient, String prenomClient) {
//        commandeRepo.save(c);
//        Commande commande = commandeRepo.findById(c.getIdCommande()).get();
        c = commandeRepo.save(c);
        Client client = repo.findByNomAndPrenom(nomClient,prenomClient);
        c.setClient(client);
        commandeRepo.save(c);
    }

    @Override
    public void ajouterEtAffecterAdresseAClient(Adresse adresse, Client client) {
        client.setAdresse(adresse);
        repo.save(client);
    }

    @Override
    public void ajoutClientEtCarteFidelite(CarteFidelite carte) {
        Client client = repo.save(carte.getClient());
        carte = carteFideliteRepo.save(carte);

        client.setCarteFidelite(carte);
        repo.save(client);
    }

    @Override
    public void ajouterClientEtCarteFideliteCascade(Client client) {
            repo.save(client);
    }

    @Override
    public void supprimerClientEtCarteFideliteCascade(Client client) {
            repo.delete(client);
    }

    @Override
    public void addClientEtCarteFidelite(Client client) {
        // l'ajout de la carte se fait dans le code
        CarteFidelite carte = CarteFidelite
                .builder()
                .pointAccumules(0)
                .dateCreating(LocalDate.now())
                .build();
        client.setCarteFidelite(carte);
        repo.save(client);
    }

    @Override
    public List<Client> incrementerPts() {
            List<Client> clients = repo.findByDateNaissance(LocalDate.now());
            for(Client c:clients){
                c.getCarteFidelite().setPointAccumules
                        ((int) (c.getCarteFidelite().getPointAccumules()
                                + (c.getCarteFidelite().getPointAccumules() * 0.1)));
                carteFideliteRepo.save(c.getCarteFidelite());
            }
        return clients;
    }

}

package tn.esprit.spring.tpcafemontassarsouli.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;
import tn.esprit.spring.tpcafemontassarsouli.mappers.CommandeMapper;
import tn.esprit.spring.tpcafemontassarsouli.repositories.ClientRepository;
import tn.esprit.spring.tpcafemontassarsouli.repositories.CommandeRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {
    CommandeRepository repo;
    CommandeMapper mapper;
    ClientRepository clientRepo;
    @Override
    public Commande addCommande(Commande a) {
        return repo.save(a);
    }

    @Override
    public CommandeResponse saveCommandeDTO(CommandeRequest c) {
        return mapper.fromEntityToDTO(repo.save(mapper.fromDTOToEntity(c)));
    }

    @Override
    public List<Commande> saveCommande(List<Commande> commandes) {
        return repo.saveAll(commandes);
    }

    @Override
    public List<CommandeResponse> saveListCommandesDTO(List<CommandeRequest> c) {
        return mapper.fromListEntityToListDTO(repo.saveAll(mapper.fromListDTOToListEntity(c)));
    }

    @Override
    public Commande selectCommandeByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public CommandeResponse getCommandeByIdDTO(long id) {
        return mapper.fromEntityToDTO(repo.findById(id).get());
    }

    @Override
    public Commande selectCommandeByIdWithOrElse(long id) {
        Commande fakeCommande = Commande.builder()
                .dateCommande(null)
                .totalCommande(0)
                .build();
        return repo.findById(id).orElse(fakeCommande);
    }

    @Override
    public List<Commande> selectAllCommande() {
        return repo.findAll();
    }

    @Override
    public List<CommandeResponse> getAllCommandesDTO() {
        return mapper.fromListEntityToListDTO(repo.findAll());
    }

    @Override
    public void deleteCommande(Commande a) {
        repo.delete(a);
    }

    @Override
    public void deleteAllCommande() {
        repo.deleteAll();
    }

    @Override
    public void deleteCommandeById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingCommande() {
        return repo.count();
    }

    @Override
    public boolean verifCommandeById(long id) {
        return repo.existsById(id);
    }

    @Override
    public void affecterCommandeAClient(long idCommande, long idClient) {
        // 1- Recuper les Objets
        Commande commande = repo.findById(idCommande).get();
        Client client = clientRepo.findById(idClient).get();
        // 2- Parent (Commande) ? Child (Client)
        // 3- On affecte le Child au Parent
        commande.setClient(client);
        // 4- Persistance de l'affectation (save au parent)
        repo.save(commande);
    }

    @Override
    public void affecterCommandeAClient(LocalDate dateCommande, String nomClient, String prenomClient) {
        // 1- Recuper les Objets
        Commande commande = repo.findByDateCommande(dateCommande);
        Client client = clientRepo.findByNomAndPrenom(nomClient, prenomClient);
        // 2- Parent (Commande) ? Child (Client)
        // 3- On affecte le Child au Parent
        commande.setClient(client);
        // 4- Persistance de l'affectation (save au parent)
        repo.save(commande);
    }

    @Override
    public void desaffecterCommandeDeClient(long idCommande) {
        // 1- Recuper les Objets
        Commande commande = repo.findById(idCommande).get();
        // 2- Parent (Commande) ? Child (Client)
        // 3- On desaffecte le Child du Parent
        commande.setClient(null);
        // 4- Persistance de la desaffectation (save au parent)
        repo.save(commande);
    }


}

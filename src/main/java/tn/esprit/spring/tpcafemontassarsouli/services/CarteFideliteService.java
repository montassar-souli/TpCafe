package tn.esprit.spring.tpcafemontassarsouli.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.mappers.CarteFideliteMapper;
import tn.esprit.spring.tpcafemontassarsouli.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafemontassarsouli.repositories.ClientRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CarteFideliteService implements ICarteFideliteService{
    CarteFideliteRepository repo;
    CarteFideliteMapper mapper;
    ClientRepository clientRepo;
    @Override
    public CarteFidelite addCarteFidelite(CarteFidelite a) {
        return repo.save(a);
    }

    @Override
    public CarteFideliteResponse saveCarteFideliteDTO(CarteFideliteRequest c) {
        return mapper.fromEntityToDTO(repo.save(mapper.fromDTOToEntity(c)));
    }

    @Override
    public List<CarteFidelite> saveCarteFidelite(List<CarteFidelite> carteFidilites) {
        return repo.saveAll(carteFidilites);
    }

    @Override
    public List<CarteFideliteResponse> saveListCarteFidelteDTO(List<CarteFideliteRequest> c) {
        return mapper.fromListEntityToDTO(repo.saveAll(mapper.fromListDTOToListEntity(c)));
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public CarteFideliteResponse getCarteFideliteByIdDTO(long id) {
        return mapper.fromEntityToDTO(repo.findById(id).get());
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithOrElse(long id) {
        CarteFidelite fakeCarteFidelite = CarteFidelite.builder()
                .pointAccumules(0)
                .dateCreating(null)
                .build();
        return repo.findById(id).orElse(fakeCarteFidelite);
    }

    @Override
    public List<CarteFidelite> selectAllCarteFidelite() {
        return repo.findAll();
    }

    @Override
    public List<CarteFideliteResponse> getAllCarteFideliteDTO() {
        return mapper.fromListEntityToDTO(repo.findAll());
    }

    @Override
    public void deleteCarteFidelite(CarteFidelite a) {
        repo.delete(a);
    }

    @Override
    public void deleteAllCarteFidelite() {
        repo.deleteAll();
    }

    @Override
    public void deleteCarteFideliteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingCarteFidelite() {
        return repo.count();
    }

    @Override
    public boolean verifCarteFideliteById(long id) {
        return repo.existsById(id);
    }

    @Override
    public void affecterCarteAClient(long idCarte, long idClient) {
        // 1- findById -> carte (child)
        CarteFidelite carte = repo.findById(idCarte).get();
        // 1- findById -> client
        Client client = clientRepo.findById(idClient).get();
        // On affecte le child au parent set
        client.setCarteFidelite(carte);
        // Persiste .save


    }
}

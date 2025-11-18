package tn.esprit.spring.tpcafemontassarsouli.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.DetailCommande;
import tn.esprit.spring.tpcafemontassarsouli.mappers.DetailCommandeMapper;
import tn.esprit.spring.tpcafemontassarsouli.repositories.DetailCommandeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailCommandeService implements IDetailCommandeService {
    DetailCommandeRepository repo;
    DetailCommandeMapper mapper;
    @Override
    public DetailCommande addDetailCommande(DetailCommande a) {
        return repo.save(a);
    }

    @Override
    public DetailCommandeResponse saveDetailCommandeDTO(DetailCommandeRequest d) {
        return mapper.fromEntityToDTO(repo.save(mapper.fromDTOToEntity(d)));
    }

    @Override
    public List<DetailCommande> saveDetailCommande(List<DetailCommande> detailCommandes) {
        return repo.saveAll(detailCommandes);
    }

    @Override
    public List<DetailCommandeResponse> saveDetailCommandesDTO(List<DetailCommandeRequest> d) {
        return mapper.fromListEntityToListDTO(repo.saveAll(mapper.fromListDTOToListEntity(d)));
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithGet(long id) {
        return repo.findById(id).get();
    }

    @Override
    public DetailCommandeResponse getDetailCommandeByIdDTO(long id) {
        return mapper.fromEntityToDTO(repo.findById(id).get());
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithOrElse(long id) {
        DetailCommande fakeDetailCommande = DetailCommande.builder()
                .quantiteArticle(10)
                .sousTotalArticle(0)
                .sousTotalArticleApresPromo(3)
                .build();
        return repo.findById(id).orElse(fakeDetailCommande);
    }

    @Override
    public List<DetailCommande> selectAllDetailCommande() {
        return repo.findAll();
    }

    @Override
    public List<DetailCommandeResponse> getAllDetailCommandesDTO() {
        return mapper.fromListEntityToListDTO(repo.findAll());
    }

    @Override
    public void deleteDetailCommande(DetailCommande a) {
        repo.delete(a);
    }

    @Override
    public void deleteAllDetailCommande() {
        repo.deleteAll();
    }

    @Override
    public void deleteDetailCommandeById(long id) {
        repo.deleteById(id);
    }

    @Override
    public long countingDetailCommande() {
        return repo.count();
    }

    @Override
    public boolean verifDetailCommandeById(long id) {
        return repo.existsById(id);
    }
}

package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.DetailCommande;

import java.util.List;

public interface IDetailCommandeService {
    DetailCommande addDetailCommande(DetailCommande a);
    DetailCommandeResponse saveDetailCommandeDTO(DetailCommandeRequest d);

    List<DetailCommande> saveDetailCommande(List<DetailCommande> detailCommandes);
    List<DetailCommandeResponse> saveDetailCommandesDTO(List<DetailCommandeRequest> d);

    DetailCommande selectDetailCommandeByIdWithGet(long id);
    DetailCommandeResponse getDetailCommandeByIdDTO(long id);

    DetailCommande selectDetailCommandeByIdWithOrElse(long id);
    List<DetailCommande> selectAllDetailCommande();
    List<DetailCommandeResponse> getAllDetailCommandesDTO();

    void deleteDetailCommande(DetailCommande a);
    void deleteAllDetailCommande();
    void deleteDetailCommandeById(long id);
    long countingDetailCommande();
    boolean verifDetailCommandeById(long id);
}

package tn.esprit.spring.tpcafemontassarsouli.services;

import tn.esprit.spring.tpcafemontassarsouli.dto.adresse.AdresseRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.adresse.AdresseResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;

import java.util.List;

public interface IAdressService {
    Adresse addAdress(Adresse a);
    AdresseResponse addAdressDTO(AdresseRequest a);

    List<Adresse> saveAdress(List<Adresse> adresses);
    List<AdresseResponse> addListAdressDTO(List<AdresseRequest> adresses);

    Adresse selectAdressByIdWithGet(long id);
    AdresseResponse selectAdressByIdDTO(long id);

    Adresse selectAdressByIdWithOrElse(long id);

    List<Adresse> selectAllAdress();
    List<AdresseResponse> selectAllAdressDTO();

    void deleteAdress(Adresse a);
    void deleteAdressDTO(AdresseRequest a);

    void deleteAllAdress();
    void deleteAdressById(long id);
    long countingAdress();
    boolean verifAdressById(long id);

    String affecterAdresseAClient(String rue,String nom,String prenom);
}

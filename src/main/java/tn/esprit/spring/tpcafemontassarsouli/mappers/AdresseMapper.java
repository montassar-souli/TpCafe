package tn.esprit.spring.tpcafemontassarsouli.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.adresse.AdresseRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.adresse.AdresseResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    Adresse fromDTOToEntity(AdresseRequest a);
    AdresseResponse fromEntityToDTO(Adresse a);

    List<Adresse> fromListDTOToListEntity(List<AdresseRequest> a);
    List<AdresseResponse> fromListEntityToListDTO(List<Adresse> a);

    //AdresseResponse fromIdToDTO(long id);

}
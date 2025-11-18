package tn.esprit.spring.tpcafemontassarsouli.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.DetailCommande;


import java.util.List;
@Mapper(componentModel = "spring")
public interface DetailCommandeMapper {
    DetailCommande fromDTOToEntity(DetailCommandeRequest d);
    DetailCommandeResponse fromEntityToDTO(DetailCommande d);

    List<DetailCommande> fromListDTOToListEntity(List<DetailCommandeRequest> d);
    List<DetailCommandeResponse> fromListEntityToListDTO(List<DetailCommande> d);
}

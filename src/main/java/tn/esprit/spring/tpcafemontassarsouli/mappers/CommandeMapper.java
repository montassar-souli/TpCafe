package tn.esprit.spring.tpcafemontassarsouli.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Commande;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande fromDTOToEntity(CommandeRequest c);
    CommandeResponse fromEntityToDTO(Commande c);

    List<Commande> fromListDTOToListEntity(List<CommandeRequest> c);
    List<CommandeResponse> fromListEntityToListDTO(List<Commande> c);
}

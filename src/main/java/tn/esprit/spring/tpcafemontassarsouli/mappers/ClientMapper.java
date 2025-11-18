package tn.esprit.spring.tpcafemontassarsouli.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client fromDTOToEntity(ClientRequest c);
    ClientResponse fromEntityToDTO(Client c);

    List<Client> fromListDTOToListEntity(List<ClientRequest> c);
    List<ClientResponse> fromListEntityToDTO(List<Client> c);
}

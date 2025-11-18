package tn.esprit.spring.tpcafemontassarsouli.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CarteFideliteMapper {
    CarteFidelite fromDTOToEntity(CarteFideliteRequest c);
    CarteFideliteResponse fromEntityToDTO(CarteFidelite c);

    List<CarteFidelite> fromListDTOToListEntity(List<CarteFideliteRequest> c);
    List<CarteFideliteResponse> fromListEntityToDTO(List<CarteFidelite> c);
}

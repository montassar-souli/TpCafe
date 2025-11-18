package tn.esprit.spring.tpcafemontassarsouli.mappers;


import org.mapstruct.Mapper;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.promotion.PromotionResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Promotion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    Promotion fromDTOToEntity(PromotionRequest p);
    PromotionResponse fromEntityToDTO(Promotion p);

    List<Promotion> fromListDTOToListEntity(List<PromotionRequest> p);
    List<PromotionResponse> fromListEntityToDTO(List<Promotion> p);
}

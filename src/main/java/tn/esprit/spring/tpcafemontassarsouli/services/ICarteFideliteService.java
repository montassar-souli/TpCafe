package tn.esprit.spring.tpcafemontassarsouli.services;



import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.CarteFidelite;

import java.util.List;

public interface ICarteFideliteService {
    CarteFidelite addCarteFidelite(CarteFidelite a);
    CarteFideliteResponse saveCarteFideliteDTO(CarteFideliteRequest c);

    List<CarteFidelite> saveCarteFidelite(List<CarteFidelite> carteFidilites);
    List<CarteFideliteResponse> saveListCarteFidelteDTO(List<CarteFideliteRequest> c);

    CarteFidelite selectCarteFideliteByIdWithGet(long id);
    CarteFideliteResponse getCarteFideliteByIdDTO(long id);

    CarteFidelite selectCarteFideliteByIdWithOrElse(long id);
    List<CarteFidelite> selectAllCarteFidelite();
    List<CarteFideliteResponse> getAllCarteFideliteDTO();

    void deleteCarteFidelite(CarteFidelite a);
    void deleteAllCarteFidelite();
    void deleteCarteFideliteById(long id);
    long countingCarteFidelite();
    boolean verifCarteFideliteById(long id);

    void affecterCarteAClient(long idCarte , long idClient);
    List<String> incrementerPointsFidelite();
}

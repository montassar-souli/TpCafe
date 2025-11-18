package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.carteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafemontassarsouli.services.ICarteFideliteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("carteFidelite")
public class CarteFideliteRestController {
    ICarteFideliteService service;

    @PostMapping("saveCarteFideliteDTO")
    public CarteFideliteResponse saveCarteFideliteDTO(@RequestBody CarteFideliteRequest c){
        return service.saveCarteFideliteDTO(c);
    }

    @PostMapping("saveListCarteFidilte")
    public List<CarteFideliteResponse> saveListCarteFidilte(@RequestBody List<CarteFideliteRequest> c){
        return service.saveListCarteFidelteDTO(c);
    }

    @GetMapping("getCarteFideliteByIdDTO/{id}")
    public CarteFideliteResponse getCarteFideliteByIdDTO(@PathVariable long id){
        return service.getCarteFideliteByIdDTO(id);
    }

@GetMapping("getAllCarteFideliteDTO")
    public List<CarteFideliteResponse> getAllCarteFideliteDTO(){
        return service.getAllCarteFideliteDTO();
    }
}

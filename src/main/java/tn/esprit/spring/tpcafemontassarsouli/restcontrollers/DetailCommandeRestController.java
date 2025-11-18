package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.detailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.services.IDetailCommandeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("detailCommande")
public class DetailCommandeRestController {
    IDetailCommandeService service;

    @PostMapping("saveDetailCommandeDTO")
    public DetailCommandeResponse saveDetailCommandeDTO(@RequestBody DetailCommandeRequest d) {
        return service.saveDetailCommandeDTO(d);
    }

    @PostMapping("saveDetailCommandesDTO")
    public List<DetailCommandeResponse> saveDetailCommandesDTO(@RequestBody List<DetailCommandeRequest> d) {
        return service.saveDetailCommandesDTO(d);
    }

    @GetMapping("getDetailCommandeByIdDTO/{id}")
    public DetailCommandeResponse getDetailCommandeByIdDTO(@PathVariable long id) {
        return service.getDetailCommandeByIdDTO(id);
    }

    @GetMapping("getAllDetailCommandesDTO")
    public List<DetailCommandeResponse> getAllDetailCommandesDTO() {
        return service.getAllDetailCommandesDTO();
    }
}

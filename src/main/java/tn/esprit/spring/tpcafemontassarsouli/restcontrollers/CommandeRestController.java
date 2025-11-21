package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.commande.CommandeResponse;
import tn.esprit.spring.tpcafemontassarsouli.services.ICommandeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("commande")
public class CommandeRestController {
    ICommandeService service;

    @PostMapping("saveCommandeDTO")
    public CommandeResponse saveCommandeDTO(@RequestBody CommandeRequest c) {
        return service.saveCommandeDTO(c);
    }

    @PostMapping("saveListCommandesDTO")
    public List<CommandeResponse> saveListCommandesDTO(@RequestBody List<CommandeRequest> c) {
        return service.saveListCommandesDTO(c);
    }

    @GetMapping("getCommandeByIdDTO/{id}")
    public CommandeResponse getCommandeByIdDTO(@PathVariable("id") long id) {
        return service.getCommandeByIdDTO(id);
    }

    @GetMapping("getAllCommandesDTO")
    public List<CommandeResponse> getAllCommandesDTO() {
        return service.getAllCommandesDTO();
    }

    @PutMapping("affecterCommandeAClient")
    public void affecterCommandeAClient(long idCommande, long idClient){
        service.affecterCommandeAClient(idCommande, idClient);
    }

    @PutMapping("affecterCommandeAClient")
    public void affecterCommandeAClient(LocalDate dateCommande, String nomClient, String prenomClient){
        service.affecterCommandeAClient(dateCommande, nomClient, prenomClient);
    }

    @PutMapping("desaffecterCommandeDeClient")
    public void desaffecterCommandeDeClient(long idCommande){
        service.desaffecterCommandeDeClient(idCommande);
    }
}

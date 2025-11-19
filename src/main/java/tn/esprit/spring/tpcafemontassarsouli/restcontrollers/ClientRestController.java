package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.client.ClientResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Client;
import tn.esprit.spring.tpcafemontassarsouli.services.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("client")
public class ClientRestController {
    IClientService service;

    @PostMapping("saveClientDTO")
    public ClientResponse saveClientDTO(@RequestBody ClientRequest c){
        return service.saveClientDTO(c);
    }

    @PostMapping("saveListClientsDTO")
    public List<ClientResponse> saveListClientsDTO(@RequestBody List<ClientRequest> c){
        return service.saveListClientsDTO(c);
    }

    @GetMapping("getClientByIdDTO/{id}")
    public ClientResponse getClientByIdDTO(@PathVariable long id){
        return service.getClientByIdDTO(id);
    }

    @GetMapping("getAllClientsDTO")
    public List<ClientResponse> getAllClientsDTO(){
        return service.getAllClientsDTO();
    }

    @PostMapping("ajouterClient")
    public void ajouterClient(@RequestBody Client c){
        service.ajouterClient(c);
    }

}

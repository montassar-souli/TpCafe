package tn.esprit.spring.tpcafemontassarsouli.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafemontassarsouli.dto.adresse.AdresseRequest;
import tn.esprit.spring.tpcafemontassarsouli.dto.adresse.AdresseResponse;
import tn.esprit.spring.tpcafemontassarsouli.entities.Adresse;
import tn.esprit.spring.tpcafemontassarsouli.services.IAdressService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("address")
public class AdressRestController {
    //POST GET PUT DELETE PATCH ...
    IAdressService service;

    @GetMapping
    public List<Adresse> getAllAdresses(){
        return service.selectAllAdress();
    }

    @PostMapping
    public  Adresse addAdress(@RequestBody Adresse a){
        return service.addAdress(a);
    }

    @PostMapping("saveAdress")
    public List<Adresse> saveAdress(@RequestBody List<Adresse> a){
        return service.saveAdress(a);
    }

    @GetMapping("getById/{id}")
    public Adresse getAdressById(@PathVariable Long id) {
        return service.selectAdressByIdWithGet(id);
    }

    //http://localhost:8080/api/address/getById2/1
    @GetMapping("getById2/{id}")
    public Adresse getAdressById2(@PathVariable(name="id") Long ididid) {
        return service.selectAdressByIdWithGet(ididid);
    }

    //http://localhost:8080/api/address?id=1
    @DeleteMapping
    public void deleteAdress(@RequestParam Long id) {
        service.deleteAdressById(id);
    }

    @PutMapping
    public Adresse updateAdress(@RequestBody Adresse a) {
        return service.addAdress(a);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllAdress() {
        service.deleteAllAdress();
    }

    @GetMapping("getCount")
    public long getGountingAdress() {
        return service.countingAdress();
    }

    @GetMapping("verifAdress/{id}")
    public boolean verifAdress(@PathVariable Long id) {
        return service.verifAdressById(id);
    }

    @PostMapping("addAdressDTO")
    public AdresseResponse addAdressDTO(@RequestBody AdresseRequest a) {
        return service.addAdressDTO(a);
    }

    @PostMapping("addListAdressDTO")
    public List<AdresseResponse> addListAdressDTO(@RequestBody List<AdresseRequest> a){
        return service.addListAdressDTO(a);
    }

    @GetMapping("selectAdressByIdDTO/{id}")
    public AdresseResponse selectAdressByIdDTO(@PathVariable("id") long id){
        return service.selectAdressByIdDTO(id);
    }

    @GetMapping("selectAllAdressDTO")
    public List<AdresseResponse> selectAllAdressDTO(){
        return service.selectAllAdressDTO();
    }

    @DeleteMapping("deleteAdress")
    public void deleteAdress(@RequestBody Adresse a){
        service.deleteAdress(a);
    }

    @DeleteMapping("deleteAdressDTO")
    public void deleteAdressDTO(@RequestBody AdresseRequest a){
        service.deleteAdressDTO(a);
    }

    @PutMapping("affecterAdresseAClient")
    public String affecterAdresseAClient(@RequestParam String rue,@RequestParam String nom,@RequestParam String prenom){
        return service.affecterAdresseAClient(rue,nom,prenom);
    }
}

package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.DTO.ClientDTO;
import net.seifhadjhassen.project.models.DTO.ClientRequestDTO;
import net.seifhadjhassen.project.models.DessertEntity;
import net.seifhadjhassen.project.repositories.ClientRepository;
import net.seifhadjhassen.project.repositories.TicketRepository;
import net.seifhadjhassen.project.services.ClientService;
import net.seifhadjhassen.project.services.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")

public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(path = "")
    public ClientEntity add(@RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.add(clientRequestDTO);
    }

    @GetMapping(path = "")
    public List<ClientDTO> getAll(){
        return clientService.getAll();
    }

    @GetMapping(path="/{id}")
    public ClientDTO getById(@PathVariable("id") int id){
        return clientService.getById(id);
    }

    @PutMapping(path = "")
    public ClientEntity update(@RequestBody ClientEntity clientEntity){
        return clientService.update(clientEntity);
    }

    @DeleteMapping("/{id}")
    public ClientDTO delete(@PathVariable("id") int id){
        return clientService.delete(id);
    }


    @GetMapping(path="/analyse/fidele")
    public ClientDTO getClientFidele(){
        return clientService.getClientFidele();
    }

    @GetMapping(path="/analyse/dates/{id}")
    public ClientRepository.dateAndNum getDateClient(@PathVariable("id") int id){
        return clientService.getDateClient(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

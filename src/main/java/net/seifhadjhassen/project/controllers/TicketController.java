package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.DTO.TicketDTO;
import net.seifhadjhassen.project.models.DTO.TicketRequestDTO;
import net.seifhadjhassen.project.models.TableEntity;
import net.seifhadjhassen.project.models.TicketEntity;
import net.seifhadjhassen.project.repositories.TicketRepository;
import net.seifhadjhassen.project.services.TableService;
import net.seifhadjhassen.project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "")
    public TicketEntity add(@RequestBody TicketEntity ticketEntity){
        return ticketService.add(ticketEntity);
    }

    @GetMapping(path = "")
    public List<TicketDTO> getAll(){
        return ticketService.getAll();
    }

    @GetMapping(path="/{id}")
    public TicketDTO getById(@PathVariable("id") int id){
        return ticketService.getById(id);
    }

    @PutMapping(path = "")
    public TicketEntity update(@RequestBody TicketEntity ticketEntity){
        return ticketService.update(ticketEntity);
    }

    @DeleteMapping(path = "/{id}")
    public TicketDTO delete(@PathVariable("id") int id){
        return ticketService.delete(id);
    }



    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

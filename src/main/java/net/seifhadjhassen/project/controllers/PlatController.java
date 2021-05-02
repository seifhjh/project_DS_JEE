package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.PlatEntity;
import net.seifhadjhassen.project.models.TicketEntity;
import net.seifhadjhassen.project.services.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/plats")
public class PlatController {

    private PlatService platService;

    @Autowired
    public PlatController(PlatService platService) {
        this.platService = platService;
    }

    @PostMapping(path = "")
    public PlatEntity add(@RequestBody PlatEntity platEntity){
        return platService.add(platEntity);
    }

    @GetMapping(path = "")
    public List<PlatEntity> getAll(){
        return platService.getAll();
    }

    @GetMapping(path="/{id}")
    public PlatEntity getById(@PathVariable("id") String id){
        return platService.getById(id);
    }

    @PutMapping(path = "")
    public PlatEntity update(@RequestBody PlatEntity platEntity){
        return platService.update(platEntity);
    }

    @DeleteMapping(path = "/{id}")
    public PlatEntity delete(@PathVariable("id") String id){
        return platService.delete(id);
    }

    @PostMapping(path = "/analyse/mostsell")
    public PlatEntity mostSell(@RequestBody Map<String, String> body ) throws ParseException {
        DateTimeFormatter formatter =DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime firstDate = LocalDateTime.parse(body.get("firstDate"), formatter);
        LocalDateTime lastDate = LocalDateTime.parse(body.get("lastDate"), formatter);
        System.out.println(firstDate);
        return platService.mostSell(firstDate,lastDate);


/*
        Date d1=new SimpleDateFormat("dd/MM/yyyy").parse(body.get("firstDate"));

        Date d2=new SimpleDateFormat("dd/MM/yyyy").parse(body.get("lastDate"));
        LocalDateTime firstDate = Instant.ofEpochMilli(d1.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime lastDate = Instant.ofEpochMilli(d2.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();*/

    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

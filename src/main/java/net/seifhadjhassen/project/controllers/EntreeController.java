package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.DessertEntity;
import net.seifhadjhassen.project.models.EntreeEntity;
import net.seifhadjhassen.project.services.DessertService;
import net.seifhadjhassen.project.services.EntreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/entrees")
public class EntreeController {

    private EntreeService entreeService;

    @Autowired
    public EntreeController(EntreeService entreeService) {
        this.entreeService = entreeService;
    }

    @PostMapping(path = "")
    public EntreeEntity add(@RequestBody EntreeEntity entreeEntity){
        return entreeService.add(entreeEntity);
    }

    @GetMapping(path = "")
    public List<EntreeEntity> getAll(){
        return entreeService.getAll();
    }

    @GetMapping(path="/{id}")
    public EntreeEntity getById(@PathVariable("id") String id){
        return entreeService.getById(id);
    }

    @PutMapping(path = "")
    public EntreeEntity update(@RequestBody EntreeEntity entreeEntity){
        return entreeService.update(entreeEntity);
    }

    @DeleteMapping(path = "/{id}")
    public EntreeEntity delete(@PathVariable("id") String id){
        return entreeService.delete(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

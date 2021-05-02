package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.DessertEntity;
import net.seifhadjhassen.project.models.PlatEntity;
import net.seifhadjhassen.project.services.DessertService;
import net.seifhadjhassen.project.services.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/desserts")
public class DessertController {

    private DessertService dessertService;

    @Autowired
    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @PostMapping(path = "")
    public DessertEntity add(@RequestBody DessertEntity dessertEntity){
        return dessertService.add(dessertEntity);
    }

    @GetMapping(path = "")
    public List<DessertEntity> getAll(){
        return dessertService.getAll();
    }

    @GetMapping(path="/{id}")
    public DessertEntity getById(@PathVariable("id") String id){
        return dessertService.getById(id);
    }

    @PutMapping(path = "")
    public DessertEntity update(@RequestBody DessertEntity dessertEntity){
        return dessertService.update(dessertEntity);
    }

    @DeleteMapping(path = "/{id}")
    public DessertEntity delete(@PathVariable("id") String id){
        return dessertService.delete(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.repositories.MetRepository;
import net.seifhadjhassen.project.services.MetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(value = "/api/mets")
public class MetController {

    private MetService metService;

    @Autowired
    public MetController(MetService metService) {
        this.metService = metService;
    }

    @PostMapping(path = "")
    public MetEntity add(@RequestBody MetEntity met){
        return metService.add(met);
    }

    @GetMapping(path = "")
    public List<MetEntity> getAll(){
        return metService.getAll();
    }

    @GetMapping(path="/{id}")
    public MetEntity getById(@PathVariable("id") String id){
        return metService.getById(id);
    }

    @PutMapping(path = "")
    public MetEntity update(@RequestBody MetEntity metEntity){
        return metService.update(metEntity);
    }

    @DeleteMapping(path = "/{id}")
    public MetEntity delete(@PathVariable("id") String id){
        return metService.delete(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}

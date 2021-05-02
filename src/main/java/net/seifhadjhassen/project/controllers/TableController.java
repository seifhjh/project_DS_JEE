package net.seifhadjhassen.project.controllers;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.TableEntity;
import net.seifhadjhassen.project.services.ClientService;
import net.seifhadjhassen.project.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping(path = "")
    public TableEntity add(@RequestBody TableEntity tableEntity){
        return tableService.add(tableEntity);
    }

    @GetMapping(path = "")
    public List<TableEntity> getAll(){
        return tableService.getAll();
    }

    @GetMapping(path="/{id}")
    public TableEntity getById(@PathVariable("id") int id){
        return tableService.getById(id);
    }


    @PutMapping(path = "")
    public TableEntity update(@RequestBody TableEntity tableEntity){
        return tableService.update(tableEntity);
    }

    @DeleteMapping(path = "/{id}")
    public TableEntity delete(@PathVariable("id") int id){
        return tableService.delete(id);
    }

    @GetMapping(path="/analyse/reserver")
    public List<TableEntity> plusReserver(){
        return tableService.plusReserver();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosSuchElement(NoSuchElementException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}

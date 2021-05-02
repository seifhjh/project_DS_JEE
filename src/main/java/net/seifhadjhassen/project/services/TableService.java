package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.PlatEntity;
import net.seifhadjhassen.project.models.TableEntity;
import net.seifhadjhassen.project.repositories.ClientRepository;
import net.seifhadjhassen.project.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TableService {

    private TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<TableEntity> getAll(){
        return tableRepository.findAll();
    }

    public TableEntity getById(int id){
        Optional<TableEntity> opt= tableRepository.findById(id);
        TableEntity tableEntity;
        if(opt.isPresent())
            tableEntity=opt.get();
        else throw new NoSuchElementException("Table with this id not found");

        return tableEntity;
    }

    public TableEntity add(TableEntity tableEntity){
        return tableRepository.save(tableEntity);
    }

    public TableEntity update(TableEntity tableEntity){
        return tableRepository.save(tableEntity);
    }

    public TableEntity delete(int id){
        TableEntity tableEntity=getById(id);
        tableRepository.delete(tableEntity);
        return tableEntity;
    }

    public List<TableEntity> plusReserver(){
        List<TableEntity> list= tableRepository.plusReerver();

        if(list.size()>0)
            return list;
        else throw new NoSuchElementException("No table exist");


    }

}

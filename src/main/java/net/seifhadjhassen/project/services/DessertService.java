package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.DessertEntity;
import net.seifhadjhassen.project.models.PlatEntity;
import net.seifhadjhassen.project.repositories.DessertRepository;
import net.seifhadjhassen.project.repositories.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DessertService {
    private DessertRepository dessertRepository;

    @Autowired
    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public List<DessertEntity> getAll(){
        return dessertRepository.findAll();
    }

    public DessertEntity getById(String id){
        Optional<DessertEntity> opt= dessertRepository.findById(id);
        DessertEntity dessertEntity;
        if(opt.isPresent())
            dessertEntity=opt.get();
        else throw new NoSuchElementException("Dessert with this id not found");

        return dessertEntity;
    }

    public DessertEntity add(DessertEntity dessertEntity){
        return dessertRepository.save(dessertEntity);
    }



    public DessertEntity update(DessertEntity dessertEntity){
        return dessertRepository.save(dessertEntity);
    }

    public DessertEntity delete(String id){
        DessertEntity dessertEntity=getById(id);
        dessertRepository.delete(dessertEntity);
        return dessertEntity;
    }
}

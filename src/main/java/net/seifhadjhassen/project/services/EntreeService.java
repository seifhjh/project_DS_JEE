package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.EntreeEntity;
import net.seifhadjhassen.project.repositories.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EntreeService {
    private EntreeRepository entreeRepository;

    @Autowired

    public EntreeService(EntreeRepository entreeRepository) {
        this.entreeRepository = entreeRepository;
    }


    public List<EntreeEntity> getAll(){
        return entreeRepository.findAll();
    }

    public EntreeEntity getById(String id){
        Optional<EntreeEntity> opt= entreeRepository.findById(id);
        EntreeEntity entreeEntity;
        if(opt.isPresent())
            entreeEntity=opt.get();
        else throw new NoSuchElementException("Entree with this id not found");

        return entreeEntity;
    }

    public EntreeEntity add(EntreeEntity entreeEntity){
        return entreeRepository.save(entreeEntity);
    }



    public EntreeEntity update(EntreeEntity entreeEntity){
        return entreeRepository.save(entreeEntity);
    }

    public EntreeEntity delete(String id){
        EntreeEntity entreeEntity=getById(id);
        entreeRepository.delete(entreeEntity);
        return entreeEntity;
    }
}

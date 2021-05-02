package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.EntreeEntity;
import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.repositories.MetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MetService {

    private MetRepository metRepository;

    @Autowired
    public MetService(MetRepository metRepository) {
        this.metRepository = metRepository;
    }

    public List<MetEntity> getAll(){
        return metRepository.findAll();
    }

    public MetEntity getById(String id){
        Optional<MetEntity> opt= metRepository.findById(id);
        MetEntity metEntity;
        if(opt.isPresent())
            metEntity=opt.get();
        else throw new NoSuchElementException("Entree with this id not found");

        return metEntity;
    }

    public MetEntity add(MetEntity metEntity){
        return metRepository.save(metEntity);
    }



    public MetEntity update(MetEntity metEntity){
        return metRepository.save(metEntity);
    }

    public MetEntity delete(String id){
        MetEntity metEntity=getById(id);
        metRepository.delete(metEntity);
        return metEntity;
    }

}

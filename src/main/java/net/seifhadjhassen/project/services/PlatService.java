package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.PlatEntity;
import net.seifhadjhassen.project.repositories.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlatService {

    private PlatRepository platRepository;

    @Autowired
    public PlatService(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    public List<PlatEntity> getAll(){
        return platRepository.findAll();
    }

    public PlatEntity getById(String id){
        Optional<PlatEntity> opt= platRepository.findById(id);
        PlatEntity platEntity;
        if(opt.isPresent())
            platEntity=opt.get();
        else throw new NoSuchElementException("Plat with this id not found");

        return platEntity;
    }

    public PlatEntity add(PlatEntity platEntity){
        return platRepository.save(platEntity);
    }



    public PlatEntity update(PlatEntity platEntity){
        return platRepository.save(platEntity);
    }

    public PlatEntity delete(String id){
        PlatEntity platEntity=getById(id);
        platRepository.delete(platEntity);
        return platEntity;
    }

    public PlatEntity mostSell(LocalDateTime firstDate,LocalDateTime lastDate){
//        Optional<PlatEntity> opt =platRepository.findByTicketsDateGreaterThanEqualAndTicketsDateLessThanEqual(firstDate,lastDate);
       /* Optional<PlatEntity> opt =platRepository.findByTicketsDate(firstDate.toString());

        PlatEntity platEntity;
        if(opt.isPresent()) {
            platEntity = opt.get();
            return platEntity;
        }*/
        throw new NoSuchElementException("No plat in this date");

    }

}

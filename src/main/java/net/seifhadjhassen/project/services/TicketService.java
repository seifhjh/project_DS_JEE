package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.DTO.TicketDTO;
import net.seifhadjhassen.project.models.DTO.TicketRequestDTO;
import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.TableEntity;
import net.seifhadjhassen.project.models.TicketEntity;
import net.seifhadjhassen.project.repositories.ClientRepository;
import net.seifhadjhassen.project.repositories.MetRepository;
import net.seifhadjhassen.project.repositories.TableRepository;
import net.seifhadjhassen.project.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private TableRepository tableRepository;
    private MetRepository metRepository;
    private ClientRepository clientRepository;
    private ModelMapper mapper=new ModelMapper();

    @Autowired
    public TicketService(TicketRepository ticketRepository, TableRepository tableRepository, MetRepository metRepository, ClientRepository clientRepository) {
        this.ticketRepository = ticketRepository;
        this.tableRepository = tableRepository;
        this.metRepository = metRepository;
        this.clientRepository = clientRepository;

    }

    public List<TicketDTO> getAll(){
        List<TicketEntity> ticketEntities = ticketRepository.findAll();
        //return ticketEntities;
        return ticketEntities.stream()
                .map(t->mapper.map(t,TicketDTO.class))
                .collect(Collectors.toList());
    }

    public TicketDTO getById(int id){
        Optional<TicketEntity> opt= ticketRepository.findById(id);
        TicketEntity ticketEntity;
        if(opt.isPresent())
            ticketEntity=opt.get();
        else throw new NoSuchElementException("Ticket with this id not found");

        return mapper.map(ticketEntity,TicketDTO.class);
    }



    public TicketEntity add(TicketEntity ticketEntity){

        /*TicketEntity ticketEntity=mapper.map(ticketRequestDTO,TicketEntity.class);

        List<TicketEntity> ticketEntities=new ArrayList<>();
        ticketEntities.add(ticketEntity);
        for (MetEntity met : ticketEntity.getMets()){
            met.setTickets(ticketEntities);
        }

        ticketEntity.getTable().setTickets(ticketEntities);

        ticketEntity.getClient().setTickets(ticketEntities);*/




        return ticketRepository.save(ticketEntity);
    }

    public TicketEntity update(TicketEntity ticketEntity){
        return ticketRepository.save(ticketEntity);
    }

    public TicketDTO delete(int id){
        TicketDTO ticketDTO=getById(id);
        TicketEntity ticketEntity=mapper.map(ticketDTO,TicketEntity.class);
        ticketRepository.delete(ticketEntity);
        return ticketDTO;
    }



}

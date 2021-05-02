package net.seifhadjhassen.project.services;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.DTO.ClientDTO;
import net.seifhadjhassen.project.models.DTO.ClientRequestDTO;
import net.seifhadjhassen.project.repositories.ClientRepository;
import net.seifhadjhassen.project.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAll(){
        clientRepository.findAll();
        List<ClientEntity> clientEntities=clientRepository.findAll();
        return clientEntities.stream()
                .map(c -> mapper.map(c, ClientDTO.class))
                .collect(Collectors.toList());
        //return clientEntities;
    }

    public ClientDTO getById(int id){
        Optional<ClientEntity> opt= clientRepository.findById(id);
        ClientEntity clientEntity;
        if(opt.isPresent())
            clientEntity=opt.get();
        else throw new NoSuchElementException("Client with this id not found");



        return mapper.map(clientEntity, ClientDTO.class);
    }

    public ClientEntity add(ClientRequestDTO clientRequestDTO){
        ClientEntity clientEntity=mapper.map(clientRequestDTO,ClientEntity.class);
        return clientRepository.save(clientEntity);
    }

    public ClientEntity update(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }

    public ClientDTO delete(int id){
        ClientDTO clientDTO=getById(id);
        ClientEntity clientEntity=mapper.map(clientDTO, ClientEntity.class);
        clientRepository.delete(clientEntity);
        return clientDTO;
    }

    public ClientDTO getClientFidele(){
        Optional<ClientEntity> opt= clientRepository.clientFidele();
        ClientEntity clientEntity;
        if(opt.isPresent())
            clientEntity=opt.get();
        else throw new NoSuchElementException("No client exist");



        return mapper.map(clientEntity, ClientDTO.class);
    }

    public ClientRepository.dateAndNum getDateClient(int client_id){
        ClientRepository.dateAndNum dates = clientRepository.clientDate(client_id);
        return dates;

    }

}

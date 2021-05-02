package net.seifhadjhassen.project.repositories;

import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.DTO.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {

    @Query(nativeQuery = true,value = "select client.* ,sum(ticket.addition) as addd from client inner join ticket on ticket.client_id=client.id  group by client.id HAVING addd =" +
            "(select max(cl.addit) from " +
            "(select client.*,sum(ticket.addition) as addit  from client inner join ticket on client.id=ticket.client_id  GROUP by client.id ) as cl)")
    Optional<ClientEntity> clientFidele();

    interface dateAndNum{
        String getDate();
          int getNfois();
    }

    @Query(nativeQuery = true,value = "select ticket.date,count(*) as nfois from ticket INNER join client on " +
            "client.id=ticket.client_id where client.id=client_id GROUP by ticket.date order by nfois desc limit 1")
    dateAndNum clientDate(int client_id);


}

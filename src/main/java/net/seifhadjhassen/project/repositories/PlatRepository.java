package net.seifhadjhassen.project.repositories;

import net.seifhadjhassen.project.models.PlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PlatRepository extends JpaRepository<PlatEntity,String> {


    @Query(nativeQuery = true,value = "SELECT plat.nom,plat.prix from plat INNER JOIN met on plat.nom=met.nom LEFT OUTER JOIN compose on met.nom=compose.met_id LEFT OUTER JOIN ticket on compose.ticket_id=ticket.numero WHERE ticket.date =  :date")
    PlatEntity findByTicketsDate(@Param("date") String date);

}

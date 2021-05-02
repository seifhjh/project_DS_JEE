package net.seifhadjhassen.project.repositories;

import net.seifhadjhassen.project.models.DTO.TicketDTO;
import net.seifhadjhassen.project.models.DTO.TicketRequestDTO;
import net.seifhadjhassen.project.models.TicketEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {



}

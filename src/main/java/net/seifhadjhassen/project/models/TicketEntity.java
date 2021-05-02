package net.seifhadjhassen.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Ticket")
@Data
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    private LocalDateTime date;

    private int nbCouvert;

    private double addition;

    @ManyToOne

    private ClientEntity client;

    @ManyToMany( mappedBy = "tickets",cascade = CascadeType.ALL)

    private List<MetEntity> mets;

    @ManyToOne

    private TableEntity table;


}

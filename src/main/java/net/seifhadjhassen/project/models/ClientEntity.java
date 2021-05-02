package net.seifhadjhassen.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Client")
@Data
@ToString(exclude = {"tickets"})

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    private String courriel;

    private String telephone;

    @OneToMany(targetEntity = TicketEntity.class, mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)

    private List<TicketEntity> tickets;



}

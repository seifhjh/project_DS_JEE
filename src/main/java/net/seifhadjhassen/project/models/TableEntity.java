package net.seifhadjhassen.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "desk")
@Data
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    private int nbCouvert;

    private String type;

    private double supplement;

    @OneToMany(mappedBy = "table")
    @JsonIgnore
    private List<TicketEntity> tickets;


}

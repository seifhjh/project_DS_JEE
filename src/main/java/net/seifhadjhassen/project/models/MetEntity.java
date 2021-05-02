package net.seifhadjhassen.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "met")
@Inheritance(strategy = InheritanceType.JOINED)

public class MetEntity {

    @Id
    private String nom;

    private double prix;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "compose",
            joinColumns = { @JoinColumn(name = "met_id")  },
            inverseJoinColumns = { @JoinColumn(name = "ticket_id") })
    @JsonIgnore
    private List<TicketEntity> tickets;


}

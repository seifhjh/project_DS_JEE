package net.seifhadjhassen.project.models.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.seifhadjhassen.project.models.TicketEntity;
import org.modelmapper.ModelMapper;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private static final ModelMapper mapper = new ModelMapper();


    private int id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    private String courriel;

    private String telephone;


    private List<TicketWithoutClientDTO> tickets;

    public List<TicketWithoutClientDTO> getTickets() {
        return tickets.stream()
                .map(t -> mapper.map(t,TicketWithoutClientDTO.class))
                .collect(Collectors.toList());
    }
}

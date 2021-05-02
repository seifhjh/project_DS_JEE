package net.seifhadjhassen.project.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.TableEntity;
import net.seifhadjhassen.project.models.TicketEntity;
import org.modelmapper.ModelMapper;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private static final ModelMapper mapper = new ModelMapper();


    private int numero;

    private LocalDateTime date;

    private int nbCouvert;

    private double addition;


    private List<MetEntity> mets;

    private ClientSimpleResDTO client;


    private TableEntity table;

    public List<MetEntity> getMets() {
        return mets.stream()
                .map(t -> mapper.map(t,MetEntity.class))
                .collect(Collectors.toList());
    }



}

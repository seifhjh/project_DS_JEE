package net.seifhadjhassen.project.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.TableEntity;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketSimpleDTO {

    private static final ModelMapper mapper = new ModelMapper();


    private int numero;

    private LocalDateTime date;

    private int nbCouvert;

    private double addition;


    private List<MetEntity> mets;


    private TableEntity table;

    public List<MetEntity> getMets() {
        return mets.stream()
                .map(t -> mapper.map(t,MetEntity.class))
                .collect(Collectors.toList());
    }



}

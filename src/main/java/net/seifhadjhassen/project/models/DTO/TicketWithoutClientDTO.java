package net.seifhadjhassen.project.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.TableEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketWithoutClientDTO {

    private int numero;

    private LocalDateTime date;

    private int nbCouvert;

    private double addition;


    private List<MetEntity> mets;


    private TableEntity table;
}

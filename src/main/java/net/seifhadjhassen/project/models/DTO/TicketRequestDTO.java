package net.seifhadjhassen.project.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.seifhadjhassen.project.models.ClientEntity;
import net.seifhadjhassen.project.models.MetEntity;
import net.seifhadjhassen.project.models.TableEntity;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequestDTO {

    private static final ModelMapper mapper = new ModelMapper();

    private Date date;

    private int nbCouvert;

    private double addition;

    private ClientEntity client;

    private List<MetEntity> mets;

    private TableEntity table;


}

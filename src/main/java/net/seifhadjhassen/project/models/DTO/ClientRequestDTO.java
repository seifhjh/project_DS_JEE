package net.seifhadjhassen.project.models.DTO;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.seifhadjhassen.project.models.TicketEntity;
import net.seifhadjhassen.project.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {




    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private LocalDate dateNaissance;

    private String courriel;

    private String telephone;


    private List<TicketRequestIDDTO> tickets=new ArrayList<>();


}

package net.seifhadjhassen.project.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientSimpleResDTO {

    private int id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    private String courriel;

    private String telephone;

}

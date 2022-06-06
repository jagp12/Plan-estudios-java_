package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Persona;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AsignacionInputDTO implements Serializable {
    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private LocalDate created, termination;
}

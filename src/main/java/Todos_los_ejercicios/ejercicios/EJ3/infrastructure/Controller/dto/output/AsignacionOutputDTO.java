package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import com.sun.istack.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class AsignacionOutputDTO {

    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;
    @NotNull
    boolean admin;

    public AsignacionOutputDTO(Persona_ej3 personaEj3){

        setId_persona(String.valueOf(personaEj3.getId_persona()));
        setUsuario(personaEj3.getUsuario());
        setPassword(personaEj3.getPassword());
        setName(personaEj3.getName());
        setSurname(personaEj3.getSurname());
        setCompany_email(personaEj3.getCompany_email());
        setPersonal_email(personaEj3.getPersonal_email());
        setCity(personaEj3.getCity());
        setImagen_url(personaEj3.getImagen_url());
        setActive(personaEj3.isActive());
        setCreated_date(personaEj3.getCreated_date());
        setTermination_date(personaEj3.getTermination_date());
        setAdmin(personaEj3.isAdmin());

    }

    public AsignacionOutputDTO(String usuario, String password){

        setUsuario(usuario);
        setPassword(password);

    }

    public AsignacionOutputDTO() {
    }
}

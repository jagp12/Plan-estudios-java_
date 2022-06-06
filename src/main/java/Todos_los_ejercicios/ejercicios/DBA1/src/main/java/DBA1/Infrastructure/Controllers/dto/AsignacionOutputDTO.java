package DBA1.Infrastructure.Controllers.dto;

import DBA1.Domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class AsignacionOutputDTO {

    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;

    public AsignacionOutputDTO(Persona persona){

        setId_persona(String.valueOf(persona.getId_persona()));
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setImagen_url(persona.getImagen_url());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setTermination_date(persona.getTermination_date());

    }

    public AsignacionOutputDTO() {
    }

}

package DBA1.Domain;

import DBA1.Infrastructure.Controllers.dto.AsignacionInputDTO;
import DBA1.Infrastructure.Controllers.dto.AsignacionOutputDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Persona {


    @Id
    @GeneratedValue
    private Integer id_persona;
    //private Integer idPersona;

    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;

    public Persona() {

    }

    public Persona(AsignacionInputDTO persona_dto){

        //setId_persona(Integer.parseInt(persona_dto.id_persona()));
        //setId(persona_dto.getId());
        setUsuario(persona_dto.getUsuario());
        setPassword(persona_dto.getPassword());
        setName(persona_dto.getName());
        setSurname(persona_dto.getSurname());
        setCompany_email(persona_dto.getCompany_email());
        setPersonal_email(persona_dto.getPersonal_email());
        setCity(persona_dto.getCity());
        setImagen_url(persona_dto.getImagen_url());
        setActive(persona_dto.isActive());
        setCreated_date(persona_dto.getCreated_date());
        setTermination_date(persona_dto.getTermination_date());
        /*
        setUsuario(persona_dto.usuario());
        setPassword(persona_dto.password());
        setName(persona_dto.name());
        setSurname(persona_dto.surname());
        setCompany_email(persona_dto.company_email());
        setPersonal_email(persona_dto.personal_email());
        setCity(persona_dto.city());
        setImagen_url(persona_dto.imagen_url());
        setActive(persona_dto.active());
        setCreated_date(persona_dto.created_date());
        setTermination_date(persona_dto.termination_date());
*/
    }

    public Persona(AsignacionOutputDTO persona_dto){

        //setId_persona(Integer.parseInt(persona_dto.id_persona()));
        //setId(persona_dto.getId());
/*
        setUsuario(persona_dto.usuario());
        setPassword(persona_dto.password());
        setName(persona_dto.name());
        setSurname(persona_dto.surname());
        setCompany_email(persona_dto.company_email());
        setPersonal_email(persona_dto.personal_email());
        setCity(persona_dto.city());
        setImagen_url(persona_dto.imagen_url());
        setActive(persona_dto.active());
        setCreated_date(persona_dto.created_date());
        setTermination_date(persona_dto.termination_date());
*/

        setUsuario(persona_dto.getUsuario());
        setPassword(persona_dto.getPassword());
        setName(persona_dto.getName());
        setSurname(persona_dto.getSurname());
        setCompany_email(persona_dto.getCompany_email());
        setPersonal_email(persona_dto.getPersonal_email());
        setCity(persona_dto.getCity());
        setImagen_url(persona_dto.getImagen_url());
        setActive(persona_dto.isActive());
        setCreated_date(persona_dto.getCreated_date());
        setTermination_date(persona_dto.getTermination_date());

    }



}

package Todos_los_ejercicios.ejercicios.EJ3.Domain;

import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@ToString
@Setter
@Getter
@Entity
public class Persona_ej3 {

    @GeneratedValue
    @Id
    private Integer id_persona;
    //private Integer idPersona;

    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;
    @NotNull
    boolean admin;

    public Persona_ej3() {

    }

    public Persona_ej3(AsignacionInputDTO persona_dto){

        if(persona_dto.getId_persona()!=null){
            setId_persona(Integer.parseInt(persona_dto.getId_persona()));
        }
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
        setAdmin(persona_dto.isAdmin());

    }

    public Persona_ej3(AsignacionOutputDTO persona_dto){

        setId_persona(Integer.parseInt(persona_dto.getId_persona()));
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
        setAdmin(persona_dto.isAdmin());

    }



}

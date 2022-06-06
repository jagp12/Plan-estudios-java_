package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import lombok.Data;

import java.time.LocalDate;
/*
@Data
public class AsignacionOutputDTO {

    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private LocalDate created, termination;

    public AsignacionOutputDTO(Persona_ej2 persona){

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
        setCreated(persona.getCreated());
        setTermination(persona.getTermination());

    }

    public AsignacionOutputDTO() {
    }
*/
public record AsignacionOutputDTO(  String usuario, String password, String name, String surname, String companyEmail, String personalEmail, String city, String imagenUrl, boolean active, LocalDate createdDate, LocalDate terminationDate) {

    //String usuario,password,name,surname,company_email,personal_email,city,imagen_url,active,created_date,termination_date;


    /*
    public void ddddd(String usuario, String password, String name, String surname, String company_email, String personal_email, String city, String imagen_url, boolean active, Date created_date, Date termination_date) {
        this.id_persona = String.valueOf(personaEj2.getId_persona());
        this.usuario = usuario;
        this.password = personaEj2.getPassword();
        this.name = personaEj2.getName();
        this.surname = personaEj2.getSurname();
        this.company_email = personaEj2.getCompany_email();
        this.personal_email = personal_email();
        this.city = personaEj2.getCity();
        this.imagen_url = personaEj2.getImagen_url();
        this.active = personaEj2.isActive();
        this.created_date = personaEj2.getCreated_date();
        this.termination_date = personaEj2.getTermination_date();
    }
*/
/*
    public AsignacionOutputDTO(Persona_ej2 personaEj2){

        this.id_persona = String.valueOf(personaEj2.getId_persona());
        this.usuario = personaEj2.getUsuario();
        this.password = personaEj2.getPassword();
        this.name = personaEj2.getName();
        this.surname = personaEj2.getSurname();
        this.company_email = personaEj2.getCompany_email();
        this.personal_email = personal_email();
        this.city = personaEj2.getCity();
        this.imagen_url = personaEj2.getImagen_url();
        this.active = personaEj2.isActive();
        this.created_date = personaEj2.getCreated_date();
        this.termination_date = personaEj2.getTermination_date();
        */
        /*
        setId_persona(String.valueOf(personaEj2.getId_persona()));
        setUsuario(personaEj2.getUsuario());
        setPassword(personaEj2.getPassword());
        setName(personaEj2.getName());
        setSurname(personaEj2.getSurname());
        setCompany_email(personaEj2.getCompany_email());
        setPersonal_email(personaEj2.getPersonal_email());
        setCity(personaEj2.getCity());
        setImagen_url(personaEj2.getImagen_url());
        setActive(personaEj2.isActive());
        setCreated_date(personaEj2.getCreated_date());
        setTermination_date(personaEj2.getTermination_date());

    }
*/

}

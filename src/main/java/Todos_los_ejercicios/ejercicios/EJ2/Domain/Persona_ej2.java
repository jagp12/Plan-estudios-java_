package Todos_los_ejercicios.ejercicios.EJ2.Domain;

import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Persona_ej2 {


    @Id
    @GeneratedValue
    private Integer id_persona;
    //private Integer idPersona;

    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    @Column(name="created_date")
    private LocalDate created;
    @Column(name="termination_date")
    private LocalDate termination;


    public Persona_ej2() {
        System.out.println(this.id_persona+"/"+this.usuario);
    }

    public Persona_ej2(AsignacionInputDTO persona_dto){

        if(persona_dto.getId_persona()!=null){
            setId_persona(Integer.parseInt(persona_dto.getId_persona()));
        }
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
        setCreated(persona_dto.getCreated());
        setTermination(persona_dto.getTermination());
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

    public Persona_ej2(AsignacionOutputDTO persona_dto){

        //setId_persona(Integer.parseInt(persona_dto.id_persona()));
        //setId(persona_dto.getId());

        setUsuario(persona_dto.usuario());
        setPassword(persona_dto.password());
        setName(persona_dto.name());
        setSurname(persona_dto.surname());
        setCompany_email(persona_dto.companyEmail());
        setPersonal_email(persona_dto.personalEmail());
        setCity(persona_dto.city());
        setImagen_url(persona_dto.imagenUrl());
        setActive(persona_dto.active());
        setCreated(persona_dto.createdDate());
        setTermination(persona_dto.terminationDate());
/**/
/*
        setUsuario(persona_dto.getUsuario());
        setPassword(persona_dto.getPassword());
        setName(persona_dto.getName());
        setSurname(persona_dto.getSurname());
        setCompany_email(persona_dto.getCompany_email());
        setPersonal_email(persona_dto.getPersonal_email());
        setCity(persona_dto.getCity());
        setImagen_url(persona_dto.getImagen_url());
        setActive(persona_dto.isActive());
        setCreated(persona_dto.getCreated());
        setTermination(persona_dto.getTermination());
*/
    }



}

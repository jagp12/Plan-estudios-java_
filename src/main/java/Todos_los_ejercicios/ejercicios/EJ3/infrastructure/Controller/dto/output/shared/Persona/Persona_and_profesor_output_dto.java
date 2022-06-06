package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Persona;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Persona_and_profesor_output_dto  extends AsignacionOutputDTO {
/*
    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;
*/
    //profesor
    //Profesor profesor;
    //List<Student_output_dto> estudiantes_del_profesor = new ArrayList<>();
    List<String> id_estudiantes_del_profesor = new ArrayList<>();

    String id_profesor;
    /*String coments;
    String branch;
*/
    public Persona_and_profesor_output_dto(Profesor_ej3 profesorEj3, List<Student_output_dto> estudiantes_del_profesor){

        setId_persona(String.valueOf(profesorEj3.getPersonaEj3().getId_persona()));
        setUsuario(profesorEj3.getPersonaEj3().getUsuario());
        setPassword(profesorEj3.getPersonaEj3().getPassword());
        setName(profesorEj3.getPersonaEj3().getName());
        setSurname(profesorEj3.getPersonaEj3().getSurname());
        setCompany_email(profesorEj3.getPersonaEj3().getCompany_email());
        setPersonal_email(profesorEj3.getPersonaEj3().getPersonal_email());
        setCity(profesorEj3.getPersonaEj3().getCity());
        setImagen_url(profesorEj3.getPersonaEj3().getImagen_url());
        setActive(profesorEj3.getPersonaEj3().isActive());
        setCreated_date(profesorEj3.getPersonaEj3().getCreated_date());
        setTermination_date(profesorEj3.getPersonaEj3().getTermination_date());

        //setProfesor(profesor);

        setId_estudiantes_del_profesor(estudiantes_del_profesor.stream().map((estudiante)->estudiante.getId_student()).toList());
        //setId_persona(String.valueOf(profesor.getIdPersona()));
        setId_profesor(String.valueOf(profesorEj3.getId_profesor()));
        //setBranch(profesor.getBranch());
        //setComents(profesor.getComents());

    }
}

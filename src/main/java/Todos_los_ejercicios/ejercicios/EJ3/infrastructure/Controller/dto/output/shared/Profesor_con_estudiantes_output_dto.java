package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Profesor_con_estudiantes_output_dto extends AsignacionOutputDTO {

    String id_profesor;
/*    //Persona Persona;
    //String id_persona;
    String coments;
    String branch;
    */
    //Profesor profesor;
    List<Student_y_asignaturas_output_dto> estudiantes_con_asignaturas;

    public Profesor_con_estudiantes_output_dto(Profesor_ej3 profesorEj3, List<Student_y_asignaturas_output_dto> estudiantes_con_asignaturas){

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

        setId_profesor(profesorEj3.getId_profesor());
        //setProfesor(profesor);
        /*
        //setPersona(profesor.getPersona());
        //setId_persona(String.valueOf(profesor.getIdPersona()));
        setId_profesor(String.valueOf(profesor.getId_profesor()));
        setBranch(profesor.getBranch());
        setComents(profesor.getComents());
*/
        //this.estudiantes_con_asignaturas = estudiantes_con_asignaturas;

    }

}

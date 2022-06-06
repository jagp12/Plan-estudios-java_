package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Persona;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Persona_and_student_output_dto extends AsignacionOutputDTO {

    private String id_persona;
    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;

    //Student student;

    String id_student;
    String id_profesor;
    List<String> id_estudios = new ArrayList<>();
    /*int num_hours_week;
    String coments;
    String id_profesor;
    String branch;
*/
    public Persona_and_student_output_dto(Persona_ej3 personaEj3, Student_ej3 studentEj3){

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

        //setPersona(String.valueOf(student.getPersona()));
        //setId_persona(String.valueOf(String.valueOf(student.getPersona().getId_persona())));
        setId_student(String.valueOf(studentEj3.getId()));

        setId_profesor(studentEj3.getProfesorEj3().getId_profesor());

        setId_estudios(studentEj3.getEstudios().stream().map((asignatura)->asignatura.getId_asignatura()).toList());
        //setStudent(student);

        //setProfesor(String.valueOf(student.getProfesor()));
        //setId_profesor(student.getId_profesor());
        //setId_profesor(student.getProfesor().getId_profesor());

        //setBranch(student.getBranch());
        //setComents(student.getComents());
        //setNum_hours_week(student.getNum_hours_week());

    }
}

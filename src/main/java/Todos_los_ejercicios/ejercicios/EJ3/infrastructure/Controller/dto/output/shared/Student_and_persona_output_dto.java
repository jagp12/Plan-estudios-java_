package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Student_and_persona_output_dto extends Student_output_dto {

    //Student student;
    //String id_student;
    //Persona persona;
    String id_persona;
    List<String> id_estudios=new ArrayList<>();
    /*
    int num_hours_week;
    String coments;
    String id_profesor;
    String branch;
*/
    //atributos persona

    private String usuario,password,name,surname,company_email,personal_email,city,imagen_url;
    private boolean active;
    private Date created_date,termination_date;
 /**/
    public Student_and_persona_output_dto(Student_ej3 studentEj3, Persona_ej3 personaEj3){

        //setPersona(student.getPersona());
        setId_persona(String.valueOf(studentEj3.getPersonaEj3().getId_persona()));
        //setStudent(student);

        //setIdPersona(String.valueOf(String.valueOf(student.getPersona().getId_persona())));
        //setIdPersona(String.valueOf(student.getPersona().getId_persona()));
        setId_student(String.valueOf(studentEj3.getId()));

        //setProfesor(student.getProfesor());
        //setId_profesor(student.getId_profesor());
        setId_profesor(studentEj3.getProfesorEj3().getId_profesor());

        setBranch(studentEj3.getBranch());
        setComents(studentEj3.getComents());
        setNum_hours_week(studentEj3.getNum_hours_week());
        setId_estudios(studentEj3.getEstudios().stream().map((asignatura)->asignatura.getId_asignatura()).toList());

        //setIdPersona(String.valueOf(persona.getId_persona()));
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
/**/
    }

    public Student_and_persona_output_dto() {
    }

}

package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto.Estudiante_asignatura_output_dto_simple;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student_y_asignaturas_output_dto {

    String id_student;
    String id_persona;
    int num_hours_week;
    String coments;
    String id_profesor;
    String branch;
    List<Estudiante_asignatura_output_dto_simple> asignaturas = new ArrayList<>();

    public Student_y_asignaturas_output_dto(Student_ej3 studentEj3, List<Estudiante_asignatura_ej3> asignaturas){
/*
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
*/
        //setPersona(student.getPersona());
        setId_persona(String.valueOf(String.valueOf(studentEj3.getPersonaEj3().getId_persona())));
        setId_student(String.valueOf(studentEj3.getId()));

        //setProfesor(String.valueOf(student.getProfesor()));
        //
        //setId_profesor(String.valueOf(student.getId_profesor()));
        setId_profesor(String.valueOf(studentEj3.getProfesorEj3().getId_profesor()));

        setBranch(studentEj3.getBranch());
        setComents(studentEj3.getComents());
        setNum_hours_week(studentEj3.getNum_hours_week());

        //this.asignaturas = asignaturas.stream().map((asignatura)->new Estudiante_asignatura_output_dto_simple(asignatura)).toList();

    }

}

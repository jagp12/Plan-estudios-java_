package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Student_con_profesores_y_asignaturas_output_dto extends AsignacionOutputDTO implements Serializable {

    String id_student;
    String id_persona;
    int num_hours_week;
    String coments;
    String id_profesor;
    String branch;

    List<Profesor_ej3> profesores;
    List<Estudiante_asignatura_ej3> asignaturas;

    int cantidad_profesores = 0;
    int cantidad_asignaturas = 0;

    public Student_con_profesores_y_asignaturas_output_dto(Student_ej3 studentEj3, List<Estudiante_asignatura_ej3> asignaturas, List<Profesor_ej3> profesores  ){

        setId_persona(String.valueOf(studentEj3.getPersonaEj3().getId_persona()));
        setUsuario(studentEj3.getPersonaEj3().getUsuario());
        setPassword(studentEj3.getPersonaEj3().getPassword());
        setName(studentEj3.getPersonaEj3().getName());
        setSurname(studentEj3.getPersonaEj3().getSurname());
        setCompany_email(studentEj3.getPersonaEj3().getCompany_email());
        setPersonal_email(studentEj3.getPersonaEj3().getPersonal_email());
        setCity(studentEj3.getPersonaEj3().getCity());
        setImagen_url(studentEj3.getPersonaEj3().getImagen_url());
        setActive(studentEj3.getPersonaEj3().isActive());
        setCreated_date(studentEj3.getPersonaEj3().getCreated_date());
        setTermination_date(studentEj3.getPersonaEj3().getTermination_date());

        //setPersona(String.valueOf(student.getPersona()));
        setId_persona(String.valueOf(String.valueOf(studentEj3.getPersonaEj3().getId_persona())));
        setId_student(String.valueOf(studentEj3.getId()));

        //setProfesor(String.valueOf(student.getProfesor()));
        //setId_profesor(student.getId_profesor());
        //setId_profesor(student.getProfesor().getId_profesor());

        setBranch(studentEj3.getBranch());
        setComents(studentEj3.getComents());
        setNum_hours_week(studentEj3.getNum_hours_week());

        //this.asignaturas= asignaturas;
        //this.profesores = profesores;

        cantidad_asignaturas = this.asignaturas.size();
        cantidad_profesores = this.profesores.size();

    }

}

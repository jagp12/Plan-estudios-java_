package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Estudiante_asignatura_output_dto {

    String id_asignatura;
    String id_student;
    String id_profesor;
    String asignatura;
    String coments;
    Date initial_date;
    Date finish_date;
    //Student_output_dto student;
    //Profesor_output_dto profesor;

    public Estudiante_asignatura_output_dto(Estudiante_asignatura_ej3 estudiante_asignaturaEj3){

        setId_asignatura(estudiante_asignaturaEj3.getId_asignatura());
        //setStudent(estudiante_asignatura.getStudent());
        //setStudent(new Student_output_dto(estudiante_asignatura.getStudent()));
        if(estudiante_asignaturaEj3.getStudentEj3() != null){
            setId_student(estudiante_asignaturaEj3.getStudentEj3().getId());
        }

        //setProfesor(new Profesor_output_dto(estudiante_asignatura.getProfesor()));
        setId_profesor(estudiante_asignaturaEj3.getProfesorEj3().getId_profesor());

        setAsignatura(estudiante_asignaturaEj3.getAsignatura());
        setComents(estudiante_asignaturaEj3.getComents());
        setInitial_date(estudiante_asignaturaEj3.getInitial_date());
        setFinish_date(estudiante_asignaturaEj3.getFinish_date());

    }

}

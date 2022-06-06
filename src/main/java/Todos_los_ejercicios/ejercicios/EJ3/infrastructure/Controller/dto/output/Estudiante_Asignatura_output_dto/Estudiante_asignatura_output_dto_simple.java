package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Estudiante_asignatura_output_dto_simple {

    String id_asignatura;
    //Student_output_dto_simple student= null;
    String id_student;
    String asignatura;
    String coments;
    Date initial_date;
    Date finish_date;

    public Estudiante_asignatura_output_dto_simple(Estudiante_asignatura_ej3 estudiante_asignaturaEj3){

        setId_asignatura(estudiante_asignaturaEj3.getId_asignatura());
        //setStudent(new Student_output_dto_simple(estudiante_asignatura.getStudent()));
        setId_student(estudiante_asignaturaEj3.getStudentEj3().getId());
        setAsignatura(estudiante_asignaturaEj3.getAsignatura());
        setComents(estudiante_asignaturaEj3.getComents());
        setInitial_date(estudiante_asignaturaEj3.getInitial_date());
        setFinish_date(estudiante_asignaturaEj3.getFinish_date());

    }

}

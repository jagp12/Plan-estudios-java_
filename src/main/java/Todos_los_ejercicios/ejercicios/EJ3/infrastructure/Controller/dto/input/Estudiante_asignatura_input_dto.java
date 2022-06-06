package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import lombok.Data;

import java.util.Date;

@Data
public class Estudiante_asignatura_input_dto {

    String id_asignatura;
    Student_ej3 Student_ej3;
    Profesor_ej3 profesorEj3;
    //String idStudent;
    String asignatura;
    String coments;
    Date initial_date;
    Date finish_date;

}

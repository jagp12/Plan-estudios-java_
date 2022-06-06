package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input;

import lombok.Data;

import java.util.List;

@Data
public class Student_input_dto {

    String id_student;
    //Persona Persona;
    String idPersona;
    int num_hours_week;
    String coments;
    //List<Profesor> id_profesor;
    String id_profesor;
    String branch;
    List<Estudiante_asignatura_input_dto> estudios;
    //List<String> id_estudios;

}

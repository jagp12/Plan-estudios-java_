package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student_output_dto {

    String id_student;
    String branch;
    //String idPersona;
    int num_hours_week;
    String coments;
    //Persona persona;
    String id_persona;
    //Profesor profesor;
    String id_profesor;

    //List<Estudiante_asignatura_output_dto_simple> estudios = new ArrayList<>();
    List<String> id_estudios = new ArrayList<>();

    public Student_output_dto(Student_ej3 studentEj3){

        if(studentEj3 == null){
            return;
        }
        //setPersona(student.getPersona());
        setId_persona(String.valueOf(String.valueOf(studentEj3.getPersonaEj3().getId_persona())));
        setId_student(String.valueOf(studentEj3.getId()));

        //setProfesor(student.getProfesor());
        //setId_profesor(String.valueOf(student.getId_profesor()));
        setId_profesor(String.valueOf(studentEj3.getProfesorEj3().getId_profesor()));

        setBranch(studentEj3.getBranch());
        setComents(studentEj3.getComents());
        setNum_hours_week(studentEj3.getNum_hours_week());

        //setEstudios(student.getEstudios().stream().map((asignatura)->new Estudiante_asignatura_output_dto_simple(asignatura)).toList());
        setId_estudios(studentEj3.getEstudios().stream().map((asignatura)->asignatura.getId_asignatura()).toList());
        for(Estudiante_asignatura_ej3 estudios: studentEj3.getEstudios()){
            //getId_estudios().add(estudios.getId_asignatura());
        }
    }


    public Student_output_dto() {
    }

}

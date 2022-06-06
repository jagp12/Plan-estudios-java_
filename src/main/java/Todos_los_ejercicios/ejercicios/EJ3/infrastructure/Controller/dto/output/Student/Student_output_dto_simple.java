package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student_output_dto_simple extends Student_output_dto {

    String id_student;
    int num_hours_week;
    String coments;
    String id_profesor;
    String branch;
    String id_persona;
    //Persona persona = null;
    //List<Estudiante_asignatura_output_dto_simple> estudios = new ArrayList<>();

    public Student_output_dto_simple(Student_ej3 studentEj3){

        //setPersona(student.getPersona());
        setId_persona(String.valueOf(studentEj3.getPersonaEj3().getId_persona()));
        setId_student(String.valueOf(studentEj3.getId()));

        //setProfesor(student.getProfesor());
        //setId_profesor(String.valueOf(student.getId_profesor()));
        setId_profesor(String.valueOf(studentEj3.getProfesorEj3().getId_profesor()));

        setBranch(studentEj3.getBranch());
        setComents(studentEj3.getComents());
        setNum_hours_week(studentEj3.getNum_hours_week());

        //setEstudios(student.getEstudios().stream().map((asignatura)->new Estudiante_asignatura_output_dto(asignatura)).toList());

    }


}

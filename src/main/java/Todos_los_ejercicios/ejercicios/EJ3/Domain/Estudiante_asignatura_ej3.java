package Todos_los_ejercicios.ejercicios.EJ3.Domain;

import Todos_los_ejercicios.ejercicios.EJ3.StringPrefixedSequenceIdGenerator;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Estudiante_asignatura_input_dto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Estudiante_asignatura_ej3 {

    @Id
    @GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "EJ2.CRUD.ej_crub.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id_asignatura")

    String id_asignatura;// String [pk, increment]

    //@ManyToMany
    //List<Student> Student;// string [ref: > student.id_student] -- Un estudiante puede tener N asignaturas
    /*
    @Column(name = "id_student")
    String idStudent;
*/
    @ManyToOne(fetch = FetchType.LAZY)//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student_ej3 studentEj3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    Profesor_ej3 profesorEj3;


    String asignatura;// string  -- Ejemplo: HTML, Angular, SpringBoot...
    String coments;// string
    Date initial_date;// date [not null], -- Fecha en que estudiante empezó a estudiar la asignatura
    Date finish_date;// date  -- Fecha en que estudiante termina de estudiar la asignatura

    public Estudiante_asignatura_ej3(Estudiante_asignatura_input_dto estudiante_asignatura_input_dto){

        setId_asignatura(estudiante_asignatura_input_dto.getId_asignatura());
        //setStudent(estudiante_asignatura_input_dto.getStudent());
        setStudentEj3(estudiante_asignatura_input_dto.getStudent_ej3());
        setProfesorEj3(estudiante_asignatura_input_dto.getProfesorEj3());
        setAsignatura(estudiante_asignatura_input_dto.getAsignatura());
        setComents(estudiante_asignatura_input_dto.getComents());
        setInitial_date(estudiante_asignatura_input_dto.getInitial_date());
        setFinish_date(estudiante_asignatura_input_dto.getFinish_date());

    }

    public Estudiante_asignatura_ej3() {

    }

}

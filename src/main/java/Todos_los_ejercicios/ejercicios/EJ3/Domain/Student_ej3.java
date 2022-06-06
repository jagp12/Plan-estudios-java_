package Todos_los_ejercicios.ejercicios.EJ3.Domain;

import Todos_los_ejercicios.ejercicios.EJ3.StringPrefixedSequenceIdGenerator;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Student_input_dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Student_ej3 {

    @Id
    @GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "EJ2.CRUD.ej_crub.StringPrefixedSequenceIdGenerator",//"com.bosonit.staffit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id_student")
    @NotNull
    String Id;// string [pk, increment]
    //@Column(name="id_persona")
    @NotNull
    //@OneToOne(mappedBy = "id_persona")
    //Persona Persona;// string [ref:-  persona.id_persona] -- Relación OneToOne con la tabla persona.
    //@Column(name = "id_persona")
    //String idPersona;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona_ej3 personaEj3;// string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.

    int num_hours_week;// int   [not null] -- Número de horas semanales del estudiante en formación
    String coments;// string
    //@OneToMany(mappedBy = "id_profesor", fetch = FetchType.LAZY)
    @NotNull

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor_ej3 profesorEj3;
/*
    @Column(name = "id_profesor")
    String id_profesor;
*/
    String branch;// string [not null] -- Rama principal delestudiante (Front, Back, FullStack)
    @OneToMany
    List<Estudiante_asignatura_ej3> estudios = new ArrayList<>();


    public Student_ej3(Student_input_dto student_input_dto){

        Persona_ej3 personaEj3 = new Persona_ej3();
        personaEj3.setId_persona(Integer.parseInt(student_input_dto.getIdPersona()));
        setPersonaEj3(personaEj3);
        //setIdPersona(student_input_dto.getId_persona());
        setId(student_input_dto.getId_student());

        //setProfesor(student_input_dto.getProfesor());
        //setId_profesor(student_input_dto.getId_profesor());
        Profesor_ej3 profesorEj31 = new Profesor_ej3();
        profesorEj31.setId_profesor(student_input_dto.getId_profesor());
        setProfesorEj3(profesorEj31);

        setBranch(student_input_dto.getBranch());
        setComents(student_input_dto.getComents());
        setNum_hours_week(student_input_dto.getNum_hours_week());

        if(student_input_dto.getEstudios() == null){
            return;
        }
        setEstudios(student_input_dto.getEstudios().stream().map((asignatura)->new Estudiante_asignatura_ej3(asignatura)).toList());


    }

    public Student_ej3(Student_input_dto student_input_dto , Persona_ej3 personaEj3, Profesor_ej3 profesorEj3){

        setPersonaEj3(personaEj3);
        //setIdPersona(profesor.getId_persona());

        //setId_profesor(String.valueOf(student_input_dto.getId_profesor()));
        setProfesorEj3(profesorEj3);

        setBranch(student_input_dto.getBranch());
        setComents(student_input_dto.getComents());
        setEstudios(student_input_dto.getEstudios().stream().map((asignatura)->new Estudiante_asignatura_ej3(asignatura)).toList());


    }

    public Student_ej3(){

    }
}

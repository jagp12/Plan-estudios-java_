package Todos_los_ejercicios.ejercicios.EJ3.Domain;

import Todos_los_ejercicios.ejercicios.EJ3.StringPrefixedSequenceIdGenerator;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Profesor_input_dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Profesor_ej3 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "Todos_los_ejercicios.ejercicios.EJ3.StringPrefixedSequenceIdGenerator",//"com.bosonit.staffit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id_profesor")
    String id_profesor;// string [pk, increment]
    //@Column(name = "id_persona")
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona_ej3 personaEj3;// string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
    //@Column(name = "id_persona")
    //String idPersona;
    @Column(name = "coments")
    String coments;// string
    @Column(name = "branch")
    String branch;// string [not null] -- Materia principal que imparte. Por ejemplo: Front

    public Profesor_ej3(Profesor_input_dto profesor_input_dto){

        Persona_ej3 personaEj3 = new Persona_ej3();
        personaEj3.setId_persona(Integer.parseInt(profesor_input_dto.getIdPersona()));
        setPersonaEj3(personaEj3);
        //setIdPersona(profesor_input_dto.getIdPersona());
        setId_profesor(String.valueOf(profesor_input_dto.getId_profesor()));
        setBranch(profesor_input_dto.getBranch());
        setComents(profesor_input_dto.getComents());
        System.err.println("profe cr4eado:"+this);
    }

    public Profesor_ej3(Profesor_input_dto profesor_input_dto , Persona_ej3 personaEj3){

        setPersonaEj3(personaEj3);
        //setIdPersona(profesor.getId_persona());
        setId_profesor(String.valueOf(profesor_input_dto.getId_profesor()));
        setBranch(profesor_input_dto.getBranch());
        setComents(profesor_input_dto.getComents());

    }

    public Profesor_ej3() {

    }
}

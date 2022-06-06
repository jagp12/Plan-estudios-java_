package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Profesor_output_dto {

    String id_profesor;
    //Persona Persona;
    String idPersona;
    String coments;
    String branch;

    public Profesor_output_dto(Profesor_ej3 profesorEj3){

        //setPersona(profesor.getPersona());
        setIdPersona(String.valueOf(profesorEj3.getPersonaEj3().getId_persona()));
        //setIdPersona(profesor.getIdPersona());
        setId_profesor(String.valueOf(profesorEj3.getId_profesor()));
        setBranch(profesorEj3.getBranch());
        setComents(profesorEj3.getComents());

    }

}

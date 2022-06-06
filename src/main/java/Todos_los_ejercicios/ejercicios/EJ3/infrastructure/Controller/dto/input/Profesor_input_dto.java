package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Profesor_input_dto {

    String id_profesor;
    //Persona Persona;
    String idPersona;
    String coments;
    String branch;

/*
    public Profesor_input_dto(Profesor profesor){
        setId_profesor(profesor.getId_profesor());
        setIdPersona(String.valueOf(profesor.getPersona().getId_persona()));
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }

    public Profesor_input_dto(){

    }
*/
}

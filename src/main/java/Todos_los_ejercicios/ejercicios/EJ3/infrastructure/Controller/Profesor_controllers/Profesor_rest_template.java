package EJ2.CRUD.ej_crub.infrastructure.Controller.Profesor_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/profesor/{id}")
public class Profesor_rest_template {

    @Autowired
    Servicios servicio_persona;
/*
    public ResponseEntity<Profesor_output_dto> getProfesor(int id) {
        Profesor profesor  = servicio_persona.find_profesor_por_id_persona(String.valueOf(id));
        return ResponseEntity.status(200).body(new Profesor_output_dto(profesor));
    }*/
}

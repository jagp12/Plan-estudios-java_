package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Profesor_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Profesor.Profesor_service;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Profesor_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor.Profesor_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/profe")
@RestController
@RequestMapping("EJ3/profesor")
public class Profesor_create_controller {

    @Autowired
    Profesor_service profesor_service;

    @PostMapping()
    public Profesor_output_dto profesor_post(@RequestBody Profesor_input_dto entity_recibida) throws Exception{
        System.err.println("entity:"+entity_recibida);
        return profesor_service.create_entity(entity_recibida);

    }

    @PostMapping("/crear_profesores_en_repositorio/{numero}")
    public void persona_post(@PathVariable int numero) throws Exception{
        profesor_service.crear_profesores_en_repositorio(numero);
    }

}

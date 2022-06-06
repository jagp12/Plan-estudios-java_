package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Profesor_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Profesor.Profesor_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Profesor_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor.Profesor_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/profe")
@RestController
@RequestMapping("profesor")
public class Profesor_update_controller {

    @Autowired
    Profesor_service profesor_service;

    @PutMapping("/{id}")
    public Profesor_output_dto persona_put(@RequestBody Profesor_input_dto student_recibido, @PathVariable String id) throws Exception_persona_404 {

        return profesor_service.update_entity(student_recibido, id);

    }

}

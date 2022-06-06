package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Estudiante_asignatura_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Estudiante_asignatura.Estudiante_asignatura_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Estudiante_asignatura_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto.Estudiante_asignatura_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/asignatura")
@RestController
@RequestMapping("EJ3/estudiante_asignatura")
public class Estudiante_asignatura_update_controller {

    @Autowired
    Estudiante_asignatura_service profesor_service;

    @PutMapping("/{id}")
    public Estudiante_asignatura_output_dto persona_put(@RequestBody Estudiante_asignatura_input_dto student_recibido, @PathVariable String id) throws Exception_persona_404 {

        return new Estudiante_asignatura_output_dto(profesor_service.update_entity(student_recibido, id));

    }

}

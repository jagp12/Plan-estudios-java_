package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Estudiante_asignatura_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Estudiante_asignatura.Estudiante_asignatura_service;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Estudiante_asignatura_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto.Estudiante_asignatura_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJ3/asignatura")
@RestController
@RequestMapping("EJ3/estudiante_asignatura")
public class Estudiante_asignatura_create_controller {

    @Autowired
    Estudiante_asignatura_service estudiante_asignatura_service;

    @PostMapping()
    public Estudiante_asignatura_output_dto persona_post(@RequestBody Estudiante_asignatura_input_dto entity_recibida) throws Exception{

        System.out.println("entity:"+entity_recibida);
        Estudiante_asignatura_ej3 estudiante_Asignatura_ej3 = estudiante_asignatura_service.create_entity(entity_recibida);
        return new Estudiante_asignatura_output_dto(estudiante_Asignatura_ej3);

    }
}

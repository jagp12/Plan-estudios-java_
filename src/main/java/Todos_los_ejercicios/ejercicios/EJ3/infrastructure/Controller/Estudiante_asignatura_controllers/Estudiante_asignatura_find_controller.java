package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Estudiante_asignatura_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Estudiante_asignatura.Estudiante_asignatura_service;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto.Estudiante_asignatura_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJ3/asignatura")
@RestController
@RequestMapping("EJ3/estudiante_asignatura")
public class Estudiante_asignatura_find_controller {

    @Autowired
    Estudiante_asignatura_service estudiante_asignatura_service;

    @GetMapping("/getid/{id}")
    public Estudiante_asignatura_output_dto get_persona_por_id(@PathVariable String id ) throws Exception_persona_404 {

        Estudiante_asignatura_ej3 estudiante = estudiante_asignatura_service.find_by_id(id);
        return new Estudiante_asignatura_output_dto(estudiante);

    }

    @GetMapping("/getByStudentId/{id}")
    public List<Estudiante_asignatura_output_dto> get_asignatura_by_studen_id(@PathVariable String id ) throws Exception_persona_404 {
        return estudiante_asignatura_service.find_by_student_id(id).stream().map(estudiante->new Estudiante_asignatura_output_dto(estudiante)).toList();
    }

    @GetMapping("/all")
    public List<Estudiante_asignatura_output_dto> get_all_persona() {

        //devolver lista dto
        System.out.println("lista obtenida");
        return estudiante_asignatura_service.find_all().stream().map(estudiante->new Estudiante_asignatura_output_dto(estudiante)).toList();

    }
}

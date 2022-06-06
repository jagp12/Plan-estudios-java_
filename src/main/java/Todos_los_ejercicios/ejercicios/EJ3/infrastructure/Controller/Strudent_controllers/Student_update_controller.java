package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Strudent_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Student.Student_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Student_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/student")
@RestController
@RequestMapping("student")
public class Student_update_controller {

    @Autowired
    Student_service servicio_student;

    @PutMapping("/{id}")
    public Student_output_dto persona_put(@RequestBody Student_input_dto student_recibido, @PathVariable String id) throws Exception_persona_404 {

        return servicio_student.update_entity(student_recibido, id);

    }

}

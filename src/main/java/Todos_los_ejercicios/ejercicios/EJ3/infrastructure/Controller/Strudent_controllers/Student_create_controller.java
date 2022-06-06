package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Strudent_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Student.Student_service;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Student_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/student")
@RestController
@RequestMapping("student")
public class Student_create_controller {

    @Autowired
    Student_service service_student;

    //public Student_create_controller(Student_service servicio_student) {this.servicio_student = servicio_student;}

    @PostMapping()
    public Student_output_dto persona_post(@RequestBody Student_input_dto entity_recibida) throws Exception{
        System.out.println("entity:"+entity_recibida);
        return service_student.create_entity(entity_recibida);

    }

    @PostMapping("/crear_students_en_repositorio/{numero}")
    public void persona_post(@PathVariable int numero) throws Exception{
        service_student.crear_students_en_repositorio(numero);
    }

}

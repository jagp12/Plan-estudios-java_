package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Strudent_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Student.Student_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Id_asignaturas_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJ3/student")
@RestController
@RequestMapping("student")
public class Student_find_controller {

    @Autowired
    Student_service servicio_student;

    @GetMapping("/getid/{id}")
    public Student_output_dto get_persona_por_id(@PathVariable String id, @RequestParam(value = "ouputType") String ouputType ) throws Exception_persona_404 {

        System.out.println("ouputType:" +ouputType);
        return servicio_student.find_by_id(id, ouputType);

    }

    @GetMapping("/desasignar_asignaturas/{id_student}")
    public void des_asignar_asignaturas(@PathVariable String id_student,@RequestBody List<Id_asignaturas_input_dto> lista_ids_de_asignaturas){

        servicio_student.asignar_y_desasignar_asignaturas(id_student, lista_ids_de_asignaturas,"desasignar");

    }

    @GetMapping("/asignar_asignaturas/{id_student}")
    public void asignar_lista_asignaturas(@PathVariable String id_student, @RequestBody List<Id_asignaturas_input_dto> lista_ids_de_asignaturas){

        servicio_student.asignar_y_desasignar_asignaturas(id_student, lista_ids_de_asignaturas,"asignar");

    }

    @GetMapping("/all")
    public List<Student_output_dto> get_all_persona() {

        //devolver lista dto
        System.out.println("lista obtenida");
        return servicio_student.find_all();

    }
}

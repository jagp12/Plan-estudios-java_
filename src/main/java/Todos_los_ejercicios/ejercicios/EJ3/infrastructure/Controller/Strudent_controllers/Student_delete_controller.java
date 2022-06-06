package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Strudent_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Student.Student_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJ3/student")
@RestController
@RequestMapping("student")
public class Student_delete_controller {

    @Autowired
    Student_service servicio_student;

    //public Student_delete_controller(Servicio_persona servicio_persona) {this.servicio_student = servicio_persona;}

    @DeleteMapping("/{id}")
    public void student_delete(@PathVariable String id) throws Exception_persona_404 {

        servicio_student.delete_by_id(id);

    }

}

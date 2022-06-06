package EJ2.CRUD.ej_crub.infrastructure.Controller.Estudiante_asignatura_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Estudiante_asignatura.Estudiante_asignatura_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJ3/asignatura")
@RestController
@RequestMapping("EJ3/estudiante_asignatura")
public class Estudiante_asignatura_delete_controller {

    @Autowired
    Estudiante_asignatura_service estudiante_asignatura_service;

    @DeleteMapping("/{id}")
    public void profesor_delete(@PathVariable String id) throws Exception_persona_404 {

        estudiante_asignatura_service.delete_by_id(id);

    }

}

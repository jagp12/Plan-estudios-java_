package EJ2.CRUD.ej_crub.infrastructure.Controller.Profesor_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Profesor.Profesor_service;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJ3/profe")
@RestController
@RequestMapping("profesor")
public class Profesor_delete_controller {

    @Autowired
    Profesor_service profesor_service;

    @DeleteMapping("/{id}")
    public void profesor_delete(@PathVariable String id) throws Exception_persona_404 {

        profesor_service.delete_by_id(id);

    }

}

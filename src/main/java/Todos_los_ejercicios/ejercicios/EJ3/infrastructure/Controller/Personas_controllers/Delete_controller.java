package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Personas_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Servicios;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJ3/persona")
@RestController
@RequestMapping("EJ3/persona")
public class Delete_controller {

    @Autowired
    Servicios servicio_persona;
/*
    public Delete_controller(Servicio_persona servicio_persona) {
        this.servicio_persona = servicio_persona;
    }*/

    @DeleteMapping("/{id}")
    public void persona_delete(@PathVariable String id) throws Exception_persona_404 {

        servicio_persona.delete_by_id(id);

    }

}

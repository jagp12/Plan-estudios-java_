package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Personas_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Servicio_persona;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/persona")
@RestController
@RequestMapping("EJ3/persona")
public class Update_controller {

    @Autowired
    Servicio_persona servicio_persona;

    @PutMapping("{id}")
    public AsignacionOutputDTO persona_put(@RequestBody AsignacionInputDTO persona_recibida, @PathVariable String id) throws Exception_persona_404 {

        return new AsignacionOutputDTO(servicio_persona.update_persona(new Persona_ej3(persona_recibida)));

    }

}

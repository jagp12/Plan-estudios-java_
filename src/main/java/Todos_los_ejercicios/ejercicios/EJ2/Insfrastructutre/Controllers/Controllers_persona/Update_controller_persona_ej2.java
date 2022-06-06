package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_other.Service_transform;
import Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_update.Service_update_persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ2/persona")
@RestController
@RequestMapping("EJ2/update")
public class Update_controller_persona_ej2 {

    @Autowired
    Service_update_persona_ej2 service_update_persona_ej2;

    @Autowired
    Service_transform service_transform;

    @PutMapping("{id}")
    public AsignacionOutputDTO persona_put(@RequestBody AsignacionInputDTO persona_recibida, @PathVariable String id) throws Exception_persona_404 {

        return service_transform.crear_output_dto(service_update_persona_ej2.update_persona(new Persona_ej2(persona_recibida)));

    }



}

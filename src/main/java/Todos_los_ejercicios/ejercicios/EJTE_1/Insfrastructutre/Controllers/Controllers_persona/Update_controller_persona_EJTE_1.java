package Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.update.Service_update_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.DTO.PersonaInputDTO;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.DTO.PersonaOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "EJTE_1")
@RestController
@RequestMapping("EJTE_1/update")
public class Update_controller_persona_EJTE_1 {

    @Autowired
    Service_update_persona_EJTE_1 service_update_persona_EJTE1;

    @PutMapping("{id}")
    public PersonaOutputDTO persona_put(@RequestBody PersonaInputDTO persona_recibida, @PathVariable String id) throws Exception_persona_404 {
        System.err.println("update:"+persona_recibida);
        return new PersonaOutputDTO(service_update_persona_EJTE1.update_persona(new Persona_EJTE_1(persona_recibida)));

    }


}

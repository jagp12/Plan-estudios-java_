package Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.DBA2.Aplication.update.Service_update_persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.DTO.PersonaInputDTO;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.DTO.PersonaOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "DBA2")
@RestController
@RequestMapping("DBA2/update")
public class Update_controller_persona_DBA2 {

    @Autowired
    Service_update_persona_DBA2 service_update_persona_dba2;

    @PutMapping("{id}")
    public PersonaOutputDTO persona_put(@RequestBody PersonaInputDTO persona_recibida, @PathVariable String id) throws Exception_persona_404 {
        System.err.println("update:"+persona_recibida);
        return new PersonaOutputDTO(service_update_persona_dba2.update_persona(new Persona_DBA2(persona_recibida)));

    }


}

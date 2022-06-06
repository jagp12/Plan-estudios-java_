package Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.create.Service_create_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.DTO.PersonaInputDTO;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.DTO.PersonaOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJTE_1")
@RestController
@RequestMapping("EJTE_1")
public class Create_controller_persona_EJTE_1 {

    @Autowired
    Service_create_persona_EJTE_1 service_create_persona_EJTE1;

    @PostMapping("/post")
    public PersonaOutputDTO persona_post(@RequestBody PersonaInputDTO persona_recibida) throws Exception{
        System.out.println("perssona:"+persona_recibida);
        Persona_EJTE_1 persona = new Persona_EJTE_1(persona_recibida);
        service_create_persona_EJTE1.create_persona(new Persona_EJTE_1(persona_recibida));
        return new PersonaOutputDTO(persona);

    }
/**/
}

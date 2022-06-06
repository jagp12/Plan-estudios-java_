package Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.DTO.PersonaInputDTO;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.DTO.PersonaOutputDTO;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Repository.PersonaRepositorio_DBA2;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "DBA2")
@RestController
@RequestMapping("DBA2")
public class Create_controller_persona_DBA2 {

    ///@Autowired
    PersonaRepositorio_DBA2 personaRepositorio_dba2;

    @PostMapping("/post")
    public PersonaOutputDTO persona_post(@RequestBody PersonaInputDTO persona_recibida) throws Exception{
        System.out.println("perssona:"+persona_recibida);
        Persona_DBA2 persona = new Persona_DBA2(persona_recibida);
        //personaRepositorio_dba2.insert(new Persona_DBA2(persona_recibida));
        return new PersonaOutputDTO(persona);

    }

}

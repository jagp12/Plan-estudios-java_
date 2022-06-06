package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_create.Service_create_persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_other.Service_transform;
import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "EJ2/persona")
@RestController
@RequestMapping("EJ2")
public class Create_controller_persona_ej2 {

    @Autowired
    Service_create_persona_ej2 service_create_persona_ej2;
    @Autowired
    Service_transform service_transform;

    @PostMapping("/post")
    public AsignacionOutputDTO persona_post(@RequestBody AsignacionInputDTO persona_recibida) throws Exception{
        System.out.println("perssona:"+persona_recibida);
        Persona_ej2 persona = new Persona_ej2(persona_recibida);
        service_create_persona_ej2.create_persona(new Persona_ej2(persona_recibida));
        return service_transform.crear_output_dto(persona);

    }


}

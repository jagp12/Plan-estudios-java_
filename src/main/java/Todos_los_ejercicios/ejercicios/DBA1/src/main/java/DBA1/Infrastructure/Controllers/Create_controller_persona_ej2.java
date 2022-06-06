package DBA1.Infrastructure.Controllers;

import DBA1.Aplicacion.Service_persona_ej2;
import DBA1.Domain.Persona;
import DBA1.Infrastructure.Controllers.dto.AsignacionInputDTO;
import DBA1.Infrastructure.Controllers.dto.AsignacionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("EJ2")
public class Create_controller_persona_ej2 {

    @Autowired
    Service_persona_ej2 service_create_persona_ej2;

    @PostMapping("/post")
    public AsignacionOutputDTO persona_post(@RequestBody AsignacionInputDTO persona_recibida) throws Exception{
        System.out.println("perssona:"+persona_recibida);
        Persona persona = new Persona(persona_recibida);
        service_create_persona_ej2.create_persona(new Persona(persona_recibida));
        return new AsignacionOutputDTO(persona);

    }

}

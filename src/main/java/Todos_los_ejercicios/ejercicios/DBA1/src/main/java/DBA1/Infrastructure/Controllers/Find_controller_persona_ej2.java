package DBA1.Infrastructure.Controllers;

import DBA1.Aplicacion.Service_persona_ej2;
import DBA1.Domain.Persona;
import DBA1.Excepciones.Exception_persona_404;
import DBA1.Infrastructure.Controllers.dto.AsignacionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("EJ2/find")
@RestController
public class Find_controller_persona_ej2 {

    @Autowired
    Service_persona_ej2 service_find_persona_ej2;

    @GetMapping("/getid/{id}")
    public AsignacionOutputDTO get_persona_por_id(@PathVariable String id, @RequestParam(value = "outputType") String ouputType  ) throws Exception_persona_404 {

        return new AsignacionOutputDTO(service_find_persona_ej2.find_by_id(id));
        //return servicio_persona.find_by_id(id,ouputType);

    }

    @GetMapping("getuser/{user}")
    public List<AsignacionOutputDTO> get_persona_por_nombre(@PathVariable String user, @RequestParam(value = "outputType") String outputType) throws Exception{

        List<AsignacionOutputDTO> lista = service_find_persona_ej2.find_by_user(user,outputType).stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();
        //List<AsignacionOutputDTO> lista = servicio_persona.find_by_user(user,ouputType).stream().map((personaEj2 -> new AsignacionOutputDTO(personaEj2))).toList();
        //persona_repositorio.findAll().stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();

        return lista;

    }

    @GetMapping("/all")
    public List<AsignacionOutputDTO> get_all_persona(@RequestParam(value = "outputType") String outputType) {

        //devolver lista dto
        System.out.println("lista obtenida");
        return service_find_persona_ej2.find_all(outputType).stream().map(personaEj2 -> crear_output_dto(personaEj2)).toList();

    }

    @GetMapping("/getparams/{id}")
    public AsignacionOutputDTO get_persona_por_parametros(@PathVariable String id, @RequestParam(value = "outputType") String ouputType  ) throws Exception_persona_404 {

        return new AsignacionOutputDTO(service_find_persona_ej2.find_by_id(id));
        //return servicio_persona.find_by_id(id,ouputType);

    }

    private AsignacionOutputDTO crear_output_dto(Persona persona){
        //AsignacionOutputDTO dto = new AsignacionOutputDTO(persona);

        AsignacionOutputDTO dto = new AsignacionOutputDTO
                (       persona
                        //String.valueOf(persona.getId_persona()),
                        /*
                        persona.getUsuario(),
                        persona.getPassword(),
                        persona.getName(),
                        persona.getSurname(),
                        persona.getCompany_email(),
                        persona.getPersonal_email(),
                        persona.getCity(),
                        persona.getImagen_url(),
                        persona.isActive(),
                        persona.getCreated_date(),
                        persona.getTermination_date()
                    */
                );

        return dto;
    }

}

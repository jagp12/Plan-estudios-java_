package Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.Controllers_persona;


import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.find.Service_find_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.DTO.PersonaOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "EJTE_1")
@RequestMapping(value="EJTE_1/find")
@RestController
public class Find_controller_persona_EJTE_1 {

    @Autowired
    Service_find_persona_EJTE_1 service_find_persona_EJTE1;

    @GetMapping("/getid/{id}")
    public PersonaOutputDTO get_persona_por_id(@PathVariable String id, @RequestParam(value = "outputType") String ouputType  ) throws Exception_persona_404 {

        return new PersonaOutputDTO(service_find_persona_EJTE1.find_by_id(id));
        //return servicio_persona.find_by_id(id,ouputType);

    }

    @GetMapping("getuser/{user}")
    public List<PersonaOutputDTO> get_persona_por_nombre(@PathVariable String user, @RequestParam(value = "outputType") String outputType) throws Exception{
        System.out.println("obteniendo por user");
        List<PersonaOutputDTO> lista = service_find_persona_EJTE1.find_by_user(user,outputType).stream().map((persona -> crear_output_dto(persona))).toList();

        return lista;

    }

    @GetMapping("/all")
    public List<PersonaOutputDTO> get_all_persona(@RequestParam(value = "outputType") String outputType) {

        //devolver lista dto
        System.out.println("lista obtenida");
        return service_find_persona_EJTE1.find_all(outputType).stream().map(persona -> crear_output_dto(persona)).toList();

    }




    private PersonaOutputDTO crear_output_dto(Persona_EJTE_1 persona){
        //AsignacionOutputDTO dto = new AsignacionOutputDTO(persona);

        PersonaOutputDTO dto = new PersonaOutputDTO
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

package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.Controllers_persona;


import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_find.Service_find_persona_docker;
import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_other.Service_transform_docker;
import Todos_los_ejercicios.ejercicios.Docker.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "Docker")
@RequestMapping(value="Docker/find")
@RestController
public class Find_controller_persona_docker {

    @Autowired
    Service_find_persona_docker service_find_persona_ej2;

    @Autowired
    Service_transform_docker service_transformDocker;

    @GetMapping("/getid/{id}")
    public Employee_output_dto get_persona_por_id(@PathVariable String id) throws Exception_persona_404 {

        return service_transformDocker.crear_output_dto(service_find_persona_ej2.find_by_id(id));//new AsignacionOutputDTO(service_find_persona_ej2.find_by_id(id));
        //return servicio_persona.find_by_id(id,ouputType);

    }


}

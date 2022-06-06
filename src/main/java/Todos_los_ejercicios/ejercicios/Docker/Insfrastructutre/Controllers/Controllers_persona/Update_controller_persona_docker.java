package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_other.Service_transform_docker;
import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_update.Service_update_persona_docker;
import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_input_dto;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "Docker")
@RestController
@RequestMapping("Docker/update")
public class Update_controller_persona_docker {

    @Autowired
    Service_update_persona_docker service_update_persona_ej2;

    @Autowired
    Service_transform_docker service_transformDocker;

    @PutMapping("{id}")
        public Employee_output_dto persona_put_docker(@RequestBody Employee_input_dto employee_input_dto, @PathVariable String id) throws Exception_persona_404 {

        return service_transformDocker.crear_output_dto(service_update_persona_ej2.update_employee_docker(new Employee_docker(employee_input_dto)));

    }



}

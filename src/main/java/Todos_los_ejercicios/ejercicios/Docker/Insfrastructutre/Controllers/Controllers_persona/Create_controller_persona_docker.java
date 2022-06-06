package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_create.Service_create_employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_other.Service_transform_docker;
import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_input_dto;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Docker")
@RestController
@RequestMapping("Docker")
public class Create_controller_persona_docker {

    @Autowired
    Service_create_employee_docker service_create_employee_docker;
    @Autowired
    Service_transform_docker service_transformDocker;

    @PostMapping("/post")
    public Employee_output_dto persona_post(@RequestBody Employee_input_dto employee_input_dto) throws Exception{
        System.out.println("perssona:"+employee_input_dto);
        Employee_docker employee_docker = new Employee_docker(employee_input_dto);
        service_create_employee_docker.create_employee(employee_docker);
        return service_transformDocker.crear_output_dto(employee_docker);

    }


}

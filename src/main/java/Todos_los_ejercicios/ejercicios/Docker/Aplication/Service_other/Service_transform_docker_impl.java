package Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_other;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_output_dto;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Persona.AsignacionOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class Service_transform_docker_impl implements Service_transform_docker {
    @Override
    public Employee_output_dto crear_output_dto(Employee_docker employee_docker){

        Employee_output_dto dto = new Employee_output_dto(employee_docker);
                //(employee_docker.getEmployeeName(), employee_docker.getEmployeeEmail(),
                        //employee_docker.getEmployeeAddress());

        return dto;
    }
}

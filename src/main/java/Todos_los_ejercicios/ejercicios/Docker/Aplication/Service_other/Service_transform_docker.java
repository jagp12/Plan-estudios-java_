package Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_other;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_output_dto;

public interface Service_transform_docker {
    Employee_output_dto crear_output_dto(Employee_docker employee_docker);
}

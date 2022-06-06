package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import lombok.Data;

@Data
public class Employee_output_dto{//(String employeeName,String employeeEmail,String employeeAddress) {
    private String employeeId,employeeName,employeeEmail,employeeAddress;
    public Employee_output_dto(Employee_docker employee){
        setEmployeeId(employee.getEmployeeId());
        setEmployeeName(employee.getEmployeeName());
        setEmployeeEmail(employee.getEmployeeEmail());
        setEmployeeAddress(employee.getEmployeeAddress());
    }
}

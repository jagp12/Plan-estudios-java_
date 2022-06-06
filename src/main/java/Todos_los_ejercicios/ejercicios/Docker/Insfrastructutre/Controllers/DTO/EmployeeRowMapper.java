package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper /*implements RowMapper<Employee_docker>*/ {
/*
    @Override
    public Employee_docker mapRow(ResultSet rs, int arg1) throws SQLException {
        Employee_docker emp = new Employee_docker();
        emp.setEmployeeId(rs.getString("employeeId"));
        emp.setEmployeeName(rs.getString("employeeName"));
        emp.setEmployeeEmail(rs.getString("employeeEmail"));

        return emp;
    }
*/
}
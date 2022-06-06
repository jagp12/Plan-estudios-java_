package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Employee_ej2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee_ej2> {

    @Override
    public Employee_ej2 mapRow(ResultSet rs, int arg1) throws SQLException {
        Employee_ej2 emp = new Employee_ej2();
        emp.setEmployeeId(rs.getString("employeeId"));
        emp.setEmployeeName(rs.getString("employeeName"));
        emp.setEmployeeEmail(rs.getString("employeeEmail"));

        return emp;
    }

}
package Todos_los_ejercicios.ejercicios.Docker.Domain;

import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.DTO.Employee.Employee_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "Employee_docker", schema = "public")
public class Employee_docker implements Serializable {

    //@GenericGenerator(name = "native",strategy = "native")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="employeeid")
    private String employeeId;

    @Column(name = "employeename")
    private String employeeName;
    @Column(name = "employeeemail")
    private String employeeEmail;
    @Column(name = "employeeaddress")
    private String employeeAddress;

    public Employee_docker(Employee_input_dto employee_input_dto){

        setEmployeeId(employee_input_dto.getEmployeeId());
        setEmployeeName(employee_input_dto.getEmployeeName());
        setEmployeeEmail(employee_input_dto.getEmployeeEmail());
        setEmployeeAddress(employee_input_dto.getEmployeeAddress());

        System.out.println("empleadoi:"+this);
    }

    public Employee_docker(){

    }

}

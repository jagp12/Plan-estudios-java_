package Todos_los_ejercicios.ejercicios.EJ2.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Employee_ej2 {

    @Id
    @GeneratedValue
    private String employeeId;
    String employeeName,employeeEmail,employeeAddress;

}

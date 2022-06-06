package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Repository;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Employee_repository_docker extends JpaRepository<Employee_docker,String> {

}

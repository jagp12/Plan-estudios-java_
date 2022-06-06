package Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_update;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Repository.Employee_repository_docker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_update_persona_docker_impl implements Service_update_persona_docker {

    @Autowired
    Employee_repository_docker persona_repositorio;

    @Override
    public Employee_docker update_employee_docker(Employee_docker empleado){

        persona_repositorio.save(empleado);

        return empleado;
    }

}

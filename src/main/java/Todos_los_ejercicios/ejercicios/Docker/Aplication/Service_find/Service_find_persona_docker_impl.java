package Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_find;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;
import Todos_los_ejercicios.ejercicios.Docker.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Repository.Employee_repository_docker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_find_persona_docker_impl implements Service_find_persona_docker {

    @Autowired
    Employee_repository_docker employee_repository_docker;

    @Override
    public Employee_docker find_by_id(String id){
        return employee_repository_docker.findById(id).get();//Integer.valueOf(id)).get();
    }


}

package Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_delete;

import Todos_los_ejercicios.ejercicios.Docker.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Repository.Employee_repository_docker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Delete_persona_docker_impl implements Service_delete_persona_docker {

    @Autowired
    Employee_repository_docker persona_repositorio;

    @Override
    public void delete_by_id(String id){

         persona_repositorio.deleteById(id);//Integer.parseInt(id));

    }

}

package Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_find;

import Todos_los_ejercicios.ejercicios.Docker.Domain.Employee_docker;

public interface Service_find_persona_docker {

    Employee_docker find_by_id(String id);

}

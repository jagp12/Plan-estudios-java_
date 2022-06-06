package Todos_los_ejercicios.ejercicios.EJ3.Aplication;

import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Output_dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class Service_impl implements Services{

    @Autowired
    JpaRepository repositorio;

    @Override
    public Output_dto find_by_id(String id) throws Exception {
        return null;
    }

    @Override
    public List<Output_dto>find_by_user(String user) {
        return null;
    }

    @Override
    public List<Output_dto> find_all() {
        return null;
    }

    @Override
    public Output_dto create_entity(Input_dto persona_dto) {
        return null;
    }

    @Override
    public Output_dto update_entity(Input_dto persona_dto) throws Exception {
        return null;
    }

    @Override
    public Output_dto delete_by_id(String id) throws Exception {
        return null;
    }
}

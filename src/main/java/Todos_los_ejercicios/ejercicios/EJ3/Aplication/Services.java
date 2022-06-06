package Todos_los_ejercicios.ejercicios.EJ3.Aplication;

import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Output_dto;

import java.util.List;

public interface Services {

    Output_dto find_by_id(String id) throws Exception;

    List<Output_dto> find_by_user(String user);

    List<Output_dto>  find_all();

    Output_dto create_entity(Input_dto persona_dto);

    Output_dto update_entity(Input_dto persona_dto) throws Exception;

    Output_dto delete_by_id(String id) throws Exception;

}

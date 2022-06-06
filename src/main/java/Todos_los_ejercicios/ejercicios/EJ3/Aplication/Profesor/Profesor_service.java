package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Profesor;

import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Profesor_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor.Profesor_output_dto;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Profesor_service {

    Profesor_output_dto find_by_id(String id) throws Exception_persona_404;
    //Output_dto find_by_id(String id) throws Exception;

    List<Profesor_output_dto>  find_all();

    Profesor_output_dto create_entity(Profesor_input_dto persona_dto);

    Profesor_output_dto update_entity(Profesor_input_dto persona_dto, String id) throws Exception_persona_404;

    Profesor_output_dto delete_by_id(String id) throws Exception_persona_404;

    void crear_profesores_en_repositorio(int numero);



}

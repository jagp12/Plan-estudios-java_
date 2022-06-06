package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Estudiante_asignatura;


import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Estudiante_asignatura_input_dto;

import java.util.List;

public interface Estudiante_asignatura_service {

    Estudiante_asignatura_ej3 find_by_id(String id) throws Exception_persona_404;
    //Output_dto find_by_id(String id) throws Exception;

    List<Estudiante_asignatura_ej3> find_by_student_id(String id);
    List<Estudiante_asignatura_ej3>  find_all();

    Estudiante_asignatura_ej3 create_entity(Estudiante_asignatura_input_dto persona_dto);

    Estudiante_asignatura_ej3 update_entity(Estudiante_asignatura_input_dto persona_dto, String id) throws Exception_persona_404;

    Estudiante_asignatura_ej3 delete_by_id(String id) throws Exception_persona_404;

    void crear_asignaturas_en_repositorio(int numero);

}

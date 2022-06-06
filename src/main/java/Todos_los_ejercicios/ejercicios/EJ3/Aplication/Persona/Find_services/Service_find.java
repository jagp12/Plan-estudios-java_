package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Student_y_asignaturas_output_dto;

import java.util.List;

public interface Service_find {

    Persona_ej3 find_by_id(String id) throws Exception_persona_404;
    Persona_ej3 find_by_id(String id, String ouputType) throws Exception_persona_404;
    List<AsignacionOutputDTO> find_by_user(String user, String ouputType) throws Exception;
    List<AsignacionOutputDTO>  find_all(String ouputType);

    AsignacionOutputDTO devolver_student_o_profesor_en_id(Persona_ej3 persona);

    List<AsignacionOutputDTO> devolver_student_o_profesor_en_user(List<AsignacionOutputDTO> lista_personas, String ouputType);

    Profesor_ej3 find_profesor_por_id_persona(String id_persona);

    List<Estudiante_asignatura_ej3> obtener_lista_de_asignaturas_de_un_estudiante(String id_studiante);
    List<Profesor_ej3> obtener_lista_de_profesores(Persona_ej3 persona_ej3_student, Student_ej3 estudiante );

    List<Student_ej3> obtener_lista_de_estudiantes(String id_profesor);
    List<Student_y_asignaturas_output_dto> obtener_lista_de_estudiantes_con_asignatura(Persona_ej3 personaEj3, List<Student_ej3> estudiantes);
    Student_ej3 find_student_por_id_persona(String id_persona);

}

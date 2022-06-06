package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Student;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Id_asignaturas_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Student_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;

import java.util.List;

public interface Student_service {

     Student_output_dto find_by_id(String id) throws Exception_persona_404;
     Student_output_dto find_by_id(String id, String ouputType) throws Exception_persona_404;

     List<Student_output_dto>  find_all();

     Student_output_dto create_entity(Student_input_dto persona_dto);

     Student_output_dto update_entity(Student_input_dto persona_dto, String id) throws Exception_persona_404;

     Student_output_dto delete_by_id(String id) throws Exception_persona_404;


     void asignar_y_desasignar_asignaturas(String id_student, List<Id_asignaturas_input_dto> lista_ids_de_asignaturas, String operacion_a_realizar);

     void des_asignar_asignatura_a_estudiante(Estudiante_asignatura_ej3 estudiante_asignaturaEj3, Student_ej3 studentEj3) ;
     void asignar_asignatura_a_estudiante(Estudiante_asignatura_ej3 estudiante_asignaturaEj3, Student_ej3 studentEj3) ;

     void crear_students_en_repositorio(int numero);

}

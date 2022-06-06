package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;

public interface Servicios {

     //AsignacionOutputDTO find_by_id(String id) throws Exception_persona_404;
     //AsignacionOutputDTO find_by_id(String id, String ouputType) throws Exception_persona_404;
     //List<AsignacionOutputDTO> find_by_user(String user, String ouputType) throws Exception;
     //List<AsignacionOutputDTO>  find_all(String ouputType);

     //AsignacionOutputDTO create_persona(AsignacionInputDTO persona_dto) throws Exception;

     Persona_ej3 update_persona(Persona_ej3 persona_dto) throws Exception_persona_404;

     //void crear_personas_en_repositorio(int numero_personas);

     Persona_ej3 delete_by_id(String id) throws Exception_persona_404;

     boolean validar_usuario(Persona_ej3 persona_dto);

     //ResponseEntity<Profesor_output_dto> getProfesor(@PathVariable int id);

     //Profesor find_profesor_por_id_persona(String id_persona);


}

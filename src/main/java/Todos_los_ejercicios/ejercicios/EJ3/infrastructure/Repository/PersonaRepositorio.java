package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona_ej3,Integer> {
    List<AsignacionOutputDTO> findByusuario(String usuario);


    //void deleteByIdPersona(String id);
}

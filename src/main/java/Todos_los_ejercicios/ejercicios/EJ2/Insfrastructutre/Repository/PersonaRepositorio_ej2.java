package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepositorio_ej2 extends JpaRepository<Persona_ej2,Integer> {

    public final static String GET_PERSONAS = "SELECT * FROM PERSONA_EJ2   WHERE usuario = :usuario AND name = :name AND surname = :surname AND created_date = :created_date ORDER BY :order";

    List<Persona_ej2> findByusuario(String usuario);

    @Query(value = GET_PERSONAS,nativeQuery = true)
    List<Persona_ej2> findByPreference(@Param("usuario")final String usuario, @Param("name")final String name, @Param("surname")final String surname, @Param("created_date")final String created_date, @Param("order")final String order);

    //List<Persona_ej2> getData(HashMap<String, Object> conditions);

    //List<Persona_ej2> findByUsuarioAndNameAndSurnameAndCreated_Date(String usuario, String name, String surname, String createddate);
    //void deleteByIdPersona(String id);
}

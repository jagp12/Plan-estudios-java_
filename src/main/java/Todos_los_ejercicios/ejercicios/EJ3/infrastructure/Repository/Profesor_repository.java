package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface Profesor_repository  extends JpaRepository<Profesor_input_dto,String> {


public interface Profesor_repository  extends JpaRepository<Profesor_ej3,String> {

        //Profesor findByIdPersona(String id_persona);
        //Profesor_input_dto findByIdPersona(String id_persona);

}

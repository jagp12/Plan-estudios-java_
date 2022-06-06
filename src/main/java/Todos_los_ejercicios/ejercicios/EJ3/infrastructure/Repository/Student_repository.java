package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_repository extends JpaRepository<Student_ej3,String> {

    //Optional<Student> findById(String id_student);
    //Student findByIdPersona(String id_persona);
}

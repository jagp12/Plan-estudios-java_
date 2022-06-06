package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Estudiante_asignatura_repository  extends JpaRepository<Estudiante_asignatura_ej3,String> {
    //List<Estudiante_asignatura_ej3> findByIdStudent(String idStudent);
}

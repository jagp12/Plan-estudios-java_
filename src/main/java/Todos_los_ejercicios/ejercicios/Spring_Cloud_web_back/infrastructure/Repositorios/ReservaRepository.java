package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,String> {
    List<Reserva> findByCiudadDestino(String ciudad);
    String findByCorreo(String correo);
}

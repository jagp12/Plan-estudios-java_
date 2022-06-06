package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Correo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CorreoRepository  extends JpaRepository<Correo,String> {

    String GET_CORREOS = "SELECT * FROM CORREO  WHERE fecha_reserva > :diaInferior AND fecha_reserva < :diaSuperior AND hora_reserva > :horaInferior AND hora_reserva < :horaSuperior AND ciudad_destino = :ciudadDestino";

    @Query(value = GET_CORREOS,nativeQuery = true)
    List<Correo> findByCiudadDestino_por_hora_Y_dia(@Param("diaInferior")final LocalDate diaInferior, @Param("diaSuperior")final LocalDate diaSuperior, @Param("horaInferior")final String horaInferior, @Param("horaSuperior")final String horaSuperior, @Param("ciudadDestino")final String ciudadDestino);
    //List<ReservasDisponibles> findAllByCiudadDestinoWhereHoraBiggerThanAndLessThan(String ciudad, String horaInferior, String horaSuperior);

    String findByEmail(String email);

}

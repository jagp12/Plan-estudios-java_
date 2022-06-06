package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.ReservasDisponibles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservasDisponiblesRepository extends JpaRepository<ReservasDisponibles,String> {

    String GET_CIUDADES_DESTINO = "SELECT * FROM RESERVAS_DISPONIBLES  WHERE dia > :diaInferior AND dia < :diaSuperior AND hora > :horaInferior AND hora < :horaSuperior AND ciudad_destino = :ciudadDestino AND plazas_Libres > 0";

    String GET_CIUDADES_DESTINO_2 = "SELECT * FROM RESERVAS_DISPONIBLES  WHERE dia = :diaSalida AND hora = :horaSalida AND ciudad_destino = :ciudadDestino AND plazas_Libres > 0 AND plazas_Libres < 40";

    List<ReservasDisponibles> findByCiudadDestino(String ciudad);

    List<ReservasDisponibles> findAllByCiudadDestino(String ciudad);

    @Query(value = GET_CIUDADES_DESTINO,nativeQuery = true)
    List<ReservasDisponibles> findByCiudadDestino_por_hora_Y_dia(@Param("diaInferior")final LocalDate diaInferior, @Param("diaSuperior")final LocalDate diaSuperior, @Param("horaInferior")final String horaInferior, @Param("horaSuperior")final String horaSuperior, @Param("ciudadDestino")final String ciudadDestino);

    @Query(value = GET_CIUDADES_DESTINO_2,nativeQuery = true)
    List<ReservasDisponibles> findByCiudadDestino_por_hora_Y_dia_2(@Param("diaSalida")final LocalDate diaSalida, @Param("horaSalida")final String horaSalida,  @Param("ciudadDestino")final String ciudadDestino);

    List<ReservasDisponibles> findByCiudadDestinoAndDiaBetweenAndHoraBetween(String ciudadDestino, LocalDate diaInferior, LocalDate diaSuperior, float horaInferior, float horaSuperior);
    //List<ReservasDisponibles> findAllByCiudadDestinoWhereHoraBiggerThanAndLessThan(String ciudad, String horaInferior, String horaSuperior);

}

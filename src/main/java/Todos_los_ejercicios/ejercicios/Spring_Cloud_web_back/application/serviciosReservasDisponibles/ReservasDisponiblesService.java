package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReservasDisponibles;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.ReservasDisponibles;

import java.time.LocalDate;
import java.util.List;

public interface ReservasDisponiblesService {

    List<ReservasDisponibles> get_reservas_disponibles();
    ReservasDisponibles introduce_reservas_disponibles(ReservasDisponibles reservasDisponibles);
    List<ReservasDisponibles> get_plazas_libres(float horaInferior, float horaSuperior, LocalDate fechaInferior, LocalDate fechaSuperior, String destino) throws Exception;
    List<ReservasDisponibles> get_reservas_disponibles(String destino) throws Exception;

}

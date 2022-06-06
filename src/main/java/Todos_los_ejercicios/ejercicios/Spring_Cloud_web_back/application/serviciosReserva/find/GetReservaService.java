package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.find;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface GetReservaService {

    List<Reserva> get_reserva_por_ciudad_destino(String horaInferior, String horaSuperior, LocalDate fechaInferior, LocalDate fechaSuperior, String destino);
    void recibir_mensaje();
}

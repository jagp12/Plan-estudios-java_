package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.create;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;

public interface IntroducirReservaService {

    Reserva introducir_reserva(Reserva reserva) throws Exception;
    Reserva introducir_reserva_2(Reserva reserva) throws Exception;
    String plazasSize(Integer plazas);

}

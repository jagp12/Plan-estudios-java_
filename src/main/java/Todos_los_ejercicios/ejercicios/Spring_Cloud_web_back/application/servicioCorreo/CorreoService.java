package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.servicioCorreo;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;

public interface CorreoService {
    void sendMail(String from, String to, String subject, String body);
    void introducir_reserva_2(Reserva reserva) throws Exception;
}

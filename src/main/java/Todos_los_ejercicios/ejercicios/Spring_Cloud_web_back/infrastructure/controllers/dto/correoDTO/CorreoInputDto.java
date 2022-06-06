package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.correoDTO;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CorreoInputDto {
    String id;
    String ciudadDestino;
    String email;
    LocalDate fechaReserva;
    float horaReserva;
}

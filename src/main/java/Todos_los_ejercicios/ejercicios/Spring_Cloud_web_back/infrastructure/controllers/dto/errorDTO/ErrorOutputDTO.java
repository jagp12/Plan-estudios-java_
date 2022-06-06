package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.errorDTO;

import java.time.LocalDate;

public class ErrorOutputDTO {

    int httpCode;
    String msgError;
    String tipo;
    LocalDate fecha;

}

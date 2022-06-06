package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservadto;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums.CiudadDestino;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums.HoraSalida;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaInputDto {

    String idReserva;
    CiudadDestino ciudadDestino;
    String nombre;
    String apellidos;
    String telefono;
    String correo;
    LocalDate fecha;
    HoraSalida hora;
}

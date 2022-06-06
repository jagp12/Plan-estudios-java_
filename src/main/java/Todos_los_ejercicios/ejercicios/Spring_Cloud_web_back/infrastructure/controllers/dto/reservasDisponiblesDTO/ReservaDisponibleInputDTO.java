package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservasDisponiblesDTO;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums.CiudadDestino;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums.HoraSalida;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class ReservaDisponibleInputDTO {

    String id;
    String autobusId;
    HoraSalida hora;
    LocalDate dia;
    CiudadDestino ciudadDestino;
    int plazasLibres;
}

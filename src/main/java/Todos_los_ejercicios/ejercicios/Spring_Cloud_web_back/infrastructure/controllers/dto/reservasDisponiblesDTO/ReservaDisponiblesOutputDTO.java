package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservasDisponiblesDTO;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.ReservasDisponibles;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums.HoraSalida;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Setter
@Getter
//@NoArgsConstructor
public class ReservaDisponiblesOutputDTO{
    String id;
    String autobusId;
    HoraSalida hora;
    LocalDate fechaSalida;
    String ciudadDestino;
    int plazasLibres;

    public ReservaDisponiblesOutputDTO(ReservasDisponibles reservasDisponibles){

        setId(reservasDisponibles.getId());
        setCiudadDestino(reservasDisponibles.getCiudadDestino());
        //HoraSalida.values().;
        //setHora(reservasDisponibles.getHora());
        setAutobusId(reservasDisponibles.getAutobusId());
        setFechaSalida(reservasDisponibles.getDia());
        setPlazasLibres(reservasDisponibles.getPlazasLibres());
    }

    public ReservaDisponiblesOutputDTO(){

    }



}

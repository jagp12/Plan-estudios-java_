package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservadto;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaOutputDto {

    String id;
    String ciudadDestino;
    String nombre;
    String apellidos;
    String telefono;
    String correo;
    LocalDate fecha;
    float hora;

    public ReservaOutputDto(Reserva reserva){

        setId(reserva.getId());
        setCiudadDestino(reserva.getCiudadDestino());
        setNombre(reserva.getNombre());
        setApellidos(reserva.getApellidos());
        setTelefono(reserva.getTelefono());
        setCorreo(reserva.getCorreo());
        setFecha(reserva.getFecha());
        setHora(reserva.getHora());

    }


}

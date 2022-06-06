package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.correoDTO;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Correo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CorreoOutputDto {

    String id;
    String ciudadDestino;
    String email;
    LocalDate fechaReserva;
    float horaReserva;
    public CorreoOutputDto(Correo correo ){

        setId(correo.getId());
        setCiudadDestino(correo.getCiudadDestino());
        setEmail(correo.getEmail());
        setFechaReserva(correo.getFechaReserva());
        setHoraReserva(correo.getHoraReserva());

    }

}

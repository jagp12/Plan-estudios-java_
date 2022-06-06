package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain;

import Todos_los_ejercicios.ejercicios.shared.StringPrefixedSequenceIdGenerator;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservadto.ReservaInputDto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ausencias_seq")
    @GenericGenerator(
            name = "ausencias_seq",
            strategy = "Todos_los_ejercicios.ejercicios.shared.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    @Column(name = "id")
    String id;
    String ciudadDestino;
    String nombre;
    String apellidos;
    String telefono;
    String correo;
    LocalDate fecha;
    float hora;

    public Reserva(ReservaInputDto reserva){

        ///setId(reserva.getIdReserva());
        setCiudadDestino(reserva.getCiudadDestino().ciudad);
        setNombre(reserva.getNombre());
        setApellidos(reserva.getApellidos());
        setTelefono(reserva.getTelefono());
        setCorreo(reserva.getCorreo());
        setFecha(reserva.getFecha());
        setHora(reserva.getHora().hora);

    }
}
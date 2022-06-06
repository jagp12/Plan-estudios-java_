package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain;

import Todos_los_ejercicios.ejercicios.shared.StringPrefixedSequenceIdGenerator;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservasDisponiblesDTO.ReservaDisponibleInputDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReservasDisponibles {

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
    String autobusId;
    float hora;
    LocalDate dia;
    String ciudadDestino;
    int plazasLibres;

    public ReservasDisponibles(ReservaDisponibleInputDTO reservaDisponibleInputDTO){

        setCiudadDestino(reservaDisponibleInputDTO.getCiudadDestino().ciudad);
        setDia(reservaDisponibleInputDTO.getDia());
        setHora(reservaDisponibleInputDTO.getHora().hora);
        setAutobusId(reservaDisponibleInputDTO.getAutobusId());
        setPlazasLibres(reservaDisponibleInputDTO.getPlazasLibres());

        System.out.println(this);
    }

}

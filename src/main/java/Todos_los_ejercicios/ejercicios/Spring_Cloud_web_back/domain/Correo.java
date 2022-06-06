package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.correoDTO.CorreoInputDto;
import Todos_los_ejercicios.ejercicios.shared.StringPrefixedSequenceIdGenerator;
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
@ToString
@NoArgsConstructor
public class Correo {

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
    String email;
    LocalDate fechaReserva;
    float horaReserva;

    public Correo(CorreoInputDto correoInputDto) {

        setId(correoInputDto.getId());
        setCiudadDestino(correoInputDto.getCiudadDestino());
        setEmail(correoInputDto.getEmail());
        setFechaReserva(correoInputDto.getFechaReserva());
        setHoraReserva(correoInputDto.getHoraReserva());

    }

}

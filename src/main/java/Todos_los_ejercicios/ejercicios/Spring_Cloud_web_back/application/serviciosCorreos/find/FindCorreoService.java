package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosCorreos.find;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Correo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface FindCorreoService {

    List<Correo> find_correos_by_ciudad_Destino(String horaInferior, String horaSuperior, LocalDate fechaInferior, LocalDate fechaSuperior, String destino);

}

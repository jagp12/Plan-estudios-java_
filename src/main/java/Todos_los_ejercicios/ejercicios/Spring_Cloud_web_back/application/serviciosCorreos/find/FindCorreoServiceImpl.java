package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosCorreos.find;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Correo;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.CorreoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FindCorreoServiceImpl implements FindCorreoService{

    @Autowired
    CorreoRepository correoRepository;

    @Override
    public List<Correo> find_correos_by_ciudad_Destino(String horaInferior, String horaSuperior, LocalDate fechaInferior, LocalDate fechaSuperior, String destino) {
        return correoRepository.findByCiudadDestino_por_hora_Y_dia(fechaInferior,  fechaSuperior , horaInferior, horaSuperior, destino);
    }

}

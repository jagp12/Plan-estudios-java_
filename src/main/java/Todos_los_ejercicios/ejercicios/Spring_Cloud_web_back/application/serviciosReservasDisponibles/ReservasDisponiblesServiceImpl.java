package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReservasDisponibles;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.ReservasDisponibles;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.ReservasDisponiblesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservasDisponiblesServiceImpl implements ReservasDisponiblesService {

    @Autowired
    ReservasDisponiblesRepository reservasDisponiblesRepository;
    @Override
    public List<ReservasDisponibles> get_reservas_disponibles() {
        return reservasDisponiblesRepository.findAll();
    }

    @Override
    public ReservasDisponibles introduce_reservas_disponibles(ReservasDisponibles reservasDisponibles) {
        return reservasDisponiblesRepository.save(reservasDisponibles);
    }

    @Override
    public List<ReservasDisponibles> get_plazas_libres(float horaInferior, float horaSuperior, LocalDate fechaInferior, LocalDate fechaSuperior, String destino) throws Exception{

        //fechaInferior.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        //fechaSuperior.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        List<ReservasDisponibles> ReservasDisponibles = reservasDisponiblesRepository.findByCiudadDestinoAndDiaBetweenAndHoraBetween(destino, fechaInferior,  fechaSuperior , horaInferior, horaSuperior);

        //System.out.println("localDate:"+fechaInferior+" dia reserva:"+reservasDisponiblesRepository.findByCiudadDestino(destino).get(0).getDia());
/*
        List<ReservasDisponibles> ReservasDisponibles = reservasDisponiblesRepository.findByCiudadDestino(destino).stream()

                .filter(reservasDisponibles -> reservasDisponibles.getHora()>Float.valueOf(horaInferior))
                .filter(reservasDisponibles -> reservasDisponibles.getHora()<=Float.valueOf(horaSuperior))
                .filter(reservasDisponibles -> reservasDisponibles.getDia().isAfter(fechaInferior))
                .filter(reservasDisponibles -> reservasDisponibles.getDia().isBefore(fechaSuperior))
                .toList();
*/

        //if(ReservasDisponibles.size() < 1){
            //return reservasDto;
        //}
        //return "plazas libres:"+String.valueOf(ReservasDisponibles.get(0).getPlazasLibres()+" reservas encontradas:"+ReservasDisponibles.size());
        return ReservasDisponibles;
    }

    @Override
    public List<ReservasDisponibles> get_reservas_disponibles(String destino) throws Exception{

        return reservasDisponiblesRepository.findByCiudadDestino(destino);

    }
}

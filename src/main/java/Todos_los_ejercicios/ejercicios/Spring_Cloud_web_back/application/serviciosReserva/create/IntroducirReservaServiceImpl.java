package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.create;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.ReservasDisponibles;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.ReservaRepository;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.ReservasDisponiblesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntroducirReservaServiceImpl implements IntroducirReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ReservasDisponiblesRepository reservasDisponiblesRepository;

    @Override
    public Reserva introducir_reserva(Reserva reserva) throws Exception{

        //añade la persona  a la lista
        System.out.println("IntroducirReservaImpl.introducir_reserva introduciendo reserva" + reserva.getId());
        //if(plazas<40){ return "disponible"; }
        reservaRepository.save(reserva);


        return reserva;

    }

    @Override
    public Reserva introducir_reserva_2(Reserva reserva) throws Exception{

        List<ReservasDisponibles> ReservasDisponibles = reservasDisponiblesRepository.findByCiudadDestino_por_hora_Y_dia_2(reserva.getFecha(),  String.valueOf(reserva.getHora()), reserva.getCiudadDestino());

        if (ReservasDisponibles.size() < 1){
            throw new NotFoundException("No hay reservas disponibles para esta reserva");
        }

        //añade la persona  a la lista
        //System.out.println("" );
        //if(plazas<40){ return "disponible"; }

        reservaRepository.save(reserva);
        ReservasDisponibles.get(0).setPlazasLibres( ReservasDisponibles.get(0).getPlazasLibres() - 1 );
        ReservasDisponibles.stream().forEach(System.out::println );
        reservasDisponiblesRepository.save(ReservasDisponibles.get(0));

        return reserva;

    }

    @Override
    public String plazasSize(Integer plazas){
        if(plazas<40){ return "disponible"; }
        return "aforo completo";
    }
}

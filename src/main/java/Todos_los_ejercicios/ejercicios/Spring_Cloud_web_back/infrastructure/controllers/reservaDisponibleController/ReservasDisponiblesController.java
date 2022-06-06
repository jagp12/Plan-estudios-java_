package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.reservaDisponibleController;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.find.GetReservaService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReservasDisponibles.ReservasDisponiblesService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.ReservasDisponibles;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservasDisponiblesDTO.ReservaDisponibleInputDTO;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservasDisponiblesDTO.ReservaDisponiblesOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "spring_cloud")
@RestController
@RequestMapping(value="/api/v0")
public class ReservasDisponiblesController {

    @Autowired
    ReservasDisponiblesService reservasDisponiblesService;
    @Autowired
    GetReservaService getReservaService;

    @GetMapping("get_all_reservas_disponibles")
    public ResponseEntity<List<ReservaDisponiblesOutputDTO>> get_reservas_disponibles() throws Exception{

        getReservaService.recibir_mensaje();
        List<ReservaDisponiblesOutputDTO> lista_reservas_disponibles = reservasDisponiblesService.get_reservas_disponibles().stream().map(reservasDisponibles -> new ReservaDisponiblesOutputDTO(reservasDisponibles)).toList();
        return new ResponseEntity<>(lista_reservas_disponibles, HttpStatus.OK);

    }

    @GetMapping("get_reservas_disponibles/{ciudadDestino}")
    public ResponseEntity<List<ReservaDisponiblesOutputDTO>> get_reservas_disponibles_por_destino(@PathVariable String ciudadDestino) throws Exception{

        List<ReservaDisponiblesOutputDTO> lista_reservas_disponibles = reservasDisponiblesService.get_reservas_disponibles(ciudadDestino).stream().map(reservasDisponibles -> new ReservaDisponiblesOutputDTO(reservasDisponibles)).toList();
        return new ResponseEntity<>(lista_reservas_disponibles, HttpStatus.OK);

    }

    @PostMapping("introduce_reservas_disponibles")
    public ResponseEntity<ReservaDisponiblesOutputDTO> get_reservas_disponibles(@RequestBody ReservaDisponibleInputDTO ReservaDisponibleInputDTO) throws Exception{

        ReservasDisponibles reservasDisponibles = new ReservasDisponibles(ReservaDisponibleInputDTO);
        ReservaDisponiblesOutputDTO reservas_disponibles = new ReservaDisponiblesOutputDTO(reservasDisponiblesService.introduce_reservas_disponibles(reservasDisponibles));
        return new ResponseEntity<>(reservas_disponibles, HttpStatus.OK);

    }

    @GetMapping("disponible/{ciudadDestino}")
    public ResponseEntity<List<ReservaDisponiblesOutputDTO>> get_plazas_libres(@PathVariable String ciudadDestino,
                                                    @RequestParam(required=false, value = "horaInferior") float horaInferior,
                                                    @RequestParam(required=false, value = "horaSuperior") float horaSuperior,
                                                    @RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fechaInferior,
                                                    @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fechaSuperior
                                                    //@RequestParam(value = "fechaInferior") String fechaInferior,
                                                    //@RequestParam(value = "fechaSuperior") String fechaSuperior

    ) throws Exception{

        List<ReservasDisponibles> reservasdisp = reservasDisponiblesService.get_plazas_libres(horaInferior, horaSuperior , fechaInferior, fechaSuperior, ciudadDestino);
        List<ReservaDisponiblesOutputDTO> listaDTO = reservasdisp.stream().map(reservasDisponibles -> new ReservaDisponiblesOutputDTO(reservasDisponibles)).toList();

        if(listaDTO.size() == 0){
            listaDTO = new ArrayList<>();
            listaDTO.add(new ReservaDisponiblesOutputDTO());
        }

        return new ResponseEntity<>(listaDTO, HttpStatus.OK);

    }
}

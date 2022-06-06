package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.correoController;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosCorreos.find.FindCorreoService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosCorreos.insert.InsertCorreo;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Correo;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.correoDTO.CorreoInputDto;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.correoDTO.CorreoOutputDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Api(tags = "spring_cloud")
@RestController
@RequestMapping(value="/api/v0")
public class CorreoController {

    @Autowired
    FindCorreoService findCorreoService;

    @Autowired
    InsertCorreo insertCorreo;

    @GetMapping("correos")
    public ResponseEntity<List<CorreoOutputDto>> get_all_correos(@RequestParam(value = "ciudadDestino") String ciudadDestino,
                                                                 @RequestParam(required=false, value = "horaInferior") String horaInferior,
                                                                 @RequestParam(required=false, value = "horaSuperior") String horaSuperior,
                                                                 @RequestParam(value = "fechaInferior") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fechaInferior,
                                                                 @RequestParam(value = "fechaSuperior") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fechaSuperior,
                                                                 @RequestHeader(value = "authorize") String authorize
                                                                 //@RequestParam(value = "fechaInferior") String fechaInferior,
                                                                 //@RequestParam(value = "fechaSuperior") String fechaSuperior

    ) throws Exception{

        System.out.println("token recibido:"+authorize);
        List<CorreoOutputDto> lista_correos_enviados = findCorreoService.find_correos_by_ciudad_Destino(horaInferior, horaSuperior, fechaInferior, fechaSuperior, ciudadDestino).stream().map(reservasDisponibles -> new CorreoOutputDto(reservasDisponibles)).toList();
        return new ResponseEntity<>(lista_correos_enviados, HttpStatus.OK);

    }

    @PostMapping("create_correo")
    public ResponseEntity<CorreoOutputDto> create_correo(@RequestBody CorreoInputDto correoInputDto) throws Exception{

        return new ResponseEntity<>(new CorreoOutputDto(insertCorreo.instert_correo(new Correo(correoInputDto))), HttpStatus.OK);

    }

    @PutMapping("correos")
    public ResponseEntity<String> reenvio_correo(@RequestBody CorreoInputDto correoInputDto, @RequestHeader(value = "authorize") String authorize) throws Exception{

        System.out.println("token recibido:"+authorize);

        return new ResponseEntity<>("este método no está implementado", HttpStatus.OK);

    }


}

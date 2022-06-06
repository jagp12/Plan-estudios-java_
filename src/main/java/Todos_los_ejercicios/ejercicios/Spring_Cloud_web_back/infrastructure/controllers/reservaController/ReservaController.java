package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.reservaController;


import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.servicioCorreo.CorreoService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.servicioCorreo.MailService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.create.IntroducirReservaService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.find.GetReservaService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservadto.ReservaInputDto;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.reservadto.ReservaOutputDto;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Api(tags = "spring_cloud")
@RestController
@RequestMapping(value="/api/v0")
public class ReservaController {

    @Autowired
    IntroducirReservaService introducirReservaService;
    @Autowired
    GetReservaService getReservaService;

    @Autowired
    CorreoService correoService;

    @Value("${busNoDispoUri}")
    String ruta;

    @PostMapping("reserva")
    public ResponseEntity<ReservaOutputDto> introducir_reserva(@RequestBody ReservaInputDto reserva) throws Exception{


        Reserva reserva1 = new Reserva(reserva);
        introducirReservaService.introducir_reserva(reserva1);

        return new ResponseEntity<>(new ReservaOutputDto(reserva1), HttpStatus.OK);

    }

    @PostMapping("alta_reserva")
    public ResponseEntity<ReservaOutputDto> alta_de_reserva(@RequestHeader ReservaOutputDto reserva, @RequestHeader String authorize) throws Exception{

        System.out.println("authorize:"+authorize);
        //Reserva reserva1 = new Reserva(reserva);
        //introducirReservaService.introducir_reserva(reserva1);

        return new ResponseEntity<>(reserva, HttpStatus.OK);

    }

    @PostMapping("introducir_reserva_2")
    public ResponseEntity<ReservaOutputDto> introducir_reserva_2(@RequestBody ReservaInputDto reserva) throws Exception{


        Reserva reserva1 = new Reserva(reserva);
        try{
            introducirReservaService.introducir_reserva_2(reserva1);
            correoService.introducir_reserva_2(reserva1);
            return new ResponseEntity<>(new ReservaOutputDto(reserva1), HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }


    }

    @GetMapping("reserva/{ciudadDestino}")
    public ResponseEntity<List<Reserva>> get_reservas_por_destino(@PathVariable String ciudadDestino,
                                                                  @RequestParam(required=false, value = "horaInferior") String horaInferior,
                                                                  @RequestParam(required=false, value = "horaSuperior") String horaSuperior,
                                                                  @RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fechaInferior,
                                                                  @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fechaSuperior
                                                                  //@RequestParam(value = "fechaInferior") String fechaInferior,
                                                                  //@RequestParam(value = "fechaSuperior") String fechaSuperior
                                                                  //@RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fecha

    ) throws Exception{

        return new ResponseEntity<>(getReservaService.get_reserva_por_ciudad_destino(horaInferior,horaSuperior,fechaInferior,fechaSuperior,ciudadDestino), HttpStatus.OK);

    }

    @PostMapping("noHayPlazas")
    public String noHayPlazas() throws Exception {

        return ruta;

    }

    @Autowired
    private MailService mailService;



    @PostMapping("/sendMail")

    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;

        mailService.sendMail("maildepropiedades","maildecontacto",subject,message);

        return"send_mail_view";

    }

}

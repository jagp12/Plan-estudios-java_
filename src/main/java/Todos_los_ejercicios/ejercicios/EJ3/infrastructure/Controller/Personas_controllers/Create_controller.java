package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Personas_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Create_Services.Service_create;
import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Servicios;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "EJ3/persona")
@RestController
@RequestMapping("EJ3/persona")
public class Create_controller {

    @Autowired
    Service_create service_create;
    @Autowired
    Servicios servicios;

    //public Create_controller(Service_create service_create) {this.service_create = service_create;}

    @PostMapping()
    public AsignacionOutputDTO persona_post(@RequestBody AsignacionInputDTO persona_recibida) throws Exception{

        System.out.println("perssona:"+persona_recibida);
        //comprobaciones

        Persona_ej3 persona = new Persona_ej3(persona_recibida);
        //if(!servicios.validar_usuario(persona)){
            //return null;
        //}
        service_create.create_persona(persona);
        return new AsignacionOutputDTO(persona);

    }

    @PostMapping("/crear_personas_en_repositorio/{numero_personas}")
    public void persona_post(@PathVariable int numero_personas) throws Exception{
        service_create.crear_personas_en_repositorio(numero_personas);
    }

    //@PostMapping("/addperson")
    @CrossOrigin(origins = "https://codepen.io")
    @PostMapping("/addperson")
    public AsignacionOutputDTO persona_externa_post(@RequestBody AsignacionInputDTO persona_recibida) throws Exception{
        //System.out.println("perssona:"+persona_recibida);
        Persona_ej3 persona = new Persona_ej3(persona_recibida);
        service_create.create_persona(persona);
        return new AsignacionOutputDTO(persona);
    }





}

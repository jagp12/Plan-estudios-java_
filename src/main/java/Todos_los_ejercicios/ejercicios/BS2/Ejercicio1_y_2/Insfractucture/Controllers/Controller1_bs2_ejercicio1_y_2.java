package Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Insfractucture.Controllers;

import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application.Lista_ciudades_service;
import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application.Persona_service;
import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Ciudad;
import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Persona;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "BS2/ejercicio1_Y_2")
@RestController
@RequestMapping(value = "BS1")
public class Controller1_bs2_ejercicio1_y_2 {


    @Autowired
    Persona_service persona_service;
    @Autowired
    Lista_ciudades_service lista_ciudades_service;

    Persona persona_recibida;
    Persona persona_generada;


    @PostMapping("/useradd")
    public Persona post_useradd(@RequestBody Persona persona) {

        //va a la clase persona service impl y sustituye la persona que ha generado por la persona que ha recibido de postman
        persona_service.setPersona(persona);
        return persona_service.getPersona();

    }

    @PostMapping("/controlador1/addCiudad")
    public Ciudad post_cityadd(@RequestBody Ciudad ciudad) {

        lista_ciudades_service.add_ciudad(ciudad);

        return ciudad;

    }



}

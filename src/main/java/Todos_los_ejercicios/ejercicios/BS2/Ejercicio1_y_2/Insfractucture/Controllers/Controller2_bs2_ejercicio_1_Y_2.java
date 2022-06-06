package Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Insfractucture.Controllers;

import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application.Lista_ciudades_service;
import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application.Persona_service;
import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Ciudad;
import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Persona;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "BS2/ejercicio1_Y_2")
@RestController
@RequestMapping(value = "BS1")
public class Controller2_bs2_ejercicio_1_Y_2 {

    @Autowired
    Persona_service persona_service;
    @Autowired
    Lista_ciudades_service lista_ciudades_service;

    @GetMapping("/controlador2/getPersona")
    public Persona get_controlador2(){
        //le pide a la clase persona service impl la persona que el controlador1 ha sustituido.
        return persona_service.getPersona();
    }

    @GetMapping("/controlador1/getCiudad")
    public List<Ciudad> get_lista_ciudades(){
        //le pide a la clase persona service impl la persona que el controlador1 ha sustituido.
        //System.out.println("lista ciudades " +lista_ciudades_service.getListaCiudades().size());
        return this.lista_ciudades_service.getListaCiudades();
    }


}

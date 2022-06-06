package Todos_los_ejercicios.ejercicios.RS1.Ejercicio_2.Infrastructure.controllers;

import Todos_los_ejercicios.ejercicios.RS1.Ejercicio_2.Application.Servicio_lista_personas_rs1_ejercicio2;
import Todos_los_ejercicios.ejercicios.RS1.Ejercicio_2.Domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "RS1")
public class Controller_get_rs1 {

    @Autowired
    Servicio_lista_personas_rs1_ejercicio2 Servicio_lista_personas;
/*
    public Controlador_get(Servicio_lista_personas_rs1_ejercicio2 servicio_lista_personas) {
        Servicio_lista_personas = servicio_lista_personas;
    }
    */
    //@RequestMapping("/persona")
    @GetMapping("/{id}/{nombre}")
    public Persona get_persona(@PathVariable String id , @PathVariable String nombre) {

        int int_id = Integer.parseInt(id);
        if(!Servicio_lista_personas.persona_esta_en_lista(int_id , nombre)){
            return null;
        }

        System.out.println("persona encontrada");
        return Servicio_lista_personas.getLista_personas().get(int_id);

    }

    @GetMapping("/lista")
    public List<Persona> get_lista_persona() {
        System.out.println("lista obtenida");
        return Servicio_lista_personas.getLista_personas();

    }

}

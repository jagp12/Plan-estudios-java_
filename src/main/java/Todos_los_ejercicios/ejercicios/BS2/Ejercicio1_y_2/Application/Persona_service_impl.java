package Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application;

import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Persona;
import org.springframework.stereotype.Service;

@Service
public class Persona_service_impl implements Persona_service{

    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }

    public Persona getPersona() {
        int edad = Integer.valueOf(persona.getEdad()) * 2;
        persona.setEdad(String.valueOf(edad));
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

}

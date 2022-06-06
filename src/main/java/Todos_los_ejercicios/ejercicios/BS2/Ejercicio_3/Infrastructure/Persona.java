package Todos_los_ejercicios.ejercicios.BS2.Ejercicio_3.Infrastructure;

import org.springframework.context.annotation.Bean;

public class Persona {

    String nombre ="",edad="";

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    //@Bean(value = "PersonaBean1")
    public Persona persona_bean1(Persona persona){
        persona.setNombre("bean1");
        return persona;
    }

    //@Bean(value = "PersonaBean2")
    public Persona persona_bean2(Persona persona){
        persona.setNombre("bean2");
        return persona;
    }

    //@Bean(value = "PersonaBean3")
    public Persona persona_bean3(Persona persona){
        persona.setNombre("bean3");
        return persona;
    }


}

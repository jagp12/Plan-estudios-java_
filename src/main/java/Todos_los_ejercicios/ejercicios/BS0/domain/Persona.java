package Todos_los_ejercicios.ejercicios.BS0.domain;

public class Persona {

    String nombre="",Poblacion="",edad="";

    public Persona(String nombre, String poblacion, String edad) {
        this.nombre = nombre;
        this.Poblacion = poblacion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

}

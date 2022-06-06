package Todos_los_ejercicios.ejercicios.RS1.Ejercicio_2.Domain;

import java.util.Optional;

public class Persona {
    Optional<String> nombre ,edad, poblacion;

    //String id ,nombre ,edad, poblacion;

    public Persona( Optional<String> nombre, Optional<String> edad, Optional<String> poblacion) {

        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
    }

    public Optional<String> getNombre() {
        return nombre;
    }
    public Optional<String> getEdad() {
        return edad;
    }

    public Optional<String> getPoblacion() {
        return poblacion;
    }

    public void setNombre(Optional<String> nombre) {
        this.nombre = nombre;
    }
    public void setEdad(Optional<String> edad) {
        this.edad = edad;
    }

    public void setPoblacion(Optional<String> poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}

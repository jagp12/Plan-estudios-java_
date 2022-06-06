package Todos_los_ejercicios.ejercicios.BS;

public class Persona {

    private String nombre ;
    private String poblacion ;
    private Integer edad ;

    public Persona(String nombre, String poblacion, Integer edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + nombre +
                        ". Poblacion: " + poblacion +
                        ". Edad: " + edad ;
    }

}

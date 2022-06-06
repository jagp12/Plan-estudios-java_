package Todos_los_ejercicios.ejercicios.RS1.Ejercicio_2.Application;

import Todos_los_ejercicios.ejercicios.RS1.Ejercicio_2.Domain.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Servicio_lista_personas_rs1_ejercicio2 {


    List<Persona> lista_personas = new ArrayList<>();


    public Servicio_lista_personas_rs1_ejercicio2() {

        lista_personas.add(new Persona(Optional.of("Maria"),Optional.of("28"),Optional.of("París")));
        lista_personas.add(new Persona(Optional.of("Carlos"),Optional.of("83"),Optional.of("Oslo")));
        lista_personas.add(new Persona(Optional.of("Luna"),Optional.of("32"),Optional.of("Buenos Aires")));


    }

    public boolean persona_esta_en_lista(int id){

        if(this.getLista_personas().get(id) == null){
            System.err.println("No se ha encontrado a ninguna persona con el id " +id);
            return false;
        }

        return true;
    }

    public boolean persona_esta_en_lista(int id , String nombre){

        if(this.getLista_personas().get(id) == null ){
            System.err.println("1No se ha encontrado a ninguna persona con el id " +id);
            return false;
        }

        if( !this.getLista_personas().get(id).getNombre().equals(Optional.of(nombre)) ){
            System.err.println("2No se ha encontrado a ninguna persona con el id " +id+ " y con el nombre " +nombre+ "/" +this.getLista_personas().get(id).getNombre());
            return false;
        }

        return true;
    }

    public void put_persona(String id , Persona persona) {

        delete_persona(id);
        lista_personas.add(Integer.parseInt(id),persona);
        System.out.println("Persona actualizada");

    }

    public List<Persona> delete_persona(String id) {

        int indice = Integer.parseInt(id);

        if(!persona_esta_en_lista(Integer.parseInt(id))){
            return this.getLista_personas();
        }

        this.getLista_personas().remove(indice);

        return this.getLista_personas();

    }

    public void comprobar_nulos(Persona persona_recibida){

        String vacio = "";

        persona_recibida.setNombre(Optional.of(persona_recibida.getNombre().orElse(vacio)));
        persona_recibida.setEdad(Optional.of(persona_recibida.getEdad().orElse(vacio)));
        persona_recibida.setPoblacion(Optional.of(persona_recibida.getPoblacion().orElse(vacio)));


    }
    public List<Persona> getLista_personas() {
        return lista_personas;
    }

    public void setLista_personas(List<Persona> lista_personas) {
        this.lista_personas = lista_personas;
    }


}

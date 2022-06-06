package Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application;

import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Ciudad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Lista_ciudades_service_impl implements Lista_ciudades_service{

    List<Ciudad> lista_ciudades;

    @Override
    public void setListaCiudades(List<Ciudad> lista_ciudades) {

        this.lista_ciudades = lista_ciudades;
        System.out.println("Lista cargada " +this.lista_ciudades.get(0).getNombre());
    }

    @Override
    public List<Ciudad> getListaCiudades() {
        return lista_ciudades;
    }

    public void add_ciudad(Ciudad ciudad){
        lista_ciudades.add(ciudad);
    }

}

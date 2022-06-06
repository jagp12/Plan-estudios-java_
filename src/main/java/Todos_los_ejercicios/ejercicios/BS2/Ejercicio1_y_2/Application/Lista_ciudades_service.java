package Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Application;

import Todos_los_ejercicios.ejercicios.BS2.Ejercicio1_y_2.Domain.Ciudad;

import java.util.List;

public interface Lista_ciudades_service {
    void setListaCiudades(List<Ciudad> lista_ciudades);
    List<Ciudad> getListaCiudades();
    void add_ciudad(Ciudad ciudad);

}

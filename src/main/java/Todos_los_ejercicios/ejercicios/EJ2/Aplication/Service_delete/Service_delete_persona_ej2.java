package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_delete;

import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;

public interface Service_delete_persona_ej2 {

    void delete_by_id(String id) throws Exception_persona_404;

}

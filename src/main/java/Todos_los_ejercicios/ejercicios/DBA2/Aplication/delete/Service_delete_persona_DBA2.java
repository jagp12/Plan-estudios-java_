package Todos_los_ejercicios.ejercicios.DBA2.Aplication.delete;


import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;

public interface Service_delete_persona_DBA2 {

    void delete_by_id(String id) throws Exception_persona_404;

}

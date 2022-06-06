package Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.find;

import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions.Exception_persona_404;

import java.util.List;

public interface Service_find_persona_EJTE_1 {

    Persona_EJTE_1 find_by_id(String id) throws Exception_persona_404;
    //AsignacionOutputDTO find_by_id(String id, String ouputType) throws Exception_persona_404;
    List<Persona_EJTE_1> find_by_user(String user) throws Exception;
    List<Persona_EJTE_1> find_by_user(String user, String ouputType) throws Exception;
    List<Persona_EJTE_1>  find_all(String ouputType);

}

package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_find;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Employee_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;

import java.util.HashMap;
import java.util.List;

public interface Service_find_persona_ej2 {

    Persona_ej2 find_by_id(String id) throws Exception_persona_404;
    //AsignacionOutputDTO find_by_id(String id, String ouputType) throws Exception_persona_404;
    List<Persona_ej2> find_by_user(String user) throws Exception;
    List<Persona_ej2> find_by_user(String user, String ouputType) throws Exception;
    List<Persona_ej2>  find_all(String ouputType);
    List<Employee_ej2> findallemployee();

    List<Persona_ej2> findByusuarioandnameandsurname(String usuario, String name, String surname, String createdDated, String order);

    List<Persona_ej2> getData(HashMap<String, Object> conditions);
}

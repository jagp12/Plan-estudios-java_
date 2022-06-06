package Todos_los_ejercicios.ejercicios.DBA2.Aplication.find;



import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;

import java.util.List;

public interface Service_find_persona_DBA2 {

    Persona_DBA2 find_by_id(String id) throws Exception_persona_404;
    //AsignacionOutputDTO find_by_id(String id, String ouputType) throws Exception_persona_404;
    //List<Persona_DBA2> find_by_user(String user) throws Exception;
    //List<Persona_DBA2> find_by_user(String user, String ouputType) throws Exception;
    List<Persona_DBA2>  find_all(String ouputType);

}

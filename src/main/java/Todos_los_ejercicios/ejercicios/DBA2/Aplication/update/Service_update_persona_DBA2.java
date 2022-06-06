package Todos_los_ejercicios.ejercicios.DBA2.Aplication.update;

import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;


public interface Service_update_persona_DBA2 {

    Persona_DBA2 update_persona(Persona_DBA2 persona_EJTE1) throws Exception_persona_404;

}

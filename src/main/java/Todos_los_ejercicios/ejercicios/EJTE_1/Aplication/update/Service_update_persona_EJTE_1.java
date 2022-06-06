package Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.update;

import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions.Exception_persona_404;

public interface Service_update_persona_EJTE_1 {

    Persona_EJTE_1 update_persona(Persona_EJTE_1 persona_EJTE1) throws Exception_persona_404;

}

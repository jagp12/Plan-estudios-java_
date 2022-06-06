package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_update;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;

public interface Service_update_persona_ej2 {

    Persona_ej2 update_persona(Persona_ej2 persona_ej2) throws Exception_persona_404;

}

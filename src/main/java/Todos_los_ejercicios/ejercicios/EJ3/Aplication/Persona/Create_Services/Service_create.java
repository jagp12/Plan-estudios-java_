package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Create_Services;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;

public interface Service_create {

    Persona_ej3 create_persona(Persona_ej3 persona_ej3) throws Exception;

    void crear_personas_en_repositorio(int numero_personas);

}

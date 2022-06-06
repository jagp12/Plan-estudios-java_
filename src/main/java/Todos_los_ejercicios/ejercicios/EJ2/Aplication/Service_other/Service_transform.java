package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_other;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;

public interface Service_transform {
    AsignacionOutputDTO crear_output_dto(Persona_ej2 persona);
}

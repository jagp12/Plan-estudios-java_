package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_other;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class Service_transform_impl implements Service_transform {
    @Override
    public AsignacionOutputDTO crear_output_dto(Persona_ej2 persona){

        AsignacionOutputDTO dto = new AsignacionOutputDTO
                (persona.getUsuario(), persona.getPassword(), persona.getName(),
                 persona.getSurname(), persona.getCompany_email(), persona.getPersonal_email(),
                 persona.getCity(), persona.getImagen_url(), persona.isActive(),
                 persona.getCreated(), persona.getTermination()
                );

        return dto;
    }
}

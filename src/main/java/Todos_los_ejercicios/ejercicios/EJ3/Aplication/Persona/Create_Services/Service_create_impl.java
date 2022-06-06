package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Create_Services;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Servicios;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class Service_create_impl implements Service_create{
    @Autowired
    PersonaRepositorio persona_repositorio;
    @Autowired
    Servicios servicios;

    @Override
    public Persona_ej3 create_persona(Persona_ej3 persona_ej3_entity) throws Exception{



        //añade la persona  a la lista
        System.out.println("id persona " + persona_ej3_entity.getId_persona());
        persona_repositorio.save(persona_ej3_entity);

        return persona_ej3_entity;

    }

    @Override
    public void crear_personas_en_repositorio(int numero_personas){

        for(int i  = 0 ; i < numero_personas; i++){
            AsignacionInputDTO persona_input_dto = new AsignacionInputDTO();

            persona_input_dto.setId_persona("987654");
            persona_input_dto.setUsuario("5489330");
            persona_input_dto.setPassword("5489330");
            persona_input_dto.setName("5489330");
            persona_input_dto.setSurname("5489330");
            persona_input_dto.setCompany_email("5489330");
            persona_input_dto.setPersonal_email("5489330");
            persona_input_dto.setCity("Madrid");
            persona_input_dto.setImagen_url("5489330");
            persona_input_dto.setActive(true);
            persona_input_dto.setCreated_date(new Date());
            persona_input_dto.setTermination_date(new Date());
            persona_input_dto.setAdmin(false);

            Persona_ej3 personaEj3 = new Persona_ej3(persona_input_dto);
            persona_repositorio.save(personaEj3);

        }



    }
}

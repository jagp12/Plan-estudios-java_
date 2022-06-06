package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_create;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository.PersonaRepositorio_ej2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_create_persona_ej2_impl implements Service_create_persona_ej2 {

    @Autowired
    PersonaRepositorio_ej2 persona_repositorio;

    @Override
    public Persona_ej2 create_persona(Persona_ej2 persona_ej2) throws Exception {
        //comprobaciones
        //if(!validar_usuario(persona_ej2)){
            //return null;
        //}

        //añade la persona  a la lista
        //Persona_ej2 persona_ej2_entity = new Persona_ej2(persona_ej2);
        System.out.println("id persona " + persona_ej2.getId_persona());
        persona_repositorio.save(persona_ej2);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(persona_ej2_entity);

        return persona_ej2;
    }
}

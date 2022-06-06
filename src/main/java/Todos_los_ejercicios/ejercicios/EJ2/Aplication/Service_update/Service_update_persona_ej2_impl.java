package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_update;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository.PersonaRepositorio_ej2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_update_persona_ej2_impl implements Service_update_persona_ej2 {

    @Autowired
    PersonaRepositorio_ej2 persona_repositorio;

    @Override
    public Persona_ej2 update_persona(Persona_ej2 persona_ej2) throws Exception_persona_404 {
        //comprobaciones
        //if(find_by_id(persona_dto.id_persona()) == null){
        //devolver un 406 o 404
        //throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +persona_dto.id_persona());
        //}

        //if(!validar_usuario(persona_ej2)){
        //    return null;
        //}

        //Persona_ej2 personaEj2 = new Persona_ej2(persona_dto);
        persona_repositorio.save(persona_ej2);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(personaEj2);

        return persona_ej2;
    }

}

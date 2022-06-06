package Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.create;

import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Repository.PersonaRepositorio_EJTE_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_create_persona_EJTE1_impl implements Service_create_persona_EJTE_1 {

    @Autowired
    PersonaRepositorio_EJTE_1 persona_repositorio;

    @Override
    public Persona_EJTE_1 create_persona(Persona_EJTE_1 persona_EJTE1) throws Exception {
        //comprobaciones
        //if(!validar_usuario(persona_ej2)){
            //return null;
        //}

        //añade la persona  a la lista
        //Persona_ej2 persona_ej2_entity = new Persona_ej2(persona_ej2);
        System.out.println("id persona " + persona_EJTE1.getId_persona());
        persona_repositorio.save(persona_EJTE1);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(persona_ej2_entity);

        return persona_EJTE1;
    }
}

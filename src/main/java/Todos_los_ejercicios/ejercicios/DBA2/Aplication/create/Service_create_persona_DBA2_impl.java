package Todos_los_ejercicios.ejercicios.DBA2.Aplication.create;



import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Repository.PersonaRepositorio_DBA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_create_persona_DBA2_impl implements Service_create_persona_DBA2 {

    //@Autowired
    PersonaRepositorio_DBA2 personaRepositorio_dba2;

    @Override
    public Persona_DBA2 create_persona(Persona_DBA2 persona_DBA2) throws Exception {
        //comprobaciones
        //if(!validar_usuario(persona_ej2)){
            //return null;
        //}

        //añade la persona  a la lista
        //Persona_ej2 persona_ej2_entity = new Persona_ej2(persona_ej2);
        System.out.println("id persona " + persona_DBA2.getId_persona());
        //personaRepositorio_dba2.save(persona_DBA2);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(persona_ej2_entity);

        return persona_DBA2;
    }
}

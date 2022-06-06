package Todos_los_ejercicios.ejercicios.DBA2.Aplication.update;


import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Repository.PersonaRepositorio_DBA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_update_persona_DBA2_impl implements Service_update_persona_DBA2 {

    //@Autowired
    PersonaRepositorio_DBA2 personaRepositorio_dba2;

    @Override
    public Persona_DBA2 update_persona(Persona_DBA2 persona_dba2) throws Exception_persona_404 {
        //comprobaciones
        //if(find_by_id(persona_dto.id_persona()) == null){
        //devolver un 406 o 404
        //throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +persona_dto.id_persona());
        //}

        //if(!validar_usuario(persona_ej2)){
        //    return null;
        //}

        //Persona_ej2 personaEj2 = new Persona_ej2(persona_dto);

        //personaRepositorio_dba2.save(persona_dba2);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(personaEj2);

        return persona_dba2;
    }

}

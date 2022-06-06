package Todos_los_ejercicios.ejercicios.DBA2.Aplication.delete;


import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Repository.PersonaRepositorio_DBA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Delete_persona_DBA2_impl implements Service_delete_persona_DBA2 {

    //@Autowired
    PersonaRepositorio_DBA2 personaRepositorio_dba2;

    @Override
    public void delete_by_id(String id) throws Exception_persona_404 {
        //if(find_by_id(id) == null){
            //devolver un 406 o un 404
            //throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        //}

        //AsignacionOutputDTO persona_eliminada = find_by_id(id);
        //persona_repositorio.deleteByIdPersona(id);
        //personaRepositorio_dba2.deleteById(Integer.parseInt(id));

        //return persona_ej2;
    }

}

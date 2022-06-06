package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_delete;

import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository.PersonaRepositorio_ej2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Delete_persona_ej2_impl implements Service_delete_persona_ej2 {

    @Autowired
    PersonaRepositorio_ej2 persona_repositorio;

    @Override
    public void delete_by_id(String id) throws Exception_persona_404 {
        //if(find_by_id(id) == null){
            //devolver un 406 o un 404
            //throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        //}

        //AsignacionOutputDTO persona_eliminada = find_by_id(id);
        //persona_repositorio.deleteByIdPersona(id);
        persona_repositorio.deleteById(Integer.parseInt(id));

        //return persona_ej2;
    }

}

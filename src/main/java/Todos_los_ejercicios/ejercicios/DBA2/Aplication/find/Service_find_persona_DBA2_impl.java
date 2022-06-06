package Todos_los_ejercicios.ejercicios.DBA2.Aplication.find;


import Todos_los_ejercicios.ejercicios.DBA2.Domain.Persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Repository.PersonaRepositorio_DBA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_find_persona_DBA2_impl implements Service_find_persona_DBA2 {


    //@Autowired
    PersonaRepositorio_DBA2 personaRepositorio_dba2;

    @Override
    public Persona_DBA2 find_by_id(String id) throws Exception_persona_404 {
        return null;//personaRepositorio_dba2.findById(Integer.valueOf(id)).orElseThrow(()->new Exception_persona_404("(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id));
        //return crear_output_dto(persona_ej2_encontrada);
    }
/*
    @Override
    public List<Persona_DBA2> find_by_user(String user) throws Exception {
        return persona_repositorio.findByusuario(user);
    }

    @Override
    public List<Persona_DBA2> find_by_user(String user, String ouputType) throws Exception {
        return persona_repositorio.findByusuario(user);
    }
*/
    @Override
    public List<Persona_DBA2> find_all(String ouputType) {
        return  null;//personaRepositorio_dba2.findAll();
        //return persona_repositorio.findAll().stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();
    }


}

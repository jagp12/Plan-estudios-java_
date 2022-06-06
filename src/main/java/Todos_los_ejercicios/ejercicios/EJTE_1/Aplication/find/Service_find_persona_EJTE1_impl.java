package Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.find;

import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Repository.PersonaRepositorio_EJTE_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Service_find_persona_EJTE1_impl implements Service_find_persona_EJTE_1 {

    @Autowired
    PersonaRepositorio_EJTE_1 persona_repositorio;

    @Autowired
    PersonaRepositorio_EJTE_1 personaRepositorio;

    @Override
    public Persona_EJTE_1 find_by_id(String id) throws Exception_persona_404 {
        return persona_repositorio.findById(Integer.valueOf(id)).orElseThrow(()->new Exception_persona_404("(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id));
        //return crear_output_dto(persona_ej2_encontrada);
    }

    @Override
    public List<Persona_EJTE_1> find_by_user(String user) throws Exception {
        return persona_repositorio.findByusuario(user);
    }

    @Override
    public List<Persona_EJTE_1> find_by_user(String user, String ouputType) throws Exception {
        return persona_repositorio.findByusuario(user);
    }

    @Override
    public List<Persona_EJTE_1> find_all(String ouputType) {
        return persona_repositorio.findAll();
        //return persona_repositorio.findAll().stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();
    }


}

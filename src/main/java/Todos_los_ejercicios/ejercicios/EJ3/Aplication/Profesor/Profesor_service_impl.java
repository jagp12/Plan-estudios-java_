package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Profesor;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Profesor_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor.Profesor_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.PersonaRepositorio;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Profesor_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class Profesor_service_impl implements Profesor_service {

    @Autowired
    Profesor_repository profesor_repository;
    @Autowired
    PersonaRepositorio persona_repositorio;

    @Override
    public Profesor_output_dto find_by_id(String id) throws Exception_persona_404 {

        String texto_error = "(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id;
        Profesor_ej3 profesorEj3 = profesor_repository.findById(id).orElseThrow(()->new Exception_persona_404(texto_error));
        //Profesor_input_dto profesor_input_dto = profesor_repository.findById(id).orElseThrow(()->new Exception_persona_404(texto_error));
        //Persona persona = persona_repositorio.findById(Integer.parseInt(profesor_input_dto.getIdPersona())).get();
        //Profesor profesor = new Profesor(profesor_input_dto,persona);
        return new Profesor_output_dto(profesorEj3);


    }

    @Override
    public List<Profesor_output_dto> find_all() {

        List<Profesor_output_dto> listadto = new ArrayList<>();

        for(Profesor_ej3 profesorEj3 :profesor_repository.findAll()){
        //for(Profesor_input_dto profesor_input_dto:profesor_repository.findAll()){

            //Persona persona = persona_repositorio.findById(Integer.parseInt(profesor.getIdPersona())).get();
            //Profesor profesor = new Profesor(profesor,persona);
            Profesor_output_dto profesor_output_dto = new Profesor_output_dto(profesorEj3);
            listadto.add(profesor_output_dto);

        }

        return listadto;
    }

    @Override
    public Profesor_output_dto create_entity(Profesor_input_dto profesor_input_dto) {

        //añade
        Profesor_ej3 profesor_ej3_entity = new Profesor_ej3(profesor_input_dto);
        System.out.println("id persona " +profesor_input_dto.getIdPersona());
        //System.out.println("persona " +profesor_input_dto.getPersona());
        profesor_repository.save(profesor_ej3_entity);
        //profesor_repository.save(profesor_input_dto);
        //Persona persona = persona_repositorio.findById(Integer.valueOf(profesor_input_dto.getIdPersona())).get();
        //Profesor profesor = new Profesor(profesor_input_dto, persona);
        Profesor_output_dto profesor_output_dto = new Profesor_output_dto(profesor_ej3_entity);

        return profesor_output_dto;
    }

    @Override
    public Profesor_output_dto update_entity(Profesor_input_dto profesor_input_dto, String id) throws Exception_persona_404 {
        //comprobaciones
        if(find_by_id(id) == null){
            //devolver un 406 o 404
            //throw new Exception_persona_404("(Servicio_persona.update)No existe una persona " +profesor_input_dto.getPersona());
            throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +profesor_input_dto.getIdPersona());
        }
        /*
        if(!validar_usuario(persona_dto)){
            return null;
        }
        */

        Profesor_ej3 profesorEj3 = new Profesor_ej3(profesor_input_dto);
        /*profesor.setId_profesor(id);
        Profesor_input_dto profesor_input_dto1 = new Profesor_input_dto(profesor);
        */
        profesor_input_dto.setId_profesor(id);
        profesor_repository.save(profesorEj3);
        //profesor_repository.save(profesor_input_dto);
        //Persona persona = persona_repositorio.findById(Integer.valueOf(profesor_input_dto.getIdPersona())).get();
        //Profesor profesor = new Profesor(profesor_input_dto, persona);
        Profesor_output_dto persona_output_dto = new Profesor_output_dto(profesorEj3);

        return persona_output_dto;
    }

    @Override
    public Profesor_output_dto delete_by_id(String id) throws Exception_persona_404 {
        if(find_by_id(id) == null){
            //devolver un 406 o un 404
            throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        }

        Profesor_output_dto profesor_eliminado = find_by_id(id);
        profesor_repository.deleteById(id);

        return profesor_eliminado;
    }

    private Profesor_ej3 find_profesor_por_id_persona(String id_persona){
/*
        Persona persona ;
        Profesor profesor1;

        for(Profesor_input_dto profesor_input_dto: profesor_repository.findAll()){
            if (profesor_input_dto.getIdPersona().equals(id_persona)){
                persona = persona_repositorio.findById(Integer.parseInt(profesor_input_dto.getIdPersona())).get();
                return new Profesor(profesor_input_dto, persona);
            }
        }
*/
        return null;
    }

    @Override
    public void crear_profesores_en_repositorio(int numero){

        for(int i  = 1 ; i < numero; i++){
            Profesor_input_dto input_dto = new Profesor_input_dto();

            input_dto.setIdPersona(String.valueOf(i*2));
            input_dto.setId_profesor("diufgd09");
            input_dto.setBranch("diufgd09");
            input_dto.setComents("diufgd09");

            Profesor_ej3 entity = new Profesor_ej3(input_dto);
            profesor_repository.save(entity);

        }

    }
/*
    @GetMapping("1/{httpCode}")
    ResponseEntity<Profesor_output_dto> getHttpCodePlusOne(@PathVariable int id)
    {
        System.out.println("En server. Devolvere: "+httpCode);
        return ResponseEntity.status(httpCode+1).body(new Profesor_output_dto());
    }
*/



}

package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Profesor_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services.Service_find;
import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Profesor.Profesor_service;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor.Profesor_output_dto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJ3/profe")
@RestController
@RequestMapping("profesor")

public class Profesor_find_controller {

    @Autowired
    Profesor_service profesor_service;
    @Autowired
    Service_find service_find_persona;



    @GetMapping("/getid/{id}")
    public Profesor_output_dto get_persona_por_id(@PathVariable String id ) throws Exception_persona_404 {

        return profesor_service.find_by_id(id);

    }

    @GetMapping("/getid2/{id}")
    public Profesor_output_dto get_profe_por_id2(@PathVariable String id ) throws Exception_persona_404 {
        System.out.println("en el controlador de profesor");
        return profesor_service.find_by_id(id);

    }

    @GetMapping("/all")
    public List<Profesor_output_dto> get_all_profesor() {

        //devolver lista dto
        System.out.println("lista obtenida");
        return profesor_service.find_all();

    }

    @GetMapping("template/{id}")
    ResponseEntity<Profesor_output_dto> getHttpCodePlusOne(@PathVariable int id)
    {
        System.out.println("En profesor. Devolvere el profesor con el id: "+id);
        Profesor_ej3 profesorEj3 = service_find_persona.find_profesor_por_id_persona(String.valueOf(id));
        System.out.println("El profesor: "+ profesorEj3);
        return ResponseEntity.status(200).body(new Profesor_output_dto(profesorEj3));
    }
/**/

/**/
}

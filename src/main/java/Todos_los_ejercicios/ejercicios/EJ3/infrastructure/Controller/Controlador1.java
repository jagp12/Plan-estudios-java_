package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Servicio_persona;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("DTO")
public class Controlador1 {

    Servicio_persona servicio_persona;

    public Controlador1(Servicio_persona servicio_persona) {
        this.servicio_persona = servicio_persona;
    }
/*
    @PostMapping()
    public Persona_output_dto persona_post(@RequestBody Persona_input_dto persona_recibida){
        System.out.println("perssona:"+persona_recibida);
        return servicio_persona.create_persona(persona_recibida);

    }
    /*
        @GetMapping("/getid/{id}")
        public Persona_output_dto get_persona_por_id(@PathVariable String id ) throws Exception {

            return servicio_persona.find_by_id(id);

        }

        @GetMapping("getuser/{user}")
        public List<Persona_output_dto> get_persona_por_nombre(@PathVariable String user) {

            return servicio_persona.find_by_user(user);

        }

        @GetMapping("/lista")
        public List<Persona_output_dto> get_lista_persona() {

            //devolver lista dto
            System.out.println("lista obtenida");
            return servicio_persona.find_all();

        }

    @PutMapping("/update")
    public Persona_output_dto persona_put(@RequestBody Persona_input_dto persona_recibida) throws Exception {

        return servicio_persona.update_persona(persona_recibida);

    }

    @DeleteMapping("/{id}")
    public void persona_delete(@PathVariable String id) throws Exception {

        servicio_persona.delete_by_id(id);


    }
*/
}

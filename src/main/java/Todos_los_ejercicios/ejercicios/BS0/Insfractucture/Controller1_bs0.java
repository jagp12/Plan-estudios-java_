package Todos_los_ejercicios.ejercicios.BS0.Insfractucture;

import Todos_los_ejercicios.ejercicios.BS0.domain.Persona;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "BS0")
public class Controller1_bs0 {

    @GetMapping("/user/{nombre}")
    public String get_hola(@PathVariable String nombre){
        return "hola " +nombre;
    }

    @GetMapping("/dfgdfgd")
    public void post_useradd_fgdfgf(){

        System.out.println("duifnvo");
        //return new Persona();

    }

    @PostMapping("/useradd")
    public Persona post_useradd(@RequestBody Persona persona) {

        System.out.println("name: "+persona.getNombre());

        persona.setEdad(String.valueOf(Integer.parseInt(persona.getEdad())+1));

        return persona;

    }

}

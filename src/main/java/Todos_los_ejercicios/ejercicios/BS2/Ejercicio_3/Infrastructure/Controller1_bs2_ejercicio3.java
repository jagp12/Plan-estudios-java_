package Todos_los_ejercicios.ejercicios.BS2.Ejercicio_3.Infrastructure;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@Api(tags = "BS2/ejercicio3")
@RestController
@RequestMapping(value = "BS1/ejercicio3")
public class Controller1_bs2_ejercicio3 {

    //@Qualifier("PersonaBean1")
    @GetMapping("/bean1")
    public String get_lista_ciudades_bean1(@RequestBody String bean){

        return "hola " +bean;

    }

    //@Qualifier("PersonaBean2")
    @GetMapping("/bean2")
    public String get_lista_ciudades_bean2(@PathVariable String bean){

        return "hola " +bean;

    }

    //@Qualifier("PersonaBean3")
    @GetMapping("/bean3")
    public String get_lista_ciudades_bean3(@PathVariable String bean){

        return "hola " +bean;

    }

}

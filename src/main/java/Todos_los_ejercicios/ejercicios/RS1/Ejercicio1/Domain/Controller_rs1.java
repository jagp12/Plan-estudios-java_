package Todos_los_ejercicios.ejercicios.RS1.Ejercicio1.Domain;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

public class Controller_rs1 {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/greeting_post")
    public Greeting greetin_post(@RequestBody Greeting saludo){

        return saludo ;

    }

    @PutMapping("/post")
    public String greetin_put(@RequestParam(value = "var1") String var1){

        System.out.println("var1=" +var1);
        return var1;

    }

}

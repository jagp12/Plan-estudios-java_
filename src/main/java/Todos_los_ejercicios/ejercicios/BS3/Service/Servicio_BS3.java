package Todos_los_ejercicios.ejercicios.BS3.Service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Servicio_BS3 {
    public Servicio_BS3() {
        System.out.println("se ha instanciado el servicio 1");
    }

    @PostConstruct
    public void funcion1(){
        System.out.println("Hola desde clase inicial");
    }

    public void funcion2(){
        System.out.println("Hola desde clase secundaria");
    }

    //public void funcion3(String texto){System.out.println("Soy la tercera clase");}
    public void funcion3(){System.out.println("Soy la tercera clase");}
/*
    @Override
    public void run(String... args) throws Exception {
        funcion2();
        funcion3();
        //funcion3(args[0]);
    }
    */
}

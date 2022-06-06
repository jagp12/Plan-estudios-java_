package Todos_los_ejercicios.ejercicios.BS4.EJ_perfiles.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "BS4/perfiles")
//@PropertySource("miconfiguracion.properties")
public class Controller2_bs4_perfiles {

    //@Value("${valor1}")
    String valor1="";
    //@Value("${valor2}")
    String valor2 = "";

    @GetMapping("miconfiguracion")
    public String getMiconfiguracion() {return "valor1:" +valor1+ " valor2:" +valor2;}
    //public String getMiconfiguracion() {return "valor1:" +url+ " valor2:" +password;}

    public void setValor1(String valor1) {this.valor1 = valor1;}

    public void setValor2(String valor2) {this.valor2 = valor2;}

}

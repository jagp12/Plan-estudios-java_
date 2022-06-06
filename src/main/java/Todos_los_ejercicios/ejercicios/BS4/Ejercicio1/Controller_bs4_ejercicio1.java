package Todos_los_ejercicios.ejercicios.BS4.Ejercicio1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping(value = "BS4")
//@ConfigurationProperties(prefix = "my")
public class Controller_bs4_ejercicio1 {
    //@Value("${VAR1}")
    private String  var1;
    //@Value("${My.VAR2}")
    private String  var2;
    //@Value("${var3:var3 no tiene valor}")
    private String  var3;
    //String valor;

    public Controller_bs4_ejercicio1() {

    }

    @GetMapping("valores")
    public String getValores() {
        return "valor de var1 es: "+var1+ " valor de my.var2 es: "+var2;
    }

    @GetMapping("var3")
    public String getVar3() {
        return "valor de var3 es: "+var3;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String to_string(){
        return "valor de var1 es: "+var1+ " valor de my.var2 es: "+var2+ "valor de var3 es: "+var3;
    }

}

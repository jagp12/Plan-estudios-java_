package Todos_los_ejercicios.ejercicios.BS4.EJ_perfiles.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "BS4/perfiles")
public class Controller1_bs4_perfiles {

    //@Value("${url}")
    String url;
    //@Value("${password}")
    String password;

    @GetMapping("parametros")
    public String getPersona() {
        return "url:" +url+ " password:" +password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package Todos_los_ejercicios.ejercicios.BS3.Controllers;

import Todos_los_ejercicios.ejercicios.BS3.Service.Servicio_BS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "BS3")
public class Controller_BS3 {

    @Autowired
    Servicio_BS3 servicio1;

    public Controller_BS3(Servicio_BS3 servicio1) {
        this.servicio1 = servicio1;
    }

}

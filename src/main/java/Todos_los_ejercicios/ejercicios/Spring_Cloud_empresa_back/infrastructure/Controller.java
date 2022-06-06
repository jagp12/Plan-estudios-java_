package Todos_los_ejercicios.ejercicios.Spring_Cloud_empresa_back.infrastructure;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_empresa_back.application.Productor;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "spring_empresa")
@RestController
@RequestMapping(value="spring_empresa")
public class Controller {

    @Autowired
    Productor productor;

    @GetMapping("send_mensaje")
    public void get_all_users() throws Exception{

        System.out.println("mensaje enviado");
        productor.crear_y_enviar_mensaje();

    }
}

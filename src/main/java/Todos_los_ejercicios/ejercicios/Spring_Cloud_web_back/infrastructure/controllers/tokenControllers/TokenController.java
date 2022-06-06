package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.tokenControllers;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosToken.TokenService_spring_cloudImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "spring_cloud")
@RestController
@RequestMapping(value="/api/v0")
public class TokenController {

    @Autowired
    TokenService_spring_cloudImpl loginServiceSpringcloud;

    @GetMapping("token")
    public ResponseEntity<String> token(@RequestHeader("usuario") String usuario, @RequestHeader("password") String pwd) throws Exception {

        System.out.println("token usuario:"+usuario+" token contraseña:"+pwd);
        return loginServiceSpringcloud.token_generator(usuario,pwd);

    }

    @GetMapping("token/{token}")
    public String token(@PathVariable("token") String token) throws Exception {

        System.out.println("token recibido:"+token);
        return token;

    }

}

package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosToken;

import org.springframework.http.ResponseEntity;

public interface TokenService_spring_cloud {

    public ResponseEntity<String> token_generator(String usuario, String pwd) throws Exception;
}

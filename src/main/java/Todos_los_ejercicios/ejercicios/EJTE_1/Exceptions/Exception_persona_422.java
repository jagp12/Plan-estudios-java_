package Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class Exception_persona_422 extends RuntimeException{

    public Exception_persona_422(String message) {
        super(message);
    }
}

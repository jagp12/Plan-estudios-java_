package Todos_los_ejercicios.ejercicios.DBA2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class Exception_persona_406 extends RuntimeException{

    public Exception_persona_406(String message) {
        super(message);
    }
}

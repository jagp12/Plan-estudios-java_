package Todos_los_ejercicios.ejercicios.EJ3.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Exception_persona_404 extends RuntimeException{

    public Exception_persona_404(String message) {
        super(message);
    }
}

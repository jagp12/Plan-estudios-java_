package Todos_los_ejercicios.ejercicios.EJ3.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice
// @RestController
@RestControllerAdvice
public class CustomErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception_persona_404.class)
    public final ResponseEntity<CustomError> handleNotFoundException(Exception_persona_404 ex, WebRequest request) {

        CustomError custom_err = new CustomError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<CustomError>(custom_err, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception_persona_406.class)
    public final ResponseEntity<CustomError> handleNotAcceptabledException(Exception_persona_406 ex, WebRequest request) {

        CustomError custom_err = new CustomError(new Date(), ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
        return new ResponseEntity<CustomError>(custom_err, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(Exception_persona_422.class)
    public final ResponseEntity<CustomError> handleunprocessableEntityException(Exception_persona_422 ex, WebRequest request) {

        CustomError custom_err = new CustomError(new Date(), ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        return new ResponseEntity<CustomError>(custom_err, HttpStatus.UNPROCESSABLE_ENTITY);

    }


}

package Todos_los_ejercicios.ejercicios.EJ3.Exception;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {

    private Date timestamp;
    private String mensaje;
    private String HttpCode;

    public CustomError(Date timestamp, String mensaje, String httpCode) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
        HttpCode = httpCode;
    }

}

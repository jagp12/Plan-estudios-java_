package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums;

public enum HoraSalida {
    PRIMERA_SALIDA(8),
    SEGUNDA_SALIDA(12),
    TERCERA_SALIDA(16),
    CUARTA_SALIDA(20);

    public float hora;

    HoraSalida(float hora){
        this.hora = hora;
    }

}

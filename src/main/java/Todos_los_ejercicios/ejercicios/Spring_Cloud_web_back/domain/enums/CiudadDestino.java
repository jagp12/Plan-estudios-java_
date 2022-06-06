package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.enums;

public enum CiudadDestino {
    VALENCIA("VAL"),
    MADRID("MAD"),
    BARCELONA("BAR"),
    BILBAO("BIL");

    public String ciudad;
    CiudadDestino(String ciudad){
        this.ciudad = ciudad;
    }
}

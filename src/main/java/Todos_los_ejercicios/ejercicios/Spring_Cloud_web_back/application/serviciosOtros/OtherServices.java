package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosOtros;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;

public interface OtherServices {

    User_spring_cloud crear_usuario(String user, String pwd) throws Exception;

}

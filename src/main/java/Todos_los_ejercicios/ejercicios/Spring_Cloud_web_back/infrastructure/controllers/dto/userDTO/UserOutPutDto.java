package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.dto.userDTO;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import lombok.Data;

@Data
public class UserOutPutDto {

    String user;
    String password;

    public UserOutPutDto(User_spring_cloud userSpringcloud){
        setUser(userSpringcloud.getUser());
        setPassword(userSpringcloud.getPassword());
    }

}

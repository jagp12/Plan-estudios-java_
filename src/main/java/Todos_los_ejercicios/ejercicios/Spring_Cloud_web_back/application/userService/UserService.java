package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.userService;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;

import java.util.List;

public interface UserService {

    User_spring_cloud insert_user(User_spring_cloud user);
    List<User_spring_cloud> get_all_users();

    List<User_spring_cloud> findByUser(String user);


}

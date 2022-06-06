package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.userService;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User_spring_cloud insert_user(User_spring_cloud user) {
        return userRepository.save(user);
    }

    @Override
    public List<User_spring_cloud> get_all_users(){
        return userRepository.findAll();
    }

    @Override
    public List<User_spring_cloud> findByUser(String user) {
        return userRepository.findByUser(user);
    }

}

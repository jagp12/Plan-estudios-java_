package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User_spring_cloud,String> {
    List<User_spring_cloud> findByUser(String user);
}

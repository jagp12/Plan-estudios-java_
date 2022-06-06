package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosOtros;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import org.springframework.stereotype.Service;

@Service
public class OtherServicesImpl implements OtherServices{

    @Override
    public User_spring_cloud crear_usuario(String user, String pwd) throws Exception {

        User_spring_cloud user1 = new User_spring_cloud();

        user1.setUser(user);
        user1.setPassword(pwd);
        //persona.setAdmin(admin);

        //System.out.println("persona generada:"+service_create_persona.create_persona(persona));
        return user1;

    }

}

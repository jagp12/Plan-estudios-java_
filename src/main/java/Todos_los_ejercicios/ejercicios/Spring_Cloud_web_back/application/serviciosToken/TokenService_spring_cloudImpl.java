package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosToken;


import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosOtros.OtherServices;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
*/

@Service
public class TokenService_spring_cloudImpl implements TokenService_spring_cloud {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OtherServices otherServices;


    @Override
    public ResponseEntity<String> token_generator(String usuario, String pwd) throws Exception {

        User_spring_cloud usuario_creado = otherServices.crear_usuario(usuario, pwd);
        //userRepository.save(usuario_creado);

        //service_create_persona.create_persona(persona);

        List<User_spring_cloud> lista_personas = userRepository.findByUser(usuario);

        System.out.println("usuarios encontrados:"+lista_personas.size());

        if(lista_personas.size() == 0){
            //System.err.println("No se ha encontrado ningun usuario con esos datos");
            //throw new Exception("No se ha encontrado ningun usuario con esos datos");
            //throw new Exception_persona_404("No se ha encontrado ninguna persona con ese usuario");
        }
        //System.out.println("admin:"+lista_personas.get(0).isAdmin());
        if(lista_personas.size() > 1){
            //System.err.println("Se ha encontrado más de un usuario con esos datos");
            //throw new Exception("Se ha encontrado más de un usuario con esos datos");
            //throw new Exception_persona_422("Hay más de una persona con ese nombre de usuario");
        }

//        if(!lista_personas.get(0).getPassword().equals(pwd)){
//            //System.err.println("La contraseña no es correcta");
//            throw new Exception("La contraseña no es correcta");
//            //throw new Exception_persona_422("La contraseña no es correcta");
//        }
/*
        String rol = (lista_personas.get(0).isAdmin()) ? "ROLE_ADMIN": "ROLE_USER";

        //AsignacionInputDTO persona_recibida = new AsignacionInputDTO();
        //System.out.println("logeando "+ persona_recibida +" rol:+rol);

*/

        //System.out.println("datos recibidos user:"+usuario+" pwd:"+pwd+" usuario creado:"+ crear_usuario(usuario, pwd));
        return new ResponseEntity<>(null/*getJWTToken(usuario, "ROLE_ADMIN")*/, HttpStatus.OK);

    }
/*
    private String getJWTToken(String username, String rol) {

        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);//(rol);
        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
*/


}


package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona;


import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Create_Services.Service_create;
import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services.Service_find;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_422;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
*/
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Autowired
    Service_find service_find;
    @Autowired
    Service_create service_create_persona;
    /*
        public ResponseEntity<String> login(String usuario, String pwd, boolean admin) throws Exception {

            Persona_ej3 persona = crear_persona(usuario, pwd, admin);

            //service_create_persona.create_persona(persona);

            List<AsignacionOutputDTO> lista_personas = service_find.find_by_user(usuario,"false");

            if(lista_personas.size() == 0){
                throw new Exception_persona_404("No se ha encontrado ninguna persona con ese usuario");
            }
            System.out.println("admin:"+lista_personas.get(0).isAdmin());
            if(lista_personas.size() > 1){
                throw new Exception_persona_422("Hay más de una persona con ese nombre de usuario");
            }

            if(!lista_personas.get(0).getPassword().equals(pwd)){
                throw new Exception_persona_422("La contraseña no es correcta");
            }

            String rol = (lista_personas.get(0).isAdmin()) ? "ROLE_ADMIN": "ROLE_USER";

            //AsignacionInputDTO persona_recibida = new AsignacionInputDTO();
            //System.out.println("logeando "+ persona_recibida +" rol:+rol);


            return new ResponseEntity<>(getJWTToken(usuario,rol), HttpStatus.OK);

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
    public Persona_ej3 crear_persona(String user, String pwd, boolean admin) throws Exception {

        Persona_ej3 persona = new Persona_ej3();

        persona.setUsuario(user);
        persona.setPassword(pwd);
        persona.setAdmin(admin);

        System.out.println("persona generada:"+service_create_persona.create_persona(persona));
        return persona;

    }

}

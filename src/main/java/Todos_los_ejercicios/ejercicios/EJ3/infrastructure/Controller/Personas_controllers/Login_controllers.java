package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Personas_controllers;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Create_Services.Service_create;
import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services.Service_find;
import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.LoginService;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_406;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_422;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Login_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
*/
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "EJ3/persona")
@RestController
@RequestMapping(value="EJ3")
public class Login_controllers {

    @Autowired
    LoginService loginService;

/*
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestParam("usuario") String usuario, @RequestParam("password") String pwd, @RequestParam("admin") boolean admin) throws Exception {

        return loginService.login(usuario,pwd,admin);

    }



    @PostMapping("/registrer")
    public ResponseEntity<AsignacionOutputDTO> registrer(@RequestBody AsignacionOutputDTO userEntity) throws Exception{
        return new ResponseEntity<>(new AsignacionOutputDTO(serviceUsuario.register(userEntity.getUser(),userEntity.getPassword(),userEntity.isAdmin())), HttpStatus.OK);
    }

    private String getJWTToken(String username, String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");//(rol);
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
/*
    @GetMapping("/login")
    public Login_input_dto get_persona_por_id(@RequestBody Login_input_dto login_Dto ) throws Exception_persona_404 {

        String token = getJWTToken(login_Dto.getUsuario());
        System.out.println("login:"+login_Dto+"\n token:"+token);
        //return servicio_persona.find_by_id(id);
        return login_Dto;//servicio_persona.find_by_id(id,ouputType);

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
*/
}

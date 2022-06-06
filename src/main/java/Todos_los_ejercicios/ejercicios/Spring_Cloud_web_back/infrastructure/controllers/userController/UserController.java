package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.controllers.userController;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.userService.UserService;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.User_spring_cloud;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "spring_cloud")
@RestController
@RequestMapping(value="/api/v0")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get_all_users")
    public ResponseEntity<List<User_spring_cloud>> get_all_users() throws Exception{

        return new ResponseEntity<>(userService.get_all_users(), HttpStatus.OK);

    }

    @PostMapping("insert_user")
    public ResponseEntity<User_spring_cloud> insert_user(@RequestBody User_spring_cloud user) throws Exception{

        return new ResponseEntity<>(userService.insert_user(user), HttpStatus.OK);

    }
}

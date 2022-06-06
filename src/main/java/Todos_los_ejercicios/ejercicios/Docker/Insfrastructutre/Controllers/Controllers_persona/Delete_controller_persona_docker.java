package Todos_los_ejercicios.ejercicios.Docker.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.Docker.Aplication.Service_delete.Service_delete_persona_docker;
import Todos_los_ejercicios.ejercicios.Docker.Exceptions.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "Docker")
@RestController
@RequestMapping("Docker/delete")
public class Delete_controller_persona_docker {

    @Autowired
    Service_delete_persona_docker service_delete_persona_docker;


    @DeleteMapping("/{id}")
    public void persona_delete(@PathVariable String id) throws Exception_persona_404 {

        service_delete_persona_docker.delete_by_id(id);

    }
}

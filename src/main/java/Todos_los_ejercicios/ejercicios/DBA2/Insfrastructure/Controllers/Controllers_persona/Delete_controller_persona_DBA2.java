package Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Controllers.Controllers_persona;


import Todos_los_ejercicios.ejercicios.DBA2.Aplication.delete.Service_delete_persona_DBA2;
import Todos_los_ejercicios.ejercicios.DBA2.Exceptions.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "DBA2")
@RestController
@RequestMapping("DBA2/delete")
public class Delete_controller_persona_DBA2 {

    @Autowired
    Service_delete_persona_DBA2 service_delete_persona_dba2;

    @DeleteMapping("/{id}")
    public void persona_delete(@PathVariable String id) throws Exception_persona_404 {

        service_delete_persona_dba2.delete_by_id(id);

    }
}

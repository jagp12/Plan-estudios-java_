package Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.Controllers_persona;

import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.delete.Service_delete_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Exceptions.Exception_persona_404;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "EJTE_1")
@RestController
@RequestMapping("EJTE_1/delete")
public class Delete_controller_persona_EJTE_1 {

    @Autowired
    Service_delete_persona_EJTE_1 service_delete_persona_EJTE1;

    @DeleteMapping("/{id}")
    public void persona_delete(@PathVariable String id) throws Exception_persona_404 {

        service_delete_persona_EJTE1.delete_by_id(id);

    }
}

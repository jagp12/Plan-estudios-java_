
package Todos_los_ejercicios.ejercicios.EJ3.Aplication;

import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Profesor.Profesor_output_dto;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="mueretefeintestupido", url = "http://localhost:8081/profesor/template")
public interface Feign_profesor {

    @GetMapping("/{id}")
    ResponseEntity<Profesor_output_dto> getWithFeign(@PathVariable int id);
}

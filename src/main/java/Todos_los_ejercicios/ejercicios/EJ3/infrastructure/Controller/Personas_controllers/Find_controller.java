package Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.Personas_controllers;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.servicioCorreo.MailService;
import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services.Service_find;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "EJ3/persona")
@RestController
@RequestMapping(value="EJ3/persona")
public class Find_controller {

    @Autowired
    Service_find service_find;
    //@Autowired
    //Feign_profesor feign_profesor;

    @Autowired
    MailService mailService;
    /*
    public Find_controller(Feint_profesor feint_profesor){
        this.feint_profesor = feint_profesor;
    }
*/
    @GetMapping("/getid/{id}")
    public AsignacionOutputDTO get_persona_por_id(@PathVariable String id, @RequestParam(value = "ouputType") String ouputType  ) throws Exception_persona_404 {

        if(!ouputType.equals("full")){
            ouputType = "simple";
        }
        if(ouputType.equals("full")){
            return service_find.devolver_student_o_profesor_en_id(service_find.find_by_id(id,ouputType));
        }

        return new AsignacionOutputDTO(service_find.find_by_id(id,ouputType));
        //return service_find.devolver_student_o_profesor(service_find.find_by_id(id,ouputType));

    }

    @GetMapping("getuser/{user}")
    public List<AsignacionOutputDTO> get_persona_por_nombre(@PathVariable String user, @RequestParam(value = "ouputType") String ouputType) throws Exception{

        List<AsignacionOutputDTO> lista_personas = service_find.find_by_user(user,ouputType);

        return service_find.devolver_student_o_profesor_en_user( lista_personas,  ouputType);
        //return service_find.find_by_user(user,ouputType).stream().map(persona_ej3 -> new AsignacionOutputDTO(persona_ej3)).toList();

    }

    @GetMapping("/all")
    public List<AsignacionOutputDTO> get_all_persona(@RequestParam(value = "ouputType") String ouputType) {

        //devolver lista dto
        //System.out.println("lista obtenida");
        List<AsignacionOutputDTO> lista_personas = service_find.find_all(ouputType);

        return service_find.devolver_student_o_profesor_en_user( lista_personas,  ouputType);
        //return service_find.find_all(ouputType).stream().map(persona_ej3 -> new AsignacionOutputDTO(persona_ej3)).toList();

    }

    @GetMapping("/send_email")
    public String send_email() {

        mailService.sendMail("ygigig@fhfgj.fgfgnf","surtatispo@vusra.com","holi","hola");
        return "email enviado";
        //return service_find.find_all(ouputType).stream().map(persona_ej3 -> new AsignacionOutputDTO(persona_ej3)).toList();

    }

    //@RestControler("/profesor/{id}")
    //@GetMapping("/profesor/{id}")
    /*public Profesor_output_dto getProfesor(@PathVariable int id){

        return servicio_persona.getProfesor(id);

    }*/
/*
    @GetMapping("persona/profesor/{id}")
    ResponseEntity<Profesor_output_dto> getHttpCodePlusOne(@PathVariable int id)
    {
        System.out.println("En server. id persona: "+id);
        ResponseEntity<Profesor_output_dto> rs = new RestTemplate().getForEntity("http://localhost:8081/profesor/template/"+id, Profesor_output_dto.class);
        System.out.println("rs:"+rs.getBody());
        //Profesor profesor  = find_profesor_por_id_persona(String.valueOf(id));
        //ResponseEntity<Profesor_output_dto> respuesta = servicio_persona.getProfesor(id);
        return ResponseEntity.ok(rs.getBody());
    }
*/
/*
    @GetMapping("persona/profesor/{id}")
    ResponseEntity<Profesor_output_dto> getHttpCodePlusOne(@PathVariable int id)
    {
        System.out.println("En server. id persona: "+id);
        ResponseEntity<Profesor_output_dto> rs = new RestTemplate().getForEntity("http://localhost:8081/template/{id}",Profesor_output_dto.class);
        System.out.println("rs:"+rs.getBody());
        //Profesor profesor  = find_profesor_por_id_persona(String.valueOf(id));
        //ResponseEntity<Profesor_output_dto> respuesta = servicio_persona.getProfesor(id);
        return ResponseEntity.ok(rs.getBody());
    }
*/
   /* @GetMapping("persona/profesor/{id}")
    public ResponseEntity<Profesor_output_dto> getWithFeign(@PathVariable int id) {
        System.out.println("Hola soy el controlador persona voy a hacerle la peticion a la otra aplicacion");
        return feign_profesor.getWithFeign(id);

    }
    */
}

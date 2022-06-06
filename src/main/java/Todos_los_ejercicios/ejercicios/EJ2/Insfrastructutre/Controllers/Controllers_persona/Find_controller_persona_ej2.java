package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.Controllers_persona;


import Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_find.Service_find_persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_other.Service_transform;
import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.AsignacionOutputDTO;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository.PersonaRepositorio_ej2;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Api(tags = "EJ2/persona")
@RequestMapping(value="EJ2/find")
@RestController
public class Find_controller_persona_ej2 {

    @Autowired
    Service_find_persona_ej2 service_find_persona_ej2;

    @Autowired
    Service_transform service_transform;

    @Autowired
    PersonaRepositorio_ej2 personaRepositorio;

    @GetMapping("/getid/{id}")
    public AsignacionOutputDTO get_persona_por_id(@PathVariable String id, @RequestParam(value = "outputType") String ouputType  ) throws Exception_persona_404 {

        return service_transform.crear_output_dto(service_find_persona_ej2.find_by_id(id));//new AsignacionOutputDTO(service_find_persona_ej2.find_by_id(id));
        //return servicio_persona.find_by_id(id,ouputType);

    }

    @GetMapping("getuser/{user}")
    public List<AsignacionOutputDTO> get_persona_por_nombre(@PathVariable String user, @RequestParam(value = "outputType") String outputType) throws Exception{

        List<AsignacionOutputDTO> lista = service_find_persona_ej2.find_by_user(user,outputType).stream().map((personaEj2 -> service_transform.crear_output_dto(personaEj2))).toList();
        //List<AsignacionOutputDTO> lista = servicio_persona.find_by_user(user,ouputType).stream().map((personaEj2 -> new AsignacionOutputDTO(personaEj2))).toList();
        //persona_repositorio.findAll().stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();

        return lista;

    }

    @GetMapping("/all")
    public List<AsignacionOutputDTO> get_all_persona(@RequestParam(value = "outputType") String outputType) {

        //devolver lista dto
        System.out.println("lista obtenida");
        return service_find_persona_ej2.find_all(outputType).stream().map(personaEj2 -> service_transform.crear_output_dto(personaEj2)).toList();

    }

    @GetMapping("/getparams/{id}")
    public List<Persona_ej2> getData(@RequestParam(required=false,value="usuario") String usuario,
                                     @RequestParam(required=false,value="name") String name,
                                     @RequestParam(required=false,value="surname") String surname,
                                     @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate,
                                     @RequestParam(required=false, value = "dateCondition") String dateCondition ,
                                     @RequestParam(required=false, value = "orderBy") String orderBy        )
    {
        System.out.println("datos recibidos: usuario:"+usuario+" name:"+name+" surname:"+surname+" datacondition:"+dateCondition+" fecha creación:"+createdDate+" datacondition:"+dateCondition+" orderBy:"+orderBy);
        HashMap<String, Object> data=new HashMap<>();
        if (usuario!=null){data.put("usuario",usuario);}
        if (name!=null){data.put("name",name);}
        if (surname!=null){data.put("surname",surname);}
        if (!dateCondition.equals("greater") && !dateCondition.equals("less") && !dateCondition.equals("equal")){
            dateCondition = "less";
        }
        if (dateCondition.equals("greater") && !dateCondition.equals("less"))
            dateCondition="greater";
        if (createdDate!=null)
        {
            data.put("created",createdDate);
            data.put("dateCondition",dateCondition);
        }
        if (orderBy!=null){data.put("orderBy",orderBy);}

        return service_find_persona_ej2.getData(data);
        //return null;//service_find_persona_ej2.getData(data);
    }
/*
    @GetMapping("/getparams2/{id}")
    public List<AsignacionOutputDTO>  getData2(@RequestParam(required=false,name="usuario") String usuario,
                                              @RequestParam(required=false,value="name") String name,
                                              @RequestParam(required=false,value="surname") String surname,
                                              @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate, @RequestParam(required=false) String dateCondition        )
    {
        HashMap<String, Object> data=new HashMap<>();

        if (idCustomer!=null)
            data.put("id",idCustomer);
        if (nameCustomer!=null)
            data.put("name",nameCustomer);
        if (addressCustomer!=null)
            data.put("address",addressCustomer);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;
        if (createdDate!=null)
        {
            data.put("created",createdDate);
            data.put("dateCondition",dateCondition);
        }

        return customersRepository.getData(data);

    }
    */
/*
    @GetMapping("/employee")
    public AsignacionOutputDTO get_employee() throws Exception_persona_404 {

        List<Employee> lista = service_find_persona_ej2.findallemployee();
        return new AsignacionOutputDTO();
        //return servicio_persona.find_by_id(id,ouputType);

    }*/


}

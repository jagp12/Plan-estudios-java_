package Todos_los_ejercicios.ejercicios.EJKA_1;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "kafka")
@RestController
@RequestMapping(value="kafka")
public class KafkaTestController {

   @Autowired
   KafkaMessageProducer kafkaMessageProducer;
   @GetMapping("/add/{mensaje}/{topic}")
   public String addIdCustomer(@PathVariable String topic,@PathVariable String mensaje)//(@PathVariable String topic, @RequestBody String body)
   {
      System.out.println("mensaje kafka recibido ");
      try{
          kafkaMessageProducer.sendMessage(topic,mensaje);
          return "mensaje enviado";
      }catch(Exception e){
          return "error enviando mensaje "+e.getMessage();
      }

   }
/**/
}
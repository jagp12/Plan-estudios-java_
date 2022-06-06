package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.find;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestListener2 {

     @KafkaListener(topics = "${message.topic.name:mitopic1}", groupId = "${message.group.name:groupid}")
     public void listenTopic1(String message) {
         System.out.println("2Recieved Message of topic1 in  listener: " + message);
     }
   
      @KafkaListener(topics = "${message.topic.name2:mitopic2}", groupId = "${message.group.name:groupid}")
      public void listenTopic2(String message) {
         System.out.println("2Recieved Message of topic2 in  listener "+message);
      }
/**/
}
package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosReserva.find;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.ReservaRepository;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Service
public class GetReservaServiceImpl implements GetReservaService{

    @Autowired
    ReservaRepository reservaRepository;

    @Override
    public List<Reserva> get_reserva_por_ciudad_destino(String horaInferior, String horaSuperior, LocalDate fechaInferior, LocalDate fechaSuperior, String destino) {
        //reservaRepository.findByCiudadDestino(ciudadDestino);
        return  reservaRepository.findByCiudadDestino(destino).stream()
                .filter(reservasDisponibles -> reservasDisponibles.getHora()>Float.valueOf(horaInferior))
                .filter(reservasDisponibles -> reservasDisponibles.getHora()<=Float.valueOf(horaSuperior))
                .filter(reservasDisponibles -> reservasDisponibles.getFecha().isAfter(fechaInferior))
                .filter(reservasDisponibles -> reservasDisponibles.getFecha().isBefore(fechaSuperior))
                .toList();
    }

    public void recibir_mensaje(){

        System.out.println("ejercicio weback");
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"groupid");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "500");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(properties);
        consumer.subscribe(Collections.singleton("mitopic1"));

        int count = 0;
        while(count<200){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1500));

            System.out.println("hhhhh:"+consumerRecords.count());

            for(ConsumerRecord<String, String> consumeri : consumerRecords){

                System.out.println("msg:"+consumeri.toString());
                count++;
            }

        }


    }

}

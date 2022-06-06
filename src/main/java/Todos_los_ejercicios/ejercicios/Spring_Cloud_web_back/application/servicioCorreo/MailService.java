package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.servicioCorreo;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService implements CorreoService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String from, String to, String subject, String body) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);

        javaMailSender.send(mail);

    }

    @Override
    public void introducir_reserva_2(Reserva reserva) throws Exception{

        sendMail("aplicacionSpringCloud@gmail.com",reserva.getCorreo(),"Asunto","reserva creada");

    }

}

package Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.application.serviciosCorreos.insert;

import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.domain.Correo;
import Todos_los_ejercicios.ejercicios.Spring_Cloud_web_back.infrastructure.Repositorios.CorreoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertCorreoImpl implements InsertCorreo{

    @Autowired
    CorreoRepository correoRepository;

    @Override
    public Correo instert_correo(Correo correo) {
        return correoRepository.save(correo);
    }

}

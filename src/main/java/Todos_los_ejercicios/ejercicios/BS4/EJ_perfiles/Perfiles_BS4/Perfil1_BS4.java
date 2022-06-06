package Todos_los_ejercicios.ejercicios.BS4.EJ_perfiles.Perfiles_BS4;

import Todos_los_ejercicios.ejercicios.BS4.EJ_perfiles.Interfaces.Perfiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
public class Perfil1_BS4 implements Perfiles {

    public String perfil = "perfil1";
    @Override
    public void miFuncion() {
        System.out.println("perfil:" +perfil);
    }

}

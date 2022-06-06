package Todos_los_ejercicios.ejercicios.BS4.EJ_perfiles.controllers;

import Todos_los_ejercicios.ejercicios.BS4.EJ_perfiles.Interfaces.Perfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class Controller3_bs4_perfiles {

    @Autowired
    Perfiles perfiles;

    @GetMapping("perfiles")
    public void getMiconfiguracion() {  perfiles.miFuncion() ;}

}

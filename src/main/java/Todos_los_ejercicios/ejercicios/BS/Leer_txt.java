package Todos_los_ejercicios.ejercicios.BS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Leer_txt {

    private static List<Persona> lista_personas = new ArrayList<>();
    public static void main(String[] args) {

        //lee el archivo, crea las instancias persona y las incluye en la lista.
        leer_archivo("Nombre_Población_Edad.txt");

        //con la lista y la edad indicada realiza el filtrado de los datos y los muestra por consola
        find(lista_personas , 999 );

    }
    public static void leer_archivo(String ruta){

        try{

            FileReader entrada = new FileReader(ruta, StandardCharsets.UTF_8);
            BufferedReader bufer_lectura = new BufferedReader(entrada);

            String temp = "";

            while(temp != null){

                temp = bufer_lectura.readLine();

                //utiliza los datos de la variable temp para crear una instancia de la clase persona y la introduce en la lista
                lista_personas.add( crear_instancia_persona(temp) );

            }


        }catch(Exception fnf){
            //System.err.println(fnf.getMessage());
        }


    }

    public static Persona crear_instancia_persona(String temp) {

        if (temp == null) {
            return null;
        }

        String datos_persona[] = temp.split(":");

        if (datos_persona.length == 1) {
            return new Persona(datos_persona[0], "Desconocida", null);
        } else if (datos_persona.length == 2) {
            return new Persona(datos_persona[0], datos_persona[1], null);
        } else {

            if (datos_persona[1].equals("")) {
                return new Persona(datos_persona[0], "Desconocida", Integer.parseInt(datos_persona[2]));
            }
            return new Persona(datos_persona[0], datos_persona[1], Integer.parseInt(datos_persona[2]));
        }


    }
    public static void find(List<Persona> lista_personas , int edad){

        //muestra por consola todas la coincidencias
        try{

            lista_personas.stream().filter(n -> Optional.ofNullable(n.getEdad()).orElse(99999) < edad).forEach(System.out::println);

        }catch (NullPointerException npe){
            return;
        }

    }

}

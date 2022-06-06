package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Profesor_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Persona.Persona_and_profesor_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Persona.Persona_and_student_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Profesor_con_estudiantes_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Student_con_profesores_y_asignaturas_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Student_y_asignaturas_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Estudiante_asignatura_repository;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.PersonaRepositorio;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Profesor_repository;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Service_find_Impl implements Service_find{

    @Autowired
    PersonaRepositorio persona_repositorio;
    @Autowired
    Student_repository repositorio_estudiante;
    @Autowired
    Profesor_repository profesor_repository;
    @Autowired
    Estudiante_asignatura_repository estudiante_asignatura_repository;

    public Persona_ej3 find_by_id(String id) throws Exception_persona_404 {

        //devuelve error 500 y no un error 404

        return persona_repositorio.findById(Integer.parseInt(id)).orElseThrow(()->new Exception_persona_404("(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id));

        /*
        //comprueba si hay estudiantes o profesores con el id de la persona encontrada
        Student_ej3 studentEj3 = find_student_por_id_persona(String.valueOf(personaEj3.getId_persona()));
        Profesor_ej3 profesorEj3 = find_profesor_por_id_persona(String.valueOf(personaEj3.getId_persona()));

        System.out.println("785ghe student:"+ studentEj3);
        System.out.println("987uijk profesor:"+ profesorEj3);

        if(studentEj3 != null){
            System.out.println("Devolviendo estudiante con asignaturas");
            List<Estudiante_asignatura_ej3> lista_de_asignaturas = obtener_lista_de_asignaturas_de_un_estudiante(studentEj3.getId());
            //List<Profesor> lista_de_profesores = obtener_lista_de_profesores(student.getId_profesor());
            List<Profesor_ej3> lista_de_profesores = obtener_lista_de_profesores(personaEj3, studentEj3);
            System.out.println("----asignaturas:" +lista_de_asignaturas.size()+ " profesores:" +lista_de_profesores.size());
            return new Student_con_profesores_y_asignaturas_output_dto(studentEj3, lista_de_asignaturas,  lista_de_profesores);
        }

        if(profesorEj3 != null){
            System.out.println("Devolviendo profesor con estudiantes");
            List<Student_ej3> lista_de_estudiantes = obtener_lista_de_estudiantes(profesorEj3.getId_profesor());
            List<Student_y_asignaturas_output_dto> lista_de_estudiantes_con_asignaturas = obtener_lista_de_estudiantes_con_asignatura(personaEj3,lista_de_estudiantes);
            System.out.println("----lista_de_estudiantes_con_asignaturas:" +lista_de_estudiantes_con_asignaturas.size() );

            return new Profesor_con_estudiantes_output_dto(profesorEj3, lista_de_estudiantes_con_asignaturas);
        }

        System.out.println("Devolviendo persona basica");
        return new AsignacionOutputDTO(personaEj3);
*/
    }

    public Persona_ej3 find_by_id(String id, String ouputType) throws Exception_persona_404 {

        if(!ouputType.equals("full")){
            ouputType = "simple";
        }

        //devuelve error 500 y no un error 404
        return persona_repositorio.findById(Integer.parseInt(id)).orElseThrow(()->new Exception_persona_404("(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id));
        /*
        if(ouputType.equals("full")){
            System.out.println("full entrado");

            Student_ej3 studentEj3 = find_student_por_id_persona(String.valueOf(personaEj3.getId_persona()));
            Profesor_ej3 profesorEj3 = find_profesor_por_id_persona(String.valueOf(personaEj3.getId_persona()));

            //System.out.println("785ghe student:"+student);
            //System.out.println("987uijk profesor:"+profesor);
            if(studentEj3 != null){
                return new Persona_and_student_output_dto(personaEj3, studentEj3);
            }

            if(profesorEj3 != null){
                List<Student_output_dto> student_del_profesor = obtener_lista_de_estudiantes(profesorEj3.getId_profesor()).stream().map((estudiantes)->new Student_output_dto(estudiantes)).toList();
                return new Persona_and_profesor_output_dto(profesorEj3, student_del_profesor);
            }
            return new AsignacionOutputDTO(personaEj3);
        }
        return new AsignacionOutputDTO(personaEj3);
        */
    }
    public List<AsignacionOutputDTO> find_by_user(String user) throws Exception {
        return  persona_repositorio.findByusuario(user);
    }
    public List<AsignacionOutputDTO> find_by_user(String user, String ouputType) throws Exception{

        List<AsignacionOutputDTO> lista_personas = persona_repositorio.findByusuario(user);
        return devolver_student_o_profesor_en_user( lista_personas,  ouputType);
        /*
        for(AsignacionOutputDTO persona_output_dto: lista_personas){
            //busca si la persona es profesor o estudiante
            Student student = repositorio_estudiante.findByIdPersona(String.valueOf(persona_output_dto.getId_persona()));
            Profesor profesor = profesor_repository.findByIdPersona(String.valueOf(persona_output_dto.getId_persona()));

            //si es estudiante guarda en la lista el dto que muestra persona y estudiante
            if(student != null){
                lista_personas_salida.add(new Persona_and_student_output_dto(new Persona(persona_output_dto),student));
            }
            //si es profesor guarda en la lista el dto que muestra persona y profesor
            if(profesor != null){
                lista_personas_salida.add(new Persona_and_profesor_output_dto(new Persona(persona_output_dto),profesor));
            }

            //si no es estudiante ni profesor devuelve el dto basico
            lista_personas_salida.add(persona_output_dto);
        }
*/
        //return  persona_repositorio.findByusuario(user);
        //return lista_personas_salida;

    }

    public List<AsignacionOutputDTO>  find_all(String ouputType){
        System.out.println("all");
        List<AsignacionOutputDTO> lista_personas = persona_repositorio.findAll().stream().map(AsignacionOutputDTO::new).toList();
        return devolver_student_o_profesor_en_user( lista_personas,  ouputType);

        /*List<AsignacionOutputDTO> lista_personas_salida = new ArrayList<>();

        if(ouputType.equals("full")){
            //System.out.println("creando lista de personas 1");
            lista_personas_salida = incluir_estudiante_o_profesor_a_persona(lista_personas);
            return lista_personas_salida;
        }else{
            return lista_personas;
        }

        List<AsignacionOutputDTO> listadto = new ArrayList<>();

        for(Persona persona: persona_repositorio.findAll()){

            Student student = repositorio_estudiante.findByIdPersona(String.valueOf(persona.getId_persona()));
            Profesor profesor = profesor_repository.findByIdPersona(String.valueOf(persona.getId_persona()));

            listadto.add(new AsignacionOutputDTO(persona));

        }

        return listadto;
        */
    }

    public AsignacionOutputDTO devolver_student_o_profesor_en_id(Persona_ej3 persona) {

        Student_ej3 studentEj3 = find_student_por_id_persona(String.valueOf(persona.getId_persona()));
        Profesor_ej3 profesorEj3 = find_profesor_por_id_persona(String.valueOf(persona.getId_persona()));

        //System.out.println("785ghe student:"+student);
        //System.out.println("987uijk profesor:"+profesor);
        if(studentEj3 != null){
            return new Persona_and_student_output_dto(persona, studentEj3);
        }

        if(profesorEj3 != null){
            List<Student_output_dto> student_del_profesor = obtener_lista_de_estudiantes(profesorEj3.getId_profesor()).stream().map((estudiantes)->new Student_output_dto(estudiantes)).toList();
            return new Persona_and_profesor_output_dto(profesorEj3, student_del_profesor);
        }
        return new AsignacionOutputDTO(persona);

    }

    public List<AsignacionOutputDTO> devolver_student_o_profesor_en_user(List<AsignacionOutputDTO> lista_personas, String ouputType) {
        System.out.println("devolver uno u otro");
        List<AsignacionOutputDTO> lista_personas_salida = new ArrayList<>();

        if(ouputType.equals("full")){
            lista_personas_salida = incluir_estudiante_o_profesor_a_persona(lista_personas);
            System.out.println("devolviendo full");
            return lista_personas_salida;
        }else{
            System.out.println("devolviendo simple");
            return lista_personas;
        }

    }

    private List<AsignacionOutputDTO> incluir_estudiante_o_profesor_a_persona(List<AsignacionOutputDTO> lista_personas){

        List<AsignacionOutputDTO> lista_personas_salida = new ArrayList<>();
        System.out.println("creando lista de personas 2 /"+lista_personas.size());

        int vuelta = 0;

        for(AsignacionOutputDTO persona_output_dto: lista_personas){

            //busca si la persona es profesor o estudiante
            System.out.println(vuelta+"-creando lista de personas 3 buscando student por id:"+persona_output_dto.getId_persona());
            Student_ej3 studentEj3 = find_student_por_id_persona(String.valueOf(persona_output_dto.getId_persona()));
            //id_persona string
            System.out.println(vuelta+"-creando lista de personas 4");
            //Student student = repositorio_estudiante.findByIdPersona(String.valueOf(persona_output_dto.getId_persona()));
            //string id
            //Profesor profesor = profesor_repository.findByIdPersona(String.valueOf(persona_output_dto.getId_persona()));
            //Profesor profesor = profesor_repository.findByPersona(new Persona(persona_output_dto));
            Persona_ej3 personaEj3 = new Persona_ej3(persona_output_dto);
            //Profesor profesor = new Profesor(profesor_repository.findByIdPersona(String.valueOf(persona.getId_persona())), persona);
            System.out.println(vuelta+"-creando lista de personas 5");
            Profesor_ej3 profesorEj3 = find_profesor_por_id_persona(String.valueOf(personaEj3.getId_persona()));
            System.out.println(vuelta+"-creando lista de personas 6");
            //si es estudiante guarda en la lista el dto que muestra persona y estudiante
            if(studentEj3 != null){
                System.out.println(vuelta+"-creando lista de personas 7");
                lista_personas_salida.add(new Persona_and_student_output_dto(new Persona_ej3(persona_output_dto), studentEj3));
                System.out.println(vuelta+"-creando lista de personas 8");
                continue;
            }
            //si es profesor guarda en la lista el dto que muestra persona y profesor
            if(profesorEj3 != null){
                System.out.println(vuelta+"-creando lista de personas 9");
                List<Student_output_dto> student_del_profesor = obtener_lista_de_estudiantes(profesorEj3.getId_profesor()).stream().map((estudiantes)->new Student_output_dto(estudiantes)).toList();
                System.out.println(vuelta+"-creando lista de personas 10");
                lista_personas_salida.add(new Persona_and_profesor_output_dto(profesorEj3, student_del_profesor));
                System.out.println(vuelta+"-creando lista de personas 11");
                continue;
            }
            System.out.println(vuelta+"-creando lista de personas 12");
            //si no es estudiante ni profesor devuelve el dto basico
            lista_personas_salida.add(persona_output_dto);
            vuelta++;
        }

        return lista_personas_salida;

    }


    public List<Estudiante_asignatura_ej3> obtener_lista_de_asignaturas_de_un_estudiante(String id_studiante){

        //List<Estudiante_asignatura> lista_estudiantes = new ArrayList<>();
        //List<Estudiante_asignatura> lista_asignaturas = new ArrayList<>();

        Student_ej3 studentEj3 = repositorio_estudiante.findById(id_studiante).orElseThrow(null);

        return studentEj3.getEstudios();

        //for (Estudiante_asignatura estudiante_asignatura : estudiante_asignatura_repository.findAll()){

        //id_student es clase student
            /*
            for(Student student_de_la_asignatura:estudiante_asignatura.getStudent()){
                if(student_de_la_asignatura.getId().equals(id_studiante)){
                    lista_estudiantes.add(estudiante_asignatura);
                }
            }
            */
        //id_student en asignatura es string

        //if(estudiante_asignatura.getIdStudent().equals(id_studiante)){
        //lista_estudiantes.add(estudiante_asignatura);
        //}
        //}

        //return lista_estudiantes;

    }

    public List<Profesor_ej3> obtener_lista_de_profesores(Persona_ej3 persona_ej3_student, Student_ej3 estudiante ){

        List<Profesor_ej3> lista_profesores = new ArrayList<>();
        //Profesor profesor_encontrado = profesor_repository.findByIdPersona(String.valueOf(persona_student.getId_persona()));
        //Profesor profesor_encontrado = profesor_repository.findByPersona(persona_student);
        //Profesor profesor_encontrado  = find_profesor_por_id_persona(String.valueOf(persona_student.getId_persona()));

        for (Profesor_ej3 profesorEj3 : profesor_repository.findAll()){
            //for (Profesor_input_dto profesor_input_dto : profesor_repository.findAll()){
            //if(profesor.getId_profesor().equals(estudiante.getId_profesor())){
            if(profesorEj3.getId_profesor().equals(estudiante.getProfesorEj3().getId_profesor())){
                lista_profesores.add(profesorEj3);
                //Persona persona = persona_repositorio.findById(Integer.parseInt(profesor.getIdPersona())).get();
                //lista_profesores.add(new Profesor(profesor,persona));
            }
        }


        //System.err.println("*****se ha encontrado al profesor: " +profesor_encontrado);


        return lista_profesores;

    }



    public List<Student_ej3> obtener_lista_de_estudiantes(String id_profesor){

        List<Student_ej3> lista_estudiantes = new ArrayList<>();

        for (Student_ej3 estudiante : repositorio_estudiante.findAll()){
            /*if(estudiante.getProfesor().equals(id_profesor)){
                lista_estudiantes.add(estudiante);
            }*/
            //if(estudiante.getId_profesor().equals(id_profesor)){
            if(estudiante.getProfesorEj3().getId_profesor().equals(id_profesor)){
                lista_estudiantes.add(estudiante);
            }
        }

        return lista_estudiantes;

    }

    public List<Student_y_asignaturas_output_dto> obtener_lista_de_estudiantes_con_asignatura(Persona_ej3 personaEj3, List<Student_ej3> estudiantes){

        List<Student_y_asignaturas_output_dto> lista_de_estudiantes_con_asignaturas = new ArrayList<>();

        for(Student_ej3 estudiante: estudiantes){
            List<Estudiante_asignatura_ej3> lista_de_asignaturas_Del_Estudiante = obtener_lista_de_asignaturas_de_un_estudiante(estudiante.getId());
            lista_de_estudiantes_con_asignaturas.add(new Student_y_asignaturas_output_dto( estudiante,lista_de_asignaturas_Del_Estudiante));
        }

        return lista_de_estudiantes_con_asignaturas;

    }

    public Profesor_ej3 find_profesor_por_id_persona(String id_persona){

        Persona_ej3 personaEj3;
        Profesor_ej3 profesorEj31;

        for(Profesor_ej3 profesorEj3 : profesor_repository.findAll()){
            System.err.println(profesorEj3.getPersonaEj3().getId_persona() +"/"+ id_persona);
            if (profesorEj3.getPersonaEj3().getId_persona()== Integer.valueOf(id_persona)){
                System.err.println(profesorEj3);
                //if (profesor.getIdPersona().equals(id_persona)){
                //persona = persona_repositorio.findById(Integer.parseInt(profesor_input_dto.getIdPersona())).get();
                return profesorEj3;//new Profesor(profesor_input_dto, persona);
            }
        }
        /**/
        return null;
    }

    public Student_ej3 find_student_por_id_persona(String id_persona){


        for(Student_ej3 studentEj3 : repositorio_estudiante.findAll()){
            //System.err.println(student.getPersona().getId_persona() +"/"+ id_persona);
            if (studentEj3.getPersonaEj3().getId_persona()== Integer.valueOf(id_persona)){

                //System.err.println(student);
                //if (profesor.getIdPersona().equals(id_persona)){
                //persona = persona_repositorio.findById(Integer.parseInt(profesor_input_dto.getIdPersona())).get();
                return studentEj3;//new Profesor(profesor_input_dto, persona);
            }
        }

        //System.out.println("-creando lista de personas estudiante nulo");
        /**/
        return null;
    }



}

package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona;

import Todos_los_ejercicios.ejercicios.EJ3.Aplication.Persona.Find_services.Service_find;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_422;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.AsignacionInputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.AsignacionOutputDTO;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Estudiante_asignatura_repository;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.PersonaRepositorio;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Profesor_repository;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Student_repository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
@Slf4j
public class Servicio_persona implements Servicios{

    @Autowired
    PersonaRepositorio persona_repositorio;
    @Autowired
    Student_repository repositorio_estudiante;
    @Autowired
    Profesor_repository profesor_repository;
    @Autowired
    Estudiante_asignatura_repository estudiante_asignatura_repository;
    @Autowired
    Service_find service_find;

/*
    private List<AsignacionOutputDTO> incluir_estudiante_o_profesor_a_persona(List<AsignacionOutputDTO> lista_personas){

        List<AsignacionOutputDTO> lista_personas_salida = new ArrayList<>();
        System.out.println("creando lista de personas 2 /"+lista_personas.size());
        int vuelta = 0;
        for(AsignacionOutputDTO persona_output_dto: lista_personas){

            //busca si la persona es profesor o estudiante
            System.out.println(vuelta+"-creando lista de personas 3 buscando student por id:"+persona_output_dto.getId_persona());
            Student student = find_student_por_id_persona(String.valueOf(persona_output_dto.getId_persona()));
            //id_persona string
            System.out.println(vuelta+"-creando lista de personas 4");
            //Student student = repositorio_estudiante.findByIdPersona(String.valueOf(persona_output_dto.getId_persona()));
            //string id
            //Profesor profesor = profesor_repository.findByIdPersona(String.valueOf(persona_output_dto.getId_persona()));
            //Profesor profesor = profesor_repository.findByPersona(new Persona(persona_output_dto));
            Persona persona = new Persona(persona_output_dto);
            //Profesor profesor = new Profesor(profesor_repository.findByIdPersona(String.valueOf(persona.getId_persona())), persona);
            System.out.println(vuelta+"-creando lista de personas 5");
            Profesor profesor  = find_profesor_por_id_persona(String.valueOf(persona.getId_persona()));
            System.out.println(vuelta+"-creando lista de personas 6");
            //si es estudiante guarda en la lista el dto que muestra persona y estudiante
            if(student != null){
                System.out.println(vuelta+"-creando lista de personas 7");
                lista_personas_salida.add(new Persona_and_student_output_dto(new Persona(persona_output_dto),student));
                System.out.println(vuelta+"-creando lista de personas 8");
                continue;
            }
            //si es profesor guarda en la lista el dto que muestra persona y profesor
            if(profesor != null){
                System.out.println(vuelta+"-creando lista de personas 9");
                List<Student_output_dto> student_del_profesor = obtener_lista_de_estudiantes(profesor.getId_profesor()).stream().map((estudiantes)->new Student_output_dto(estudiantes)).toList();
                System.out.println(vuelta+"-creando lista de personas 10");
                lista_personas_salida.add(new Persona_and_profesor_output_dto(profesor, student_del_profesor));
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

    public AsignacionOutputDTO create_persona(AsignacionInputDTO persona_dto) throws Exception{

        //comprobaciones
        if(!validar_usuario(persona_dto)){
            return null;
        }

        //añade la persona  a la lista
        Persona persona_entity = new Persona(persona_dto);
        System.out.println("id persona " +persona_entity.getId_persona());
        persona_repositorio.save(persona_entity);
        AsignacionOutputDTO persona_output_dto = new AsignacionOutputDTO(persona_entity);

        return persona_output_dto;

    }
*/
    public Persona_ej3 update_persona(Persona_ej3 persona_ej3) throws Exception_persona_404 {

        //comprobaciones
        if(service_find.find_by_id(String.valueOf(persona_ej3.getId_persona())) == null){
            //devolver un 406 o 404
            throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +persona_ej3.getId_persona());
        }
        if(!validar_usuario(persona_ej3)){
            return null;
        }

        persona_repositorio.save(persona_ej3);
        return persona_repositorio.save(persona_ej3);


    }

    public Persona_ej3 delete_by_id(String id) throws Exception_persona_404 {

        if(service_find.find_by_id(id) == null){
            //devolver un 406 o un 404
            throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        }

        Persona_ej3 persona_eliminada = service_find.find_by_id(id);
        //persona_repositorio.deleteByIdPersona(id);
        persona_repositorio.deleteById(Integer.parseInt(id));

        return persona_eliminada;

    }



    @Override
    public boolean validar_usuario(Persona_ej3 persona_Recibida) throws Exception_persona_422 {

        if(persona_Recibida.getId_persona() == null  || persona_Recibida.getUsuario() == null  || persona_Recibida.getPassword() == null ){
            throw new Exception_persona_422("(Servicio_persona.validar_usuario)Ningún parametro puede ser nulo");
            //return false;
        }

        if(persona_Recibida.getName() == null  || persona_Recibida.getSurname() == null  || persona_Recibida.getCompany_email() == null ){
            throw new Exception_persona_422("(Servicio_persona.validar_usuario)Ningún parametro puede ser nulo");
            //return false;
        }

        if(persona_Recibida.getPersonal_email() == null  || persona_Recibida.getCity() == null  || persona_Recibida.getCreated_date() == null ){
            throw new Exception_persona_422("Ningún parametro puede ser nulo");
            //return false;
        }

        if(persona_Recibida.getTermination_date() == null || persona_Recibida.getImagen_url() == null ){
            throw new Exception_persona_422("Ningún parametro puede ser nulo");
            //return false;
        }

        if(persona_Recibida.getUsuario().length() > 10 || persona_Recibida.getUsuario().length() < 6 ){
            throw new Exception_persona_422("El usuario es mayor a 10 o menor a 6 (" +persona_Recibida.getUsuario().length()+ ")");
            //return false;
        }

        return true;
    }
/*
    private List<Estudiante_asignatura> obtener_lista_de_asignaturas_de_un_estudiante(String id_studiante){

        //List<Estudiante_asignatura> lista_estudiantes = new ArrayList<>();
        //List<Estudiante_asignatura> lista_asignaturas = new ArrayList<>();

        Student student = repositorio_estudiante.findById(id_studiante).orElseThrow(null);

        return student.getEstudios();

        //for (Estudiante_asignatura estudiante_asignatura : estudiante_asignatura_repository.findAll()){

            //id_student es clase student

            //id_student en asignatura es string

            //if(estudiante_asignatura.getIdStudent().equals(id_studiante)){
                //lista_estudiantes.add(estudiante_asignatura);
            //}
        //}

        //return lista_estudiantes;

    }

    private List<Profesor> obtener_lista_de_profesores(Persona persona_student, Student estudiante ){

        List<Profesor> lista_profesores = new ArrayList<>();
        //Profesor profesor_encontrado = profesor_repository.findByIdPersona(String.valueOf(persona_student.getId_persona()));
        //Profesor profesor_encontrado = profesor_repository.findByPersona(persona_student);
        //Profesor profesor_encontrado  = find_profesor_por_id_persona(String.valueOf(persona_student.getId_persona()));

        for (Profesor profesor : profesor_repository.findAll()){
        //for (Profesor_input_dto profesor_input_dto : profesor_repository.findAll()){
            //if(profesor.getId_profesor().equals(estudiante.getId_profesor())){
            if(profesor.getId_profesor().equals(estudiante.getProfesor().getId_profesor())){
                lista_profesores.add(profesor);
                //Persona persona = persona_repositorio.findById(Integer.parseInt(profesor.getIdPersona())).get();
                //lista_profesores.add(new Profesor(profesor,persona));
            }
        }


        //System.err.println("*****se ha encontrado al profesor: " +profesor_encontrado);


        return lista_profesores;

    }



    private List<Student> obtener_lista_de_estudiantes(String id_profesor){

        List<Student> lista_estudiantes = new ArrayList<>();

        for (Student estudiante : repositorio_estudiante.findAll()){

            //if(estudiante.getId_profesor().equals(id_profesor)){
            if(estudiante.getProfesor().getId_profesor().equals(id_profesor)){
                lista_estudiantes.add(estudiante);
            }
        }

        return lista_estudiantes;

    }

    private List<Student_y_asignaturas_output_dto> obtener_lista_de_estudiantes_con_asignatura(Persona persona, List<Student> estudiantes){

        List<Student_y_asignaturas_output_dto> lista_de_estudiantes_con_asignaturas = new ArrayList<>();

        for(Student estudiante: estudiantes){
            List<Estudiante_asignatura> lista_de_asignaturas_Del_Estudiante = obtener_lista_de_asignaturas_de_un_estudiante(estudiante.getId());
            lista_de_estudiantes_con_asignaturas.add(new Student_y_asignaturas_output_dto( estudiante,lista_de_asignaturas_Del_Estudiante));
        }

        return lista_de_estudiantes_con_asignaturas;

    }

    public Profesor find_profesor_por_id_persona(String id_persona){

        Persona persona ;
        Profesor profesor1;

        for(Profesor profesor: profesor_repository.findAll()){
            System.err.println(profesor.getPersona().getId_persona() +"/"+ id_persona);
            if (profesor.getPersona().getId_persona()== Integer.valueOf(id_persona)){
                System.err.println(profesor);
            //if (profesor.getIdPersona().equals(id_persona)){
                //persona = persona_repositorio.findById(Integer.parseInt(profesor_input_dto.getIdPersona())).get();
                return profesor;//new Profesor(profesor_input_dto, persona);
            }
        }

        return null;
    }

    public Student find_student_por_id_persona(String id_persona){


        for(Student student: repositorio_estudiante.findAll()){
            //System.err.println(student.getPersona().getId_persona() +"/"+ id_persona);
            if (student.getPersona().getId_persona()== Integer.valueOf(id_persona)){

                //System.err.println(student);
                //if (profesor.getIdPersona().equals(id_persona)){
                //persona = persona_repositorio.findById(Integer.parseInt(profesor_input_dto.getIdPersona())).get();
                return student;//new Profesor(profesor_input_dto, persona);
            }
        }

        //System.out.println("-creando lista de personas estudiante nulo");

        return null;
    }


    public void crear_personas_en_repositorio(int numero_personas){

        for(int i  = 0 ; i < numero_personas; i++){
            AsignacionInputDTO persona_input_dto = new AsignacionInputDTO();

            persona_input_dto.setId_persona("987654");
            persona_input_dto.setUsuario("5489330");
            persona_input_dto.setPassword("5489330");
            persona_input_dto.setName("5489330");
            persona_input_dto.setSurname("5489330");
            persona_input_dto.setCompany_email("5489330");
            persona_input_dto.setPersonal_email("5489330");
            persona_input_dto.setCity("Madrid");
            persona_input_dto.setImagen_url("5489330");
            persona_input_dto.setActive(true);
            persona_input_dto.setCreated_date(new Date());
            persona_input_dto.setTermination_date(new Date());

            Persona persona = new Persona(persona_input_dto);
            persona_repositorio.save(persona);

        }



    }

/*
    @Override
    public ResponseEntity<Profesor_output_dto> getProfesor(int id) {
        Profesor profesor  = find_profesor_por_id_persona(String.valueOf(id));
        return ResponseEntity.status(200).body(new Profesor_output_dto(profesor));
    }
*/


}

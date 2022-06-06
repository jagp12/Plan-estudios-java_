package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Student;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Persona_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Domain.Student_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Id_asignaturas_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Student_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Student.Student_output_dto_simple;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.shared.Student_and_persona_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Estudiante_asignatura_repository;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.PersonaRepositorio;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicio_student_impl implements Student_service{

    @Autowired
    Student_repository repositorio_estudiante;
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    Estudiante_asignatura_repository estudiante_asignatura_repository;

    @Override
    public Student_output_dto find_by_id(String id) throws Exception_persona_404 {
        String texto_error = "(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id;
        return new Student_output_dto(repositorio_estudiante.findById(id).orElseThrow(()->new Exception_persona_404(texto_error)));

    }

    @Override
    public Student_output_dto find_by_id(String id, String ouputType)  throws Exception_persona_404 {

        if(ouputType.isEmpty()){
            ouputType = "simple";
        }
        String texto_error = "(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id;
        Student_ej3 estudiante = repositorio_estudiante.findById(id).orElseThrow(()->new Exception_persona_404(texto_error));
        Persona_ej3 personaEj3 = personaRepositorio.findById(estudiante.getPersonaEj3().getId_persona()).orElseThrow(()->new Exception_persona_404(texto_error));
        //Persona persona = personaRepositorio.findById(Integer.parseInt(estudiante.getIdPersona())).orElseThrow(()->new Exception_persona_404(texto_error));

        if(ouputType.equals("full")){
            return new Student_and_persona_output_dto(estudiante, personaEj3);
        }

        return new Student_output_dto_simple(estudiante);

    }

    @Override
    public List<Student_output_dto> find_all() {

        List<Student_output_dto> listadto = repositorio_estudiante.findAll().stream().map(n->new Student_output_dto(n)).toList();
        return listadto;
    }

    @Override
    public Student_output_dto create_entity(Student_input_dto student_input_dto) {
        //comprobaciones
        //if(!validar_usuario(student_input_dto)){
            //return null;
        //}

        //añade la persona  a la lista
        Student_ej3 student_ej3_entity = new Student_ej3(student_input_dto);
        System.out.println("id persona " +student_input_dto.getIdPersona());
        repositorio_estudiante.save(student_ej3_entity);
        Student_output_dto persona_output_dto = new Student_output_dto(student_ej3_entity);

        return persona_output_dto;
    }

    @Override
    public Student_output_dto update_entity(Student_input_dto estudiante_dto, String id) throws Exception_persona_404 {
        //comprobaciones
        if(find_by_id(id) == null){
            //devolver un 406 o 404
            throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +estudiante_dto.getIdPersona());
        }
        /*
        if(!validar_usuario(persona_dto)){
            return null;
        }
        */
        Student_ej3 estudiante = new Student_ej3(estudiante_dto);
        estudiante.setId(id);
        repositorio_estudiante.save(estudiante);
        Student_output_dto persona_output_dto = new Student_output_dto(estudiante);

        return persona_output_dto;
    }

    @Override
    public Student_output_dto delete_by_id(String id) throws Exception_persona_404 {

        if(find_by_id(id) == null){
            //devolver un 406 o un 404
            throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        }

        Student_output_dto student_eliminado = find_by_id(id);
        //persona_repositorio.deleteByIdPersona(id);
        repositorio_estudiante.deleteById(id);

        return student_eliminado;

    }

    public void asignar_y_desasignar_asignaturas(String id_student, List<Id_asignaturas_input_dto> lista_ids_de_asignaturas, String operacion_a_realizar){

        Estudiante_asignatura_ej3 estudiante_asignaturaEj3 = null;

        //obtiene el estudiante al que desasignar las asignaturas
        Student_ej3 studentEj3 = repositorio_estudiante.getById(id_student);

        if(studentEj3 == null){
            System.err.println("No se ha encontrado al estudiante con id:"+id_student);
            return;
        }

        //itera la lista con las asignaturas que desasignar
        for (Id_asignaturas_input_dto id_asignaturas_input_dto : lista_ids_de_asignaturas) {
            System.out.println("iterando lista");
            //busca en el repositorio la asignatura que tenga el mismo id que la lista de id de asignaturas recibida
            estudiante_asignaturaEj3 = estudiante_asignatura_repository.findById(id_asignaturas_input_dto.getId_asignaturas()).get();
            if(estudiante_asignaturaEj3 == null){
                System.err.println("No se ha encontrado la asignatura con id:"+ estudiante_asignaturaEj3.getId_asignatura());
                continue;
            }

            switch (operacion_a_realizar){
                case "desasignar":
                    System.out.println("desasignandooooo");
                    des_asignar_asignatura_a_estudiante(estudiante_asignaturaEj3, studentEj3);
                    break;
                default:asignar_asignatura_a_estudiante(estudiante_asignaturaEj3, studentEj3);
                    System.out.println("asignandoooooo");break;
            }

        }

    }

    @Override
    public void asignar_asignatura_a_estudiante(Estudiante_asignatura_ej3 estudiante_asignaturaEj3, Student_ej3 studentEj3){

        //pone el estudiante en la asignatura
        estudiante_asignaturaEj3.setStudentEj3(studentEj3);
        estudiante_asignatura_repository.save(estudiante_asignaturaEj3);

        //pone la asignatura en el estudiante
        studentEj3.getEstudios().add(estudiante_asignaturaEj3);
        repositorio_estudiante.save(studentEj3);
        System.out.println("Se ha asignando la asignatura " + estudiante_asignaturaEj3.getId_asignatura()+ " al estudiante con id:"+ studentEj3.getId()+"/"+ studentEj3.getEstudios().get(studentEj3.getEstudios().size()-1).getId_asignatura());

    }

    @Override
    public void crear_students_en_repositorio(int numero) {

        for(int i  = 1 ; i < numero; i++){

            Student_input_dto input_dto = new Student_input_dto();

            if(i == 1){
                input_dto.setIdPersona(String.valueOf(i));
            }else{
                input_dto.setIdPersona(String.valueOf(i+2));
            }

            input_dto.setId_student(String.valueOf("567865"));
            input_dto.setId_profesor(String.valueOf("AUS0000000"+i));
            input_dto.setBranch("567865");
            input_dto.setComents("567865");
            input_dto.setNum_hours_week(487);
            //input_dto.setId_estudios(student.getEstudios().stream().map((asignatura)->asignatura.getId_asignatura()).toList());

            Student_ej3 entity = new Student_ej3(input_dto);
            repositorio_estudiante.save(entity);

        }
    }

    @Override
    public void des_asignar_asignatura_a_estudiante(Estudiante_asignatura_ej3 estudiante_asignaturaEj3, Student_ej3 studentEj3){

        System.out.println("Desasignando asignatura al estudiante con id:" + studentEj3.getId());
        //quita el estudiante de la asignatura
        if(estudiante_asignaturaEj3.getStudentEj3().getId().equals(studentEj3.getId())) {
            estudiante_asignaturaEj3.setStudentEj3(null);
            System.out.println("Se ha eliminado al estudiante de la asignatura:" + estudiante_asignaturaEj3.getStudentEj3());
            estudiante_asignatura_repository.save(estudiante_asignaturaEj3);
        }

        //quita la asignatura del estudiante
        System.out.println("Desasignando la asignatura al estudiante con id:" + studentEj3.getId());

        int indice_de_la_asignatura_en_estudiante = get_index_of_asignatura_estudiante_en_estudiante(estudiante_asignaturaEj3.getId_asignatura(), studentEj3);
        //System.out.println(" indice obtenido " +indice_de_la_asignatura_en_estudiante + " estudios:"+ student.getEstudios());
        studentEj3.getEstudios().remove(indice_de_la_asignatura_en_estudiante);
        //System.out.println("Se ha eliminado del estudiante la asignatura:" +student.getEstudios().stream().toList());

        repositorio_estudiante.save(studentEj3);
        System.out.println("Se ha desasignando la asignatura " + estudiante_asignaturaEj3.getId_asignatura()+ " al estudiante con id:"+ studentEj3.getId());

    }
    //@Override
    private void des_asignar_asignaturas(String id_student, List<Id_asignaturas_input_dto> lista_ids_de_asignaturas) {

        Estudiante_asignatura_ej3 estudiante_asignaturaEj3 = null;

        //obtiene el estudiante al que desasignar las asignaturas
        Student_ej3 studentEj3 = repositorio_estudiante.getById(id_student);

        if(studentEj3 == null){
            System.err.println("No se ha encontrado al estudiante con id:"+id_student);
            return;
        }

        //itera la lista con las asignaturas que desasignar
        for (Id_asignaturas_input_dto id_asignaturas_input_dto : lista_ids_de_asignaturas) {

            //busca en el repositorio la asignatura que tenga el mismo id que la lista de id de asignaturas recibida
            estudiante_asignaturaEj3 = estudiante_asignatura_repository.findById(id_asignaturas_input_dto.getId_asignaturas()).get();
            if(estudiante_asignaturaEj3 == null){
                System.err.println("No se ha encontrado la asignatura con id:"+ estudiante_asignaturaEj3.getId_asignatura());
                continue;
            }

            //quita el estudiante de la asignatura
            if(estudiante_asignaturaEj3.getStudentEj3().getId().equals(studentEj3.getId())) {
                estudiante_asignaturaEj3.setStudentEj3(null);
                estudiante_asignatura_repository.save(estudiante_asignaturaEj3);
            }

            //quita la asignatura del estudiante
            int indice_de_la_asignatura_en_estudiante = get_index_of_asignatura_estudiante_en_estudiante(estudiante_asignaturaEj3.getId_asignatura(), studentEj3);

            studentEj3.getEstudios().remove(indice_de_la_asignatura_en_estudiante);

            repositorio_estudiante.save(studentEj3);

        }



    }
    //@Override
    public Estudiante_asignatura_ej3 asignar_lista_asignaturas(String id_student, List<Id_asignaturas_input_dto> lista_ids_de_asignaturas) {

        System.out.println("asignando asignaturas al usuario con id:"+id_student);

        //id_student en asignaturas es clase
        Estudiante_asignatura_ej3 estudiante_asignaturaEj3 = null;

        //obtiene el estudiante al que asignar las asignaturas
        Student_ej3 studentEj3 = repositorio_estudiante.getById(id_student);

        if(studentEj3 == null){
            System.err.println("No se ha encontrado al usuario con id:"+id_student);
            return null;
        }

        //itera la lista con las asignaturas que asignar
        for(Id_asignaturas_input_dto id_asignaturas_input_dto:lista_ids_de_asignaturas){

            //busca en el repositorio la asignatura que tenga el mismo id que la lista de id de asignaturas recibida
            estudiante_asignaturaEj3 = estudiante_asignatura_repository.findById(id_asignaturas_input_dto.getId_asignaturas()).get();
            System.out.println("Intentando asignar la asignatura  con id:"+ estudiante_asignaturaEj3.getId_asignatura());

            if(estudiante_asignaturaEj3 == null){
                System.err.println("No se ha encontrado la asignatura con id:"+ estudiante_asignaturaEj3.getId_asignatura());

                continue;
            }

            //pone el estudiante en la asignatura
            estudiante_asignaturaEj3.setStudentEj3(studentEj3);
            estudiante_asignatura_repository.save(estudiante_asignaturaEj3);

            //pone la asignatura en el estudiante
            studentEj3.getEstudios().add(estudiante_asignaturaEj3);
            repositorio_estudiante.save(studentEj3);
            System.out.println("Se ha asignando la asignatura " + estudiante_asignaturaEj3.getId_asignatura()+ " al estudiante con id:"+ studentEj3.getId());


            /*
            boolean studen_existe = false;
            for(Student Student2:estudiante_asignatura.getStudent()){
                if(Student2.getId().equals(id_student)){
                    System.out.println("el estudiante ya existe en esta asignatura");
                    studen_existe = true;
                    break;
                }
            }

            if(!studen_existe){
                estudiante_asignatura.getStudent().add(student);
            }
            */
        }

        //id_studen en asignatura es string
/*
        Estudiante_asignatura estudiante_asignatura = new Estudiante_asignatura();
        for(int i = 0 ; i < lista_ids_de_asignaturas.size(); i++){

            Student student = repositorio_estudiante.getById(id_student);
            estudiante_asignatura = estudiante_asignatura_repository.findById(lista_ids_de_asignaturas.get(i).getId_asignaturas()).orElse(new Estudiante_asignatura());
            System.out.println("Se va a asignar la asignatura "+estudiante_asignatura+ " al usuario con id " +id_student);
            List<Student> lista_estudiantes = new ArrayList<>();
            //estudiante_asignatura.setStudent(lista_estudiantes);
            estudiante_asignatura.setIdStudent(id_student);
            System.out.println("se ha asignado la asignatura " +estudiante_asignatura);
            estudiante_asignatura_repository.save(estudiante_asignatura);

        }
*/
        return estudiante_asignaturaEj3;

    }

    private int get_index_of_asignatura_estudiante_en_estudiante( String id_asignatura, Student_ej3 studentEj3) {

        System.out.println("obteniendo indice");
        int i = 0;
        for (Estudiante_asignatura_ej3 asignatura : studentEj3.getEstudios()) {
            if (asignatura.getId_asignatura().equals(id_asignatura)) {
                System.out.println(" indice obtenido");
                return i;
            }
            i++;
        }

        System.out.println("indice no obtenido");

        return -1;

    }



}

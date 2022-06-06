package Todos_los_ejercicios.ejercicios.EJ3.Aplication.Estudiante_asignatura;

import Todos_los_ejercicios.ejercicios.EJ3.Domain.Estudiante_asignatura_ej3;
import Todos_los_ejercicios.ejercicios.EJ3.Exception.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.input.Estudiante_asignatura_input_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Controller.dto.output.Estudiante_Asignatura_output_dto.Estudiante_asignatura_output_dto;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Estudiante_asignatura_repository;
import Todos_los_ejercicios.ejercicios.EJ3.infrastructure.Repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Estudiante_asignatura_service_impl implements Estudiante_asignatura_service{

    @Autowired
    Estudiante_asignatura_repository estudiante_asignatura_repository;
    @Autowired
    Student_repository repositorio_estudiante;

    @Override
    public Estudiante_asignatura_ej3 find_by_id(String id) throws Exception_persona_404 {

        String texto_error = "(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id;
        return estudiante_asignatura_repository.findById(id).orElseThrow(()->new Exception_persona_404(texto_error));

    }

    @Override
    public List<Estudiante_asignatura_ej3> find_by_student_id(String id) {

        List<Estudiante_asignatura_ej3> lista_de_asignaturas = new ArrayList<>();

        for(Estudiante_asignatura_ej3 estudiante_asignaturaEj3 : estudiante_asignatura_repository.findAll()){

            //id_Student es clase student
            /*
            for(Student student_de_la_asignatura:estudiante_asignatura.getStudent()){
                if(student_de_la_asignatura.getId().equals(id)){
                    lista_de_asignaturas.add(new Estudiante_asignatura_output_dto(estudiante_asignatura));
                }
            }
*/
            //id_student en asignatura es string

            if(estudiante_asignaturaEj3.getStudentEj3() == null){
                continue;
            }

            if(estudiante_asignaturaEj3.getStudentEj3().getId().equals(id)){
                lista_de_asignaturas.add(estudiante_asignaturaEj3);
            }
        }

        return lista_de_asignaturas;

    }

    @Override
    public List<Estudiante_asignatura_ej3> find_all() {
        List<Estudiante_asignatura_ej3> listadto = estudiante_asignatura_repository.findAll();
        return listadto;
    }

    @Override
    public Estudiante_asignatura_ej3 create_entity(Estudiante_asignatura_input_dto persona_dto) {
        //añade
        Estudiante_asignatura_ej3 estudiante_asignaturaEj3 = new Estudiante_asignatura_ej3(persona_dto);
        System.err.println("estudiante asignatura " + estudiante_asignaturaEj3);
        estudiante_asignatura_repository.save(estudiante_asignaturaEj3);
        return estudiante_asignaturaEj3;
    }

    @Override
    public Estudiante_asignatura_ej3 update_entity(Estudiante_asignatura_input_dto persona_dto, String id) throws Exception_persona_404 {
        //comprobaciones
        if(find_by_id(id) == null){
            //devolver un 406 o 404
            throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +id);
        }

        Estudiante_asignatura_ej3 estudiante_asignaturaEj3 = new Estudiante_asignatura_ej3(persona_dto);
        estudiante_asignaturaEj3.setId_asignatura(id);
        estudiante_asignatura_repository.save(estudiante_asignaturaEj3);

        return estudiante_asignaturaEj3;
    }

    @Override
    public Estudiante_asignatura_ej3 delete_by_id(String id) throws Exception_persona_404 {
        if(find_by_id(id) == null){
            //devolver un 406 o un 404
            throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        }

        Estudiante_asignatura_ej3 estudiante_eliminado = find_by_id(id);
        estudiante_asignatura_repository.deleteById(id);

        return estudiante_eliminado;
    }

    @Override
    public void crear_asignaturas_en_repositorio(int numero) {

    }
}

package DBA1.Aplicacion;

import DBA1.Domain.Persona;
import DBA1.Excepciones.Exception_persona_404;
import DBA1.Excepciones.Exception_persona_422;
import DBA1.Infrastructure.repositorios.PersonaRepositorio_ej2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Service_persona_ej2_impl implements Service_persona_ej2{

    @Autowired
    PersonaRepositorio_ej2 persona_repositorio;

    @Override
    public Persona find_by_id(String id) throws Exception_persona_404 {
        return persona_repositorio.findById(Integer.valueOf(id)).orElseThrow(()->new Exception_persona_404("(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id));
        //return crear_output_dto(persona_ej2_encontrada);
    }

    @Override
    public List<Persona> find_by_user(String user, String ouputType) throws Exception {
        return persona_repositorio.findByusuario(user);
    }

    @Override
    public List<Persona> find_all(String ouputType) {
        return persona_repositorio.findAll();
        //return persona_repositorio.findAll().stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();
    }

    @Override
    public Persona create_persona(Persona persona_ej2) throws Exception {
        //comprobaciones
        if(!validar_usuario(persona_ej2)){
            return null;
        }

        //añade la persona  a la lista
        //Persona_ej2 persona_ej2_entity = new Persona_ej2(persona_ej2);
        System.out.println("id persona " + persona_ej2.getId_persona());
        persona_repositorio.save(persona_ej2);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(persona_ej2_entity);

        return persona_ej2;
    }

    @Override
    public Persona update_persona(Persona persona_ej2) throws Exception_persona_404 {
        //comprobaciones
        //if(find_by_id(persona_dto.id_persona()) == null){
        //devolver un 406 o 404
        //throw new Exception_persona_404("(Servicio_persona.update)No existe una persona con el id " +persona_dto.id_persona());
        //}
        if(!validar_usuario(persona_ej2)){
            return null;
        }

        //Persona_ej2 personaEj2 = new Persona_ej2(persona_dto);
        persona_repositorio.save(persona_ej2);
        //AsignacionOutputDTO persona_output_dto = crear_output_dto(personaEj2);

        return persona_ej2;
    }

    @Override
    public void delete_by_id(String id) throws Exception_persona_404 {
        if(find_by_id(id) == null){
            //devolver un 406 o un 404
            throw new Exception_persona_404("(Servicio_persona.delete_by_id)No existe una persona con el id " +id);
        }

        //AsignacionOutputDTO persona_eliminada = find_by_id(id);
        //persona_repositorio.deleteByIdPersona(id);
        persona_repositorio.deleteById(Integer.parseInt(id));

        //return persona_ej2;
    }

    private boolean validar_usuario(Persona persona_ej2) throws Exception_persona_422 {

        //if(/*persona_ej2.id_persona() == null  ||*/ persona_ej2.usuario() == null  || persona_ej2.password() == null ){
        if(/*persona_ej2.id_persona() == null  ||*/ persona_ej2.getUsuario() == null  || persona_ej2.getPassword() == null ){
            throw new Exception_persona_422("(Servicio_persona.validar_usuario)Ningún parametro puede ser nulo");
            //return false;
        }

        if(persona_ej2.getName() == null  || persona_ej2.getSurname() == null  || persona_ej2.getCompany_email() == null ){
            //if(persona_ej2.name() == null  || persona_ej2.surname() == null  || persona_ej2.company_email() == null ){
            throw new Exception_persona_422("(Servicio_persona.validar_usuario)Ningún parametro puede ser nulo");
            //return false;
        }

        //if(persona_ej2.personal_email() == null  || persona_ej2.city() == null  || persona_ej2.created_date() == null ){
        if(persona_ej2.getPersonal_email() == null  || persona_ej2.getCity() == null  || persona_ej2.getCreated_date() == null ){
            throw new Exception_persona_422("Ningún parametro puede ser nulo");
            //return false;
        }

        //if(persona_ej2.termination_date() == null || persona_ej2.imagen_url() == null ){
        if(persona_ej2.getTermination_date() == null || persona_ej2.getImagen_url() == null ){
            throw new Exception_persona_422("Ningún parametro puede ser nulo");
            //return false;
        }

        //if(persona_ej2.usuario().length() > 10 || persona_ej2.usuario().length() < 6 ){
        if(persona_ej2.getUsuario().length() > 10 || persona_ej2.getUsuario().length() < 6 ){
            throw new Exception_persona_422("El usuario es mayor a 10 o menor a 6 (" +persona_ej2.getUsuario().length()+ ")");
            //return false;
        }

        return true;
    }
}

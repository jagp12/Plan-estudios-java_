package DBA1.Aplicacion;

import DBA1.Domain.Persona;
import DBA1.Excepciones.Exception_persona_404;

import java.util.List;

public interface Service_persona_ej2 {
    Persona find_by_id(String id) throws Exception_persona_404;
    //AsignacionOutputDTO find_by_id(String id, String ouputType) throws Exception_persona_404;
    List<Persona> find_by_user(String user, String ouputType) throws Exception;
    List<Persona>  find_all(String ouputType);

    Persona create_persona(Persona persona_ej2) throws Exception;

    Persona update_persona(Persona persona_ej2) throws Exception_persona_404;

    void delete_by_id(String id) throws Exception_persona_404;
}

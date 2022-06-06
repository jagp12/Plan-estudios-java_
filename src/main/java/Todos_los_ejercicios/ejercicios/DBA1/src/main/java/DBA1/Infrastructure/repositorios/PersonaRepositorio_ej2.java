package DBA1.Infrastructure.repositorios;

import DBA1.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio_ej2 extends JpaRepository<Persona,Integer> {
    List<Persona> findByusuario(String usuario);
    //void deleteByIdPersona(String id);
}

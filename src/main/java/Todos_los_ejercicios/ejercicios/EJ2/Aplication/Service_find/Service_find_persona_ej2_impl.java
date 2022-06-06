package Todos_los_ejercicios.ejercicios.EJ2.Aplication.Service_find;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Employee_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;
import Todos_los_ejercicios.ejercicios.EJ2.Exceptions.Exception_persona_404;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Controllers.DTO.EmployeeRowMapper;
import Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository.PersonaRepositorio_ej2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Service
public class Service_find_persona_ej2_impl implements Service_find_persona_ej2 {

    @Autowired
    PersonaRepositorio_ej2 persona_repositorio;

    @Autowired
    PersonaRepositorio_ej2 personaRepositorio;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Persona_ej2 find_by_id(String id) throws Exception_persona_404 {
        return persona_repositorio.findById(Integer.valueOf(id)).orElseThrow(()->new Exception_persona_404("(Servicio_persona.find_by_id)No se ha encontrado una persona con el id " +id));
        //return crear_output_dto(persona_ej2_encontrada);
    }

    @Override
    public List<Persona_ej2> find_by_user(String user) throws Exception {
        return persona_repositorio.findByusuario(user);
    }

    @Override
    public List<Persona_ej2> find_by_user(String user, String ouputType) throws Exception {
        return persona_repositorio.findByusuario(user);
    }

    @Override
    public List<Persona_ej2> find_all(String ouputType) {
        return persona_repositorio.findAll();
        //return persona_repositorio.findAll().stream().map((personaEj2 -> crear_output_dto(personaEj2))).toList();
    }

    @Override
    public List<Persona_ej2> findByusuarioandnameandsurname(String usuario, String name, String surname, String createdDated, String order){
        return persona_repositorio.findByPreference(usuario,name,surname,createdDated,order);
    }
/*
    @Override
    public List<Persona_ej2> getData(HashMap<String, Object> conditions) {
        return null;//personaRepositorio.getData(conditions);
    }
*/
    NamedParameterJdbcTemplate template;
    public List<Employee_ej2> findallemployee() {
        return template.query("select * from employee", new EmployeeRowMapper());
    }
    @Override
    public List<Persona_ej2> getData(HashMap<String, Object> conditions)
    {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona_ej2> query= cb.createQuery(Persona_ej2.class);
        Root<Persona_ej2> root = query.from(Persona_ej2.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {

                case "usuario":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "created_date":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case "GREATER_THAN":
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case "LESS_THAN":
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case "EQUAL":
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
                /**/
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.asc(root.get((String) conditions.get("orderBy"))));
        return entityManager.createQuery(query).getResultList();
    }

}

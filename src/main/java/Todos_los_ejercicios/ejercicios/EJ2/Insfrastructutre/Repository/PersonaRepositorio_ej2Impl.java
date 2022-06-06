package Todos_los_ejercicios.ejercicios.EJ2.Insfrastructutre.Repository;

import Todos_los_ejercicios.ejercicios.EJ2.Domain.Persona_ej2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//import static sun.tools.jconsole.Messages.GREATER_THAN;
//import static sun.tools.jconsole.Messages.LESS_THAN;

public class PersonaRepositorio_ej2Impl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Persona_ej2> getData(HashMap<String, Object> conditions)
    {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona_ej2> query= cb.createQuery(Persona_ej2.class);
        Root<Persona_ej2> root = query.from(Persona_ej2.class);

         String orden ;

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

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy((Order) conditions.get("orderBy"));
        return entityManager.createQuery(query).getResultList();
    }

}

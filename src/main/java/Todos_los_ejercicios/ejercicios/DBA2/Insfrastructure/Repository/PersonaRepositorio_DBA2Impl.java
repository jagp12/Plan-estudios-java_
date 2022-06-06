package Todos_los_ejercicios.ejercicios.DBA2.Insfrastructure.Repository;


public class PersonaRepositorio_DBA2Impl/* implements PersonaRepositorio_DBA2_Custom */{
/*
    private final MongoTemplate mongoTemplate;

    public PersonaRepositorio_DBA2Impl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Persona_DBA2 addPersona(Persona_DBA2 persona) throws Exception {
        mongoTemplate.insert(persona);
        return null;
    }

    @Override
    public void deletePerson(int i) {
        mongoTemplate.remove(i);
    }

    @Override
    public Persona_DBA2 updatePerson(Persona_DBA2 persona, int id) {
        mongoTemplate.save(persona);
        return null;
    }

    @Override
    public Persona_DBA2 findByIdPerson(Persona_DBA2 persona) throws Exception {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        criteria.add(Criteria.where("id_persona").regex(MongoRegexCreator.INSTANCE.toRegularExpression(String.valueOf(persona.getId_persona()), null), "i"));
        if(!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        mongoTemplate.find(query, Persona_DBA2.class);
        return null;
    }
    */
}

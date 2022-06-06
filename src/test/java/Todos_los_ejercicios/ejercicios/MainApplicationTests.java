package Todos_los_ejercicios.ejercicios;

import Todos_los_ejercicios.ejercicios.DBA2.Aplication.delete.Service_delete_persona_DBA2;
import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.create.Service_create_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.delete.Service_delete_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.find.Service_find_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Aplication.update.Service_update_persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Domain.Persona_EJTE_1;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Controllers.DTO.PersonaOutputDTO;
import Todos_los_ejercicios.ejercicios.EJTE_1.Insfrastructutre.Repository.PersonaRepositorio_EJTE_1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;



@SpringBootTest
class MainApplicationTests {

	@MockBean
	Service_create_persona_EJTE_1 createPerson;
	@MockBean
	Service_find_persona_EJTE_1 find_persona_ejte_1;
	@MockBean
	Service_delete_persona_EJTE_1 delete_persona_ejte_1;
	@MockBean
	Service_update_persona_EJTE_1 update_persona_ejte_1;

	//@Autowired

/*
	@Test
	void contextLoads() throws Exception {
		test_persona test_persona = new test_persona();
		starting();
	}*/
	/*Persona_EJTE_1 persona;
	@BeforeAll
	public  void creatar_persona() {

		this.persona = persona_De_prueba();

	}*/

	//@Autowired
	//private MockMvc mockMvc;
	@MockBean
	private PersonaRepositorio_EJTE_1 repositorio_ejte_1_mock;

	@Before
	public void init() throws Exception {
		Persona_EJTE_1 persona = persona_De_prueba();
		when(repositorio_ejte_1_mock.save(persona)).thenReturn(persona);
	}

	@Test
	@DisplayName("Created test")
	public  void created_test() throws Exception {

		Persona_EJTE_1 persona = Mockito.mock(Persona_EJTE_1.class);

		System.out.println("he creado una persona en los test "+createPerson.create_persona(persona)+"/"+persona);
		//assertEquals(repositorio_ejte_1_mock.save(persona).hashCode(), persona.hashCode());
	}

	@Test
	@DisplayName("update test")
	public  void update_test() throws Exception {

		Persona_EJTE_1 persona = persona_De_prueba();

		System.out.println("he creado una persona en los test");
		//assertEquals(update_persona_ejte_1.update_persona(persona), persona);
	}

	@Test
	@DisplayName("get test")
	public  void get_persona_Test() throws Exception {

		Persona_EJTE_1 persona = persona_De_prueba();
		repositorio_ejte_1_mock.save(persona);
		System.out.println("he pedido la persona con el id 1 en los test "+persona+"/"+repositorio_ejte_1_mock.findById(1));

		assertNotNull(repositorio_ejte_1_mock.findById(1));

	}
/*
	@Test
	@DisplayName("get not found test")
	public void get_personaNotFound_404() throws Exception {
		mockMvc.perform(get("http://localhost:8080/EJTE_1/find/getid/1?outputType=full")).andExpect(status().isNotFound());
	}
*/
	@Test
	@DisplayName("delete test")
	public  void delete_persona_Test() throws Exception {

		Persona_EJTE_1 persona = persona_De_prueba();
		createPerson.create_persona(persona);
		System.out.println("he pedido la persona con el id 1 en los test");
		//asse(delete_persona_ejte_1.delete_by_id("1"),void);

	}

	private Persona_EJTE_1 persona_De_prueba(){
		Persona_EJTE_1 persona = new Persona_EJTE_1();
		//persona.setId_persona(1);
		persona.setUsuario("pepe");
		persona.setPassword("1234");
		persona.setName("pepe");
		persona.setSurname("pepe1 pepe2");
		persona.setCompany_email("pepe@gmail.com");
		persona.setPersonal_email("personaemail@gmail.com");
		persona.setActive(true);
		persona.setCreated(LocalDate.of(2008, 12, 12));
		persona.setTermination(LocalDate.of(2018, 12, 12));
		persona.setImagen_url("http...");

		return persona;
	}

}

package Todos_los_ejercicios.ejercicios;

import Todos_los_ejercicios.ejercicios.SA2.Application.FileSystemStorageService;
import Todos_los_ejercicios.ejercicios.SA2.Application.StorageProperties;
import Todos_los_ejercicios.ejercicios.SA2.Application.StorageService;
import Todos_los_ejercicios.ejercicios.shared.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableFeignClients
//@EnableWebSecurity
//@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
public class MainApplication {// extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	//ejercicio SA2
	@Bean
	StorageService init() {

		StorageProperties strorageProperties = new StorageProperties();
		return new FileSystemStorageService(strorageProperties);
		/*return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
		*/
	}

	//security ejercicio ej3 y spring cloud
	//@Override
//	public void configure(HttpSecurity http) throws Exception{

//		http.csrf().disable()
//				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//				.authorizeRequests()
				//rutas generales
//				.antMatchers(HttpMethod.GET,"/").permitAll()
//				.antMatchers(HttpMethod.GET,"/swagger-ui/index.html").permitAll()
//				.antMatchers("/spring_cloud/login").permitAll()

//				.antMatchers(HttpMethod.GET,"http://localhost:8080/h2-console").permitAll()
//				.antMatchers(HttpMethod.GET,"http://localhost:8080/h2-console").permitAll()
//				.antMatchers(HttpMethod.GET,"http://http://localhost:8080/h2-console/login.do?jsessionid").permitAll()
//				.antMatchers(HttpMethod.POST,"http://http://localhost:8080/h2-console/login.do?jsessionid").permitAll()
//				.antMatchers(HttpMethod.PUT,"http://http://localhost:8080/h2-console/login.do?jsessionid").permitAll()
//				.antMatchers(HttpMethod.DELETE,"http://http://localhost:8080/h2-console/login.do?jsessionid").permitAll()

				//otros
// 				.antMatchers(HttpMethod.GET).permitAll()
//				.antMatchers(HttpMethod.POST).permitAll()
//				.antMatchers(HttpMethod.PUT).permitAll()
//				.antMatchers(HttpMethod.PATCH).permitAll()
//				.antMatchers(HttpMethod.DELETE).permitAll()
//				.antMatchers(HttpMethod.HEAD).permitAll()
//				.antMatchers(HttpMethod.OPTIONS).permitAll()
//				.antMatchers(HttpMethod.TRACE).permitAll()
//				.antMatchers(HttpMethod.GET).permitAll()

				//rutas proyecto ej3
//				.antMatchers("/EJ3/login").permitAll()
//				.antMatchers("/spring_cloud/token").permitAll()
//				.antMatchers(HttpMethod.GET, "/EJ3/persona/all").hasAnyRole("USER", "ADMIN")
//				.antMatchers(HttpMethod.POST).hasAnyRole( "ADMIN")//.antMatchers(HttpMethod.POST, "EJ3/persona").hasAnyRole( "ADMIN")
//				.antMatchers(HttpMethod.GET,"/spring_cloud/reserva/{ciudadDestino}").hasAnyRole( "ADMIN")
//				.antMatchers(HttpMethod.PUT).hasAnyRole( "ADMIN")//.antMatchers(HttpMethod.PUT, "EJ3/persona/{id}").hasAnyRole( "ADMIN")
//				.antMatchers(HttpMethod.DELETE).hasAnyRole( "ADMIN")//.antMatchers(HttpMethod.DELETE, "EJ3/persona/{id}").hasAnyRole( "ADMIN")

				//rutas proyecto spring cloud
//				.antMatchers("/EJ3/login").permitAll()
//				.antMatchers(HttpMethod.GET, "/spring_cloud/get_plazas_libres").hasAnyRole("USER", "ADMIN")

//				.anyRequest().authenticated();

//	}

}

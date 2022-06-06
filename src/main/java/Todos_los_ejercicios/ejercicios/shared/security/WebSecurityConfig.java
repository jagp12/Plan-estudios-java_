package Todos_los_ejercicios.ejercicios.shared.security;

import org.springframework.http.HttpMethod;
/*
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
*/
///esta clase está en el main
public class WebSecurityConfig{/* extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                //rutas generales
                .antMatchers("/").permitAll()
                //.antMatchers("/swagger-ui/index.html").permitAll()
                //.antMatchers("/spring_cloud/login").permitAll()

                //rutas proyecto ej3
                .antMatchers("/EJ3/login").permitAll()
                .antMatchers("/spring_cloud/token").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                //.antMatchers(HttpMethod.GET, "/EJ3/persona/all").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST).hasAnyRole( "ADMIN")//.antMatchers(HttpMethod.POST, "EJ3/persona").hasAnyRole( "ADMIN")
                //.antMatchers(HttpMethod.PUT).hasAnyRole( "ADMIN")//.antMatchers(HttpMethod.PUT, "EJ3/persona/{id}").hasAnyRole( "ADMIN")
                //.antMatchers(HttpMethod.DELETE).hasAnyRole( "ADMIN")//.antMatchers(HttpMethod.DELETE, "EJ3/persona/{id}").hasAnyRole( "ADMIN")

                //rutas proyecto spring cloud
                //.antMatchers("/EJ3/login").permitAll()
                .antMatchers(HttpMethod.GET, "/spring_cloud/get_plazas_libres").hasAnyRole("USER", "ADMIN")


                .anyRequest().authenticated();

    }*/
}

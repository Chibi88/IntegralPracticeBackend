package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        protected void configure(HttpSecurity http) throws Exception{
                http
                        .csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/altaTurnos.html").hasRole("USER")
                        .antMatchers("/altaPaciente.html").hasRole("ADMIN")
                        .antMatchers("/altaOdontologo.html").hasRole("ADMIN")
                        .antMatchers("/altaTurnos.html").hasRole("ADMIN")
                        .antMatchers("/buscarPacientes.html").hasRole("ADMIN")
                        .antMatchers("/editarPaciente.html").hasRole("ADMIN")
                        .antMatchers("/modificarPaciente.html").hasRole("ADMIN")
                        .antMatchers("/buscarPacientes.html").hasRole("ADMIN")
                        .antMatchers("/odontologos.html").hasRole("ADMIN")
                        .antMatchers("/pacientes.html").hasRole("ADMIN")
                        .antMatchers("/turnos.html").hasRole("ADMIN")
                        .anyRequest()
                        .permitAll()
                        .and()
                        .formLogin()
                        .and()
                        .logout();
        }}
// Si no corre automaticamente el archivo import.sql crear roles,
// Usuarios y sus relaciones
// INSERT INTO ROLES(ID, NAME) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USUARIO');
//INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (1, 'admin', 'admin'), (2, 'user', 'user');
//INSERT INTO USER_ROLES (ID_USER, ID_ROL) VALUES (1, 1), (1,2), (2, 2);
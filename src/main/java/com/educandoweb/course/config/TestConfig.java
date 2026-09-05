package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration	//classe de configuração especifica para o perfil de teste - serve para popular o bd com objs
@Profile("test")
public class TestConfig implements CommandLineRunner{	//CommandLineRunner - usado para rodar quando o programa for iniciado

	//injetando dependencia - essa classe tera dependencia com o UserRepository (repositotrio de dados)
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		//salvando no bd as instanciacoes
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
	
}

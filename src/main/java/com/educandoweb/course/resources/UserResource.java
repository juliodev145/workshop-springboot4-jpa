package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//implementando recurso web que e implementado por um controlador rest

@RestController	
@RequestMapping(value = "/users")
public class UserResource {

	//endpoint para acesar os usuarios
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@email.com", "999999999", "12345");
		return ResponseEntity.ok().body(u);
		
	}
	
}

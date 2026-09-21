package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//implementando recurso web que e implementado por um controlador rest

@RestController	
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	
	//endpoint para acesar os usuarios
	@GetMapping //
	public ResponseEntity<List<Order>> findAll(){  //ResponseEntity - tipo de retorno que faz retornar respostas de requisições web
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")	//{} - dinâmico
	public ResponseEntity<Order> findById(@PathVariable Long id){  //@PathVariable serve para pegar um valor que está na URL e colocá-lo em uma variável Java.
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}

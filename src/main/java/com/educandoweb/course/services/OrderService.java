package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//REGRAS DE NEGÓCIO

@Service //registro de componentes - classes que podem ser injetados pelo Autowired
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//listar todos os usuários
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);  //Optional - "Pode existir um Order aqui, mas talvez não exista."
		return obj.get();
	}
	
}

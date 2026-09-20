package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//REGRAS DE NEGÓCIO

@Service //registro de componentes - classes que podem ser injetados pelo Autowired
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//listar todos os usuários
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);  //Optional - "Pode existir um User aqui, mas talvez não exista."
		return obj.get();
	}
	
}

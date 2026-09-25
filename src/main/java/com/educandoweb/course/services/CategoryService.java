package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//REGRAS DE NEGÓCIO

@Service //registro de componentes - classes que podem ser injetados pelo Autowired
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//listar todos os usuários
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);  //Optional - "Pode existir um Category aqui, mas talvez não exista."
		return obj.get();
	}
	
}

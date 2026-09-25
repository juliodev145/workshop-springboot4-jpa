package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//REGRAS DE NEGÓCIO

@Service //registro de componentes - classes que podem ser injetados pelo Autowired
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//listar todos os usuários
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);  //Optional - "Pode existir um Product aqui, mas talvez não exista."
		return obj.get();
	}
	
}

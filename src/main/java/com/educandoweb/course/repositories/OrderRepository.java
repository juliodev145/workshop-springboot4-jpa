package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;


//Os repositórios são interfaces
//É opcional colocar a annotation pois o JpaRepository já é registrado como componente.
public interface OrderRepository extends JpaRepository<Order, Long> {	//tipo da entidade, tipo do ID
	
}

package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_user")	//para nao dar conflito com a palavra reservada User no bd
public class User implements Serializable { //Serializable serve para transformar o objeto em cadeia de bytes (trafegue na rede, gravado em arquivos etc)
	
	private static final long serialVersionUID = 1L; //Serializable tem que ter um numero de serie

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//auto-incremento
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//acrescentando associação (1 - N)
	@OneToMany(mappedBy = "client") 
	private List<Order> orders = new ArrayList<>();

	// é obrigado pelo framework
	public User() {

	}

	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {	
		// Gera um número (hash) usando o ID do User.
		// O hashCode é utilizado pelo Java em estruturas como HashSet e HashMap para localizar objetos com mais eficiência.
		return Objects.hash(id);	
	}

	@Override
	public boolean equals(Object obj) {
		// Verifica se os dois objetos são exatamente o mesmo objeto na memória. Se forem, já podemos dizer que são iguais.
		if (this == obj)
			return true;
		// Se o objeto que estamos comparando for null, ele não pode ser igual a este User.
		if (obj == null)
			return false;
		// Verifica se os dois objetos pertencem à mesma classe. Um User não deve ser comparado como se fosse outra entidade.
		if (getClass() != obj.getClass())
			return false;
		// O parâmetro obj é recebido como Object. Como já verificamos que ele é da mesma classe, podemos convertê-lo para User.
		User other = (User) obj;
		// Compara os IDs dos dois Users. Neste código, dois Users são considerados iguais quando possuem o mesmo ID.
		return Objects.equals(id, other.id);
	}

}

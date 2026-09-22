package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	//São enumerados do seguinte padrão
	//STATUSA,	0
	//STATUSB,	1
	//STATUSC,	2
	//No futuro, caso queira colocar outro status entre o B e C, dará conflito e 
	//o banco ficará errado
	
	//Para evitar é preciso criar os valores numericos manualmente para cada um:
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	//converter o valor numerico para o tipo enumerado
	public static OrderStatus valueOf(int code) { //static pois vai funcionar sem precisar instanciar
		//validação de codigo para retornar o valor 
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
}

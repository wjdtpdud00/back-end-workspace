package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {

	public static void main(String[] args) {
		Customer customer1 = new Customer("이상현"); // CUSTOMER생성자를 호출한것임
		//customer1.setName("이상현");
		Customer customer2 = new Customer("이상호");
		//둘의 내용은같지만, 주소값은 다름
		System.out.println(customer1);
		System.out.println(customer2);
		
		// false
		System.out.println(customer1 == customer2);
		
		//false > equals는 자바오브젝트에 있는것이여서 재정의 가능
		//equals로 customer 1,2가 동일한지 비교함
		System.out.println(customer1.equals(customer2));// true
	
		System.out.println();
		
		VIPCustomer customer3 = new VIPCustomer("정세영");
		VIPCustomer customer4 = new VIPCustomer("정회영");
		//true / customer상속받았기 때문임.
		System.out.println(customer3.equals(customer4));
		
		// customer1 또는 customer2
		// customer3 또는 customer4
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다.
		// 위의 문자, customer클래스의 c
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
			customer1.getName(), customer1.getGrade(), customer1.calcPrice(1000), customer1.getBonusPoint());
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.",
				customer3.getName(), customer3.getGrade(), customer3.calcPrice(1000), customer3.getBonusPoint());
		}
	
}

	
	
	
	
	


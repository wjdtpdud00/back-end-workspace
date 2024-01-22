package com.kh._abstract.step2;

public class PotatoPizza extends Pizza {

	//강제화 
	@Override
	public void topping() {
		System.out.println("Potato Topping");
	}



	public PotatoPizza(int price, String brand) {
	}

	
}

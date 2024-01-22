package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {
	
	//강제화
	@Override
	public void topping() {
		System.out.println("Bulgogi Topping ...");
	}


	public BulgogiPizza(int price, String brand) {
		super(price, brand);
		
	}
	
	
}

package com.coupang.model;

import java.util.Date;

public class Purchase {
	private int purCode;//구매 코드
    private Date purDate; //구매 일시 
    private String purStatus;
    
    private Customer customer;
    private Product product;
}

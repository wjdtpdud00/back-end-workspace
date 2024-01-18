package com.coupang.model;

import java.util.Date;

public class Swap {
	private int swapCode;//교환 반품 코드
    private String reason;//사유
    private Date swapDate;
    private int price;//비용
    private int swapStatus;//교환/반품 
    
    private Customer customer;
    private Product product;
}

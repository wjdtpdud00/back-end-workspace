package com.coupang.model;

import java.util.Date;

public class Product {


	private int prodCode; // 상품코드
    private String prodName;// 상품명
    private String prodDesc; //상품설명 
    private int price; //가격
    private int stock;//재고수량
    private Date prodDate; //상품등록일
    
    private Enterprise enterprise;
    private Category category;
    
}

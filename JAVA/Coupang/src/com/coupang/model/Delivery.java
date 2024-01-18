package com.coupang.model;

import java.util.Date;

public class Delivery {
	private int deliCode;//배송코드
    private Date deliDate; //배송 날짜
    private String deliCompany;//배송사
    private int deliCost;//배송비
    private String deliAddr; //배송 주소 
    
    private Purchase purchase;
}

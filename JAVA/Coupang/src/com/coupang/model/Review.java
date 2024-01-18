package com.coupang.model;

import java.util.Date;

public class Review {
	private int reviCode;//리뷰코드
    private String reviTitle;//제목
    private Date revi_date; //작성 날짜
    private int rating;//평점
    
    private Customer customer;
    private Product product;
}

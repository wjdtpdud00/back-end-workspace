package com.coupang.model;

import java.util.Date;

public class Coupon {
	private int couponCode;//쿠폰 코드
    private String couponName;//쿠폰명
    private Date expiryDate; //사용 기한

    private Customer customer;
    private Product product;
}

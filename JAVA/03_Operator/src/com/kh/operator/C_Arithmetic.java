package com.kh.operator;

public class C_Arithmetic {
	public static void main(String[] args) {
		// 생성자 생성
		C_Arithmetic c = new  C_Arithmetic();
		//c.method1();
		c.method2();
		
	}
	
	public void mehthod1() {
		int num1 = 10;
		int num2 = 3; 
		
		System.out.println("+ :" +  num1 + num2);
		//103으로 인식 > 괄호가 없어서 문자로 인식하기 때문이다.
		System.out.println("- : " + (num1 - num2));//7
		System.out.println("* :" + (num1 * num2));//30
		System.out.println("/ :" + (num1 / num2));//3
		System.out.println("% :" + (num1 % num2));//1
	}
	public void method2() {
		int a = 5; 
		int b = 10;
		int c = (++a) + b; //6 + 10 | a = 6 
		int d = c / a;// 16/6 = 2 | c =  16 | d=2
		int e = c % a;// 16 % 6 = 4 
		int f = e++; // f = 4 | e = 5
		int g = (--b) + (d--);// 9 + 2 = 11 | g = 11| b= 9| d=1
		int h = 2;
		int i = (a++) + b / (--c / f) * (g-- -d) % (++e +h);
        // 6  +  9/ (15/4)*(11 - 2)%(6 + 2)    
        //         6+9 / 3 * 9 % 8 
        //          6 + 3*9 % 8(3) = 9
		
	}
	
 }		               























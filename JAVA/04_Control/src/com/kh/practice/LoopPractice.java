package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();
	}
	
	Scanner sc = new Scanner(System.in);
    /*
        1. 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.println("사용자 입력 > ");
    	// 해당 번째까지 반복문 , 끝이 정해진 for문
    	int num = sc.nextInt();
    	for(int i = num; i >= 1; i--) {
    		System.out.println(i);
    	}
    }

    // 2. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	// n, -2n // 끝이 정해지지 않음 while
    	int sum = 0;
    	int num = 1;
    	
    	while(sum < 100) {
    		if(num % 2 == 0) {
    			sum += -num;
    		}else {
    			sum += num;
    		}
    	}
    	
    }

    /*
        3. 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.println("문자열 : ");
    	String str = sc.nextLine();

    	System.out.println("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	// 몇개인지는 count
    	// 문자열로도 나타내야함
    	int count= 0; // 횟수 담아낼거임
    	for(int i=0; i<str.length(); i++) {
    		if(ch == str.charAt(i)) count++;
    	}
    	System.out.println(str + "안에 포함된" + ch + "개수 : " + count);
    }
    

    /*
        4. 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	while(true) {
    	// random범위 정하기
    	int random = (int)(Math.random() * 11);
    	
    	System.out.println(random);
    	// while ~일 동안
    	if(random == 0) break;
    	}
    }

    /*
        5. 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	
    	
    	for(int i=0; i < 10; i++) {
	    	// 몇번째 주사위인지 표현
	    	int[] dice = new int[6];
	    	// 눈의값은 1~6까지 : 0*6 +1 <  random*6+1 < 1*6+1
	    	int random = (int)(Math.random()*6 +1);
	    	// count 필요
	    	switch(random) {
	    		// 각 주사위의 눈의 경우
		    	case 1 :
		    		dice[0]++;
		    	case 2 :
		    		dice[1]++;
		    	case 3 :
		    		dice[2]++;
		    	case 4 :
		    		dice[3]++;
		    	case 5 :
		    		dice[4]++;
		    	case 6 :
		    		dice[5]++;
		    		}
		    	// 1~6 case
    	}
   }
    	

    /*
        6. 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
    */
 public void method6() {
    	
    	String[] rps = {"가위", "바위", "보"};
    	int win = 0;
    	int lose = 0;
    	int draw = 0;
    	
    	
    	System.out.println("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.println("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		// 사용자가 입력한 문자열이, 배열의 몇번째인지 찾아 주어야함.
    		int number = Arrays.asList(rps).indexOf(input);
    		// 배열에서 값으로 인덱스 찾기 -> 리스트로 만들기 -> 몇번째 인지 찾기 
    		//rps[number] : 컴퓨터가 어떤것을 내었는지 나타냄
    		
    		// 사용자가 낸것
    		System.out.println("사용자 : " + rps[number]);
    		
    		// 컴퓨터가 낸것
    		// 0 - 가위, 1 -  바위, 2- 보 random
    		int computer = (int)(Math.random() * 3);
    		System.out.println("컴퓨터 : " + rps[computer]);
    		
    		// 경우의 수별로 나오게끔
    		if(number == 0 && computer == 0) {
    			draw++;
    			System.out.println("비겼습니다.");
    		} else if((number == 0 && computer == 2)
    			|| (number == 1 && computer == 0)
    			|| (number == 2 && computer == 1)) {
    			win++;
    			System.out.println("이겼습니다.");
    		} else if((number == 0 && computer == 1)
    				|| (number == 1 && computer == 0)
    				|| (number == 2 && computer == 2)) {
    			lose++;
    			System.out.println("졌습니다.");
    		}
    		// 횟수도 같이 세줌
    		
    		System.out.println("비긴 횟수 : " + draw + ", 진 횟수 : " + lose + "이긴 횟수 : " + win);
    		// 총 결과값 나오게끔 출력

    	}
  	
    }

}
/*
 * 작명 규칙
 * 1. 변수명, 함수명
 * - camelCase : 첫글자는 소문자로, 그이후 연결된 문자들은 첫글자 대문자로 표기
 * 
 * 2. 클래스명
 * - 파스칼 표기법 : 첫글자를 대문자로 표기
 * 
 * */


package com.kh.practice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionPractice {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//생성자 
		ConditionPractice p = new ConditionPractice();
//		p.practice1();
//		p.practice2();
//		p.practice3();
//		p.practice3();
//		p.practice5();
//		p.practice6();
//		p.practice7();
//		p.practice8();
//		p.practice9();
//		p.practice10();
		p.practice11();
	}

	/*
	 * 1. 키보드로 정수를 입력 받은 정수가 양수이면서 짝수일 때만 
	 * “짝수다”를 출력하고 짝수가 아니면 “홀수다“를 출력하세요. 양수가 아니면
	 * “양수만 입력해주세요.”를 출력하세요.
	 * 
	 * 숫자를 한 개 입력하세요 : -8 양수만 입력해주세요.
	 */
	public void practice1() {
		
		System.out.println("숫자를 한 개 입력하세요 : ");
		int number = sc.nextInt();
//      
//		[if문 1개쓰는 방식]
//		if(number <= 0) {
//			System.out.println("양수만 입력해주세요");
//		}else if(number % 2 == 0) {  // 아래부터는 양수인것만 들어올테니.
//			System.out.println("짝수다");			
//		}else
//			System.out.println("홀수다");
//		
//		[if문 2개쓰는 방식]
		if(number >= 0) {
			if(number % 2 == 0) {
				System.out.println("짝수다");
			}else {
				System.out.println("홀수다");
			}
		}else 
			System.out.println("양수만 입력해주세요");
	}
	
	

	/*
	 * 2. 정수 num1과 num2가를 입력 받아서 두 수가 같으면 1 다르면 -1을 출력하세요.
	 * 
	 * num1 : 2 num2 : 3 -1
	 * 
	 * num1 : 11 num2 : 11 1
	 */
	public void practice2() {
		System.out.println("숫자를 입력하시오 > ");
		int num1 = sc.nextInt();
		System.out.println("숫자를 입력하시오 > ");
		int num2 = sc.nextInt();
		
		//[삼항자 사용]
		//변수선언 = ? : ;
//		int result = (num1 == num2)? 1: -1;
//		System.out.println(result);
		
		//[if문 사용]
		if(num1 ==  num2) {
			System.out.println(1);
		}else 
			System.out.println(-1);
		
	}

	/*
	 * 3. A 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
	 * 	  피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 한 조각 이상 
	 * 	  피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요.
	 * 
	 * 피자 조각 수 : 7 피자 먹는 사람 수 : 10 2 // 조각나머지가 생겼을때 +1
	 * 
	 */
	public void practice3() {
		//피자 조각 수
		//피자를 먹는 사람의 수
		// 가정 : 7조각 3사람  2조각
		//       3조각 5사람  +1조각
		System.out.println("먹는 인원 수를 입력하시오 > ");
		int people = sc.nextInt();
		System.out.println("피자 조각 수를 입력하시오 > ");
		int pizza = sc.nextInt();
//		
//		// 필요한것? 조각이 남을때 안남을때
//		int result = (pizza%people!= 0)? (people/pizza)+1 : (people%pizza);
//		System.out.println(result);
//		
		
//		[if문 사용]
		int result = pizza/people;
		
		if(people % pizza == 0) {
			result++;
		}System.out.println(result);
	}

	/*
	 * 4. 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고 
	 * 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요. (합격 조건 : 세 과목의 점수가 
	 * 각각 40점 이상이면서 평균이 60점 이상일 경우) 합격 했을 경우 과목 별 점수와
	 * 합계, 평균, “축하합니다, 합격입니다!”를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
	 * 
	 * 국어점수 : 88 수학점수 : 50 영어점수 : 40 불합격입니다.
	 * 
	 * 국어점수 : 88 수학점수 : 50 영어점수 : 45 합계 : 183 평균 : 61.0 축하합니다, 합격입니다!
	 */
	 public void practice4() {
	    	System.out.print("국어점수 : ");
	    	int korea = sc.nextInt();
	    	
	    	System.out.print("수학점수 : ");
	    	int math = sc.nextInt();
	    	
	    	System.out.print("영어점수 : ");
	    	int english = sc.nextInt();
	    	
	    	int sum = korea + math + english;
	    	double avg = (double)(sum) / 3;
	    	
	    	if(korea >= 40 && math >= 40 && english >= 40) {
	    		System.out.println("합계 : " + sum);
	    		System.out.printf("평균 : %.2f\n", avg);
	    		System.out.println("축하합니다, 합격입니다!");
	    	} else {
	    		System.out.println("불합격입니다.");
	    	}
	    }

	/*
	 * 5. B 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만원 이상 사면 20%를 할인해준다. 
	 * 구매한 옷의 가격을 입력했을 때, 지불해야 할 금액을 출력하세요.
	 * 
	 * 구매한 옷 가격 : 580,000 464,000
	 */
	public void practice5() {
		
			System.out.println("구매한 옷의 가격을 입력하시오 > ");
			//필요한 변수
			int price = Integer.parseInt(sc.nextLine());
			
			if(price >= 100000) {
				price = (int) (price * 0.95);
			}else if(price >= 300000) {
				price = (int) (price * 0.9);
			}else if (price >= 500000) {
				price = (int) (price * 0.8);
			}
			
			/* [DecimalFormat - 돈 단위 표시 설정]
			DecimalFormat df = new DecimalFormat("###,###");
			System.out.println(df.format(price));
			*/
			
	}

	/*
	 * 6. 각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 
	 * 둔각 180도는 평각으로 분류한다. 입력받은 각에
	 * 따라 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 출력하세요.
	 */
	public void practice6() {
		
		 System.out.println("각도를 입력하시오 > ");
		// 필요한값
		 int angle = sc.nextInt(); 
		 int result = 0; // 초기값 태어난것.
		 

		if(0 < angle && angle < 90 ) {
			result = (int)1;
		}else if(angle == 90) {
			result = (int)2;
		}else if(90 < angle && angle < 180) {
			result = (int)3;
		}else if (angle == 180) {
			result = (int)4;
			
		}else 
		System.out.println("올바른 각이 아닙니다.");
		System.out.println(result);
		
	}

	/*
	 * 7. 아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요. 로그인 성공 시 “로그인 성공”,
	 * 아이디가 틀렸을 시 “아이디가 틀렸습니다.“, 비밀번호가 틀렸을 시 “비밀번호가 틀렸습니다.”를 출력하세요.
	 * 
	 * 아이디 : happy 비밀번호 : 1234 로그인 성공!
	 * 
	 * 아이디 : happy 비밀번호 : 23467 비밀번호가 틀렸습니다.
	 * 
	 * 아이디 : happy222 비밀번호 : 1234 아이디가 틀렸습니다.
	 */
	public void practice7() {
		System.out.println("아이디를 입력하시오 > ");
		String id = sc.nextLine();

		System.out.println("비밀번호를 입력하시오 > ");
		int pw = sc.nextInt();
		
		String result = " ";// 초기값과동시에 변수가 탄생
		/*
		// 제일 까다로운걸 if첫번째로~
		//문자열 끼리 비교할 때에는 equls사용
		 * */
		if(id.equals("happy") && pw == (int)1234) {
			result = "로그인 성공!";
		}else if(id != "happy" && pw == (int)1234) {
			result = "아이디가 틀렸습니다.";
		}else if(id.equals("happy") && pw != (int)1234) {
			result = "비밀번호가 틀렸습니다.";
		}else 
		System.out.println("로그인 실패");
		System.out.println(result);
		
	} //

	/*
	 * 8. 키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 저체중 / 정상체중 
	 * / 과체중 / 비만을 출력하세요.BMI = 몸무게 / (키(m) * 키(m)) BMI가 18.5미만일 경우 저체중 
	 * / 18.5이상 23미만일 경우 정상체중 BMI가 23이상 25미만일 경우 과체중 / 
	 * 25이상 30미만일 경우 비만 BMI가 30이상일 경우 고도 비만입니다.
	 * 
	 * 키(m)를 입력해 주세요 : 1.62 
	 * 몸무게(kg)를 입력해 주세요 : 46 
	 * BMI 지수 : 17.527815881725342 저체중
	 * 
	 */
	public void practice8() {
//		// 필요한 변수
//		System.out.println("키를 입력하시오 > ");
//		double m = sc.nextDouble();
//
//		System.out.println("몸무게를 입력하시오 > ");
//		double kg = sc.nextDouble();
//		
//		//소수점 까지 담을것임  > double
//		double bmi = kg / (m * m);
//		System.out.println("BMI 지수 : " + bmi);
//		// 결과값 담기 
//		String result = "";
//
//		if(bmi >= 30) {
//			System.out.println("고도비만");
//		}else if(bmi >= 25) {
//			System.out.println("비만");
//		}else if(bmi >= 23) {
//			System.out.println("과체중");
//			
//		}else if(bmi >= 18.5){
//			System.out.println("정상체중");
//			
//		}else {
//			System.out.println("저체중");
//			
//		}
		
	}
	
	
	//# 학습동영상 필요 #
	/*
	 * 9. 키보드로 두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 
	 * 연산 결과를 출력하세요. (단, 양수가 아닌 값을 입력하거나
	 * 제시되어 있지 않은 연산 기호를 입력 했을 시 “잘못 입력하셨습니다. 프로그램을 종료합니다.” 출력)
	 * 
	 * 숫자 입력 : 15 숫자 입력 : 4 연산자를 입력(+,-,*,/,%) : / 15 / 4 = 3
	 * 
	 */
	public void practice9() {
			System.out.print("숫자 입력 : ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.print("숫자 입력 : ");
			int num2 = Integer.parseInt(sc.nextLine());
			System.out.print("연산자를  입력(+,-,*,/,%) : ");
			char op = sc.nextLine().charAt(0);
			
//			if(num1 <= 0 && num2 > 0) {
//				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
//				return; // return은 메서드에서 나감.
//			}  첫번째에서 false면 두번째에서도 false이다./ 그리고 다르게 푸는경우 알려주는거임
			
			int result = 0;
			//양수인것만 받기
			if(num1 > 0 && num2 >0) {
			// case문 활용
			switch(op) {
			case '+' :
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case '*' :
				result = num1 * num2;
				break;
			case '/' :
				result = num1 / num2;
				break;
			case '%' :
				result = num1 % num2;
				break;
				
			}
			}else;
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
	}

	/*
	 * 10. 아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를, 종료 번호를 누르면 “프로그램이 종료됩니다.”를
	 * 출력하세요
	 * 
	 * 1. 입력 2. 수정 3. 조회 4. 삭제 9. 종료 메뉴 번호를 입력하세요 : 3 조회 메뉴입니다.
	 */
	public void practice10() {
		
		//메뉴창
		System.out.println("1.입력");
		System.out.println("2.수정");
		System.out.println("3.조회");
		System.out.println("4.삭제");
		System.out.println("5.종료");
		System.out.println("메뉴 번호를 입력 하세요 : ");
		//입력창
		int num = sc.nextInt();
		String result = "";
		// case필요
		switch(num) {
		case 1:
			result = "입력 메뉴입니다.";
			break;
		case 2:
			result = "수정 메뉴입니다.";
			break;
		case 3:
			result = "조회 메뉴입니다.";
			break;
		case 4:
			result = "삭제 메뉴입니다.";
			break;
		case 5:
			result = "종료 메뉴입니다.";
			break;
		case 9:
			result = "프로그램이 종료됩니다.";
			break;
		default:
			System.out.println("잘못 입력하셨스니다. 프로그램을 종료합니다.");
		} 

	}

	/*
	 * 11. 중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요. 총 점 100점 중 배점으로는 다음과
	 * 같다. 중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
	 * 이 때, 출석 회수는 총 강의 회수 20회 중에서 출석한 날만 입력
	 * 총 점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass, 아니면 Fail을 출력하세요.
	 * 
	 * 
	 * 중간 고사 점수 : 80 기말 고사 점수 : 90 과제 점수 : 50 출석 회수 : 15 ===========결과========== 
     * 고사 점수(20) : 16.0 기말 고사 점수(30) : 27.0 과제 점수 (30) : 15.0 출석 점수 (20) : 15.0 총점 :
     * 73.0 PASS
	 * 
	 * 중간 고사 점수 : 80 기말 고사 점수 : 30 과제 점수 : 60 출석 회수 : 18 ===========결과==========
	 * FAIL [점수 미달] (총점 61.0)
	 * 
	 * 중간 고사 점수 : 90 기말 고사 점수 : 100 과제 점수 : 80 출석 회수 : 13 ===========결과==========
	 * FAIL [출석 횟수 부족] (13/20)
	 * 
	 * 중간 고사 점수 : 100 기말 고사 점수 : 80 과제 점수 : 40 출석 회수 : 10 ===========결과==========
	 * FAIL [출석 횟수 부족] (10/20) FAIL [점수 미달] (총점 66.0)
	 * 
	 */
	public void practice11() {
		//질문
		System.out.println("중간 고사 점수 : ");
		//입력창
		int num1 = sc.nextInt();
		System.out.println("기말 고사 점수 : ");
		//입력창
		int num2 = sc.nextInt();
		System.out.println("과제 점수 : ");
		//입력창
		int num3 = sc.nextInt();
		System.out.println("출석 횟수 : ");
		//입력창
		int num4 = sc.nextInt();
		System.out.println("=====결과=====");
		
		// 필요한것 : 총점, 출석 점수 
		// 총점 70이상, 배점 적용점수 합계
		// 중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
		int result = (num4/20) * 100;
		double score1 = num1 * 0.2;
		double score2 = num2 * 0.3;
		double score3 = num3 * 0.3;
		double score4 = num4 * 0.2;
		double sum = score1 + score2 + score3+ score4;
		
//		if(sum >= 70 && result >=70) {
//			System.out.println("중간 고사 점수(20) : " + score1);
//			System.out.println("기말 고사 점수(30) : " + score2);
//			System.out.println("과제 점수(30) : " + score3);
//			System.out.println("출석 점수(20) : " + score4);
//			System.out.println("총점 : " + sum);
//			System.out.println("PASS");
//		} else { // 아니라면 > 나가버린다.
//			if(sum < 70) { // 맞다면 - 맞다면 > 이어간다.
//				System.out.println("FAIL [점수 미달] (총점 "+ sum +")");
//			}if(result < 70) {
//				
//				
//			}
//		}	
	}
}
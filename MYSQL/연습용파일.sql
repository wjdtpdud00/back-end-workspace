-- 실습문제 ---------------------------------------------
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회

-- 변경함수 
-- 다른 컬럼과 나란히 쓸 수 있음
SELECT replace('kh.or.kr', 'kh.or.kr', 'gmail.com');
-- 어떤 테이블에서 보았는가 employee
SELECT * FROM employee;
-- 조회 구조
SELECT emp_name, email "변경전", replace('kh.or.kr', 'kh.or.kr', 'gmail.com') "변경후"
FROM employee;

-- 2. 사원명과 주민등록번호(000000-0******)으로 조회 
-- replace(문자열 변경), concat(문자열 합침), rpad(오른쪽에서 덧붙임) , substr(문자열 추출)
-- 순서 replace, substr  rpad,  concat
SELECT 
	emp_name, 
    replace(emp_no, substr() , )
FROM employee;
-- rpad(substr(emp_no, 1, 8), 14, '*')
-- RPAD(컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
-- SUBSTR(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
SELECT emp_name,s
        rpad(substr(emp_no, 1, 8), 14,'*******')
FROM employee;
-- concat
-- CONCAT(컬럼|'문자열', 컬럼|'문자열', ...)
SELECT 
	emp_name,
    concat(substr(emp_no, 1, 8), '******')
FROM employee;


-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회 (@ 앞) 
-- replace, trim, substr




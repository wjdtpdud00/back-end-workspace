SELECT * FROM employee;
-- 다음 작성된 SQL 구문이 정상적으로 작동하지 않는다.
-- 1번 문제 수정이 필요한 코드
INSERT INTO employee
VALUES(300, '전지우', '700101-1234567');
-- 1번문제 정답
INSERT INTO employee(emp_id, emp_name, emp_no)
VALUES(300, '전지우', '700101-1234567');

-- 다음 조건에 맞는 사원을 조회하려고 SQL 구문을 작성했는데 제대로된 결과가 출력되지 않았다.
-- 2번 문제 수정이 필요한 코드
SELECT emp_name, emp_no, dept_code, salary
FROM employee
WHERE dept_code = 'D6' OR dept_code = 'D9'
AND salary > 3000000
AND email LIKE '____%';

-- 정답
SELECT emp_name, emp_no, dept_code, salary
FROM employee
WHERE
	dept_code IN ('D6', 'D9')
	AND salary >= 3000000
    AND email LIKE '___%_$' ESCAPE '%';
    -- %의 뒤에오는 것을 문자로 인식하겠음!
    
SELECT *
FROM employee
WHERE bonus IS null;

-- 아래의 SQL 구문은 부서 별 평균 월급이 280만원을 초과하는 부서를 조회한 것이다.
-- 3번 문제 수정이 필요한 코드
SELECT dept_code, sum(salary) 합계, avg(salary) 평균, 
		count(*) 인원수
FROM employee
WHERE salary > 2800000
GROUP BY dept_code
ORDER BY dept_code;

-- 정답
SELECT dept_code, sum(salary) 합계, avg(salary) 평균, 
		count(*) 인원수
FROM employee
GROUP BY dept_code
HAVING avg(salary) > 2800000
ORDER BY dept_code;


/*다음은 '해외영업1부', '해외영업2부', '해외영업3부'를 '해외영업부'로 변경하는 UPDATE 문을 작성했지만 문제가 발생한다.
문제 원인(30점)을 작성하고, 이를 해결한 UPDATE 문을 조치사항(30점)에 작성하시오. (총 60점)*/

-- 4번 문제 수정이 필요한 코드
UPDATE department
SET dept_title = '해외영업부'
WHERE dept_title LIKE '해외%';

-- 정답
UPDATE department
SET dept_title = '해외영업부'
WHERE dept_id IN ('D5', 'D6', 'D7'); 
-- dept_id 기본키가지고 찾아야함

/*
다음은 직원 테이블에서 사원명, 직급코드, 보너스를 받는 사원 수를 조회하여 직급코드 순으로 오름차순 정렬하는 구문이다.
이 코드의 결과가 올바르지 않다고 할 때 그 이유를 원인(20점)에 기술하고, 알맞은 SQL문을 조치내용(20점)에 작성하시오. (총 40점)
*/
-- 5번 문제 수정이 필요한 코드
SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus != NULL
GROUP BY job_code
ORDER BY job_code;

-- 정답
SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus IS NOT NULL
GROUP BY emp_name, job_code -- 명시되어있는게 select에 올수있기 때문에, select에 있는걸로 써라.(emp_id x)
ORDER BY job_code;

/*
다음 두 개의 테이블을 조인하여 emp_id, emp_name, dept_id, dept_title 컬럼을 조회하였을 때 문제가 발생한다. 아래의 내용과 문제상황을 보고, 발생한 원인(30점)과 알맞은 SQL 문을 조치사항(30점)에 작성하시오. (총 60점)
*/
-- 6번 문제 수정이 필요한 코드
SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department USING (dept_id);


-- 정답
SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department ON (dept_id = dept_code)
WHERE dept_id = 'D9';




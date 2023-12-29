/*
	서브쿼리(SUBQUERY), 중첩쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
    - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일때 (한 행 한 열)
    - 일반 비교연산자 사용 가능 : =, =!, ^=, <>, >, >=, <=, ...
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = "노옹철"; -- D9

-- 2) 부서코드가 D9인 사원들 조회
SELECT emp_name
FROM employee
WHERE dept_code = 'D9';

-- 3) 위의 2단계를 하나의 쿼리문으로!
SELECT dept_code
FROM employee
WHERE dept_code = (SELECT dept_code
					FROM employee
					WHERE emp_name = "노옹철");

-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT * FROM employee; -- emp_id, emp_name, job_code, salary
SELECT * FROM department; --                        job_code

-- 전직원의 평균급여  format(avg(salary), 0)
-- 조건은 더많은  format(avg(salary), 0) =< salary
SELECT emp_id, emp_name, job_code, salary
FROM employee
WHERE  salary > (SELECT avg(salary) 
				 FROM employee);

-- 최저 급여를 받는 사원의 사번, 이름, 직급 코드, 급여, 입사일 조회
SELECT emp_id, emp_name, job_code, salary, hire_date
FROM employee
WHERE salary = (SELECT min(salary) 
				FROM employee);

-- 전지연 사원이 속해있는 부서원들이 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
-- 단, 전지연 사원은 제외
SELECT * FROM employee; -- emp_id, emp_name, job_code, salary
SELECT * FROM department;

-- 1) 전지연 사원이 속해있는 부서
SELECT dept_title
FROM department
	JOIN employee ON (dept_code = dept_id)
WHERE dept_title = "전지연";

-- 2) 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM department
	JOIN employee ON (dept_code = dept_id)
    JOIN job USING (job_code)
WHERE dept_code = "D1";

-- 3) 전지연 사원 제외
SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM department
	JOIN employee ON (dept_code = dept_id)
    JOIN job USING (job_code)
WHERE dept_code = "D1" = (SELECT dept_code
						  FROM employee
                          WHERE emp_name = '전지연')
						  AND emp_name != '전지연';

-- 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합을 조회
SELECT * FROM employee;
SELECT * FROM department;

SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
ORDER BY 2 desc
LIMIT 1;

-- 서브쿼리 사용!
SELECT dept_code, sum(salary) sum_sal
FROM employee
GROUP BY dept_code; -- > 결과값이 테이블이 된거임!

-- 부서별 합이 가장 큰 값   --> 위가 테이블 화가 되어서 연결해준것임.
SELECT max(sum_sal)
FROM  (SELECT dept_code, sum(salary) sum_sal
	  FROM employee
	  GROUP BY dept_code) as dept_sum;
      
-- 다배우고 나서 할말이 있어요!
-- 서브쿼리 특징 ! 쿼리 자체는 직관적임
--  쿼리 속도를 중요시 ! 서브쿼리는 느려요~~~
-- 가급적으로 서브쿼리를 사용하지 않아도 되는 거면 안 쓰고 하시는 걸 추천!
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
HAVING sum(salary) = (SELECT max(sum_sal)
						FROM  (SELECT dept_code, sum(salary) sum_sal
							   FROM employee
							   GROUP BY dept_code) dept_sum);

/*
	2. 다중행 서브쿼리
    - 서브쿼리의 조회 결과 값의 개수가 여러 행 일 때 (여러행 한열)
    
    IN 서브쿼리 : 여러개의 결과값 중에서 한개라도 일치하는 값이 있다면
*/
-- 각 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드 , 급여 조회
 -- 1) 각 부서별 최고급여 조회
 SELECT max(salary)
 FROM employee
 GROUP BY dept_code; -- 8000000, 3900000, 3760000, 2550000, 2890000, 3660000, 2490000
 
 -- 2) 위에 값들을 받은 직원의 이름, 직급코드, 부서코드 , 급여 조회
SELECT emp_name, job_code, dept_code, salary
FROM employee
WHERE salary IN (8000000, 3900000, 3760000, 2550000, 2890000, 3660000, 2490000);

-- 3) 합치기!
SELECT emp_name, job_code, dept_code, salary
FROM employee
WHERE salary IN (SELECT max(salary)
				FROM employee
				GROUP BY dept_code);


-- 직원들에 대해 사번, 이름, 부서코드, 구분(사수/사원) 조회
SELECT * FROM employee;

-- 사수 테이블 조회
-- >> 누군가의 사수인 사람들의 id! 
SELECT emp_id, emp_name, dept_code, '사수' as '구분'
FROM employee
WHERE emp_id IN (SELECT distinct manager_id 
				 FROM employee
				 WHERE manager_id is not null);


-- 사원만 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE emp_id NOT IN (SELECT distinct manager_id 
					 FROM employee
					 WHERE manager_id is not null);

-- >> 오로지 서브쿼리로만 사용하는 방법! 힌트 : SELECT절에서도 서브쿼리를 사용할 수 있다.
-- if, case ~ 
SELECT 
	emp_id, emp_name, dept_code,
    if(emp_id IN (SELECT distinct manager_id 
				  FROM employee
				  WHERE manager_id is not null), "사수", "사원") 구분
FROM employee;

-- >> case~
SELECT 
	emp_id, emp_name, dept_code,
    CASE 
		WHEN emp_id IN (SELECT distinct manager_id 
				FROM employee
				WHERE manager_id is not null) THEN "사수" 
		ELSE "사원"
	END 구분
FROM employee;
/*
	컬럼 > ANY (서브쿼리) : 여러개의 결과값 중에서 "한개라도" 클 경우
							(여러개의 결과값 중에서 가장 작은 값 보다 클 경우)
    컬럼 < ANY (서브쿼리) : 여러개의 결과값 중에서 "한개라도" 작을 경우
							(여러개의 결과값 중에서 가장 큰 값보다 작을 경우)
	-- > OR과 동일함
*/
-- 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회

SELECT * FROM employee;
SELECT * FROM department;
SELECT * FROM job;

-- 1) 과장 직급들의 급여 조회
SELECT salary
FROM employee e, job j
WHERE e.job_code = j.job_code
	AND job_name = '과장'; -- 220000, 250000, 3760000 <--- 최소 급여 : 220000

-- 2) 대리직급 급여 조회
SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '대리';

-- 3) 과장직급 최소급여보다 많이 받는 직원
SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '대리'
	AND salary > ANY(SELECT salary
						FROM employee e, job j
						WHERE e.job_code = j.job_code
						AND job_name = '과장');
-- = salary > 220000 OR salary > 250000 OR  salary > 3760000
/*
	컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 클 경우
    컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들 보다 작을 경우
    -- > AND와 동일함
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회

-- 1) 차장직급  급여 조회
SELECT salary
FROM employee e, job j
WHERE e.job_code = j.job_code
AND job_name = '차장';   -- 최대급여 2490000

-- 2) 과장 직급  급여 조회, 합치기(사번, 이름, 직급, 급여 조회)
SELECT emp_id, emp_name, job_name, salary
FROM employee e, job j
WHERE e.job_code = j.job_code
AND job_name = '과장' 
AND salary > ALL (SELECT salary
				 FROM employee e, job j
				 WHERE e.job_code = j.job_code
				 AND job_name = "차장");

/*
	3. 다중열 서브쿼리
		- 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는
-- 사원들의 사원명, 부서코드, 직급 코드 조회
SELECT * FROM employee;
SELECT * FROM department;

-- 1) 하이유 사원과 같은 부서코드인 직원들 조회
SELECT dept_code
FROM employee 
WHERE emp_name = '하이유'; -- D5

-- 2) 하이유 사원과 같은 직급 코드
SELECT job_code
FROM employee
WHERE emp_name = '하이유'; -- J5

-- 부서코드가 D5면서, 직급 코드가 J5인 사원명, 부서코드, 직급 코드 조회
SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (SELECT dept_code
					FROM employee 
					WHERE emp_name = '하이유')
AND job_code = (SELECT job_code
			    FROM employee
				WHERE emp_name = '하이유');

-- >> 다중열 서브쿼리로!
SELECT emp_name, dept_code, job_code
FROM employee

-- WHERE dept_code ='D5' AND job_code = 'J5';를 아래와 같이 나타낼 수 있음.
-- WHERE (dept_code, job_code) = (('D5', 'J5')); 
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
								FROM employee
								WHERE emp_name = '하이유');

-- 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 
-- 직급코드, 사수 사번 조회
SELECT * FROM employee; 

-- 1) 박나라 사원과 직급 코드가 같은 직원
SELECT job_code, manager_id
FROM employee
WHERE emp_name = '박나라' ;  -- 'J7'

-- 2) 같은 사수를 가진 사원
SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) = (SELECT job_code, manager_id
								FROM employee
								WHERE emp_name = '박나라');

/*
	4.다중행 다중열 서브쿼리
	 - 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT * FROM employee;

-- 1)직급별 최소 급여 
SELECT min(salary), job_code
FROM employee
GROUP BY job_code;

-- 2) 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT emp_id, emp_name, job_code, salary
FROM employee
WHERE (salary, job_code) IN (SELECT min(salary), job_code
								FROM employee
								GROUP BY job_code);

-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회(부서없음  명시)

-- 1) 각 부서별 최대 급여 조회
SELECT max(salary), dept_code
FROM employee
GROUP BY dept_code;   -- max(salary)값, dept_code값

-- 2) 사원들의 사번, 이름, 부서코드, 급여 조회(부서없음  명시)

SELECT emp_id, emp_name, ifnull(dept_code, '부서없음'), salary
FROM employee
WHERE (salary, ifnull(dept_code, '부서없음')) IN (SELECT  max(salary), ifnull( dept_code, '부서없음')
									FROM employee
									GROUP BY dept_code);
/*
	RANK 함수 
    - RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 동일한 인원수 만큼 건너뛰고 순위를 계산한다.
								(ex. 공동 1위가 2명이면 다음 순위는 3위)
    - DENSE_RANK() OVER (정렬기준) :  동일한 순위 이후의 등수를 무조건 1씩 증가한다.
								(ex. 공동 1위가 2명이면 다음 순위는 2위)
*/
-- 사원별 급여가 높은 순서대로 순위 매겨서 순위, 사원명, 급여 조회
SELECT 
	rank() over(ORDER BY salary DESC) 순위,
	emp_name, salary
FROM employee; -- 박나라가 21위
-- 1~10위까지만!
SELECT 
	dense_rank() over(ORDER BY salary DESC) 순위,
	emp_name, salary
FROM employee
LIMIT 10; -- 박나라가 20위

-- 실습문제 1 ---------------------------------------
-- Sakila : DVD 대여 및 영화 정보와 관련된 데이터 포함

SELECT * FROM category; -- 영화 카테고리 정보 : category_id
SELECT * FROM rental; -- DVD 대여 정보 : customer_id, inventory_id
SELECT * FROM inventory; -- DVD 대여점에서 관리하는 정보 : inventory_id, film_id
SELECT * FROM customer; -- DVD 대여 고객 정보 : customer_id, address_id
SELECT * FROM film; -- 영화 정보 : film_id
SELECT * FROM actor; -- 영화 배우 정보 : actor_id

SELECT * FROM film_category; -- film과 category 연결 : film_id, category_id
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id

SELECT * FROM address; -- 고객 주소 정보 : address_id, city_id, address, district
SELECT * FROM city; -- city_id, country_id
SELECT * FROM country; -- country_id;
SELECT * FROM customer; -- DVD

-- 1) customer 테이블의 first_name이 TRACY인 사람들 조회
SELECT country, city, address, district, first_name, last_name
FROM country 
	JOIN city USING country_id
    JOIN address USING city_id
    JOIN customer USING address_id 
WHERE first_name = 'TRACY';












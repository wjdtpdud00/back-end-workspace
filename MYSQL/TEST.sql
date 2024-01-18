SET SQL_SAFE_UPDATES = 1;

UPDATE department SET dept_title = '해외영업1부' WHERE dept_id = 'D5';
UPDATE department SET dept_title = '해외영업2부' WHERE dept_id = 'D6';
UPDATE department SET dept_title = '해외영업3부' WHERE dept_id = 'D7';



-- 다음 두 개의 테이블을 조인하여 emp_id, emp_name, dept_id, dept_title 컬럼을 조회하였을 때 

SELECT * FROM employee;
SELECT * FROM department;

SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department USING (dept_id);





















-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의
--  사번, 직원명, 직급명, 부서명, 근무지역, 급여를 조회
SELECT*FROM employee;  -- emp_id, emp_name, salary, job_code, dept_code
SELECT*FROM job; -- job_name,                       job_code
SELECT*FROM department; -- dept_title, location_id           , dept_id
SELECT*FROM location;  --              local_code, local_name

SELECT emp_id, emp_name, job_name, dept_title, local_name, salary
FROM employee e, job j, department, location
WHERE e.job_code = j.job_code
	AND dept_code = dept_id
    AND local_code = location_id
    AND job_name = '대리'
    AND local_name LIKE 'ASIA%';
    
-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의
-- 	  직원명, 주민번호, 부서명, 직급명 조회
-- >> where
SELECT emp_name, emp_no, dept_title, job_name
FROM employee e, department, job j
WHERE dept_code = dept_id
	AND e.job_code = dept_id
    -- AND emp_no LIKE '7%';
AND substr(emp_no, 1, 2) between 70 AND 79;
-- ANSI 구문
SELECT emp_name, emp_no, dept_title, job_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING (job_code)
    WHERE emp_no LIKE '7_____-2%'
    AND emp_name LIKE '전%';

-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역,근무국가 조회
-- 단, 부서 코드가 없는 사원도 출력될 수 있게! OUTER JOIN 사용!
SELECT*FROM employee;  -- emp_id, emp_name, salary, job_code, dept_code
SELECT*FROM job; -- job_name,                       job_code
SELECT*FROM department; -- dept_title, location_id           , dept_id
SELECT*FROM location;
SELECT*FROM national;  --              local_code, local_name
SELECT emp_name, bonus, salary * 12, dept_title, local_name, national_name
FROM employee
	left JOIN department ON (dept_id = dept_code)
    left JOIN location ON (local_code = location_id)
    left JOIN national USING (national_code);



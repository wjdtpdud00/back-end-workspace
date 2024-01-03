-- 실습문제-------------------------------------------

-- 1. employee에서 부서코드(dept_code)가 'D1'인 사원들이
--    사원명(emp_name), 급여(salary), 부서코드만 조회
SELECT emp_name, salary, dept_code
FROM employee
WHERE dePt_code = 'D1';

-- 2. employee에서 부서코드가 'D1'이 아닌 사원들의
-- 사번(emp_id), 사원명(emp_name), 부서코드 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE dept_code <> 'D1';

-- 3. 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE salary >= 4000000;
-- 4. 재직중(ent_yn 컬럼값이'N')인 사원들의
-- 사번, 사원명, 입사일(hire_date) 조회
SELECT emp_id, emp_name, hire_date,  ent_yn
FROM employee
WHERE ent_yn = 'N';
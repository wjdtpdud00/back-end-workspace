SELECT
	emp_name, salary,
		CASE WHEN salary >5000000 THEN '1등급'
			 WHEN salary > 3500000 THEN '2등급'
		ELSE "4등급"
	END "급여등급"
FROM employee;
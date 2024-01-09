CREATE OR REPLACE VIEW vw_job
AS SELECT job_code
FROM job;


-- DELETE (에러)
DELETE FROM vw_job
WHERE job_name = '사원'; 

DELETE FROM vw_job
WHERE job_code = 'J0'; -- 가능!




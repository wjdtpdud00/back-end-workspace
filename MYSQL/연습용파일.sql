-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
SELECT * FROM actor;

SELECT * 
FROM actor
WHERE first_name Like 'A%';

-- 2. film_list 테이블에서 category가 Sci-Fi 또는 Family면서
-- rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
SELECT * FROM film_list;

SELECT title
FROM film_list
WHERE category IN ('Sci-Fi', 'Family')
AND rating = 'PG'
AND title Like '%GO%';
/*정답
SELECT title
FROM film_list
-- WHERE (category = 'Sci-Fi' OR categrory ='Family')
WHERE category IN ('Sci-Fi' OR category = 'Family')
AND rating = 'PG' 
AND title LIKE '%GO%';*/

-- 3. film_list 테이블에서 fid가 7 이하면서 4 또는 6이 아닌 fid, title 조회
SELECT * FROM film_list;

SELECT *
FROM film_list
WHERE fid <= 7 
AND fid NOT IN(4, 6);

/*
	 가격(테이블) 컬럼 (PRICE)에서 200, 300 포함되지 않은 경우
	SELECT *
    FROM 가격
    WHERE PRICE NOT IN(200, 300);
*/ 

-- 4. film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 category가 Documentary거나 Animation이고 
-- 배우들(actors) 중 BOB가 포함되어 있는 영화 제목(title)만 조회 
SELECT * FROM film_list;

SELECT title
FROM film_list
WHERE price BETWEEN 2 AND 4
AND category IN ('Documentary', 'Animation')
AND actors like '%BOB%';

-- 정답
SELECT title
FROM film_list
WHERE price between 2 AND 4  
AND category IN ('Documentary', 'Animation')
AND actors LIKE '%BOB%';

-- 5. address 테이블에서 district가 비어있지 않고 앞에 숫자 제외 주소만 10개 조회
SELECT * FROM address;
-- 앞에 숫자 빼기
-- substr(값, 시작점 위치, 개수)
-- substr(address, instr(address, '')+1) 'address'
SELECT 
	substr(address, instr(address, '')+1) 'address', district
FROM address
WHERE district NOT IN('')
ORDER BY  address desc
LIMIT 10;



-- 6. customer_list 테이블에서 id가 6인 사람부터 10명 조회
SELECT * FROM customer_list ;

SELECT * 
FROM customer_list 
ORDER BY id
LIMIT 5, 10;

-- 7. actor 테이블에서 J로 시작하는 이름과 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
SELECT concat(firtst_name, ' ',last_name) 이름,
	   char_length(concat(first_name, last_name)) 글자수
FROM actor
WHERE first_name LIKE 'J%'
ORDER BY 2 desc;

-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
SELECT * FROM film;
SELECT distinct substr(description, instr(description, 'of') +1)'description'
FROM film
ORDER BY 1;
-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회

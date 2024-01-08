DROP TABLE mem_unique;
CREATE TABLE mem_unique(
  	mem_no INT NOT NULL, 
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(13),
    email VARCHAR(50),
    mem_date DATE
);
SELECT * FROM mem_unique;
INSERT INTO mem_unique VALUES(1, 'user02' 'pass01', '정대윤', null, null, null, null);
INSERT INTO mem_unique VALUES(2, 'user01', 'pass02', '이하림', null, null, null, null);

-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)

DROP TABLE TB_PUBLISHER;
-- 1) 테이블 만들기
-- 2) 컬럼 넣기
CREATE TABLE TB_PUBLISHER( 
	pub_no INT,
	pub_name  VARCHAR(20) NOT NULL,
	phone VARCHAR(13),
	PRIMARY KEY(pub_no)
);

-- 3) 데이터 넣기
INSERT INTO TB_PUBLISHER VALUES(1, '천그루숲', '010-8748-0784');
INSERT INTO TB_PUBLISHER VALUES(2, '골든래빗', '0505-398-0505');
INSERT INTO TB_PUBLISHER VALUES(3, '윌북', '031-955-3777');

SELECT * FROM TB_PUBLISHER;





-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (tb_book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(tb_publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정

DROP TABLE tb_book;
CREATE TABLE tb_book( 
	bk_no INT,
    bk_title VARCHAR(20) NOT NULL,
    bk_author VARCHAR(20) NOT NULL,
	bk_price VARCHAR(13),
    bk_pub_no INT,
    PRIMARY KEY(bk_no),
    FOREIGN KEY (bk_pub_no) REFERENCES TB_PUBLISHER(pub_no) ON DELETE CASCADE 
);

INSERT INTO tb_book VALUES(1, '오늘부터 개발자', '김병욱', 16800, '1');
INSERT INTO tb_book VALUES(2, '요즘 우아한 개발', '우아한 형제들', 24000, '2');
INSERT INTO tb_book VALUES(3, '프로덕트 매니저 원칙', '장흥석', 22000, '2');
INSERT INTO tb_book VALUES(4, '코딩 좀 아는 사람', '제레미 키신', 17800, '3');
INSERT INTO tb_book VALUES(5, '그렇게 쓰면 아무도 안 읽습니다.', '전주경', 19800, '3');

SELECT * FROM tb_book;
SELECT * FROM tb_publisher;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (tb_member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜

DROP TABLE tb_member;
CREATE TABLE tb_member( 
	member_no INT,
    member_id VARCHAR(20) UNIQUE,
    member_pwd VARCHAR(20) NOT NULL,
    member_name VARCHAR(20) NOT NULL,
    gender CHAR(3) CHECK(gender IN('M', 'F')) NOT NULL,
    address VARCHAR(13),
    phone VARCHAR(13),
    status CHAR(3) CHECK(status IN('N', 'Y')) NOT NULL,
    enroll_date  DATE DEFAULT (current_date),
    PRIMARY KEY(member_no)
);

INSERT INTO tb_member VALUES(1, 'user01', 'pass01', '홍길동', 'M' , '서울시 강서구', '010-1111-2222', 'N', current_date());
INSERT INTO tb_member VALUES(2, 'user02', 'pass02', '김말똥', 'M' , '서울시 강남구', '010-3333-4444', 'N', current_date());
INSERT INTO tb_member VALUES(3, 'user03', 'pass03', '강길순', 'F' , '경기도 광주시', '010-4444-5555', 'N', current_date());

SELECT * FROM tb_member;

-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(tb_rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(tb_member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(tb_book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정

DROP TABLE tb_rent;
CREATE TABLE tb_rent( 
	rent_no INT,
    rent_mem_no INT,
    rent_book_no INT,
    rent_date VARCHAR(20),
    PRIMARY KEY(rent_no),
	FOREIGN KEY (rent_mem_no) REFERENCES tb_member(member_no),
    FOREIGN KEY (rent_book_no) REFERENCES tb_book(bk_no) ON DELETE SET NULL
);

INSERT INTO tb_rent VALUES(1, 1, 2, '2024-01-09');
INSERT INTO tb_rent VALUES(2, 1, 3, '2024-01-09');
INSERT INTO tb_rent VALUES(3, 2, 1, '2024-01-09');
INSERT INTO tb_rent VALUES(4, 2, 2, '2024-01-09');
INSERT INTO tb_rent VALUES(5, 1, 5, '2024-01-09');

SELECT * FROM tb_rent;

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.

CREATE TABLE book_copy
AS SELECT member_name, member_id, rent_date, add(rent_date, 7) 
FROM tb_book, tb_member, tb_rent;



-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.

CREATE TABLE book_an
AS SELECT bk_title, pub_name, rent_date, add(rebt_date, 7)
FROM tb_book, tb_publisher, tb_rent, tb_member 
WHERE member_no = '1';







/*
    조회(Read)
    - 미리 테이블에 넣어둔 데이터를 원하는 목적에 맞게 탐색
    - 조건, 그룹, 정렬
*/

CREATE TABLE PRODUCT(
NO NUMBER PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
TYPE VARCHAR2(15) CHECK(TYPE IN ('과자','아이스크림','주류','사탕')),
PRICE NUMBER,
MADE DATE,
EXPIRE DATE
);

INSERT INTO PRODUCT VALUES(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
INSERT INTO PRODUCT VALUES(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
INSERT INTO PRODUCT VALUES(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
INSERT INTO PRODUCT VALUES(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
INSERT INTO PRODUCT VALUES(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
INSERT INTO PRODUCT VALUES(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
INSERT INTO PRODUCT VALUES(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
INSERT INTO PRODUCT VALUES(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
INSERT INTO PRODUCT VALUES(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
INSERT INTO PRODUCT VALUES(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

COMMIT;

-- 전체 데이터 조회
SELECT * FROM PRODUCT;

-- 특정 항목만 조회
-- select 항목 from 대상테이블;
SELECT NAME FROM PRODUCT;
SELECT NAME,PRICE FROM PRODUCT;

-- 없는 항목은 조회 불가능
-- 모든 항목을 조회
SELECT NO,NAME,PRICE,TYPE,MADE,EXPIRE FROM PRODUCT;
-- 와일드카드 사용
 SELECT*FROM PRODUCT;
    
-- 계산한 항목을 추가로 조회
-- 날짜 계산(일단위)
SELECT NAME, EXPIRE-MADE FROM PRODUCT;

-- 에러 : 와일드카드는 단독으로만 사용 가능
--select*,expire-made from product;
SELECT PRODUCT.*, EXPIRE-MADE FROM PRODUCT;

--조건(필터) : 숫자, 문자열, 날짜
-- select*from product where 필터링조건;
--조건 1개
SELECT*FROM PRODUCT WHERE PRICE < 1000;

-- 조건이 2개 이상이라면 자바에서는 &&, ||을 사용
-- 오라클에서 &&는 입력기호, ||는 문자열 덧셈 기호
-- 대신 알파벳 형태의 연산을 지원(and,or)
SELECT*FROM PRODUCT WHERE PRICE >= 1000 AND PRICE <=2000;


        -- Quiz 가격이 1000원 미만이거나 2000원 초과인 제품을 조회
SELECT*FROM PRODUCT WHERE PRICE <1000 OR PRICE >2000;

-- 번호가 5번인 상품을 조회
-- 오라클에서 같다는 = (1개)로 처리한다.
SELECT * FROM PRODUCT WHERE NO=5;
SELECT*FROM PRODUCT WHERE NO != 5;

-- 문자열 조건 : 일치, 유사 검색
-- 유사 검색 명령이 2가지이므로 구분하여 사용할 수 있어야 한다
    -- like 는 %를 사용하여 패턴검사를 하는 방식
    -- instr은 특정 키워드가 몇번째 위치에 존재하는지 알아내는 방식
-- 전체적인 성능은 instr이 우세하지만 시작검사만큼은 like가 빠름(like : 첫글자만 보면 뒤를 안봐도됨)

SELECT * FROM PRODUCT WHERE NAME = '스크류바';          -- 완벽히 동일

-- like 처리속도가 더 빠름(시작검사)
SELECT * FROM PRODUCT WHERE NAME LIKE '스%류%';       -- 유사검색 like '%';
SELECT * FROM PRODUCT WHERE INSTR(NAME, '스크류') >0;  -- 유사검색 instr


-- 이 경우 instr 처리속도가 더 빠름(시작검사 제외)
SELECT * FROM PRODUCT WHERE NAME LIKE '%이%' ;         -- '이' 가 들어간 상품, like 유사검색 시 첫글자에 %가 있을 시 성능이 떨어짐  
SELECT * FROM PRODUCT WHERE INSTR(NAME, '이') >0;


        -- Quiz 과자와 아이스크림을 조회
        SELECT*FROM PRODUCT WHERE TYPE='과자' AND TYPE='아이스크림';
        SELECT*FROM PRODUCT WHERE TYPE IN ('과자','아이스크림');
        
        -- Quiz 과자와 주류중에서 가격이 1000원 이상 2000원 이하인 제품을 조회
        SELECT * FROM PRODUCT WHERE (TYPE ='과자' OR TYPE = '주류') AND (PRICE >= 1000 PRICE <= 2000);
        SELECT * FROM PRODUCT WHERE TYPE IN('과자','주류') AND PRICE BETWEEN 1000 AND 2000;        -- 1000 ~ 2000 사이 = 1000이상 2000이하
         
        -- Quiz 이름에 '초코'가 들어있는 제품 조회
        SELECT * FROM PRODUCT WHERE INSTR(NAME,'초코')>0;
        
        -- Quiz 이름이 '바나나'로 시작하는 제품을 조회
        SELECT * FROM PRODUCT WHERE NAME LIKE '바나나%';
        
        -- Quiz 이름에 '이'라는 글자가 들어있지 않은 제품 조회
        -- (참고) not은 부정연산 자리에 쓸 수 있는 영어 단어형 연산 기호
        SELECT * FROM PRODUCT WHERE NAME NOT LIKE '%이%';
        SELECT * FROM PRODUCT WHERE INSTR(NAME,'이')=0;
        
-/*
    날짜
    - 기본형식은 YYYY-MM-DD HH24:MI:SS (자바와 다름, 대소문자 구분 안함)
    - 문자열처럼 사용할 수 잇디만 국가마다 날짜 형식이 달라서 위험
    - 날짜용 명령들이 존재(to_char, TO_DATE, EXTRACT)
*/

-- extract는
SELECT NAME, MADE, EXTRACT(YEAR FROM MADE)FROM PRODUCT;         -- made에서 년도를 뽑아라 product안의

-- ex) 2019년도에 생산한 제품 조회
SELECT*FROM PRODUCT WHERE EXTRACT(YEAR FROM MADE) = 2019; 

        -- Quiz 여름(6,7,8)월에 생산한 제품 조회
        SELECT*FROM PRODUCT WHERE EXTRACT(MONTH FROM MADE) = 06 OR EXTRACT(MONTH FROM MADE) = 07; OR EXTRACT(MONTH FROM MADE) = 08;
        SELECT * FROM PRODUCT WHERE EXTRACT(MONTH FROM MADE) IN(6,7,8);
        SELECT * FROM PRODUCT WHERE EXTRACT(MONTH FROM MADE) BETWEEN 06 AND 08;

-- to_char 명령은 날짜를 원하는 서식의 문자열로 변경하는 명령
-- (자바의 SimpleDateFormat과 유사한 느낌, 대소문자 구분 없음)
SELECT NAME, MADE, TO_CHAR(MADE,'yyyy-mm-dd')FROM PRODUCT;

--  EX) 2019년에 생산한 제품 조회
SELECT*FROM PRODUCT WHERE TO_CHAR(MADE,'YYYY') = 2019;

-- EX) 봄(3,4,5월)에 생상한 제품 조회
SELECT*FROM PRODUCT WHERE TO_CHAR(MADE,'MM') IN (03,04,05);
SELECT*FROM PRODUCT WHERE REGEXP_LIKE(RO_CHAR(MADE,'MM'),'^0[345]$');   -- 정규표현식도 사용가능, 성능 저하(정규표현식이 꼭 필요한 경우만)

-- 날짜 자체로 비교도 가능한가?
-- EX) 2019년에 생산한 제품 조회 = 2019-01-01~2019-12-31
/*
문자열과 날짜를 혼용하면 국가,지역에 따라 작동 X 
SELECT*FROM PRODUCT WHERE MADE >= '2019-01-01' AND MADE <='2019-12-31';
TO_DATE를 사용하면 문자열을 날짜로 바꿀 수 있다(형식을 알려줘야 한다)
*/
SELECT*FROM PRODUCT WHERE MADE >= TO_DATE('2019-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS');       -- 19년도이후
SELECT*FROM PRODUCT WHERE MADE <= TO_DATE('2019-12-31 23:59:59','YYYY-MM-DD HH24:MI:SS');       -- 19년도 이전

SELECT*FROM PRODUCT WHERE MADE BETWEEN TO_DATE('2019-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')       -- 19년도 1월1일 부터 19년도 12월31일까지
    AND TO_DATE('2019-12-31 23:59:59','YYYY-MM-DD HH24:MI:SS');

-- 날짜에서 SYSDATE라는 키워드는 현재시각에 대한 날짜 객체를 말한다.
-- 최근 1년간 생산된 제품 조회
SELECT*FROM PRODUCT WHERE MADE BETWEEN SYSDATE-365 AND SYSDATE;

-- 최근 5분간 내역 조회
SELECT*FROM PRODUCT WHERE MADE BETWEEN SYSDATE-5/24/60 AND SYSDATE;

/*
    정렬
    - 조회가 끝난 데이터를 원하는 순서대로 나열하는 작업
    - 오름차순(ASCENDING, ASC)과 내림차순(DESCENDING, DESC)으로 구분
    - (주의) 정렬은 데이터가 확정된 이후에 해야한다
*/
SELECT* FROM PRODUCT ORDER BY NO ASC;       -- 오름차순
SELECT*FROM PRODUCT ORDER BY PRICE ASC;     -- 저렴한순
SELECT*FROM PRODUCT ORDER BY PRICE DESC;   -- 비싼순

-- 정렬은 마지막에 
-- SELECT*FROM PRODUCT ORDER BY PRICE DESC WHERE PRICE BETWEEN 1000 AND 2000;
SELECT*FROM PRODUCT WHERE PRICE BETWEEN 1000 AND 2000 ORDER BY PRICE DESC;

-- 만약 정렬 시 동일한 항목이 존재한다면, 하위 정렬 조건을 추가해야 함
SELECT*FROM PRODUCT ORDER BY PRICE DESC, NO ASC;

        -- QUIZ 최근에 제조한 상품부터 출력
        SELECT * FROM PRODUCT ORDER BY MADE DESC,NO DESC;
        -- QUIZ 이름순으로 출력
        SELECT * FROM PRODUCT ORDER BY NAME ASC, NO ASC;
        -- QUIZ 과자와 주류 상품들은 가격이 비싼 순으로 출력
        SELECT * FROM PRODUCT WHERE TYPE BETWEEN '과자' AND '주류' ORDER BY PRICE DESC,NO DESC;
         SELECT * FROM PRODUCT WHERE TYPE IN( '과자','주류') ORDER BY PRICE DESC,NO DESC;
        -- QUIZ 유통기한이 가장 짧은 상품부터 출력
        SELECT * FROM PRODUCT ORDER BY EXPIRE-MADE ASC, NO ASC;
        
        -- # 조회하는 항목은 별칭을 붙여 원하는 이름으로 바꿀 수 있다.
        SELECT PRODUCT.* , EXPIRE-MADE EXPIREDAYS FROM PRODUCT      --  SELECT PRODUCT . * , EXPIRE - MADE 별칭
        ORDER BY EXPIREDAYS ASC, NO ASC;
        
        -- # 별칭에 띄어쓰기를 쓰고 싶다면 쌍따옴표로 감싼다
        -- (참고) 자바에서 명령문을 만들 때에는 쓰기가 어렵다.
        SELECT PRODUCT.* , EXPIRE-MADE "유통기한 일수" FROM PRODUCT     
        ORDER BY "유통기한 일수" ASC, NO ASC;
        

        
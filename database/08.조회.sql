/*
    조회(Read)
    - 미리 테이블에 넣어둔 데이터를 원하는 목적에 맞게 탐색
    - 조건, 그룹, 정렬
*/

create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕')),
price number,
made date,
expire date
);

insert into product values(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

commit;

-- 전체 데이터 조회
select * from product;

-- 특정 항목만 조회
-- select 항목 from 대상테이블;
select name from product;
select name,price from product;

-- 없는 항목은 조회 불가능
-- 모든 항목을 조회
select no,name,price,type,made,expire from product;
-- 와일드카드 사용
 select*from product;
    
-- 계산한 항목을 추가로 조회
-- 날짜 계산(일단위)
select name, expire-made from product;

-- 에러 : 와일드카드는 단독으로만 사용 가능
--select*,expire-made from product;
select product.*, expire-made from product;

--조건(필터) : 숫자, 문자열, 날짜
-- select*from product where 필터링조건;
--조건 1개
select*from product where price < 1000;

-- 조건이 2개 이상이라면 자바에서는 &&, ||을 사용
-- 오라클에서 &&는 입력기호, ||는 문자열 덧셈 기호
-- 대신 알파벳 형태의 연산을 지원(and,or)
select*from product where price >= 1000 and price <=2000;


        -- Quiz 가격이 1000원 미만이거나 2000원 초과인 제품을 조회
select*from product where price <1000 or price >2000;

-- 번호가 5번인 상품을 조회
-- 오라클에서 같다는 = (1개)로 처리한다.
select * from product where no=5;
select*from product where no != 5;

-- 문자열 조건 : 일치, 유사 검색
-- 유사 검색 명령이 2가지이므로 구분하여 사용할 수 있어야 한다
    -- like 는 %를 사용하여 패턴검사를 하는 방식
    -- instr은 특정 키워드가 몇번째 위치에 존재하는지 알아내는 방식
-- 전체적인 성능은 instr이 우세하지만 시작검사만큼은 like가 빠름(like : 첫글자만 보면 뒤를 안봐도됨)

select * from product where name = '스크류바';          -- 완벽히 동일

-- like 처리속도가 더 빠름(시작검사)
select * from product where name like '스%류%';       -- 유사검색 like '%';
select * from product where instr(name, '스크류') >0;  -- 유사검색 instr


-- 이 경우 instr 처리속도가 더 빠름(시작검사 제외)
select * from product where name like '%이%' ;         -- '이' 가 들어간 상품, like 유사검색 시 첫글자에 %가 있을 시 성능이 떨어짐  
select * from product where instr(name, '이') >0;


        -- Quiz 과자와 아이스크림을 조회
        select*from product where type='과자' and type='아이스크림';
        select*from product where type in ('과자','아이스크림');
        
        -- Quiz 과자와 주류중에서 가격이 1000원 이상 2000원 이하인 제품을 조회
        select * from product where (type ='과자' or type = '주류') and (price >= 1000 price <= 2000);
        select * from product where type in('과자','주류') and price between 1000 and 2000;        -- 1000 ~ 2000 사이 = 1000이상 2000이하
         
        -- Quiz 이름에 '초코'가 들어있는 제품 조회
        select * from product where instr(name,'초코')>0;
        
        -- Quiz 이름이 '바나나'로 시작하는 제품을 조회
        select * from product where name like '바나나%';
        
        -- Quiz 이름에 '이'라는 글자가 들어있지 않은 제품 조회
        -- (참고) not은 부정연산 자리에 쓸 수 있는 영어 단어형 연산 기호
        select * from product where name not like '%이%';
        select * from product where instr(name,'이')=0;
        
-- 날짜
-- 기본형식은 YYYY-MM-DD HH24:MI:SS (자바와 다름, 대소문자 구분 안함)
-- 문자열처럼 사용할 수 잇디만 국가마다 날짜 형식이 달라서 위험
-- 날짜용 명령들이 존재(to_char, to_date, extract)

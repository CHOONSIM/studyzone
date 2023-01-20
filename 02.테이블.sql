-- 테이블(table)
-- 데이터가 저장되는 객체
-- 표 형태이다

create table attendance(
no number(10),
name varchar2(21),
phone char(13)
);

drop table attendance;

-- Day08 월드컵 테이블 예제
 create table worldcup(
 rank number(3),
 name varchar(39),
 nation varchar(15),
 goal number(2)
 );
 drop table worldcup;
 
 --Day08 포켓몬 테이블 예제
 create table pocketmon(
 no number(3),          -- 숫자를 안쓰면 자동으로 38자리가 됨
 name varchar2(21),
 type varchar2(9)
 );
 drop table pocketmon;
 
 --Day08 메달리스트 테이블 예제
 create table medalist(
 name varchar2(21),
 event varchar2(12),
 type char(6),             -- 고정된 글자에 char
 gold number(2),
 silver number(2),
 bronze number(2)
 );
 drop table medalist;
 

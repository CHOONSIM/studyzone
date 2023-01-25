/*
    # 데이터 추가
       - 데이터는 객체가 아니다(create로 시작하지 않는다)
       - 테이블은 이미 생성되어 있어야 한다.
       - insert into 테이블이름(집어넣을 컬럼) values(집어넣을값);
       - 숫자는 따옴표를 붙이지 않는다(자바와 동일)
       - 문자열은 따옴표 1개짜리로 설정(자바와 다름)
       - COMMIT 확정저장, ROLLBACK 버리기
*/

INSERT INTO WORLDCUP(RANK,NAME,NATION,GOAL)
VALUES(1,'음바페','프랑스',8);
INSERT INTO WORLDCUP(RANK,NAME,NATION,GOAL)
VALUES(2,'리오넬 메시','아르헨티나',7);
INSERT INTO WORLDCUP(RANK,NAME,NATION,GOAL)
VALUES(3,'올리비에 지루','프랑스',4);
INSERT INTO WORLDCUP(RANK,NAME,NATION,GOAL)
VALUES(4,'훌리안 알바레스','아르헨티나',4);
-- 데이터조회
SELECT * FROM WORLDCUP;
DELETE WORLDCUP;


-- 데이터 추가
INSERT INTO POCKETMON(NO,NAME,TYPE)
VALUES(1,'이상해씨','풀');
INSERT INTO POCKETMON(NO,NAME,TYPE)
VALUES(4,'파이리','불꽃');
INSERT INTO POCKETMON(NO,NAME,TYPE)
VALUES(7,'꼬부기','물');
INSERT INTO POCKETMON(NO,NAME,TYPE)
VALUES(25,'피카츄','전기');
-- 데이터 조회
SELECT * FROM POCKETMON;


-- 데이터 추가
INSERT INTO MEDALIST(NAME,EVENT,TYPE,GOLD,SILVER,BRONZE)
VALUES('진종오','사격','하계',4,2,0);
INSERT INTO MEDALIST(NAME,EVENT,TYPE,GOLD,SILVER,BRONZE)
VALUES('김수녕','양궁','하계',4,1,1);
INSERT INTO MEDALIST(NAME,EVENT,TYPE,GOLD,SILVER,BRONZE)
VALUES('전이경','쇼트트랙','동계',4,0,1);
-- 데이터 조회
SELECT * FROM MEDALIST;

ROLLBACK; -- 현재까지의 작업내역을 무효화
COMMIT;  -- 현재까지의 작업내역을 최종저장




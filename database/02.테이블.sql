-- ���̺�(table)
-- �����Ͱ� ����Ǵ� ��ü
-- ǥ �����̴�

CREATE TABLE ATTENDANCE(
NO NUMBER(10),
NAME VARCHAR2(21),
PHONE CHAR(13)
);

DROP TABLE ATTENDANCE;

-- Day08 ������ ���̺� ����
 CREATE TABLE WORLDCUP(
 RANK NUMBER(3),
 NAME VARCHAR(39),
 NATION VARCHAR(15),
 GOAL NUMBER(2)
 );
SELECT * FROM WORLDCUP;
DELETE WORLDCUP;
 ROLLBACK ;
 
 --Day08 ���ϸ� ���̺� ����
 CREATE TABLE POCKETMON(
 NO NUMBER(3),          -- ���ڸ� �Ⱦ��� �ڵ����� 38�ڸ��� ��
 NAME VARCHAR2(21),
 TYPE VARCHAR2(9)
 );
 DROP TABLE POCKETMON;
 
 --Day08 �޴޸���Ʈ ���̺� ����
 CREATE TABLE MEDALIST(
 NAME VARCHAR2(21),
 EVENT VARCHAR2(12),
 TYPE CHAR(6),             -- ������ ���ڿ� char
 GOLD NUMBER(2),
 SILVER NUMBER(2),
 BRONZE NUMBER(2)
 );
 DROP TABLE MEDALIST;
 

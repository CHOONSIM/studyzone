/*
            #������(SEQUENCE)
    - ��ȣ�� �̿��Ͽ� �����͵��� �����ؾ� �ϴ� ��� ��ȣ�� �����ϴ� ����
    - �� �� �߱��� ��ȣ�� ����� �ٽ� �߱����� ����
    - ��ȣ�� ���п�
    
    ���� : CREATE SEQUENXE �̸� [�ɼ�];        [ ] ������ ����
    ��� : �̸�.NEXTVAL
    ��ȸ : SELECT* FROM USER_SEQUENCE;
    ���� : DROP SEQUENCE �̸�;
*/
CREATE SEQUENCE ITEM_SEQ;
SELECT * FROM USER_SEQUENCES;
DROP SEQUENCE ITEM;

CREATE TABLE ITEM(
NO NUMBER PRIMARY KEY,                   -- ��ǥ�׸� (NOT NULL UNIQUE ����) 
NAME VARCHAR2(60) NOT NULL CHECK(REGEXP_LIKE(NAME,'^[��-�R0-9]+$')),            -- ����ǥ����
TYPE VARCHAR2(15) NOT NULL,
PRICE NUMBER NOT NULL CHECK(PRICE >=0),
EARLY CHAR(1) NOT NULL CHECK(EARLY IN('0','1')),
EVENT CHAR(1) NOT NULL CHECK(EVENT IN('0','1'))
);
DROP TABLE ITEM;


INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'���̽��ķ���','�ַ�',1200,'1','1');
INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'Ŭ�������','�ַ�',3000,'0','1');
INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'�ٳ���ű','����',1500,'0','1');
INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'��Ϲ���Ĩ','����',2000,'1','0');
COMMIT;

SELECT*FROM ITEM;


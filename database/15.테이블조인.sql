/*
    ���̺� ����(TABLE JOIN)
    - �и��Ǿ� �ִ� ���̺��� Ư�� ���ؿ� ���ؼ� ��ġ�� ��
    - ��ĥ ���� ������ �־�� ��
    - ������ �ִ� ���̺��� ���ľ� �Ѵ�.
*/
-- �Ʒ� �ڵ�� �ǹ̰� ����
-- SELECT * FROM POCKETMON, STUDENT; (ũ�ν� ����)

-- ������ ���̺� ����(�п��� ������)
CREATE TABLE ACADEMY(
ACADEMY_NO NUMBER PRIMARY KEY,
ACADEMY_NAME VARCHAR2(30) NOT NULL
);
INSERT INTO ACADEMY(
    ACADEMY_NO, ACADEMY_NAME
        ) VALUES(100,'KH������');
INSERT INTO ACADEMY(
    ACADEMY_NO, ACADEMY_NAME
        ) VALUES(200,'KH�����');
INSERT INTO ACADEMY(
    ACADEMY_NO, ACADEMY_NAME
        ) VALUES(300,'KH������');
COMMIT;

CREATE TABLE ROOM(
ROOM_NO NUMBER PRIMARY KEY,
ROOM_NAME VARCHAR2(30) NOT NULL,
ROOM_SIZE NUMBER NOT NULL,
ACADEMY_NO REFERENCES ACADEMY(ACADEMY_NO) ON DELETE CASCADE
);
INSERT INTO ROOM(
    ROOM_NO, ROOM_NAME, ROOM_SIZE, ACADEMY_NO
        ) VALUES(1,'A������',10,200);
        INSERT INTO ROOM(
    ROOM_NO, ROOM_NAME, ROOM_SIZE, ACADEMY_NO
        ) VALUES(2,'B������',20,200);
        INSERT INTO ROOM(
    ROOM_NO, ROOM_NAME, ROOM_SIZE, ACADEMY_NO
        ) VALUES(3,'C������',20,200);
        INSERT INTO ROOM(
    ROOM_NO, ROOM_NAME, ROOM_SIZE, ACADEMY_NO
        ) VALUES(4,'D������',10,100);
        INSERT INTO ROOM(
    ROOM_NO, ROOM_NAME, ROOM_SIZE, ACADEMY_NO
        ) VALUES(5,'E������',10,100);
        
        COMMIT;
        
-- INNER JOIN�� ����� �����͸� ��ȸ�� �����ϴ�
-- ���� : SELECT �׸� FROM A���̺� INNER JOIN B���̺� ON ��������
-- (����!) �ߺ��Ǵ� �÷����� �����ϰų� ��Ī���� �����ؾ� ��

-- SELECT*FROM ACADEMY+ROOM;
SELECT ACADEMY.*,ROOM.ROOM_NO, ROOM.ROOM_NAME, ROOM.ROOM_SIZE
FROM ACADEMY INNER JOIN ROOM 
ON ACADEMY.ACADEMY_NO = ROOM.ACADEMY_NO;

-- ��Ī �߰�
SELECT A.*,R.ROOM_NO, R.ROOM_NAME, R.ROOM_SIZE
FROM ACADEMY A INNER JOIN ROOM R 
ON A.ACADEMY_NO = R.ACADEMY_NO;

-- ���� : �Խñ� ��ȸ �� ȸ�� �г����� ���� ��ȸ
-- ������) ȸ���� Ż���Ͽ� �ۼ��ڰ� NULL�� �Ǹ� ��ȸ�� �̷������ �ʴ´�
-- �ذ�å) OUTER JOIN ���
SELECT B.*,M.MEMBER_NICK
FROM BOARD B INNER JOIN MEMBER M ON B.BOARD_WRITER = M.MEMBER_ID;

-- OUTER JOIN�� Ư�� ���̺��� �������� �Ͽ� ������ �����͸� ���� ��ȸ�Ѵ�.
-- ���� ���̺��� ��� ��ġ�� �ִ��Ŀ� ���� ������ �����ȴ�.
-- A �� B�� A LEFT OUTER JOIN B
-- A �� B�� A RIGHT OUTER JOIN B
-- A �� B�� A FULL OUTER JOIN B
-- ���� ���̺��� ���� �����Ͱ� ��� ��� ��ȸ�� �ȴ�

-- EX : �п��� �������� ������ ����������ȸ
SELECT A.*,R.ROOM_NO,R.ROOM_NAME
FROM 
    ACADEMY A LEFT OUTER JOIN ROOM R 
        ON A.ACADEMY_NO = R.ACADEMY_NO;
        
-- EX : Ȯ�� �� ������ ������ ���
-- (����!) COUNT(*)�� ����ϸ� NULL�� ī���õȴ�.
SELECT A.ACADEMY_NAME, COUNT(R.ROOM_NO)
FROM ACADEMY A LEFT OUTER JOIN ROOM R ON A.ACADEMY_NO = R.ACADEMY_NO
GROUP BY A.ACADEMY_NAME;

-- ���� : ȸ���� �Խñ� �ۼ� ���� ���
SELECT M.MEMBER_ID, COUNT(B.BOARD_NO) CNT
FROM MEMBER M LEFT OUTER JOIN BOARD B ON M.MEMBER_ID = B.BOARD_WRITER
GROUP BY M.MEMBER_ID 
ORDER BY CNT DESC;


-- ���� : ���ϸ��� ������ �̹��� ��ȣ�� ���
SELECT P.*, PI.ATTACHMENT_NO
FROM POCKETMON P LEFT OUTER JOIN POCKETMON_IMAGE PI ON P.NO = PI.POCKETMON_NO;

-- ���� : �Խñ� ������ ȸ�� �г��� , ������ �̹����� ��ȸ 
SELECT B.BOARD_NO,M.MEMBER_NICK, MP.ATTACHMENT_NO
FROM BOARD B
    LEFT OUTER JOIN MEMBER M ON B.BOARD_WRITER = M.MEMBER_ID
--    LEFT OUTER JOIN MEMBER_PROFILE MP ON B.BOARD_WRITER = MP.MEMBER_ID;
      LEFT OUTER JOIN MEMBER_PROFILE MP ON M.MEMBER_ID = MP.MEMBER_ID;
      
-- ���ϸ��� ������ �̹��� ��ȣ�� �Բ� ��ȸ�ϴ� ��
create view pocketmon_with_image as
SELECT P.*, PI.ATTACHMENT_NO
FROM POCKETMON P LEFT OUTER JOIN POCKETMON_IMAGE PI ON P.NO = PI.POCKETMON_NO;

select*from pocketmon_with_image;
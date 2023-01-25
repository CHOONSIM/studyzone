/*
    ��ȸ(Read)
    - �̸� ���̺� �־�� �����͸� ���ϴ� ������ �°� Ž��
    - ����, �׷�, ����
*/

CREATE TABLE PRODUCT(
NO NUMBER PRIMARY KEY,
NAME VARCHAR2(30) NOT NULL,
TYPE VARCHAR2(15) CHECK(TYPE IN ('����','���̽�ũ��','�ַ�','����')),
PRICE NUMBER,
MADE DATE,
EXPIRE DATE
);

INSERT INTO PRODUCT VALUES(1, '��ũ����', '���̽�ũ��', 1200, '2020-05-01', '2020-10-01');
INSERT INTO PRODUCT VALUES(2, '������', '����', 900, '2020-01-01', '2021-01-01');
INSERT INTO PRODUCT VALUES(3, '��������', '����', 3000, '2020-01-01', '2021-01-01');
INSERT INTO PRODUCT VALUES(4, '������', '����', 2200, '2020-02-01', '2020-10-20');
INSERT INTO PRODUCT VALUES(5, '���̽�', '�ַ�', 1000, '2020-01-05', '2020-04-05');
INSERT INTO PRODUCT VALUES(6, 'ó��ó��', '�ַ�', 1000, '2020-03-15', '2020-08-15');
INSERT INTO PRODUCT VALUES(7, '�ٳ���ű', '����', 1500, '2020-05-03', '2020-06-03');
INSERT INTO PRODUCT VALUES(8, '������', '���̽�ũ��', 1000, '2019-12-01', '2020-06-01');
INSERT INTO PRODUCT VALUES(9, '���佺', '����', 1200, '2020-03-20', '2020-12-31');
INSERT INTO PRODUCT VALUES(10, '������', '����', 2100, '2019-06-01', '2020-06-01');

COMMIT;

-- ��ü ������ ��ȸ
SELECT * FROM PRODUCT;

-- Ư�� �׸� ��ȸ
-- select �׸� from ������̺�;
SELECT NAME FROM PRODUCT;
SELECT NAME,PRICE FROM PRODUCT;

-- ���� �׸��� ��ȸ �Ұ���
-- ��� �׸��� ��ȸ
SELECT NO,NAME,PRICE,TYPE,MADE,EXPIRE FROM PRODUCT;
-- ���ϵ�ī�� ���
 SELECT*FROM PRODUCT;
    
-- ����� �׸��� �߰��� ��ȸ
-- ��¥ ���(�ϴ���)
SELECT NAME, EXPIRE-MADE FROM PRODUCT;

-- ���� : ���ϵ�ī��� �ܵ����θ� ��� ����
--select*,expire-made from product;
SELECT PRODUCT.*, EXPIRE-MADE FROM PRODUCT;

--����(����) : ����, ���ڿ�, ��¥
-- select*from product where ���͸�����;
--���� 1��
SELECT*FROM PRODUCT WHERE PRICE < 1000;

-- ������ 2�� �̻��̶�� �ڹٿ����� &&, ||�� ���
-- ����Ŭ���� &&�� �Է±�ȣ, ||�� ���ڿ� ���� ��ȣ
-- ��� ���ĺ� ������ ������ ����(and,or)
SELECT*FROM PRODUCT WHERE PRICE >= 1000 AND PRICE <=2000;


        -- Quiz ������ 1000�� �̸��̰ų� 2000�� �ʰ��� ��ǰ�� ��ȸ
SELECT*FROM PRODUCT WHERE PRICE <1000 OR PRICE >2000;

-- ��ȣ�� 5���� ��ǰ�� ��ȸ
-- ����Ŭ���� ���ٴ� = (1��)�� ó���Ѵ�.
SELECT * FROM PRODUCT WHERE NO=5;
SELECT*FROM PRODUCT WHERE NO != 5;

-- ���ڿ� ���� : ��ġ, ���� �˻�
-- ���� �˻� ����� 2�����̹Ƿ� �����Ͽ� ����� �� �־�� �Ѵ�
    -- like �� %�� ����Ͽ� ���ϰ˻縦 �ϴ� ���
    -- instr�� Ư�� Ű���尡 ���° ��ġ�� �����ϴ��� �˾Ƴ��� ���
-- ��ü���� ������ instr�� �켼������ ���۰˻縸ŭ�� like�� ����(like : ù���ڸ� ���� �ڸ� �Ⱥ�����)

SELECT * FROM PRODUCT WHERE NAME = '��ũ����';          -- �Ϻ��� ����

-- like ó���ӵ��� �� ����(���۰˻�)
SELECT * FROM PRODUCT WHERE NAME LIKE '��%��%';       -- ����˻� like '%';
SELECT * FROM PRODUCT WHERE INSTR(NAME, '��ũ��') >0;  -- ����˻� instr


-- �� ��� instr ó���ӵ��� �� ����(���۰˻� ����)
SELECT * FROM PRODUCT WHERE NAME LIKE '%��%' ;         -- '��' �� �� ��ǰ, like ����˻� �� ù���ڿ� %�� ���� �� ������ ������  
SELECT * FROM PRODUCT WHERE INSTR(NAME, '��') >0;


        -- Quiz ���ڿ� ���̽�ũ���� ��ȸ
        SELECT*FROM PRODUCT WHERE TYPE='����' AND TYPE='���̽�ũ��';
        SELECT*FROM PRODUCT WHERE TYPE IN ('����','���̽�ũ��');
        
        -- Quiz ���ڿ� �ַ��߿��� ������ 1000�� �̻� 2000�� ������ ��ǰ�� ��ȸ
        SELECT * FROM PRODUCT WHERE (TYPE ='����' OR TYPE = '�ַ�') AND (PRICE >= 1000 PRICE <= 2000);
        SELECT * FROM PRODUCT WHERE TYPE IN('����','�ַ�') AND PRICE BETWEEN 1000 AND 2000;        -- 1000 ~ 2000 ���� = 1000�̻� 2000����
         
        -- Quiz �̸��� '����'�� ����ִ� ��ǰ ��ȸ
        SELECT * FROM PRODUCT WHERE INSTR(NAME,'����')>0;
        
        -- Quiz �̸��� '�ٳ���'�� �����ϴ� ��ǰ�� ��ȸ
        SELECT * FROM PRODUCT WHERE NAME LIKE '�ٳ���%';
        
        -- Quiz �̸��� '��'��� ���ڰ� ������� ���� ��ǰ ��ȸ
        -- (����) not�� �������� �ڸ��� �� �� �ִ� ���� �ܾ��� ���� ��ȣ
        SELECT * FROM PRODUCT WHERE NAME NOT LIKE '%��%';
        SELECT * FROM PRODUCT WHERE INSTR(NAME,'��')=0;
        
-/*
    ��¥
    - �⺻������ YYYY-MM-DD HH24:MI:SS (�ڹٿ� �ٸ�, ��ҹ��� ���� ����)
    - ���ڿ�ó�� ����� �� �յ� �������� ��¥ ������ �޶� ����
    - ��¥�� ��ɵ��� ����(to_char, TO_DATE, EXTRACT)
*/

-- extract��
SELECT NAME, MADE, EXTRACT(YEAR FROM MADE)FROM PRODUCT;         -- made���� �⵵�� �̾ƶ� product����

-- ex) 2019�⵵�� ������ ��ǰ ��ȸ
SELECT*FROM PRODUCT WHERE EXTRACT(YEAR FROM MADE) = 2019; 

        -- Quiz ����(6,7,8)���� ������ ��ǰ ��ȸ
        SELECT*FROM PRODUCT WHERE EXTRACT(MONTH FROM MADE) = 06 OR EXTRACT(MONTH FROM MADE) = 07; OR EXTRACT(MONTH FROM MADE) = 08;
        SELECT * FROM PRODUCT WHERE EXTRACT(MONTH FROM MADE) IN(6,7,8);
        SELECT * FROM PRODUCT WHERE EXTRACT(MONTH FROM MADE) BETWEEN 06 AND 08;

-- to_char ����� ��¥�� ���ϴ� ������ ���ڿ��� �����ϴ� ���
-- (�ڹ��� SimpleDateFormat�� ������ ����, ��ҹ��� ���� ����)
SELECT NAME, MADE, TO_CHAR(MADE,'yyyy-mm-dd')FROM PRODUCT;

--  EX) 2019�⿡ ������ ��ǰ ��ȸ
SELECT*FROM PRODUCT WHERE TO_CHAR(MADE,'YYYY') = 2019;

-- EX) ��(3,4,5��)�� ������ ��ǰ ��ȸ
SELECT*FROM PRODUCT WHERE TO_CHAR(MADE,'MM') IN (03,04,05);
SELECT*FROM PRODUCT WHERE REGEXP_LIKE(RO_CHAR(MADE,'MM'),'^0[345]$');   -- ����ǥ���ĵ� ��밡��, ���� ����(����ǥ������ �� �ʿ��� ��츸)

-- ��¥ ��ü�� �񱳵� �����Ѱ�?
-- EX) 2019�⿡ ������ ��ǰ ��ȸ = 2019-01-01~2019-12-31
/*
���ڿ��� ��¥�� ȥ���ϸ� ����,������ ���� �۵� X 
SELECT*FROM PRODUCT WHERE MADE >= '2019-01-01' AND MADE <='2019-12-31';
TO_DATE�� ����ϸ� ���ڿ��� ��¥�� �ٲ� �� �ִ�(������ �˷���� �Ѵ�)
*/
SELECT*FROM PRODUCT WHERE MADE >= TO_DATE('2019-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS');       -- 19�⵵����
SELECT*FROM PRODUCT WHERE MADE <= TO_DATE('2019-12-31 23:59:59','YYYY-MM-DD HH24:MI:SS');       -- 19�⵵ ����

SELECT*FROM PRODUCT WHERE MADE BETWEEN TO_DATE('2019-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS')       -- 19�⵵ 1��1�� ���� 19�⵵ 12��31�ϱ���
    AND TO_DATE('2019-12-31 23:59:59','YYYY-MM-DD HH24:MI:SS');

-- ��¥���� SYSDATE��� Ű����� ����ð��� ���� ��¥ ��ü�� ���Ѵ�.
-- �ֱ� 1�Ⱓ ����� ��ǰ ��ȸ
SELECT*FROM PRODUCT WHERE MADE BETWEEN SYSDATE-365 AND SYSDATE;

-- �ֱ� 5�а� ���� ��ȸ
SELECT*FROM PRODUCT WHERE MADE BETWEEN SYSDATE-5/24/60 AND SYSDATE;

/*
    ����
    - ��ȸ�� ���� �����͸� ���ϴ� ������� �����ϴ� �۾�
    - ��������(ASCENDING, ASC)�� ��������(DESCENDING, DESC)���� ����
    - (����) ������ �����Ͱ� Ȯ���� ���Ŀ� �ؾ��Ѵ�
*/
SELECT* FROM PRODUCT ORDER BY NO ASC;       -- ��������
SELECT*FROM PRODUCT ORDER BY PRICE ASC;     -- �����Ѽ�
SELECT*FROM PRODUCT ORDER BY PRICE DESC;   -- ��Ѽ�

-- ������ �������� 
-- SELECT*FROM PRODUCT ORDER BY PRICE DESC WHERE PRICE BETWEEN 1000 AND 2000;
SELECT*FROM PRODUCT WHERE PRICE BETWEEN 1000 AND 2000 ORDER BY PRICE DESC;

-- ���� ���� �� ������ �׸��� �����Ѵٸ�, ���� ���� ������ �߰��ؾ� ��
SELECT*FROM PRODUCT ORDER BY PRICE DESC, NO ASC;

        -- QUIZ �ֱٿ� ������ ��ǰ���� ���
        SELECT * FROM PRODUCT ORDER BY MADE DESC,NO DESC;
        -- QUIZ �̸������� ���
        SELECT * FROM PRODUCT ORDER BY NAME ASC, NO ASC;
        -- QUIZ ���ڿ� �ַ� ��ǰ���� ������ ��� ������ ���
        SELECT * FROM PRODUCT WHERE TYPE BETWEEN '����' AND '�ַ�' ORDER BY PRICE DESC,NO DESC;
         SELECT * FROM PRODUCT WHERE TYPE IN( '����','�ַ�') ORDER BY PRICE DESC,NO DESC;
        -- QUIZ ��������� ���� ª�� ��ǰ���� ���
        SELECT * FROM PRODUCT ORDER BY EXPIRE-MADE ASC, NO ASC;
        
        -- # ��ȸ�ϴ� �׸��� ��Ī�� �ٿ� ���ϴ� �̸����� �ٲ� �� �ִ�.
        SELECT PRODUCT.* , EXPIRE-MADE EXPIREDAYS FROM PRODUCT      --  SELECT PRODUCT . * , EXPIRE - MADE ��Ī
        ORDER BY EXPIREDAYS ASC, NO ASC;
        
        -- # ��Ī�� ���⸦ ���� �ʹٸ� �ֵ���ǥ�� ���Ѵ�
        -- (����) �ڹٿ��� ��ɹ��� ���� ������ ���Ⱑ ��ƴ�.
        SELECT PRODUCT.* , EXPIRE-MADE "������� �ϼ�" FROM PRODUCT     
        ORDER BY "������� �ϼ�" ASC, NO ASC;
        

        
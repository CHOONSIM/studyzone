/*
    # ����(UPDATE)
    - �̹� �����ϴ� �����͸� �����ϴ� ��
    - �����Ͱ� ���ϴ� ��쿡�� COMMIT / ROLLBACK�� ������ ����
    - ��ü�� �����ϴ� ���� ���� ����, ������ ���� ���ϴ� �׸��� �����Ѵ�.
    -Ư�� PK(PRIMARY KEY)�� �̿��Ͽ� �ϳ��� �׸� ��ġ�� ��찡 ����.
    
    - UPDATE ���̺��̸� SET �ٲܳ��� [����]
*/

-- ��� ��ǰ�� ������ 0����
UPDATE PRODUCT SET PRICE = 0;

--  1�� ��ǰ�� ������ 1500������ ����
UPDATE PRODUCT SET PRICE = 1500 WHERE NO = 1;

        -- QUIZ ��ũ������ ������ 2000������ ����
        UPDATE PRODUCT SET PRICE = 2000 WHERE NAME = '��ũ����';
        -- QUIZ ���佺�� ������ 1000������ �����ϰ� �з��� ���ڷ� ����
        UPDATE PRODUCT SET PRICE = 1000, TYPE = '����'  WHERE NAME = '���佺' ; 
        -- QUIZ ���ڰ��� 500�� ����
        UPDATE PRODUCT SET PRICE = PRICE -500 WHERE TYPE = '����';
        -- QUIZ ���̽�ũ�� ���� 10% �λ�
        UPDATE PRODUCT SET PRICE = PRICE * 1.1 WHERE TYPE = '���̽�ũ��';
        
SELECT * FROM PRODUCT;
ROLLBACK;


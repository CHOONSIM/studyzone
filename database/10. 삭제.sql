/*
    ����
    - �����ϴ� �����͸� ����� �۾�
    - �������� ������ ����Ƿ� COMMIT / ROLLBACK �ʿ�
    - ������ ��κ� ���
    
    DELETE ���̺��̸� [����]
*/

DELETE PRODUCT;

        -- QUIZ 1�� ��ǰ ����
        DELETE PRODUCT WHERE NO = 1;
        
        -- QUIZ 2020�� ��ݱ⿡ ������ ��ǰ ������ ����
        DELETE PRODUCT WHERE MADE BETWEEN 
        TO_DATE('2020-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS') 
        AND 
        TO_DATE('2020-06-30 00:00:00','YYYY-MM-DD HH24:MI:SS');
        
        DELETE PRODUCT
        WHERE EXTRACT(YER FROM MADE) = 2020
        AND EXTRACT(MONTH FROM MADE) BETWEEN 1 AND 6;
        
        DELETE PRODUCT
        WHERE REGEXP_LIKE(TO_CHAR(MADE,'YYYY-MM'), '^2020-0[1-6]$');

SELECT * FROM PRODUCT;
ROLLBACK;
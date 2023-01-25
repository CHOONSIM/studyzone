/*
    삭제
    - 존재하는 데이터를 지우는 작업
    - 데이터의 변경이 생기므로 COMMIT / ROLLBACK 필요
    - 조건을 대부분 사용
    
    DELETE 테이블이름 [조건]
*/

DELETE PRODUCT;

        -- QUIZ 1번 상품 삭제
        DELETE PRODUCT WHERE NO = 1;
        
        -- QUIZ 2020년 상반기에 제조된 상품 정보를 삭제
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
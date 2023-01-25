/*
    # 수정(UPDATE)
    - 이미 존재하는 데이터를 변경하는 것
    - 데이터가 변하는 경우에만 COMMIT / ROLLBACK의 영향을 받음
    - 전체를 수정하는 경우는 거의 없고, 조건을 통해 원하는 항목을 수정한다.
    -특히 PK(PRIMARY KEY)를 이용하여 하나의 항목만 고치는 경우가 많다.
    
    - UPDATE 테이블이름 SET 바꿀내용 [조건]
*/

-- 모든 상품의 가격을 0으로
UPDATE PRODUCT SET PRICE = 0;

--  1번 상품의 가격을 1500원으로 변경
UPDATE PRODUCT SET PRICE = 1500 WHERE NO = 1;

        -- QUIZ 스크류바의 가격을 2000원으로 변경
        UPDATE PRODUCT SET PRICE = 2000 WHERE NAME = '스크류바';
        -- QUIZ 멘토스의 가격을 1000원으로 변경하고 분류를 과자로 변경
        UPDATE PRODUCT SET PRICE = 1000, TYPE = '과자'  WHERE NAME = '멘토스' ; 
        -- QUIZ 과자가격 500원 할인
        UPDATE PRODUCT SET PRICE = PRICE -500 WHERE TYPE = '과자';
        -- QUIZ 아이스크림 가격 10% 인상
        UPDATE PRODUCT SET PRICE = PRICE * 1.1 WHERE TYPE = '아이스크림';
        
SELECT * FROM PRODUCT;
ROLLBACK;


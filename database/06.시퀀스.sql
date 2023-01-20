/*
            #½ÃÄö½º(SEQUENCE)
    - ¹øÈ£¸¦ ÀÌ¿ëÇÏ¿© µ¥ÀÌÅÍµéÀ» ±¸ºÐÇØ¾ß ÇÏ´Â °æ¿ì ¹øÈ£¸¦ »ý¼ºÇÏ´Â µµ±¸
    - ÇÑ ¹ø ¹ß±ÞÇÑ ¹øÈ£´Â Àý´ë·Î ´Ù½Ã ¹ß±ÞÇÏÁö ¾ÊÀ½
    - ¹øÈ£´Â ±¸ºÐ¿ë
    
    »ý¼º : CREATE SEQUENXE ÀÌ¸§ [¿É¼Ç];        [ ] »ý·«ÀÌ °¡´É
    »ç¿ë : ÀÌ¸§.NEXTVAL
    Á¶È¸ : SELECT* FROM USER_SEQUENCE;
    »èÁ¦ : DROP SEQUENCE ÀÌ¸§;
*/
CREATE SEQUENCE ITEM_SEQ;
SELECT * FROM USER_SEQUENCES;
DROP SEQUENCE ITEM;

CREATE TABLE ITEM(
NO NUMBER PRIMARY KEY,                   -- ´ëÇ¥Ç×¸ñ (NOT NULL UNIQUE Æ÷ÇÔ) 
NAME VARCHAR2(60) NOT NULL CHECK(REGEXP_LIKE(NAME,'^[°¡-ÆR0-9]+$')),            -- Á¤±ÔÇ¥Çö½Ä
TYPE VARCHAR2(15) NOT NULL,
PRICE NUMBER NOT NULL CHECK(PRICE >=0),
EARLY CHAR(1) NOT NULL CHECK(EARLY IN('0','1')),
EVENT CHAR(1) NOT NULL CHECK(EVENT IN('0','1'))
);
DROP TABLE ITEM;


INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'ÂüÀÌ½½ÈÄ·¹½¬','ÁÖ·ù',1200,'1','1');
INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'Å¬¶ó¿ìµå¸ÆÁÖ','ÁÖ·ù',3000,'0','1');
INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'¹Ù³ª³ªÅ±','°úÀÚ',1500,'0','1');
INSERT INTO ITEM(NO,NAME,TYPE,PRICE,EARLY,EVENT)
VALUES(ITEM_SEQ.NEXTVAL,'Çã´Ï¹öÅÍÄ¨','°úÀÚ',2000,'1','0');
COMMIT;

SELECT*FROM ITEM;


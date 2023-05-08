--대표 결제 테이블(결제1건에 대한 정보)
create table payment(
payment_no number primary key,
payment_tid varchar2(20) not null,
payment_name varchar2(300) not null,
payment_total number not null,
payment_remain number not null,
payment_time date not null,
member_id varchar2(20) not null
);
create SEQUENCE payment_seq;

--상품 테이블
create table item(
item_no number primary key,
item_name varchar2(60) not null,
item_price number not null check(item_price >= 0),
item_discount number not null,
--check(item_discount < item_price and item_discount >0)
check(item_discount between 0 and item_price)
);
create SEQUENCE item_seq;

select*from item;

-- 상세 결제 정보 테이블
create table payment_detail(
payment_detail_no number primary key,
payment_no references payment(payment_no) on delete cascade,
item_no number not null,
item_name varchar2(300) not null,
item_price number not null,
item_qty number not null,
);
create SEQUENCE payment_detail_seq;

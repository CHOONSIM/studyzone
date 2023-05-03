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

select*from table payment;
delete table payment;
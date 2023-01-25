/*
    ��ȸ(Read)
    - �̸� ���̺� �־�� �����͸� ���ϴ� ������ �°� Ž��
    - ����, �׷�, ����
*/

create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('����','���̽�ũ��','�ַ�','����')),
price number,
made date,
expire date
);

insert into product values(1, '��ũ����', '���̽�ũ��', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '������', '����', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '��������', '����', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '������', '����', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '���̽�', '�ַ�', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, 'ó��ó��', '�ַ�', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '�ٳ���ű', '����', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '������', '���̽�ũ��', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '���佺', '����', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '������', '����', 2100, '2019-06-01', '2020-06-01');

commit;

-- ��ü ������ ��ȸ
select * from product;

-- Ư�� �׸� ��ȸ
-- select �׸� from ������̺�;
select name from product;
select name,price from product;

-- ���� �׸��� ��ȸ �Ұ���
-- ��� �׸��� ��ȸ
select no,name,price,type,made,expire from product;
-- ���ϵ�ī�� ���
 select*from product;
    
-- ����� �׸��� �߰��� ��ȸ
-- ��¥ ���(�ϴ���)
select name, expire-made from product;

-- ���� : ���ϵ�ī��� �ܵ����θ� ��� ����
--select*,expire-made from product;
select product.*, expire-made from product;

--����(����) : ����, ���ڿ�, ��¥
-- select*from product where ���͸�����;
--���� 1��
select*from product where price < 1000;

-- ������ 2�� �̻��̶�� �ڹٿ����� &&, ||�� ���
-- ����Ŭ���� &&�� �Է±�ȣ, ||�� ���ڿ� ���� ��ȣ
-- ��� ���ĺ� ������ ������ ����(and,or)
select*from product where price >= 1000 and price <=2000;


        -- Quiz ������ 1000�� �̸��̰ų� 2000�� �ʰ��� ��ǰ�� ��ȸ
select*from product where price <1000 or price >2000;

-- ��ȣ�� 5���� ��ǰ�� ��ȸ
-- ����Ŭ���� ���ٴ� = (1��)�� ó���Ѵ�.
select * from product where no=5;
select*from product where no != 5;

-- ���ڿ� ���� : ��ġ, ���� �˻�
-- ���� �˻� ����� 2�����̹Ƿ� �����Ͽ� ����� �� �־�� �Ѵ�
    -- like �� %�� ����Ͽ� ���ϰ˻縦 �ϴ� ���
    -- instr�� Ư�� Ű���尡 ���° ��ġ�� �����ϴ��� �˾Ƴ��� ���
-- ��ü���� ������ instr�� �켼������ ���۰˻縸ŭ�� like�� ����(like : ù���ڸ� ���� �ڸ� �Ⱥ�����)

select * from product where name = '��ũ����';          -- �Ϻ��� ����

-- like ó���ӵ��� �� ����(���۰˻�)
select * from product where name like '��%��%';       -- ����˻� like '%';
select * from product where instr(name, '��ũ��') >0;  -- ����˻� instr


-- �� ��� instr ó���ӵ��� �� ����(���۰˻� ����)
select * from product where name like '%��%' ;         -- '��' �� �� ��ǰ, like ����˻� �� ù���ڿ� %�� ���� �� ������ ������  
select * from product where instr(name, '��') >0;


        -- Quiz ���ڿ� ���̽�ũ���� ��ȸ
        select*from product where type='����' and type='���̽�ũ��';
        select*from product where type in ('����','���̽�ũ��');
        
        -- Quiz ���ڿ� �ַ��߿��� ������ 1000�� �̻� 2000�� ������ ��ǰ�� ��ȸ
        select * from product where (type ='����' or type = '�ַ�') and (price >= 1000 price <= 2000);
        select * from product where type in('����','�ַ�') and price between 1000 and 2000;        -- 1000 ~ 2000 ���� = 1000�̻� 2000����
         
        -- Quiz �̸��� '����'�� ����ִ� ��ǰ ��ȸ
        select * from product where instr(name,'����')>0;
        
        -- Quiz �̸��� '�ٳ���'�� �����ϴ� ��ǰ�� ��ȸ
        select * from product where name like '�ٳ���%';
        
        -- Quiz �̸��� '��'��� ���ڰ� ������� ���� ��ǰ ��ȸ
        -- (����) not�� �������� �ڸ��� �� �� �ִ� ���� �ܾ��� ���� ��ȣ
        select * from product where name not like '%��%';
        select * from product where instr(name,'��')=0;
        
-- ��¥
-- �⺻������ YYYY-MM-DD HH24:MI:SS (�ڹٿ� �ٸ�, ��ҹ��� ���� ����)
-- ���ڿ�ó�� ����� �� �յ� �������� ��¥ ������ �޶� ����
-- ��¥�� ��ɵ��� ����(to_char, to_date, extract)

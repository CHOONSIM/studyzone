-- ���̺�(table)
-- �����Ͱ� ����Ǵ� ��ü
-- ǥ �����̴�

create table attendance(
no number(10),
name varchar2(21),
phone char(13)
);

drop table attendance;

-- Day08 ������ ���̺� ����
 create table worldcup(
 rank number(3),
 name varchar(39),
 nation varchar(15),
 goal number(2)
 );
 drop table worldcup;
 
 --Day08 ���ϸ� ���̺� ����
 create table pocketmon(
 no number(3),          -- ���ڸ� �Ⱦ��� �ڵ����� 38�ڸ��� ��
 name varchar2(21),
 type varchar2(9)
 );
 drop table pocketmon;
 
 --Day08 �޴޸���Ʈ ���̺� ����
 create table medalist(
 name varchar2(21),
 event varchar2(12),
 type char(6),             -- ������ ���ڿ� char
 gold number(2),
 silver number(2),
 bronze number(2)
 );
 drop table medalist;
 

/*
    # ������ �߰�
       - �����ʹ� ��ü�� �ƴϴ�(create�� �������� �ʴ´�)
       - ���̺��� �̹� �����Ǿ� �־�� �Ѵ�.
       - insert into ���̺��̸�(������� �÷�) values(���������);
       - ���ڴ� ����ǥ�� ������ �ʴ´�(�ڹٿ� ����)
       - ���ڿ��� ����ǥ 1��¥���� ����(�ڹٿ� �ٸ�)
       - commit Ȯ������, rollback ������
*/

insert into worldcup(rank,name,nation,goal)
values(1,'������','������',8);
insert into worldcup(rank,name,nation,goal)
values(2,'������ �޽�','�Ƹ���Ƽ��',7);
insert into worldcup(rank,name,nation,goal)
values(3,'�ø��� ����','������',4);
insert into worldcup(rank,name,nation,goal)
values(4,'�Ǹ��� �˹ٷ���','�Ƹ���Ƽ��',4);
-- ��������ȸ
select * from worldcup;


-- ������ �߰�
insert into pocketmon(no,name,type)
values(1,'�̻��ؾ�','Ǯ');
insert into pocketmon(no,name,type)
values(4,'���̸�','�Ҳ�');
insert into pocketmon(no,name,type)
values(7,'���α�','��');
insert into pocketmon(no,name,type)
values(25,'��ī��','����');
-- ������ ��ȸ
select * from pocketmon;


-- ������ �߰�
insert into medalist(name,event,type,gold,silver,bronze)
values('������','���','�ϰ�',4,2,0);
insert into medalist(name,event,type,gold,silver,bronze)
values('�����','���','�ϰ�',4,1,1);
insert into medalist(name,event,type,gold,silver,bronze)
values('���̰�','��ƮƮ��','����',4,0,1);
-- ������ ��ȸ
select * from medalist;

rollback; -- ��������� �۾������� ��ȿȭ
commit;  -- ��������� �۾������� ��������




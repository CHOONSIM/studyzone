drop table chat_user;
drop table chat_room;
-- 채팅방 테이블 
create table chat_room (
room_name varchar2(100) primary key,
room_created date default sysdate not null
);

-- 채팅방 참여자 테이블
create table chat_user (
room_name references chat_room(room_name) on delete cascade not null,
member_id references member(member_id) on delete set null,
join_time date default sysdate not null,
primary key(room_name, member_id)
);
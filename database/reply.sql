create table reply(
reply_no number primary key,
reply_writer references member(member_id) on delete cascade not null,
reply_origin references board(board_no) on delete cascade not null,
reply_content varchar2(3000) not null,
reply_time date default sysdate not null
);
create sequence reply_seq;
drop table reply;
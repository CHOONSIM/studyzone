-- 사용자 생성 및 삭제
create user testuser identified by test1234;
drop user testuser;

-- 권한 부여
create user kh11 identified by kh11;
grant connect, resource to kh11;


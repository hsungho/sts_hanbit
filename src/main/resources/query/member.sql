insert into TEST select 'lee','1' from dual union all select 'ckan','2222' from dual;

select * from member; -- list
select * from member where id = 'lee'; -- find By PK
select * from member where name = '이순신'; -- find By Not PK
select count(*) from member; -- count
delete test;

create table member(
	name varchar2(20),
	id varchar2(20) primary key,
	pw varchar2(20),
	reg_date varchar2(20),
	ssn_id varchar2(8),
	email varchar2(30)
);
-- Create
delete member;
insert into member(id,pw,name,reg_date,ssn_id)
values('hong2','1','홍길동','2016-07-01','800101-1');
insert into member(id,pw,name,reg_date,ssn_id)
values('lee','1','이순신','2015-07-01','900101-1');
insert into member(id,pw,name,reg_date,ssn_id)
values('you','1','유관순','2014-07-01','010101-4');
select *
from   member;
update member 
set    pw = '99'
where id = 'you'
;
delete MEMBER mem
where mem.id = 'park'
;
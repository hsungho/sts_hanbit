create sequence seq
increment by 1
start with 1000
NOCYCLE
;

create table grade(
	seq	       number constraint grade_pk primary key,
	exam_date  varchar2(10),
	grade      varchar2(1),
	java       number,
	sql        number,
	html       number,
	javascript number,
	id         varchar2(20),
	constraint grade_member_fk foreign key(id)
	references member(id) on delete cascade
);
-- create
insert into grade(
	seq,
	grade,
	java,
	sql,
	html,
	javascript,
	id,
	exam_date
)
values(
	seq.nextval,
	'C',
	70,
	75,
	70,
	72,
	'hong',
	'2016-06'
);
-- read : list
select * from grade;
-- read : findByPK
select * from grade 
where seq = 1000;
-- read : findBynotPK
select * from grade
where id = 'hong';
-- read : count
select count(*) from grade;
alter table grade add exam_date varchar2(10);
-- update : update
update grade
set    exam_date = '2016-05'
where  seq = 1000
;
-- delete : delete
delete from grade where  seq = 1000;
drop table grade;
-----------------view--------------------------------
--- 뷰 권한주기
sqlplus system/dksckdrb;
grant dba to hanbit;
create view grade_view as
select g.seq
      ,m.name
      ,g.grade
      ,g.exam_date
      ,g.java
      ,g.sql
      ,g.html
      ,g.javascript
      ,g.id
from   grade g,member m
where  g.id = m.id
;
select *
from grade_view
;
drop view grade_view;
-- join 조인
create view grade_member as
select g.seq,
       g.exam_date,
       g.grade,
       g.java,
       g.sql,
       g.html,
       g.javascript js,
       m.id,
       m.pw,
       m.name,
       m.reg_date,
       m.ssn_id
from   grade g,member m
where  g.id = m.id
;
select *
from   grade_member
;
insert into
(select g.seq,
       g.exam_date,
       g.grade,
       g.java,
       g.sql,
       g.html,
       g.javascript js,
       m.id,
       m.pw,
       m.name,
       m.reg_date,
       m.ssn_id
from   grade g,member m
where  g.id = m.id
)
values(
seq.nextval,
'2016-06',
'B',
80,
80,
80,
80,
'ckan',
'7777',
'안중근',
to_char(sysdate,'YYYY-MM-DD HH24:MI:SS'),
'700101-1'
);
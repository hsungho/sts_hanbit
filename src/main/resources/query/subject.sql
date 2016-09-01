create sequence subj_seq start with 1000;
create table subject(
	subj_seq number primary key,
	major    varchar2(10),
	subjects varchar2(100),
	id       varchar2(20),
	constraint subject_member_fk foreign key(id)
	references member(id) on delete cascade
);
select *
from   subject
;
insert into subject(subj_seq,major,subjects,id)
values(subj_seq.nextval,'computer','java,sql,python','haesu');
insert into subject(subj_seq,major,subjects,id)
values(subj_seq.nextval,'computer','java,sql,html','tzuyu');
insert into subject(subj_seq,major,subjects,id)
values(subj_seq.nextval,'mgmt','cpp,python,delphi','bewhy');
insert into subject(subj_seq,major,subjects,id)
values(subj_seq.nextval,'math','java,python,delphi','han');
insert into subject(subj_seq,major,subjects,id)
values(subj_seq.nextval,'eng','java,sql,python,delphi','bae');
drop table subject;

create or replace view subject_member
as
select m.id
      ,m.pw
      ,m.name
      ,m.reg_date
      ,m.ssn_id
      ,substrb(m.ssn_id,1,6) birth
      ,m.email
      ,m.profile_img img
      ,m.phone
      ,s.major
      ,s.subjects
from   member  m,
       subject s
where  m.id = s.id
;
select *
from   subject_member
;
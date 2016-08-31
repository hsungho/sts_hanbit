---------[내부 스키마:물리적]------------
create table account
(account_no number       not null primary key,
 money      number,
 pw         varchar2(20) not null,
 id         varchar2(20) not null,
 constraint account_member_fk foreign key(id)
         references member(id) on delete cascade
);
select * from account;
drop table account;
delete ACCOUNt
where  account_no = 0;
---------[외부 스키마:논리적]------------
create view account_member as
select a.account_no
      ,m.name
      ,m.id
      ,a.money
      ,a.pw
      ,m.ssn_id
from   account a,member m
where  a.id = m.id
;
drop view account_member;
select *
from   account_member;
drop table if exists AccessCountEntity;
drop table if exists MemberEntity;

create table AccessCountEntity (
   id bigint not null auto_increment,
    ipAddr varchar(20) not null,
    dayCount integer,
    monthCount integer,
    totalCount integer,
    yearCount integer,
    createdAt datetime(6) not null,
    updatedAt datetime(6) not null,
    primary key (id)
) engine=InnoDB;
alter table AccessCountEntity
   add constraint UK_AccessCountEntity_ipAddr unique (ipAddr);

create table MemberEntity (
   id bigint not null auto_increment,
    userid varchar(50) not null,
    email varchar(50) not null,
    password varchar(50),
    nickName varchar(50) not null,
    role varchar(5) not null,
    age integer,
    phoneNumber varchar(50),
    zipcode varchar(6),
    address varchar(50),
    addressDetail varchar(100),
    createdAt datetime(6) not null,
    updatedAt datetime(6) not null,
    primary key (id)
) engine=InnoDB;
alter table MemberEntity
   add constraint UK_MemberEntity_userid unique (userid);
alter table MemberEntity
   add constraint UK_MemberEntity_email unique (email);

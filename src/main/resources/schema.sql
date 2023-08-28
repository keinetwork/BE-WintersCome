drop table if exists AccessCount;
drop table if exists Member;

create table AccessCount (
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
alter table AccessCount
   add constraint UK_AccessCount_ipAddr unique (ipAddr);

create table Member (
   id bigint not null auto_increment,
    username varchar(50) not null,
    email varchar(50) not null,
    password varchar(100) not null,
    nickName varchar(50),
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
alter table Member
   add constraint UK_Member_username unique (username);
alter table Member
   add constraint UK_Member_email unique (email);

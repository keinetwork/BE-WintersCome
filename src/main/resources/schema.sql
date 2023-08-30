---------------------- JPA
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

---------------------- MY Batis
drop table if exists POSTURE;
drop table if exists MEMBERS;

CREATE TABLE MEMBERS
(
    MB_ID           VARCHAR(30) NOT NULL    COMMENT '회원 아이디',
    MB_NAME         VARCHAR(30) NULL        COMMENT '회원 이름',
    MB_PWD          VARCHAR(30) NULL        COMMENT '회원 비밀번호',
    MB_BIRTHDATE    DATE        NULL        COMMENT '생년월일',
    JOIN_DATE       DATETIME    NULL DEFAULT NOW() COMMENT '가입일자',
    ADMIN_YN        VARCHAR(1)  NULL        COMMENT '관리자여부',
    MB_SEX          VARCHAR(30) NULL        COMMENT '성별',
    MB_EMAIL        VARCHAR(30) NULL        COMMENT '이메일',
    MB_NICK         VARCHAR(30) NULL        COMMENT '닉네임',
    CONSTRAINT PK_MEMBERS PRIMARY KEY (MB_ID)
);
ALTER TABLE MEMBERS COMMENT '회원정보';

CREATE TABLE POSTURE
(
    `POS_SEQ` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '자세 순번',
    `POS_TYPE` VARCHAR(30) NOT NULL COMMENT '자세 종류',
    `POS_TIME` DATE NOT NULL COMMENT '발생일자',
    `POS_COUNT` INT UNSIGNED NOT NULL COMMENT '발생횟수',
    `MB_ID` VARCHAR(30) NOT NULL COMMENT '회원아이디',
    PRIMARY KEY (POS_SEQ)
);
--ALTER TABLE POSTURE COMMENT '자세정보';
--ALTER TABLE POSTURE
--    ADD CONSTRAINT FK_POSTURE_MB_ID_MEMBER_MB_ID FOREIGN KEY (MB_ID)
--        REFERENCES MEMBERS (MB_ID) ON DELETE RESTRICT ON UPDATE RESTRICT;
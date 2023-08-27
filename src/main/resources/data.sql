-- h2
--insert into MemberEntity(`id`,`userid`, email`, `password`, `nickName`, `role`, `createdAt`, `updatedAt`)
--    values(1, 'admin', 'admin', 'admin', 'ADMIN', 'ADMIN', now(), now());
-- mysql
insert into MemberEntity(`userid`, `email`, `password`, `nickName`, `role`, `createdAt`, `updatedAt`)
    values('admin', 'admin', 'admin', 'ADMIN', 'ADMIN', now(), now());
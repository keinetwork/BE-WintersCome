-- h2
--insert into MemberEntity(`id`,`userid`, email`, `password`, `nickName`, `role`, `createdAt`, `updatedAt`)
--    values(1, 'admin', 'admin', 'admin', 'ADMIN', 'ADMIN', now(), now());
-- mysql
insert into Member(`userid`, `email`, `password`, `nickName`, `role`, `createdAt`, `updatedAt`)
    values('admin', 'admin', 'admin', 'ADMIN', 'ADMIN', now(), now());
insert into Member(`userid`, `email`, `password`, `nickName`, `role`, `createdAt`, `updatedAt`)
    values('user', 'user', 'user', 'USER', 'USER', now(), now());
-- h2
--insert into MemberEntity(`id`,`username`, email`, `password`, `nickName`, `role`, `createdAt`, `updatedAt`)
--    values(1, 'admin', 'admin', 'admin', 'ADMIN', 'ADMIN', now(), now());
-- mysql
insert into Member(`username`, `password`, `email`, `nickName`, `role`, `createdAt`, `updatedAt`)
    values('admin', '$2a$10$oIoNU9J44I8HnAy7oiVJdOa4WyCLLQfk1aFuYuF4rufI6B6Nh364i', 'admin@gmail.com', 'ADMIN', 'ADMIN', now(), now());
insert into Member(`username`, `password`, `email`, `nickName`, `role`, `createdAt`, `updatedAt`)
    values('user', '$2a$10$k4Jn6WzQAtCTeGLqpMVEWO/sa1ZVeHHbEbeASFu3xY7lXVbhe/fJa', 'user@gmail.com', 'USER', 'USER', now(), now());
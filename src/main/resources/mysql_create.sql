create database winterscome;

use mysql;
select user, host from user;

create user 'winterscome'@'localhost' identified by 'comewinters';
create user 'winterscome'@'%' identified by 'comewinters';

grant all privileges on *.* to 'winterscome'@'localhost';
grant all privileges on *.* to 'winterscome'@'%';
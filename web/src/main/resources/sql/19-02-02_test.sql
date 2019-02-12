
DROP TABLE IF EXISTS test_user;
create table test_user
(
  id int auto_increment comment 'id主键',
  name varchar(20) default '' not null comment '姓名',
  age int default 0 not null comment '年龄',
  email varchar(30) default '' not null comment '邮箱',
  constraint test_user_pk
    primary key (id)
)
  comment '测试数据库';

INSERT INTO test_user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

alter table test_user
  add is_delete int default 0 not null comment '0:未删除 1:已删除';
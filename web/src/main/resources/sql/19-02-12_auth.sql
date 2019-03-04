create table my_user
(
  id int(11) auto_increment comment '用户id主键',
  user_name varchar(20) default '' not null comment '用户名',
  password varchar(20) default '' not null comment '密码',
  nick_name varchar(20) default '' not null comment '昵称',
  salt_value varchar(20) default '' not null comment '加密盐值',
  status tinyint(2) default 0 not null comment '0:正常 1:冻结',
  remark varchar(200) default '' not null comment '备注',
  add_uid varchar(20) default '' not null comment '添加人',
  add_time timestamp default CURRENT_TIMESTAMP not null comment '注册时间',
  update_uid varchar(20) default '' not null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间',
  is_delete tinyint(2) default 0 not null comment '0: 删除 1: 未删除',
  last_update_time timestamp default CURRENT_TIMESTAMP not null comment '最后更新时间',
  constraint my_user_pk
    primary key (id)
)
  comment '用户表';

## 增加角色关联字段
alter table my_user
  add role_id int default 0 not null comment '角色id' after salt_value;

create table my_role
(
  id int(11) auto_increment comment '角色id主键',
  role_name varchar(20) default '' not null comment '角色名',
  role_rule varchar(500) default '' not null comment '角色权限',
  remark varchar(200) default '' not null comment '备注',
  add_uid varchar(20) default '' not null comment '添加人',
  add_time timestamp default CURRENT_TIMESTAMP not null comment '添加时间',
  update_uid varchar(20) default '' not null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间',
  is_delete tinyint(2) default 0 not null comment '0: 删除 1: 未删除',
  last_update_time timestamp default CURRENT_TIMESTAMP not null comment '最后更新时间',
  constraint my_user_pk
    primary key (id)
)
  comment '角色表';

## 超级管理员角色
INSERT INTO application.my_role (id, role_name, role_rule, remark, add_uid, add_time, update_uid, update_time, is_delete, last_update_time) VALUES (1, 'admin', '["all"]', '', 'admin', '2019-03-01 07:59:24', '', '2019-03-01 07:59:24', 0, '2019-03-01 07:59:24');
## 更新超级管理员的role_id
UPDATE application.my_user SET user_name = 'admin', password = 'admin', nick_name = 'admin', salt_value = '', role_id = 1, status = 0, remark = '', add_uid = 'system', add_time = '2019-02-13 03:32:13', update_uid = '', update_time = '2019-02-13 03:32:13', is_delete = 0, last_update_time = '2019-02-13 03:32:13' WHERE id = 1;

create table my_rule
(
  id int(11) auto_increment comment '主键id',
  rule_name varchar(20) default '' comment '权限名称',
  rule_detail varchar(20) default '' comment '权限地址',
  rule_type tinyint(2) default 0 not null comment '1: 菜单 2: 面包学 2: 权限',
  pid int(11) default 0 not null comment '父id',
  add_uid varchar(20) default '' not null comment '添加人',
  add_time timestamp default CURRENT_TIMESTAMP not null comment '添加时间',
  update_uid varchar(20) default '' not null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间',
  is_delete tinyint(2) default 0 not null comment '0: 删除 1: 未删除',
  last_update_time timestamp default CURRENT_TIMESTAMP not null comment '最后更新时间',
  constraint my_rule_pk
    primary key (id)
)
  comment '权限表';
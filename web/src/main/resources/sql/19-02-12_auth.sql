create table my_user
(
  id int(11) auto_increment comment '用户id主键',
  user_name varchar(20) default '' not null comment '用户名',
  password varchar(20) default '' not null comment '密码',
  nick_name varchar(20) default '' not null comment '昵称',
  salt_value varchar(20) default '' not null comment '加密盐值',
  status int(11) default 0 not null comment '0:正常 1:冻结',
  remark varchar(200) default '' not null comment '备注',
  add_uid varchar(20) default '' not null comment '添加人',
  add_time timestamp default CURRENT_TIMESTAMP not null comment '注册时间',
  update_uid varchar(20) default '' not null comment '修改人',
  update_time timestamp default CURRENT_TIMESTAMP not null comment '修改时间',
  is_delete int(11) default 0 not null comment '0: 删除 1: 未删除',
  last_update_time timestamp default CURRENT_TIMESTAMP not null comment '最后更新时间',
  constraint my_user_pk
    primary key (id)
)
  comment '用户表';
CREATE DATABASE `ks_mybatis` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

USE `ks_mybatis`;

CREATE TABLE `country` (
    `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NULL,
  `code` varchar(255) NULL,
 PRIMARY KEY (`id`)
);

INSERT `country` (`name`, `code`) VALUES
  ('中国', 'CN'),
  ('美国', 'US'),
  ('俄罗斯', 'RU'),
  ('英国', 'GB'),
  ('法国', 'FR');

-----

CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(50) COMMENT '用户名',
    `password` varchar(50) COMMENT '密码',
    `email` varchar(50) COMMENT '邮箱',
    `intro` text COMMENT '简介',
    `portrait` blob COMMENT '头像',
    `create_at` datetime COMMENT '创建时间',
    PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user` COMMENT '用户表';

CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `name` varchar(50) COMMENT '角色名',
    `enabled` int COMMENT '有效标识',
    `create_by` bigint COMMENT '创建人',
    `create_at` datetime COMMENT '创建时间',
    PRIMARY KEY (`id`)
);
ALTER TABLE `sys_role` COMMENT '角色表';

CREATE TABLE `sys_privilege` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
    `name` varchar(50) COMMENT '权限名称',
    `url` varchar(500) COMMENT '权限URL',
    PRIMARY KEY (`id`)
);
ALTER TABLE `sys_privilege` COMMENT '权限表';

CREATE TABLE `sys_user_role` (
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `role_id` bigint NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`)
);
ALTER TABLE `sys_user_role` COMMENT '用户角色关联表';

CREATE TABLE `sys_role_privilege` (
    `role_id` bigint NOT NULL COMMENT '角色ID',
    `privilege_id` bigint NOT NULL COMMENT '权限ID',
    PRIMARY KEY (`role_id`, `privilege_id`)
);
ALTER TABLE `sys_role_privilege` COMMENT '角色权限关联表';

INSERT INTO `sys_user` VALUES
    (1, 'admin', '123456', 'admin@mybatis.ks', '管理员', null, now()),
    (1001, 'test', '123456', 'test@mybatis.ks', '测试用户', null, now());

INSERT INTO `sys_role` VALUES
    (1, '管理员', 1, 1, now()),
    (2, '普通用户', 1, 1, now());

INSERT INTO `sys_privilege` VALUES
    (1, '用户管理', '/users'),
    (2, '角色管理', '/roles'),
    (3, '系统日志', '/logs'),
    (4, '人员维护', '/persons'),
    (5, '部门维护', '/departments');

INSERT INTO `sys_user_role` VALUES
    (1, 1),
    (1, 2),
    (1001, 2);

INSERT INTO `sys_role_privilege` VALUES
    (1, 1),
    (1, 3),
    (1, 2),
    (2, 4),
    (2, 5);

-----
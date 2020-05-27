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
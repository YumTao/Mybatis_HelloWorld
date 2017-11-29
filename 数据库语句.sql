-- 创建数据库
CREATE DATABASE mybatis_hello_world DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 创建student表
CREATE TABLE student(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
age INT ,
gender INT COMMENT '0: 未知, 1:男, 2:女'
);
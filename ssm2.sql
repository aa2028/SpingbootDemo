/*
 Navicat Premium Data Transfer

 Source Server         : peijie
 Source Server Type    : MySQL
 Source Server Version : 50737 (5.7.37-log)
 Source Host           : localhost:3306
 Source Schema         : ssm2

 Target Server Type    : MySQL
 Target Server Version : 50737 (5.7.37-log)
 File Encoding         : 65001

 Date: 04/06/2024 14:41:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `isbn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书标准ISBN编号',
  `press` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书出版社',
  `author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书作者',
  `price` double(10, 0) NULL DEFAULT NULL COMMENT '图书价格',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态（0:可借阅，1:已借阅，2:归还中，3：已下架）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '平凡的世界', '9787115547477', '人民邮电出版社', '路遥', 291, 1);
INSERT INTO `book` VALUES (2, '挪威的森林', '9787546205618', '上海译文出版社', '村上春树', 380, 1);
INSERT INTO `book` VALUES (3, 'JavaWeb程序设计', '9787115439369', '人民邮电出版社', '传智播客', 419, 0);
INSERT INTO `book` VALUES (4, 'java', '9787115439312', '清华大学出版社', '张三', 123, 0);
INSERT INTO `book` VALUES (5, 'mysql数据库', '12345678', '清华出版社', '张三疯', 20, 0);
INSERT INTO `book` VALUES (9, '小明图书', '1212121212', '上海译文出版社', '小明', 100, 0);
INSERT INTO `book` VALUES (10, '小张图书', '11111', '上海译文出版社', '小张', 100, 0);
INSERT INTO `book` VALUES (11, '小张图书', '11111', '上海译文出版社', '小张', 100, 0);
INSERT INTO `book` VALUES (12, '小张图书', '11111', '上海译文出版社', '小张', 100, 0);
INSERT INTO `book` VALUES (13, '小张图书', '11111', '上海译文出版社', '小张', 100, 0);
INSERT INTO `book` VALUES (14, '小张图书', '11111', '上海译文出版社', '小张', 100, 0);
INSERT INTO `book` VALUES (15, '12', '12', '12', '12', 12, 0);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅记录id',
  `bookid` int(11) NOT NULL COMMENT '借阅的图书编号',
  `userid` int(11) NOT NULL COMMENT '图书借阅人编号',
  `borrowtime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书借阅时间',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '图书归还状态：0: 借阅 1：归还',
  `returntime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书归还时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 1, 2, '2020-12-21', 1, '2024-06-04');
INSERT INTO `record` VALUES (2, 2, 2, '2020-12-11', 1, '2024-06-04');
INSERT INTO `record` VALUES (3, 3, 2, '2020-12-11', 1, '2024-06-04');
INSERT INTO `record` VALUES (4, 4, 3, '2020-12-11', 1, '2024-06-04');
INSERT INTO `record` VALUES (5, 5, 3, '2020-12-11', 1, '2024-06-04');
INSERT INTO `record` VALUES (6, 9, 3, '2020-12-11', 1, '2024-06-04');
INSERT INTO `record` VALUES (11, 1, 3, '2024-06-04', 0, NULL);
INSERT INTO `record` VALUES (12, 2, 2, '2024-06-04', 0, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱（用户账号）',
  `role` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户角色',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '用户状态（0:正常,1:禁用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '李白', '123', '862163475@qq.com', 'ADMIN', 0);
INSERT INTO `user` VALUES (2, '张三', '123', '862163475@qq.com', 'USER', 0);
INSERT INTO `user` VALUES (3, '张飞', '123', '862163475@qq.com', 'USER', 0);

SET FOREIGN_KEY_CHECKS = 1;

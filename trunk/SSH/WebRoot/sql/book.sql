/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : snow

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2011-09-29 22:04:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(8) NOT NULL,
  `author` varchar(32) DEFAULT NULL,
  `title` varchar(64) NOT NULL,
  `price` double(6,2) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  `sale_amout` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('201', '孙卫琴', 'Java面向对象编程', '65.00', '2006', '让读者由浅入深了解Java语言', '20000');
INSERT INTO `book` VALUES ('202', '孙卫琴', '精通Struts', '49.00', '2004', '真的很棒', '80000');
INSERT INTO `book` VALUES ('203', '孙卫琴', 'Java网络编程精解', '55.00', '2007', '值得一看', '10000');

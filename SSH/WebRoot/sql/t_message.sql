/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : snow

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2011-10-04 22:56:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` varchar(32) NOT NULL,
  `userId` varchar(32) NOT NULL,
  `title` varchar(32) NOT NULL,
  `content` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userId_user` (`userId`),
  CONSTRAINT `fk_userId_user` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('msg001', '001', '青花瓷', '随风飘乱');
INSERT INTO `t_message` VALUES ('msg002', '001', '菊花台', '是谁在阁楼上冰冷地绝望');
INSERT INTO `t_message` VALUES ('msg003', '002', '忘情水', '给我一杯忘情水');
INSERT INTO `t_message` VALUES ('msg004', '002', '中国人', '我们都是中国人');

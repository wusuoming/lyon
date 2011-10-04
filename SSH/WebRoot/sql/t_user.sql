/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : snow

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2011-10-04 22:56:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `userName` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('001', 'steiny', '345');
INSERT INTO `t_user` VALUES ('002', 'alakiss', '789');
INSERT INTO `t_user` VALUES ('003', 'niyad', '&6中');
INSERT INTO `t_user` VALUES ('402881e632c7ff4b0132c80015720000', 'slowvic', '654321');

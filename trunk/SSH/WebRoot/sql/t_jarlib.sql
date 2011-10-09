/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : snow

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2011-10-08 16:37:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_jarlib`
-- ----------------------------
DROP TABLE IF EXISTS `t_jarlib`;
CREATE TABLE `t_jarlib` (
  `name` varchar(32) NOT NULL,
  `version` varchar(16) DEFAULT NULL,
  `belong` varchar(32) DEFAULT NULL,
  `usage` varchar(128) DEFAULT NULL,
  `jdk` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jarlib
-- ----------------------------
INSERT INTO `t_jarlib` VALUES ('antlr', '2.7.6', 'antlr', '词法分析工具', null);
INSERT INTO `t_jarlib` VALUES ('asm', '3.3.1', 'ow2', '字节码操控框架', null);
INSERT INTO `t_jarlib` VALUES ('bsf', '2.4.0', 'apache-commons', 'Bean Scripting Framework，用于在Java程序中执行脚本语言', null);
INSERT INTO `t_jarlib` VALUES ('c3p0', '0.9.1.2', 'sourceforge', '数据库连接池组件', null);
INSERT INTO `t_jarlib` VALUES ('cglib', '2.2.2', 'sourceforge', 'code生成类库，动态字节码生成', null);
INSERT INTO `t_jarlib` VALUES ('commons-beanUtils', '1.8.3', 'apache-commons', 'Bean操作工具', null);
INSERT INTO `t_jarlib` VALUES ('commons-chain', '1.2', 'apache-commons', '一个实现了责任链设计模式的Java 类库', null);
INSERT INTO `t_jarlib` VALUES ('commons-collections', '3.2.1', 'apache-commons', 'Collection增强包，提供对集合类和集合工具类的封装', null);
INSERT INTO `t_jarlib` VALUES ('commons-dbcp', '1.4', 'apache-commons', '数据库连接池组件', '1.6+');
INSERT INTO `t_jarlib` VALUES ('commons-dbutils', '1.3', 'apache-commons', '数据库工具类封装', '1.5+');
INSERT INTO `t_jarlib` VALUES ('commons-digester', '1.8.1', 'apache-commons', 'XML读取工具，常配合BeanUtils和Collections组件使用', null);
INSERT INTO `t_jarlib` VALUES ('commons-digester3', '3.3', 'apache-commons', 'XML读取工具，常配合BeanUtils和Collections组件使用', '1.6+');
INSERT INTO `t_jarlib` VALUES ('commons-fileupload', '1.2.2', 'apache-commons', '文件上传组件', null);
INSERT INTO `t_jarlib` VALUES ('commons-io', '2.0.1', 'apache-commons', 'IO工具类封装', '1.5+');
INSERT INTO `t_jarlib` VALUES ('commons-lang3', '3.0.1', 'apache-commons', '语言包增强，比如equals、hashCode、toString方法的增强', '1.5+');
INSERT INTO `t_jarlib` VALUES ('commons-logging', '1.1.1', 'apache-commons', '通用日志记录接口', null);
INSERT INTO `t_jarlib` VALUES ('commons-pool', '1.5.6', 'apache-commons', '对象池化组件', null);
INSERT INTO `t_jarlib` VALUES ('commons-validator', '1.3.1', 'apache-commons', 'Java验证框架', null);
INSERT INTO `t_jarlib` VALUES ('dom4j', '1.6.1', 'sourceforge', 'XML API', null);
INSERT INTO `t_jarlib` VALUES ('easymock', '3.0', 'easymock', '单元测试，模拟对象', null);
INSERT INTO `t_jarlib` VALUES ('fastjson', '1.1.6', 'alibaba', 'json工具', null);
INSERT INTO `t_jarlib` VALUES ('javassit', '3.15.0-GA', 'jboss', '字节码操控工具', null);
INSERT INTO `t_jarlib` VALUES ('jbosscache', '3.2.5.GA', 'jboss', '事务处理缓存', null);
INSERT INTO `t_jarlib` VALUES ('jdom', '1.1.1', 'jdom', 'XML API', null);
INSERT INTO `t_jarlib` VALUES ('json-taglib', '0.4.1', 'sourceforge', '一套JSP标签库，用于在JSP代码中输出JSON格式的数据', null);
INSERT INTO `t_jarlib` VALUES ('junit', '4.10', 'junit', '单元测试工具', '1.5+');
INSERT INTO `t_jarlib` VALUES ('log4j', '1.2.16', 'apache', '日志', null);
INSERT INTO `t_jarlib` VALUES ('oscache', '2.4.1', 'oscache', '缓存系统', null);
INSERT INTO `t_jarlib` VALUES ('proxool', '0.9.1', 'sourceforge', '数据库连接池组件', null);
INSERT INTO `t_jarlib` VALUES ('slf4j', '1.6.2', 'slf4j', 'simple logging facade for java，日志系统', null);

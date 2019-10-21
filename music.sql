/*
Navicat MySQL Data Transfer

Source Server         : 20190729
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : music

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2019-10-19 11:16:17
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;	--管理员用户表
CREATE TABLE `admininfo` (
   `aid` int(11) NOT NULL AUTO_INCREMENT,--管理员id
  `aname` varchar(255) NOT NULL,		--管理员账号名字
  `pwd` varchar(255) NOT NULL,			--管理员密码
  `pic` varchar(255) DEFAULT NULL,		--管理员头像
  `email` varchar(255) DEFAULT NULL,	--邮箱地址
  `status` varchar(255) DEFAULT NULL,	--状态
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------

-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
   `uid` int(11) NOT NULL AUTO_INCREMENT,	--用户id
  `uname` varchar(255) NOT NULL,			--用户名字
  `pwd` varchar(255) NOT NULL,				--用户密码
  `email` varchar(255) NOT NULL,			--用户邮箱
  `vip` int(11) NOT NULL DEFAULT '0',		--判断是否是vip
  `pic` varchar(255) DEFAULT NULL,			--用户头像地址
  `status` int(11) DEFAULT NULL,			--状态    管理员可以让他封号之类的
  `realName` varchar(255) DEFAULT NULL,		--用户真实姓名	
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `applicationtype`
-- ----------------------------
DROP TABLE IF EXISTS `applicationtype`;		--应用场景类型
CREATE TABLE `applicationtype` (
  `atid` int(11) NOT NULL AUTO_INCREMENT,	--应用id
  `atname` varchar(255) DEFAULT NULL,		--应用场景名字
  PRIMARY KEY (`atid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicationtype
-- ----------------------------

-- ----------------------------
-- Table structure for `songtype`
-- ----------------------------
DROP TABLE IF EXISTS `songtype`;			--歌曲类型
CREATE TABLE `songtype` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,	--类型id
  `atid` int(11) DEFAULT NULL,				--类型应用场景id
  `stype` varchar(255) DEFAULT NULL,		--类型名字
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of songtype
-- ----------------------------

-- ----------------------------
-- Table structure for `combination`
-- ----------------------------
DROP TABLE IF EXISTS `combination`;		--组合表
CREATE TABLE `combination` (
 `cid` int(11) NOT NULL AUTO_INCREMENT,	--组合id
  `cname` varchar(255) DEFAULT NULL,		---组合名字
  `num` int(11) DEFAULT NULL,				--组合关注
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combination
-- ----------------------------



-- ----------------------------
-- Table structure for `singerinfo`
-- ----------------------------
DROP TABLE IF EXISTS `singerinfo`;			--歌手表
CREATE TABLE `singerinfo` (
  `sgid` int(255) NOT NULL AUTO_INCREMENT,	--歌手id
  `sgname` varchar(255) DEFAULT NULL,		--歌手名字
  `addr` varchar(255) DEFAULT NULL,			--歌手所在的地方
  `sex` varchar(255) DEFAULT NULL,			--性别
  `genre` varchar(255) DEFAULT NULL,		--跟手区风		比如：摇滚
  `status` int(11) DEFAULT NULL,				
  `cid` int(255) DEFAULT NULL,				--组合id
  `num` int(11) DEFAULT NULL,				--歌手关注
  PRIMARY KEY (`sgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of singerinfo
-- ----------------------------


-- ----------------------------
-- Table structure for `musicinfo`
-- ----------------------------
DROP TABLE IF EXISTS `musicinfo`;		--音乐信息表/歌曲表
CREATE TABLE `musicinfo` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,		--音乐id
  `sgid` int(11) DEFAULT NULL,					--歌手id
  `sid` int(11) DEFAULT NULL,					--歌曲类型id
  `cid` int(11) DEFAULT NULL,					--组合id				
  `atid` int(11) DEFAULT NULL,					--应用场景id
  `mname` varchar(255) DEFAULT NULL,			--音乐名字
  `musciaddr` varchar(255) DEFAULT NULL,		--音乐播发地址
  `pices` varchar(200) DEFAULT NULL,			--音乐图片
  `Lyricaddr` varchar(255) DEFAULT NULL,		--音乐歌词地址
  `judgestauts` int(11) DEFAULT NULL,			--播放的次数
  `status` int(11) DEFAULT NULL,				--歌曲状态（用于我喜欢）
 'rgdate' datetime DEFAULT NULL,			--歌曲发行时间
'by2'	varchar  DEFAULT NULL,   			--歌曲公司
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of musicinfo
-- ----------------------------


-- ----------------------------
-- Table structure for `userlist`
-- ----------------------------
DROP TABLE IF EXISTS `userlist`;		--用户歌单表
CREATE TABLE `userlist` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,	--歌单id
  `uid` int(11) DEFAULT NULL,				--用户id
  `lname` varchar(255) DEFAULT NULL,		--歌单名字
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlist
-- ----------------------------

-- ----------------------------
-- Table structure for `usermusic`
-- ----------------------------
DROP TABLE IF EXISTS `usermusic`;
CREATE TABLE `usermusic` (				--用户歌单里面的歌曲表
  `umid` int(11) NOT NULL AUTO_INCREMENT,	--歌曲id
  `lid` int(255) DEFAULT NULL,				--歌单id
  `mid` int(11) DEFAULT NULL,				--音乐id
  PRIMARY KEY (`umid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermusic
-- ----------------------------

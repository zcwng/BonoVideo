/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : svw

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-07 16:48:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'vod', '0', '培训视频');
INSERT INTO `category` VALUES ('2', 'live', '0', null);

-- ----------------------------
-- Table structure for configure
-- ----------------------------
DROP TABLE IF EXISTS `configure`;
CREATE TABLE `configure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `val` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of configure
-- ----------------------------
INSERT INTO `configure` VALUES ('1', 'transcoder_vcodec', 'libx264', 'Video encoder');
INSERT INTO `configure` VALUES ('2', 'transcoder_bv', '500000', 'Video bitrate');
INSERT INTO `configure` VALUES ('3', 'transcoder_framerate', '25', 'Video frame rate');
INSERT INTO `configure` VALUES ('4', 'transcoder_acodec', 'libmp3lame', 'Audio encoder');
INSERT INTO `configure` VALUES ('5', 'transcoder_ar', '22050', 'Audio sample rate');
INSERT INTO `configure` VALUES ('6', 'transcoder_ba', '64000', 'Audio bitrate');
INSERT INTO `configure` VALUES ('7', 'transcoder_scale_w', '640', 'Video width');
INSERT INTO `configure` VALUES ('8', 'transcoder_scale_h', '360', 'Video height');
INSERT INTO `configure` VALUES ('9', 'transcoder_watermarkuse', 'true', 'Use Watermark');
INSERT INTO `configure` VALUES ('10', 'transcoder_watermark_url', 'watermark/svw.png', 'Watermark file\'s URL');
INSERT INTO `configure` VALUES ('11', 'transcoder_watermark_x', '5', 'Watermark\'s location (x)');
INSERT INTO `configure` VALUES ('12', 'transcoder_watermark_y', '5', 'Watermark\'s location (y)');
INSERT INTO `configure` VALUES ('13', 'transcoder_keepaspectratio', 'true', 'Keep original aspect ratio');
INSERT INTO `configure` VALUES ('14', 'transcoder_outfmt', 'flv', 'Output file format');
INSERT INTO `configure` VALUES ('15', 'thumbnail_ss', '5', 'When to get thumbnail (from start)');
INSERT INTO `configure` VALUES ('16', 'folder_videoori', 'videoori', 'Folder to save Upload Video');
INSERT INTO `configure` VALUES ('17', 'folder_video', 'video', 'Folder to save Transcode Video');
INSERT INTO `configure` VALUES ('18', 'folder_thumbnail', 'videothumbnail', 'Folder to save Thumbnail of Video');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `intro` varchar(8192) DEFAULT NULL,
  `edittime` datetime DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  `islive` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `oriurl` varchar(255) DEFAULT NULL,
  `thumbnailurl` varchar(255) DEFAULT NULL,
  `videostateid` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CATEGORY` (`categoryid`),
  KEY `FK_VIDEOSTATE` (`videostateid`),
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_VIDEOSTATE` FOREIGN KEY (`videostateid`) REFERENCES `videostate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '商务装物流控制流程', '陆迎春-商务装物流控制流程', '2018-05-01 10:00:24', '1', '0', 'video/1.flv', 'videoori/商务装物流控制流程.flv', 'videothumbnail/1.jpg', '4', null);
INSERT INTO `video` VALUES ('2', '合同签订及风险控制', '陆迎春-合同签订及风险控制', '2018-05-01 10:00:24', '1', '0', 'video/2.flv', 'videoori/合同签订及风险控制.flv', 'videothumbnail/2.jpg', '4', null);
INSERT INTO `video` VALUES ('3', '激励机制', '陆迎春-激励机制', '2018-05-01 10:00:24', '1', '2', 'video/3.flv', 'videoori/激励机制.flv', 'videothumbnail/3.jpg', '4', null);
INSERT INTO `video` VALUES ('4', '面辅料基础知识', '王晓兰-面辅料基础知识', '2018-05-01 10:00:24', '1', '0', 'video/4.flv', 'videoori/面辅料基础知识.flv', 'videothumbnail/4.jpg', '4', null);
INSERT INTO `video` VALUES ('5', '功能性面料及款式介绍', '王晓兰-功能性面料及款式介绍', '2018-05-07 10:50:39', '1', '0', 'video/5.flv', 'videoori/功能性面料及款式介绍.flv', 'videothumbnail/5.jpg', '4', null);
INSERT INTO `video` VALUES ('6', '附件产品知识', '周梅-附件产品知识', '2018-05-07 10:50:39', '1', '0', 'video/6.flv', 'videoori/附件产品知识.flv', 'videothumbnail/6.jpg', '4', null);
INSERT INTO `video` VALUES ('7', '男女装基础知识', '项娟娟、魏鸿-男女装基础知识', '2018-05-07 13:51:35', '1', '0', 'video/7.flv', 'videoori/男女装基础知识.flv', 'videothumbnail/7.jpg', '4', null);
INSERT INTO `video` VALUES ('8', '产品介绍技巧', '张茜-产品介绍技巧', '2018-05-07 10:50:39', '1', '0', 'video/8.flv', 'videoori/产品介绍技巧.flv', 'videothumbnail/8.jpg', '4', null);
INSERT INTO `video` VALUES ('9', '职业装讲解现场模拟', '张茜-职业装讲解现场模拟', '2018-05-07 10:50:39', '1', '2', 'video/9.flv', 'videoori/职业装讲解现场模拟.flv', 'videothumbnail/9.jpg', '4', null);
INSERT INTO `video` VALUES ('10', '沙盘模拟演练', '吴洪祥-沙盘模拟演练', '2018-05-07 10:50:39', '1', '2', 'video/10.flv', 'videoori/沙盘模拟演练.flv', 'videothumbnail/10.jpg', '4', null);
INSERT INTO `video` VALUES ('11', '销售同步理论', '吴洪祥-销售同步理论', '2018-05-07 10:50:39', '1', '2', 'video/11.flv', 'videoori/销售同步理论.flv', 'videothumbnail/11.jpg', '4', null);
INSERT INTO `video` VALUES ('12', '电话访销', '王甲甲-电话访销', '2018-05-07 10:50:39', '1', '2', 'video/12.flv', 'videoori/电话访销.flv', 'videothumbnail/12.jpg', '4', null);
INSERT INTO `video` VALUES ('13', '登门拜访', '刘福明-登门拜访', '2018-05-07 10:50:39', '1', '2', 'video/13.flv', 'videoori/登门拜访.flv', 'videothumbnail/13.jpg', '4', null);
INSERT INTO `video` VALUES ('14', 'BPM流程操作指南', '方红-BPM流程操作指南', '2018-05-07 10:50:39', '1', '0', 'video/14.flv', 'videoori/BPM流程操作指南.flv', 'videothumbnail/14.jpg', '4', null);

-- ----------------------------
-- Table structure for videostate
-- ----------------------------
DROP TABLE IF EXISTS `videostate`;
CREATE TABLE `videostate` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `cssstyle` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videostate
-- ----------------------------
INSERT INTO `videostate` VALUES ('1', '等待上传', '1', 'background:#CCFFFF', null);
INSERT INTO `videostate` VALUES ('2', '等待截图', '2', 'background:#00FF99', null);
INSERT INTO `videostate` VALUES ('3', '等待转码', '3', 'background:#00FF00', null);
INSERT INTO `videostate` VALUES ('4', '完成', '4', 'background:#FFFFFF', null);

/*
 Navicat Premium Data Transfer

 Source Server         : tencent
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 193.112.59.11
:3306
 Source Schema         : scau_circle

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 20/09/2018 11:24:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for circle_user_image
-- ----------------------------
DROP TABLE IF EXISTS `circle_user_image`;
CREATE TABLE `circle_user_image`  (
  `image__id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `real_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实路径',
  `web_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相对路径',
  `uid` int(11) UNSIGNED DEFAULT NULL COMMENT '图片所属消息对应的id',
  `is_delete` tinyint(4) NOT NULL DEFAULT 1 COMMENT '软删除，1代表未删除，0代表已删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '图片上传时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '图片修改时间',
  PRIMARY KEY (`image__id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

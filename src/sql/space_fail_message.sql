/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 21/07/2020 17:45:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for space_fail_message
-- ----------------------------
DROP TABLE IF EXISTS `space_fail_message`;
CREATE TABLE `space_fail_message`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `exchange_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `queue_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '0:未处理1：已处理',
  `send_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of space_fail_message
-- ----------------------------
INSERT INTO `space_fail_message` VALUES ('3ba019f7-9515-4e66-85f2-79dd7584c09f', '{\"address\":\"新城一号\",\"createBy\":\"admin\",\"createTime\":1595324564000,\"id\":\"6c547a0e-380d-4119-aa38-0917676bc577\",\"password\":\"123\",\"sex\":1,\"userName\":\"梁欣\"}', 'rabbitMq_direct', 'user', 0, '2020-07-21 17:42:44');

SET FOREIGN_KEY_CHECKS = 1;

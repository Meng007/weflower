/*
 Navicat MySQL Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : flower

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 29/12/2019 17:49:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `aid` int(10) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `grade` int(10) NULL DEFAULT 2,
  `isdelete` int(10) NULL DEFAULT 1,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'mds', '123456', '13557280197@163.com', '17878192811', 1, 1);

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `sid` int(10) NULL DEFAULT NULL COMMENT '学生id',
  `fid` int(10) NULL DEFAULT NULL COMMENT '花id',
  `count` int(10) NULL DEFAULT NULL COMMENT '数量',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 1, 1, 1, 50.00);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int(10) NOT NULL COMMENT ' 评论 id',
  `sid` int(10) NULL DEFAULT NULL COMMENT '学生id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `isDelete` int(255) NULL DEFAULT 1 COMMENT '是否删除 0 表示删除 1 表示未删除',
  `reply` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '管理员回复 内容',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for flower
-- ----------------------------
DROP TABLE IF EXISTS `flower`;
CREATE TABLE `flower`  (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bock` int(10) NULL DEFAULT 1,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片地址',
  `isDelete` int(2) NULL DEFAULT 1,
  `num` int(10) NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of flower
-- ----------------------------
INSERT INTO `flower` VALUES (1, '史德竹', 50.00, '多肉', 1, '2019-12-29 14:56:43', '/images/2019-12-28-18-40-04_66.jpg', 1, 198, '没没没鬼鬼鬼鬼鬼', '2019-12-28 18:40:22');
INSERT INTO `flower` VALUES (2, 'uuuu', 55.00, '多肉', 1, '2019-12-28 18:56:00', '/images/2019-12-28-18-40-39_TIM图片20191004182642.jpg', 1, 0, 'hhhhhhh', '2019-12-28 18:40:46');
INSERT INTO `flower` VALUES (3, 'hhhhhhh', 555.00, '多肉', 1, '2019-12-28 18:55:59', '/images/2019-12-28-18-40-58_败家女0.jpg', 1, 0, 'iiiiiiiiiiiii', '2019-12-28 18:41:03');
INSERT INTO `flower` VALUES (4, 'oooo', 555.00, '多肉', 1, '2019-12-28 18:55:58', '/images/2019-12-28-18-41-16_女人.jpg', 1, 0, 'hhhhhhhhh', '2019-12-28 18:55:02');
INSERT INTO `flower` VALUES (5, 'hhhhhh', 5.00, '多肉', 1, '2019-12-29 16:57:33', '/images/2019-12-28-18-40-39_TIM图片20191004182642.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (6, 'uuu', 555.00, '盆栽', 1, '2019-12-29 16:47:24', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, 'ooooooo', NULL);
INSERT INTO `flower` VALUES (7, 'kk', 55.00, '盆栽', 1, '2019-12-29 16:47:26', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, 'uiui', NULL);
INSERT INTO `flower` VALUES (8, 'jkok', NULL, '盆栽', 1, '2019-12-29 16:47:27', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, 'kikj', NULL);
INSERT INTO `flower` VALUES (9, 'kjk', 56.00, '盆栽', 1, '2019-12-29 16:47:28', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, 'jijij', NULL);
INSERT INTO `flower` VALUES (10, 'jjk', 5.00, '多肉', 1, '2019-12-29 16:47:29', '/images/2019-12-28-18-40-04_66.jpg', 1, 5, 'u', NULL);
INSERT INTO `flower` VALUES (11, 'ui', 56.00, '盆栽', 1, '2019-12-29 16:47:30', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, 'hhj', NULL);
INSERT INTO `flower` VALUES (12, 'hj', NULL, '盆栽', 1, '2019-12-29 16:47:31', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, 'jhh', NULL);
INSERT INTO `flower` VALUES (13, 'hj', 5.00, '盆栽', 1, '2019-12-29 16:45:12', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, 'jh', NULL);
INSERT INTO `flower` VALUES (14, '史德竹', 25.23, '盆景', 1, '2019-12-29 16:47:33', '/images/2019-12-28-18-40-04_66.jpg', 1, 200, ' 我 ix 换你i 大力士冠军赛两个角色就咖喱感觉', '2019-12-27 17:03:52');
INSERT INTO `flower` VALUES (15, '史德竹', 25.23, '盆景', 1, '2019-12-28 18:35:58', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 200, ' 我 ix 换你i 大力士冠军赛两个角色就咖喱感觉', '2019-12-27 17:10:48');
INSERT INTO `flower` VALUES (16, '经济法历史交锋', NULL, '盆景', 1, '2019-12-29 16:47:35', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (17, '给', NULL, '盆景', 1, '2019-12-29 16:47:36', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (18, '的观点', NULL, '盆景', 1, '2019-12-29 16:47:37', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (19, '都是', NULL, '盆景', 1, '2019-12-29 16:47:38', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (20, '是的', NULL, '盆景', 1, '2019-12-29 16:47:39', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (21, '史德竹1', NULL, '盆景', 1, '2019-12-29 16:47:41', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (22, '水植绿培', NULL, '水植绿培', 1, '2019-12-29 16:46:30', '/images/2019-12-27-17-03-46_沙雕/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (23, '史德竹1', NULL, '水植绿培', 1, '2019-12-29 16:46:33', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (24, NULL, NULL, '水植绿培', 1, '2019-12-29 16:46:34', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (25, '史德竹1', NULL, '水植绿培', 1, '2019-12-29 16:46:36', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (26, '史德竹1', NULL, '水植绿培', 1, '2019-12-29 16:46:37', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (27, '史德竹1', NULL, '水植绿培', 1, '2019-12-29 16:46:38', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (28, '史德竹1', NULL, NULL, 1, '2019-12-29 16:46:40', '/images/2019-12-28-18-40-04_66.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (29, '竹', NULL, '盆栽', 1, '2019-12-29 16:45:27', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (30, '竹', NULL, '盆栽', 1, '2019-12-29 16:45:28', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (31, '竹', NULL, '盆栽', 1, '2019-12-29 16:45:29', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (32, '竹', NULL, '盆栽', 1, '2019-12-29 16:45:30', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (33, '竹', NULL, '盆栽', 1, '2019-12-29 16:45:31', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (34, '竹', NULL, NULL, 1, '2019-12-29 16:45:32', '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (35, NULL, NULL, NULL, 1, NULL, '/images/2019-12-27-17-03-46_沙雕=0.jpg', 1, 0, NULL, NULL);
INSERT INTO `flower` VALUES (36, NULL, NULL, NULL, 1, NULL, NULL, 1, 0, NULL, NULL);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `nid` int(10) NOT NULL COMMENT '公告id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公告内容',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片地址',
  `isDelete` int(2) NULL DEFAULT 1 COMMENT '是否过期 0 表示过期 1 表示未过期',
  PRIMARY KEY (`nid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `numbers` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fid` int(10) NULL DEFAULT NULL,
  `sid` int(10) NULL DEFAULT NULL,
  `stated` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isdelete` int(10) NULL DEFAULT 1,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '971dd6da-61d7-4676-8efc-aebac241bf55', 1, 1, '123', 1);
INSERT INTO `orders` VALUES (2, 'ed29bcec-f8a7-487b-bc5a-986e87fa7ea8', 1, 1, '已付款', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isdelete` int(2) NULL DEFAULT 1,
  `updated` datetime(0) NULL DEFAULT NULL,
  `regdate` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'mds', '123', '123456789', 'gz', 1, '2019-12-27 11:03:46', '2019-12-27 11:03:50', NULL);
INSERT INTO `student` VALUES (13, 'gggggg', '555555555', 'gggggggg', 'gggggggggg', 1, '2019-12-28 14:02:38', '2019-12-28 14:02:38', '111@163');
INSERT INTO `student` VALUES (16, 'eeeee', 'eeee', 'eee', 'eee', 1, '2019-12-27 11:04:14', '2019-12-27 11:04:18', NULL);
INSERT INTO `student` VALUES (17, 'eef', 'gg', 'gg', 'jj', 1, '2019-12-27 11:04:20', '2019-12-27 11:04:23', NULL);
INSERT INTO `student` VALUES (19, 'user', '123456', '13557280197', 'fddsdsgdgdg', 1, NULL, '2019-12-28 12:58:45', 'aa@a');
INSERT INTO `student` VALUES (20, 'user', '123456', '13557280197', 'fddsdsgdgdg', 1, NULL, '2019-12-28 13:02:55', 'aa@a');
INSERT INTO `student` VALUES (21, 'user', '123456', '13557280197', 'fddsdsgdgdg', 1, '2019-12-28 13:18:01', NULL, 'aa@a');
INSERT INTO `student` VALUES (22, 'user', '123456', '13557280197', 'fddsdsgdgdg', 1, '2019-12-28 13:18:59', NULL, 'aa@a');
INSERT INTO `student` VALUES (23, 'user', '123456', '13557280197', 'fddsdsgdgdg', 1, '2019-12-28 13:43:20', NULL, 'aa@a');
INSERT INTO `student` VALUES (24, 'user', '123456', '13557280197', 'fddsdsgdgdg', 1, '2019-12-28 13:43:25', NULL, 'aa@a');

SET FOREIGN_KEY_CHECKS = 1;

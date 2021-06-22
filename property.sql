/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : property

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 09/06/2021 15:31:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `comment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论主键id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '当前用户id',
  `pid` int(0) NULL DEFAULT 0 COMMENT '发帖用户id',
  `responder` int(0) NULL DEFAULT 0 COMMENT '回复对方id',
  `comments` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论图片',
  `comment_address` tinyint(1) NULL DEFAULT 0 COMMENT '评论地址 0:本小区 1:附近',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, 1, 0, 0, '第一条文章试试水', 'https://img2.woyaogexing.com/2021/05/31/038c53a588ec4eb4b9b52bfa4c64d629!400x400.jpeg', 0, '2021-05-30 19:49:09', '2021-05-30 19:49:09');
INSERT INTO `t_comment` VALUES (2, 1, 0, 0, '附近第二条文章', 'https://img2.woyaogexing.com/2021/05/31/614610562e5440148db397495ce3f199!400x400.jpeg', 1, '2021-05-30 19:49:09', '2021-05-30 19:49:09');
INSERT INTO `t_comment` VALUES (3, 2, 1, 0, '评论第一条文章', NULL, 0, '2021-05-30 19:49:09', '2021-05-30 19:49:09');
INSERT INTO `t_comment` VALUES (4, 3, 1, 2, '评论第一个评论', NULL, 0, '2021-05-30 23:47:27', '2021-05-30 23:47:31');
INSERT INTO `t_comment` VALUES (5, 2, 0, 0, '附近友两手第一条帖子', 'https://img2.woyaogexing.com/2021/05/31/d014839557874b118cdb83ff52f1973b!400x400.jpeg', 1, '2021-06-01 14:31:14', '2021-06-01 14:31:14');
INSERT INTO `t_comment` VALUES (6, 1, 0, 0, '本小区友两手第一条帖子', 'https://img2.woyaogexing.com/2021/05/31/45b3f1c8160646349b0076409f7d9515!400x400.jpeg', 0, '2021-06-01 14:32:57', '2021-06-01 14:32:57');
INSERT INTO `t_comment` VALUES (7, 3, 0, 0, '本小区活动第一条', 'https://img2.woyaogexing.com/2021/05/31/84b252b60d3f42be8afefa9fef2d77d5!400x400.png', 0, '2021-06-01 14:36:47', '2021-06-01 14:36:47');
INSERT INTO `t_comment` VALUES (8, 2, 0, 0, '附近活动第一条', 'https://img2.woyaogexing.com/2021/05/31/bb078655f30c4791890387589b7ec95b!400x400.jpeg', 0, '2021-06-01 14:37:38', '2021-06-01 14:37:38');
INSERT INTO `t_comment` VALUES (9, 1, 0, 0, '本小区帮忙第一条', 'https://img2.woyaogexing.com/2021/05/30/d7c05f4e3a2a46d2a947366edd9655e2!400x400.jpeg', 0, '2021-06-01 14:38:51', '2021-06-01 14:38:51');
INSERT INTO `t_comment` VALUES (10, 2, 0, 0, '附近帮忙第一条', 'https://img2.woyaogexing.com/2021/05/31/f797647afe534b12bf3a9d4c14a5497a!400x400.jpeg', 1, '2021-06-01 14:41:43', '2021-06-01 14:41:43');
INSERT INTO `t_comment` VALUES (11, 2, 0, 0, '附近帮忙第一条', 'https://img2.woyaogexing.com/2021/05/30/5068fc64cdc84df7863b18f208a17cc6!400x400.jpeg', 1, '2021-06-01 15:21:30', '2021-06-01 15:21:30');
INSERT INTO `t_comment` VALUES (12, 1, 0, 0, '接口测试1', 'https://img2.woyaogexing.com/2021/05/30/5068fc64cdc84df7863b18f208a17cc6!400x400.jpeg', 0, '2021-06-01 15:25:58', '2021-06-01 15:25:58');
INSERT INTO `t_comment` VALUES (13, 2, 0, 0, '接口测试2', 'https://img2.woyaogexing.com/2021/05/30/e4ea845cbc98430bb0733765de77d65a!400x400.jpeg', 0, '2021-06-01 15:42:14', '2021-06-01 15:42:14');

-- ----------------------------
-- Table structure for t_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '优惠券主键id',
  `shop_id` int(0) NULL DEFAULT NULL COMMENT '商店id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠券内容',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `disabled` tinyint(1) NULL DEFAULT 0 COMMENT '是否可用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_coupon
-- ----------------------------
INSERT INTO `t_coupon` VALUES (1, 1, '满30减10', 1, 0, '2021-06-09 19:49:09');
INSERT INTO `t_coupon` VALUES (2, 1, '满45减30', 1, 0, '2021-06-09 19:49:09');
INSERT INTO `t_coupon` VALUES (3, 2, '买一送一', 1, 0, '2021-06-09 15:20:09');
INSERT INTO `t_coupon` VALUES (4, 3, '满15减5', 1, 0, '2021-06-09 15:22:46');
INSERT INTO `t_coupon` VALUES (5, 4, '满1500减799', 1, 0, '2021-06-09 15:22:49');
INSERT INTO `t_coupon` VALUES (6, 5, '草莓牛奶麦旋风1杯', 1, 0, '2021-06-09 15:22:51');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(0) NULL DEFAULT NULL COMMENT '父菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单icon',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '类型 0菜单 1按钮',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序',
  `disabled` tinyint(1) NULL DEFAULT 0 COMMENT '是否可用',
  `open` tinyint(1) NULL DEFAULT 0 COMMENT '是否展开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 0, '首页', '/home/index', 'el-icon-s-home', '0', 1, 0, 0);
INSERT INTO `t_menu` VALUES (2, 0, '物业管理', '/article-menu', 'iconfont icon-guanli', '0', 2, 0, 0);
INSERT INTO `t_menu` VALUES (3, 0, '消息管理', '/message-menu', 'iconfont icon-xiaoxitongzhi', '0', 3, 0, 0);
INSERT INTO `t_menu` VALUES (4, 0, '用户管理', '/users-menu', 'iconfont icon-zhanghaoquanxianguanli', '0', 4, 0, 0);
INSERT INTO `t_menu` VALUES (5, 0, '个人中心', '/setting-menu', 'iconfont icon-denglu', '0', 5, 0, 0);
INSERT INTO `t_menu` VALUES (6, 2, '物业公告', '/article/add', 'iconfont icon-ceshishenqing', '0', 1, 0, 0);
INSERT INTO `t_menu` VALUES (7, 3, '评论管理', '/comments', 'iconfont icon-youhui', '0', 1, 0, 0);
INSERT INTO `t_menu` VALUES (8, 4, '用户列表', '/users', 'iconfont icon-Customermanagement', '0', 1, 0, 0);
INSERT INTO `t_menu` VALUES (9, 4, '角色管理', '/roles', 'iconfont icon-tongxunlu', '0', 2, 0, 0);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色主键id',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'admin', '管理员');
INSERT INTO `t_role` VALUES (2, 'user', '普通用户');
INSERT INTO `t_role` VALUES (3, 'testUser', '测试用户');

-- ----------------------------
-- Table structure for t_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联主键id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_user
-- ----------------------------
INSERT INTO `t_role_user` VALUES (1, 1, 1);
INSERT INTO `t_role_user` VALUES (2, 2, 2);
INSERT INTO `t_role_user` VALUES (3, 3, 2);
INSERT INTO `t_role_user` VALUES (4, 4, 2);
INSERT INTO `t_role_user` VALUES (5, 5, 2);

-- ----------------------------
-- Table structure for t_store
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '商家主键id',
  `store_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名字',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_store
-- ----------------------------
INSERT INTO `t_store` VALUES (1, '星巴克', 'https://img.zcool.cn/community/0180005bf766b2a801209252ced78c.jpg@1280w_1l_2o_100sh.jpg', '2021-06-09 19:49:09');
INSERT INTO `t_store` VALUES (2, '喜茶', 'https://pic1.zhimg.com/v2-8c13c9f55882ff2bd9f0a3f03d32e0ec_b.jpg', '2021-06-09 15:19:20');
INSERT INTO `t_store` VALUES (3, '伏见桃山', 'https://th.bing.com/th/id/R8429d4b166c9154dfbed80cc393c03b7?rik=3Wa4O4U6LJL8pw&riu=http%3a%2f%2fimg.canyin.com%2f2020%2f05%2f172352833D4.jpg&ehk=ZnwizveEInv%2fwHeXOWXyZGZaooVdyZ9MH5AcBwwA1bc%3d&risl=&pid=ImgRaw', '2021-06-09 15:19:22');
INSERT INTO `t_store` VALUES (4, '保利洲际酒店', 'https://tse3-mm.cn.bing.net/th/id/OIP.Mlt2nlJf_CUGarqq9o403AHaDx?pid=ImgDet&rs=1', '2021-06-09 15:19:24');
INSERT INTO `t_store` VALUES (5, '麦当劳', 'https://th.bing.com/th/id/R6b351b60c60feccd7e48b5c989330bed?rik=mvLFqh20Nj2GwQ&riu=http%3a%2f%2fwww.kuaipng.com%2fUploads%2fpic%2fwater%2f44987%2fgoods_water_44987_698_698_.png&ehk=75yQndzjKyet5b1maEOTEGUQyjBzBbyHBlKJkxQjoxo%3d&risl=&pid=ImgRaw', '2021-06-09 15:19:29');
INSERT INTO `t_store` VALUES (6, 'Aape', 'https://gdp.alicdn.com/imgextra/i3/2989293827/O1CN01Bu1Vpz1e8oLREstZ6_!!2989293827.jpg', '2021-06-09 15:25:17');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `tag_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '社区标签主键id',
  `tag_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, '帖子', '2021-05-30 19:49:09');
INSERT INTO `t_tag` VALUES (2, '友两手', '2021-05-30 19:49:09');
INSERT INTO `t_tag` VALUES (3, '活动', '2021-05-30 19:49:09');
INSERT INTO `t_tag` VALUES (4, '帮忙', '2021-05-30 19:49:09');

-- ----------------------------
-- Table structure for t_tag_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_tag_comment`;
CREATE TABLE `t_tag_comment`  (
  `tag_comment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '标签评论主键id',
  `tag_id` int(0) NULL DEFAULT NULL COMMENT '标签id',
  `comment_id` int(0) NULL DEFAULT NULL COMMENT '评论id',
  PRIMARY KEY (`tag_comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag_comment
-- ----------------------------
INSERT INTO `t_tag_comment` VALUES (1, 1, 1);
INSERT INTO `t_tag_comment` VALUES (2, 1, 2);
INSERT INTO `t_tag_comment` VALUES (3, 1, 3);
INSERT INTO `t_tag_comment` VALUES (4, 1, 4);
INSERT INTO `t_tag_comment` VALUES (5, 2, 5);
INSERT INTO `t_tag_comment` VALUES (6, 2, 6);
INSERT INTO `t_tag_comment` VALUES (7, 3, 7);
INSERT INTO `t_tag_comment` VALUES (8, 3, 8);
INSERT INTO `t_tag_comment` VALUES (9, 4, 9);
INSERT INTO `t_tag_comment` VALUES (10, 4, 10);
INSERT INTO `t_tag_comment` VALUES (11, 4, 11);
INSERT INTO `t_tag_comment` VALUES (12, 2, 12);
INSERT INTO `t_tag_comment` VALUES (13, 4, 13);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户主键ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://img2.woyaogexing.com/2021/05/29/9b713a794d8a409b844f31e6ca3c9ed4!400x400.jpeg' COMMENT '头像',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除 0：存在 1：已删',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `ip_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip坐标',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'cqt', '$2a$10$k52gEkrAwwbWHGBDC8BvyOlEJIROnB5qEhXYwa0E09eUOA4gBmWeC', '管理员cqt', 'https://img2.woyaogexing.com/2021/06/01/f9bd8828ca5d431783ed5a9dfcfda132!400x400.jpeg', '密码123456', 0, '2021-06-02 17:54:34', '127.0.0.1', '', '2021-05-06 17:11:49', '2021-05-30 19:46:09');
INSERT INTO `t_user` VALUES (2, '用户', '$2a$10$oqV6GnZkMDTAaicTuFqEI.iDyEuq6hbSkbtV.3vSnTilJauMbSOkG', '用户昵称', 'https://img2.woyaogexing.com/2021/06/01/ff58d13e31b949e39463ce7c4af9111a!400x400.png', 'password123456', 0, '2021-05-30 19:49:09', '127.0.0.1', '', '2021-05-30 19:26:08', '2021-05-30 19:26:08');
INSERT INTO `t_user` VALUES (3, '黑仔', '$2a$10$PGvrrFNAUawEjb9Mf2IqL.CP0naa/TFSJbmj4C70u0WaT3Ku/hdKm', '黑仔', 'https://img2.woyaogexing.com/2021/05/31/32c37eb9ed9a41c4ac7afb4108f409a1!400x400.png', 'password123456', 0, NULL, NULL, NULL, '2021-05-30 19:28:16', '2021-05-30 19:28:16');
INSERT INTO `t_user` VALUES (4, 'jinx', '$2a$10$C1qx24LL9vtlYFSY8x4hluutTpMBObnTEQP8f7YUdTEt2G/h9XkIq', 'xjh', 'https://img2.woyaogexing.com/2021/05/31/6bd1b51c44eb4e31b96e8b520b9b3200!400x400.jpeg', '123456', 0, '2021-06-09 15:30:08', '127.0.0.1', '', '2021-05-31 23:27:48', '2021-05-31 23:27:48');
INSERT INTO `t_user` VALUES (5, '迷梦', '$2a$10$5l3Z3.mXsTuh68qtHI9puuLhAie.25JTdLmCYozvoGBdcwtjrJuFm', '迷梦', 'https://img2.woyaogexing.com/2021/05/31/dccfe5ec68f145be816223937a2d4927!400x400.jpeg', '123456', 0, NULL, NULL, NULL, '2021-05-31 23:36:54', '2021-05-31 23:36:54');

SET FOREIGN_KEY_CHECKS = 1;

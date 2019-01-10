/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 10/01/2019 19:21:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `fullname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '全名',
  `e_mail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别：0女，1男,2保密',
  `birthday` date NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `tb_admin_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'arthur', 'duxiaod@qq.com', '1', '1994-11-08', '陕西省西安市雁塔区', '17693109997', 1);
INSERT INTO `tb_admin` VALUES (18, 'test', 'e10adc3949ba59abbe56e057f20f883e', NULL, 'test', 'test@test.com', '1', '2018-02-25', '甘肃省兰州市榆中县和平镇', '17601038192', 61);
INSERT INTO `tb_admin` VALUES (19, 'qiugy', '36abbdcaa6b0d925f65c86dd6cb15d2c', NULL, '仇高阳', '240252729@qq.com', '1', '2019-01-05', '深刻的法律考试的风景', '18066117806', 61);

-- ----------------------------
-- Table structure for tb_carousel
-- ----------------------------
DROP TABLE IF EXISTS `tb_carousel`;
CREATE TABLE `tb_carousel`  (
  `id` tinyint(8) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `imgLink` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sorting` int(10) NOT NULL,
  `status` int(1) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_carousel
-- ----------------------------
INSERT INTO `tb_carousel` VALUES (8, 'fe3ecede0bec467b8be253684db5e28b3193.jpg', 'http://localhost:8080/irs/index.jsp', '百姓关心的环境问题 习近平给出最新答案', 200, 1, '2018-05-20 23:36:49', '2018-08-21 10:21:16');
INSERT INTO `tb_carousel` VALUES (10, '1e4e799ccb41438ab4ece494f32d72c59900.jpg', 'http://localhost:8080/irs_maven/index.jsp', 'test', 19, 1, '2018-08-21 10:28:49', NULL);

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` int(11) NULL DEFAULT NULL COMMENT '级别 0普通1vip',
  `sex` int(11) NOT NULL COMMENT '性别 0男1女',
  `carded` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES (1, 1, 'c240252729', 1, 1, '123445', '深刻的法律考试的风景', '18066117806', '123456');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specifications` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `batch_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批号',
  `approval_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准文号',
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产地',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `packing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '包装',
  `suppliers_id` int(11) NULL DEFAULT NULL COMMENT '供应商ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES (1, 7, '西瓜', 'test1', 'test1', 'test1', '中国', 0.03, 'test1', 3);
INSERT INTO `tb_goods` VALUES (2, 5, 'test1', 'test1', 'test1', 'test3', '中国', 0.03, '123456', 4);
INSERT INTO `tb_goods` VALUES (3, 5, '冬瓜', 'test1', 'test3', 'test3', '中国', 15.00, 'test3', 4);
INSERT INTO `tb_goods` VALUES (4, 7, '黄瓜', 'test1', 'test3', 'test3', 'china', 40.00, 'test1', 4);

-- ----------------------------
-- Table structure for tb_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_type`;
CREATE TABLE `tb_goods_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_goods_type
-- ----------------------------
INSERT INTO `tb_goods_type` VALUES (5, 'test1', 'test1');
INSERT INTO `tb_goods_type` VALUES (6, 'test12', 'test');
INSERT INTO `tb_goods_type` VALUES (7, 'test12', 'test');

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行方法',
  `params` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `create_time` datetime(0) NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 874 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_log
-- ----------------------------
INSERT INTO `tb_log` VALUES (690, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":2,\"title\":\"系统管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":998,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:48:02');
INSERT INTO `tb_log` VALUES (691, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":0,\"title\":\"基础信息管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:48:52');
INSERT INTO `tb_log` VALUES (692, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":57,\"title\":\"商品信息\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:49:20');
INSERT INTO `tb_log` VALUES (693, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":57,\"title\":\"供应商信息\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:49:37');
INSERT INTO `tb_log` VALUES (694, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":57,\"title\":\"客户信息\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:49:48');
INSERT INTO `tb_log` VALUES (695, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":58,\"title\":\"商品信息\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"\",\"spread\":null,\"parentId\":57,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:50:17');
INSERT INTO `tb_log` VALUES (696, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":59,\"title\":\"供应商信息\",\"icon\":\"\",\"href\":\"supplier/supplierList\",\"perms\":\"\",\"spread\":null,\"parentId\":57,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:51:18');
INSERT INTO `tb_log` VALUES (697, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":60,\"title\":\"客户信息\",\"icon\":\"\",\"href\":\"customer/customerList\",\"perms\":\"\",\"spread\":null,\"parentId\":57,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:51:35');
INSERT INTO `tb_log` VALUES (698, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,17,18,19,4,20,46,47,48,49,50,9,11,34,14,15,42,43,44,45,57,58,59,60\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:52:00');
INSERT INTO `tb_log` VALUES (699, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,59,60\";', '0:0:0:0:0:0:0:1', '2019-01-03 17:52:11');
INSERT INTO `tb_log` VALUES (700, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":57,\"title\":\"基础信息管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:56:08');
INSERT INTO `tb_log` VALUES (701, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":57,\"title\":\"基础信息管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:56:22');
INSERT INTO `tb_log` VALUES (702, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":58,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:57:09');
INSERT INTO `tb_log` VALUES (703, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":58,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:57:24');
INSERT INTO `tb_log` VALUES (704, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":58,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:57:42');
INSERT INTO `tb_log` VALUES (705, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":58,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:57:55');
INSERT INTO `tb_log` VALUES (706, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":61,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:list\",\"spread\":null,\"parentId\":58,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:58:43');
INSERT INTO `tb_log` VALUES (707, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":64,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:save\",\"spread\":null,\"parentId\":58,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:59:30');
INSERT INTO `tb_log` VALUES (708, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":62,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:delete\",\"spread\":null,\"parentId\":58,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 19:59:46');
INSERT INTO `tb_log` VALUES (709, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":63,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:update\",\"spread\":null,\"parentId\":58,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-03 20:00:17');
INSERT INTO `tb_log` VALUES (710, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,17,18,19,4,20,46,47,48,49,50,9,11,34,14,15,42,43,44,45,57,58,61,62,63,64,59,60\";', '0:0:0:0:0:0:0:1', '2019-01-03 20:02:50');
INSERT INTO `tb_log` VALUES (711, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60\";', '0:0:0:0:0:0:0:1', '2019-01-03 20:05:02');
INSERT INTO `tb_log` VALUES (712, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":null,\"name\":\"test3\",\"specifications\":\"test3\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test3\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 10:37:09');
INSERT INTO `tb_log` VALUES (713, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":null,\"name\":\"test3\",\"specifications\":\"test3\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test3\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 10:38:18');
INSERT INTO `tb_log` VALUES (714, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":null,\"name\":\"test3\",\"specifications\":\"test3\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test3\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 10:39:37');
INSERT INTO `tb_log` VALUES (715, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":null,\"name\":\"test3\",\"specifications\":\"test3\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test3\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 10:40:19');
INSERT INTO `tb_log` VALUES (716, 'admin', '更新商品信息', '/goods/update', '{\"id\":3,\"goodsType\":null,\"name\":\"test3\",\"specifications\":\"test3\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"chian\",\"price\":0.03,\"packing\":\"test3\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 10:56:00');
INSERT INTO `tb_log` VALUES (717, 'admin', '删除商品信息', '/goods/delete', '1;', '0:0:0:0:0:0:0:1', '2019-01-04 11:00:06');
INSERT INTO `tb_log` VALUES (718, 'admin', '批量删除商品信息', '/goods/deletes', '\"3,2\";', '0:0:0:0:0:0:0:1', '2019-01-04 11:00:11');
INSERT INTO `tb_log` VALUES (719, 'admin', '批量删除商品信息', '/goods/deletes', '\"3,2\";', '0:0:0:0:0:0:0:1', '2019-01-04 11:00:38');
INSERT INTO `tb_log` VALUES (720, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":60,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"customer:customer:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-04 16:58:36');
INSERT INTO `tb_log` VALUES (721, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":60,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"customer:customer:delete\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-04 16:59:27');
INSERT INTO `tb_log` VALUES (722, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":60,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"customer:customer:update\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-04 16:59:54');
INSERT INTO `tb_log` VALUES (723, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":60,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"customer:customer:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-04 17:00:16');
INSERT INTO `tb_log` VALUES (724, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68\";', '0:0:0:0:0:0:0:1', '2019-01-04 17:00:41');
INSERT INTO `tb_log` VALUES (725, 'admin', '添加商品信息', '/customer/save', '{\"id\":null,\"number\":null,\"name\":\"1\",\"grade\":1,\"sex\":1,\"carded\":null,\"address\":null,\"phone\":null,\"qq\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 17:41:52');
INSERT INTO `tb_log` VALUES (726, 'admin', '添加商品信息', '/customer/save', '{\"id\":null,\"number\":null,\"name\":\"test1\",\"grade\":1,\"sex\":1,\"carded\":null,\"address\":null,\"phone\":null,\"qq\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 17:43:20');
INSERT INTO `tb_log` VALUES (727, 'admin', '添加商品信息', '/customer/save', '{\"id\":null,\"number\":null,\"name\":\"test3\",\"grade\":1,\"sex\":1,\"carded\":null,\"address\":null,\"phone\":null,\"qq\":null};', '0:0:0:0:0:0:0:1', '2019-01-04 17:44:17');
INSERT INTO `tb_log` VALUES (728, 'admin', '添加商品信息', '/customer/save', '{\"id\":null,\"number\":123,\"name\":\"test1\",\"grade\":1,\"sex\":1,\"carded\":\"123445\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"qq\":\"123456\"};', '0:0:0:0:0:0:0:1', '2019-01-04 17:48:47');
INSERT INTO `tb_log` VALUES (729, 'admin', '添加商品信息', '/customer/save', '{\"id\":null,\"number\":2,\"name\":\"test3\",\"grade\":1,\"sex\":1,\"carded\":\"123445\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"qq\":\"123456\"};', '0:0:0:0:0:0:0:1', '2019-01-04 17:51:43');
INSERT INTO `tb_log` VALUES (730, 'admin', '更新商品信息', '/customer/update', '{\"id\":2,\"number\":2,\"name\":\"test3\",\"grade\":0,\"sex\":0,\"carded\":\"123445\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"qq\":\"123456\"};', '0:0:0:0:0:0:0:1', '2019-01-04 18:01:27');
INSERT INTO `tb_log` VALUES (731, 'admin', '删除商品信息', '/customer/delete', '2;', '0:0:0:0:0:0:0:1', '2019-01-04 18:01:40');
INSERT INTO `tb_log` VALUES (732, 'admin', '批量删除商品信息', '/customer/deletes', '\"1\";', '0:0:0:0:0:0:0:1', '2019-01-04 18:01:43');
INSERT INTO `tb_log` VALUES (733, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:11:32');
INSERT INTO `tb_log` VALUES (734, 'admin', '添加供应商信息', '/supplier/save', '{\"id\":null,\"name\":\"test1\",\"address\":\"深刻的法律考试的风景\",\"postCode\":\"23623\",\"phone\":\"18066117806\",\"contact\":\"test1\",\"contactPhone\":\"18066117806\",\"mail\":\"240250@qq.com\",\"bank\":\"中国银行\",\"account\":\"test1\"};', '0:0:0:0:0:0:0:1', '2019-01-05 10:15:36');
INSERT INTO `tb_log` VALUES (735, 'admin', '添加供应商信息', '/supplier/save', '{\"id\":null,\"name\":\"test1\",\"address\":\"深刻的法律考试的风景\",\"postCode\":\"23623\",\"phone\":\"18066117806\",\"contact\":\"test1\",\"contactPhone\":\"18066117806\",\"mail\":\"240250@qq.com\",\"bank\":\"中国银行\",\"account\":\"test1\"};', '0:0:0:0:0:0:0:1', '2019-01-05 10:16:46');
INSERT INTO `tb_log` VALUES (736, 'admin', '更新供应商信息', '/supplier/update', '{\"id\":1,\"name\":\"test12\",\"address\":\"深刻的法律考试的风景\",\"postCode\":\"23623\",\"phone\":\"18066117806\",\"contact\":\"test1\",\"contactPhone\":\"18066117806\",\"mail\":\"240250@qq.com\",\"bank\":\"中国银行\",\"account\":\"test1\"};', '0:0:0:0:0:0:0:1', '2019-01-05 10:18:05');
INSERT INTO `tb_log` VALUES (737, 'admin', '添加供应商信息', '/supplier/save', '{\"id\":null,\"name\":\"test11\",\"address\":\"深刻的法律考试的风景\",\"postCode\":\"23623\",\"phone\":\"18066117806\",\"contact\":\"test1\",\"contactPhone\":\"18066117806\",\"mail\":\"240250@qq.com\",\"bank\":\"中国银行\",\"account\":\"240252729@qq.com\"};', '0:0:0:0:0:0:0:1', '2019-01-05 10:18:24');
INSERT INTO `tb_log` VALUES (738, 'admin', '删除供应商信息', '/supplier/delete', '2;', '0:0:0:0:0:0:0:1', '2019-01-05 10:18:32');
INSERT INTO `tb_log` VALUES (739, 'admin', '批量删除供应商信息', '/supplier/deletes', '\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:18:36');
INSERT INTO `tb_log` VALUES (740, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":0,\"title\":\"进货管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:28:27');
INSERT INTO `tb_log` VALUES (741, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":0,\"title\":\"销售管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:29:08');
INSERT INTO `tb_log` VALUES (742, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":69,\"title\":\"进货管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:29:26');
INSERT INTO `tb_log` VALUES (743, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68,69,70\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:29:46');
INSERT INTO `tb_log` VALUES (744, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":69,\"title\":\"采购单管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:32:14');
INSERT INTO `tb_log` VALUES (745, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":58,\"title\":\"商品信息\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"\",\"spread\":null,\"parentId\":57,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:33:30');
INSERT INTO `tb_log` VALUES (746, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":59,\"title\":\"供应商信息\",\"icon\":\"\",\"href\":\"supplier/supplierList\",\"perms\":\"\",\"spread\":null,\"parentId\":57,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:33:56');
INSERT INTO `tb_log` VALUES (747, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":60,\"title\":\"客户信息\",\"icon\":\"\",\"href\":\"customer/customerList\",\"perms\":\"\",\"spread\":null,\"parentId\":57,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:34:09');
INSERT INTO `tb_log` VALUES (748, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":69,\"title\":\"采购退货单\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:36:33');
INSERT INTO `tb_log` VALUES (749, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":70,\"title\":\"销售单\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:37:16');
INSERT INTO `tb_log` VALUES (750, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":70,\"title\":\"销售退货单\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:37:39');
INSERT INTO `tb_log` VALUES (751, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":74,\"title\":\"销售退货单\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":70,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:38:04');
INSERT INTO `tb_log` VALUES (752, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":70,\"title\":\"库存管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:38:45');
INSERT INTO `tb_log` VALUES (753, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68,69,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:39:09');
INSERT INTO `tb_log` VALUES (754, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:39:51');
INSERT INTO `tb_log` VALUES (755, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,14,15,42,43,44,45,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:41:02');
INSERT INTO `tb_log` VALUES (756, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"管理员\",\"roleRemark\":\"test\"};\"1,9,10,33,11,34,35,36,37,14,15,42,43,44,45,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:41:23');
INSERT INTO `tb_log` VALUES (757, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"管理员\",\"roleRemark\":\"普通管理员\"};\"1,9,10,33,11,34,35,36,37,14,15,42,43,44,45,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-05 10:41:36');
INSERT INTO `tb_log` VALUES (758, 'admin', '添加管理员', '/sys/insAdmin', '{\"id\":null,\"username\":\"qiugy\",\"password\":\"c240252729\",\"salt\":null,\"fullname\":\"仇高阳\",\"eMail\":\"240252729@qq.com\",\"sex\":\"1\",\"birthday\":\"2019-01-05\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"roleId\":61,\"roleName\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 10:42:34');
INSERT INTO `tb_log` VALUES (759, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"管理员\",\"roleRemark\":\"普通管理员\"};\"1,9,10,33,11,34,35,36,37,14,15,42,43,44,45,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-05 17:10:28');
INSERT INTO `tb_log` VALUES (760, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":71,\"title\":\"采购单管理\",\"icon\":\"\",\"href\":\"purchaseOrder/purchaseOrderList\",\"perms\":\"\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-05 17:13:12');
INSERT INTO `tb_log` VALUES (761, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":null,\"name\":\"西瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test1\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:14:15');
INSERT INTO `tb_log` VALUES (762, 'admin', '添加供应商信息', '/supplier/save', '{\"id\":null,\"name\":\"供应商test1\",\"address\":\"深刻的法律考试的风景\",\"postCode\":\"23623\",\"phone\":\"18066117806\",\"contact\":\"test1\",\"contactPhone\":\"18066117806\",\"mail\":\"240250@qq.com\",\"bank\":\"中国银行\",\"account\":\"240252729@qq.com\"};', '0:0:0:0:0:0:0:1', '2019-01-05 17:15:06');
INSERT INTO `tb_log` VALUES (763, 'qiugy', '添加用户', '/user/insUser', '{\"uid\":null,\"eMail\":\"240252729@qq.com\",\"nickname\":\"test4\",\"password\":\"240252729\",\"sex\":\"1\",\"birthday\":\"2019-01-05\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"eCode\":null,\"status\":null,\"createTime\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:29:57');
INSERT INTO `tb_log` VALUES (764, 'qiugy', '更新用户信息', '/user/updUser', '{\"uid\":30,\"eMail\":\"240252729@qq.com\",\"nickname\":\"test4\",\"password\":null,\"sex\":\"1\",\"birthday\":\"2019-01-05\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"eCode\":null,\"status\":\"1\",\"createTime\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:30:23');
INSERT INTO `tb_log` VALUES (765, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:34:58');
INSERT INTO `tb_log` VALUES (766, 'qiugy', '更新采购单', '/purchaseOrder/update', '{\"id\":1,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":90,\"money\":90.00,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:35:24');
INSERT INTO `tb_log` VALUES (767, 'qiugy', '删除采购单', '/purchaseOrder/delete', '1;', '0:0:0:0:0:0:0:1', '2019-01-05 17:35:37');
INSERT INTO `tb_log` VALUES (768, 'qiugy', '删除采购单', '/purchaseOrder/delete', '1;', '0:0:0:0:0:0:0:1', '2019-01-05 17:35:48');
INSERT INTO `tb_log` VALUES (769, 'qiugy', '删除采购单', '/purchaseOrder/delete', '1;', '0:0:0:0:0:0:0:1', '2019-01-05 17:38:10');
INSERT INTO `tb_log` VALUES (770, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":2,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:39:48');
INSERT INTO `tb_log` VALUES (771, 'qiugy', '删除采购单', '/purchaseOrder/delete', '2;', '0:0:0:0:0:0:0:1', '2019-01-05 17:39:56');
INSERT INTO `tb_log` VALUES (772, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:41:49');
INSERT INTO `tb_log` VALUES (773, 'qiugy', '删除采购单', '/purchaseOrder/delete', '3;', '0:0:0:0:0:0:0:1', '2019-01-05 17:41:55');
INSERT INTO `tb_log` VALUES (774, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:43:00');
INSERT INTO `tb_log` VALUES (775, 'qiugy', '删除采购单', '/purchaseOrder/delete', '4;', '0:0:0:0:0:0:0:1', '2019-01-05 17:50:12');
INSERT INTO `tb_log` VALUES (776, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:50:57');
INSERT INTO `tb_log` VALUES (777, 'qiugy', '删除采购单', '/purchaseOrder/delete', '5;', '0:0:0:0:0:0:0:1', '2019-01-05 17:56:39');
INSERT INTO `tb_log` VALUES (778, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:57:01');
INSERT INTO `tb_log` VALUES (779, 'qiugy', '删除采购单', '/purchaseOrder/delete', '6;', '0:0:0:0:0:0:0:1', '2019-01-05 17:57:07');
INSERT INTO `tb_log` VALUES (780, 'qiugy', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":90,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 17:57:19');
INSERT INTO `tb_log` VALUES (781, 'qiugy', '添加采购单', '/purchaseOrder/saveReturnPurchaseOrder', '{\"id\":null,\"number\":123,\"type\":null,\"price\":0.03,\"amount\":30,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 18:49:11');
INSERT INTO `tb_log` VALUES (782, 'qiugy', '添加采购单', '/purchaseOrder/saveReturnPurchaseOrder', '{\"id\":null,\"number\":123,\"type\":null,\"price\":0.03,\"amount\":30,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-05 18:51:41');
INSERT INTO `tb_log` VALUES (783, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":72,\"title\":\"采购退货单\",\"icon\":\"\",\"href\":\"purchaseReturnOrder/purchaseReturnOrderList\",\"perms\":\"\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-07 10:48:38');
INSERT INTO `tb_log` VALUES (784, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-07 10:49:04');
INSERT INTO `tb_log` VALUES (785, 'admin', '添加采购单', '/purchaseOrder/saveReturnPurchaseOrder', '{\"id\":null,\"number\":123,\"type\":null,\"price\":0.03,\"amount\":30,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 10:58:58');
INSERT INTO `tb_log` VALUES (786, 'admin', '添加采购单', '/purchaseOrder/saveReturnPurchaseOrder', '{\"id\":null,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 11:03:22');
INSERT INTO `tb_log` VALUES (787, 'admin', '更新采购退货单', '/purchaseReturnOrder/update', '{\"id\":4,\"number\":123,\"type\":1,\"price\":0.03,\"amount\":30,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test2\",\"approvalNumber\":\"test2\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 11:18:17');
INSERT INTO `tb_log` VALUES (788, 'admin', '删除采购单', '/purchaseReturnOrder/delete', '4;', '0:0:0:0:0:0:0:1', '2019-01-07 11:18:27');
INSERT INTO `tb_log` VALUES (789, 'admin', '批量删除采购退货单', '/purchaseReturnOrder/deletes', '\"3,2,1\";', '0:0:0:0:0:0:0:1', '2019-01-07 11:18:31');
INSERT INTO `tb_log` VALUES (790, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":73,\"title\":\"销售单\",\"icon\":\"\",\"href\":\"saleOrder/saleOrderList\",\"perms\":\"\",\"spread\":null,\"parentId\":70,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-07 17:01:52');
INSERT INTO `tb_log` VALUES (791, 'admin', '添加商品信息', '/customer/save', '{\"id\":null,\"number\":1,\"name\":\"c240252729\",\"grade\":1,\"sex\":1,\"carded\":\"123445\",\"address\":\"深刻的法律考试的风景\",\"phone\":\"18066117806\",\"qq\":\"123456\"};', '0:0:0:0:0:0:0:1', '2019-01-07 17:04:27');
INSERT INTO `tb_log` VALUES (792, 'admin', '添加销售单', '/saleOrder/save', '{\"id\":null,\"number\":1,\"type\":1,\"home\":\"中国\",\"supplierId\":null,\"sticks\":1,\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"customerId\":null,\"amount\":90,\"salePrice\":30,\"realPrice\":60};', '0:0:0:0:0:0:0:1', '2019-01-07 17:04:50');
INSERT INTO `tb_log` VALUES (793, 'admin', '添加销售单', '/saleOrder/save', '{\"id\":null,\"number\":1,\"type\":1,\"home\":\"中国\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"customerId\":1,\"amount\":90,\"salePrice\":30,\"realPrice\":60};', '0:0:0:0:0:0:0:1', '2019-01-07 17:09:03');
INSERT INTO `tb_log` VALUES (794, 'admin', '添加销售单', '/saleOrder/save', '{\"id\":null,\"number\":123,\"type\":1,\"home\":\"中国\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test3\",\"approvalNumber\":\"test2\",\"customerId\":1,\"amount\":30,\"salePrice\":30,\"realPrice\":60};', '0:0:0:0:0:0:0:1', '2019-01-07 17:15:33');
INSERT INTO `tb_log` VALUES (795, 'admin', '更新销售单', '/saleOrder/update', '{\"id\":3,\"number\":123,\"type\":1,\"home\":\"china\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test3\",\"approvalNumber\":\"test2\",\"customerId\":1,\"amount\":30,\"salePrice\":30.00,\"realPrice\":60.00};', '0:0:0:0:0:0:0:1', '2019-01-07 17:15:46');
INSERT INTO `tb_log` VALUES (796, 'admin', '批量删除销售单', '/saleOrder/deletes', '\"2\";', '0:0:0:0:0:0:0:1', '2019-01-07 17:16:02');
INSERT INTO `tb_log` VALUES (797, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":74,\"title\":\"销售退货单\",\"icon\":\"\",\"href\":\"saleReturnOrder/saleReturnOrderList\",\"perms\":\"\",\"spread\":null,\"parentId\":70,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-07 19:20:44');
INSERT INTO `tb_log` VALUES (798, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":74,\"title\":\"销售退货单\",\"icon\":\"\",\"href\":\"saleReturnOrder/saleReturnOrderList\",\"perms\":\"\",\"spread\":null,\"parentId\":70,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-07 19:22:06');
INSERT INTO `tb_log` VALUES (799, 'admin', '添加销售单', '/saleOrder/saveReturnSaleOrder', '{\"id\":null,\"number\":1,\"type\":1,\"price\":0.03,\"amount\":90,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 19:38:08');
INSERT INTO `tb_log` VALUES (800, 'admin', '添加销售单', '/saleOrder/saveReturnSaleOrder', '{\"id\":null,\"number\":1,\"type\":1,\"price\":0.03,\"amount\":90,\"money\":null,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 19:38:46');
INSERT INTO `tb_log` VALUES (801, 'admin', '添加销售单', '/saleOrder/saveReturnSaleOrder', '{\"id\":null,\"number\":123,\"type\":1,\"home\":\"中国\",\"supplierId\":null,\"sticks\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"customerId\":null,\"amount\":90,\"salePrice\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 19:42:38');
INSERT INTO `tb_log` VALUES (802, 'admin', '添加销售单', '/saleOrder/saveReturnSaleOrder', '{\"id\":null,\"number\":123,\"type\":1,\"home\":\"中国\",\"supplierId\":null,\"sticks\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"customerId\":1,\"amount\":90,\"salePrice\":30.00};', '0:0:0:0:0:0:0:1', '2019-01-07 19:46:20');
INSERT INTO `tb_log` VALUES (803, 'admin', '添加销售单', '/saleOrder/saveReturnSaleOrder', '{\"id\":null,\"number\":123,\"type\":1,\"home\":\"中国\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"customerId\":1,\"amount\":90,\"salePrice\":30.00};', '0:0:0:0:0:0:0:1', '2019-01-07 19:47:51');
INSERT INTO `tb_log` VALUES (804, 'admin', '更新采购退货单', '/purchaseReturnOrder/update', '{\"id\":3,\"number\":123,\"type\":1,\"price\":null,\"amount\":60,\"money\":null,\"home\":\"中国\",\"supplier\":null,\"remark\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 20:03:51');
INSERT INTO `tb_log` VALUES (805, 'admin', '更新采购退货单', '/purchaseReturnOrder/update', '{\"id\":3,\"number\":123,\"type\":1,\"price\":null,\"amount\":60,\"money\":null,\"home\":\"中国\",\"supplier\":null,\"remark\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 20:04:24');
INSERT INTO `tb_log` VALUES (806, 'admin', '更新采购退货单', '/purchaseReturnOrder/update', '{\"id\":3,\"number\":123,\"type\":1,\"price\":null,\"amount\":60,\"money\":null,\"home\":\"中国\",\"supplier\":null,\"remark\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 20:05:05');
INSERT INTO `tb_log` VALUES (807, 'admin', '更新采购退货单', '/purchaseReturnOrder/update', '{\"id\":3,\"number\":123,\"type\":1,\"price\":null,\"amount\":60,\"money\":null,\"home\":\"中国\",\"supplier\":null,\"remark\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 20:05:59');
INSERT INTO `tb_log` VALUES (808, 'admin', '更新采购退货单', '/purchaseReturnOrder/update', '{\"id\":3,\"number\":123,\"type\":1,\"price\":null,\"amount\":60,\"money\":null,\"home\":\"中国\",\"supplier\":null,\"remark\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-07 20:07:10');
INSERT INTO `tb_log` VALUES (809, 'admin', '添加销售单', '/saleOrder/saveReturnSaleOrder', '{\"id\":null,\"number\":1,\"type\":1,\"home\":\"中国\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"customerId\":1,\"amount\":60,\"salePrice\":30.00};', '0:0:0:0:0:0:0:1', '2019-01-07 20:09:04');
INSERT INTO `tb_log` VALUES (810, 'admin', '更新销售退货单', '/saleReturnOrder/update', '{\"id\":4,\"number\":1,\"type\":1,\"home\":\"中国\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"customerId\":1,\"amount\":180,\"salePrice\":30.00};', '0:0:0:0:0:0:0:1', '2019-01-07 20:10:02');
INSERT INTO `tb_log` VALUES (811, 'admin', '更新销售退货单', '/saleReturnOrder/update', '{\"id\":4,\"number\":1,\"type\":1,\"home\":\"中国\",\"supplierId\":3,\"sticks\":null,\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"customerId\":1,\"amount\":200,\"salePrice\":30.00};', '0:0:0:0:0:0:0:1', '2019-01-07 20:12:39');
INSERT INTO `tb_log` VALUES (812, 'admin', '删除销售单', '/saleReturnOrder/delete', '3;', '0:0:0:0:0:0:0:1', '2019-01-07 20:12:52');
INSERT INTO `tb_log` VALUES (813, 'admin', '批量删除销售退货单', '/saleReturnOrder/deletes', '\"4\";', '0:0:0:0:0:0:0:1', '2019-01-07 20:12:58');
INSERT INTO `tb_log` VALUES (814, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":0,\"title\":\"商品类型\",\"icon\":\"\",\"href\":\"goodsType/goodsTypeList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-08 10:52:12');
INSERT INTO `tb_log` VALUES (815, 'admin', '删除菜单信息', '/sys/delMenuById/76', '76;', '0:0:0:0:0:0:0:1', '2019-01-08 10:52:42');
INSERT INTO `tb_log` VALUES (816, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":57,\"title\":\"商品类型管理\",\"icon\":\"\",\"href\":\"goodsType/goodsTypeList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-08 10:53:06');
INSERT INTO `tb_log` VALUES (817, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68,77,69,71,72,70,73,74,75\";', '0:0:0:0:0:0:0:1', '2019-01-08 10:53:24');
INSERT INTO `tb_log` VALUES (818, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"test1\",\"desc\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:11:42');
INSERT INTO `tb_log` VALUES (819, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"2\",\"desc\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:12:24');
INSERT INTO `tb_log` VALUES (820, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"test1\",\"desc\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:12:53');
INSERT INTO `tb_log` VALUES (821, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"c240252729\",\"desc\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:13:51');
INSERT INTO `tb_log` VALUES (822, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"test1\",\"desc\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:15:15');
INSERT INTO `tb_log` VALUES (823, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"test12\",\"desc\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:15:43');
INSERT INTO `tb_log` VALUES (824, 'admin', '添加商品信息', '/goodsType/save', '{\"id\":null,\"name\":\"test12\",\"remark\":\"test\"};', '0:0:0:0:0:0:0:1', '2019-01-08 11:19:24');
INSERT INTO `tb_log` VALUES (825, 'admin', '更新商品信息', '/goodsType/update', '{\"id\":6,\"name\":\"test12\",\"remark\":\"test\"};', '0:0:0:0:0:0:0:1', '2019-01-08 11:26:27');
INSERT INTO `tb_log` VALUES (826, 'admin', '更新商品信息', '/goodsType/update', '{\"id\":5,\"name\":\"test1\",\"remark\":\"test1\"};', '0:0:0:0:0:0:0:1', '2019-01-08 11:26:35');
INSERT INTO `tb_log` VALUES (827, 'admin', '删除商品信息', '/goodsType/delete', '4;', '0:0:0:0:0:0:0:1', '2019-01-08 11:26:40');
INSERT INTO `tb_log` VALUES (828, 'admin', '删除商品信息', '/goodsType/delete', '3;', '0:0:0:0:0:0:0:1', '2019-01-08 11:26:43');
INSERT INTO `tb_log` VALUES (829, 'admin', '批量删除商品信息', '/goodsType/deletes', '\"2,1\";', '0:0:0:0:0:0:0:1', '2019-01-08 11:26:48');
INSERT INTO `tb_log` VALUES (830, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":5,\"name\":\"test1\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"123456\",\"suppliersId\":null};', '0:0:0:0:0:0:0:1', '2019-01-08 11:51:15');
INSERT INTO `tb_log` VALUES (831, 'admin', '更新商品信息', '/goods/update', '{\"id\":1,\"goodsType\":6,\"name\":\"西瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test1\",\"suppliersId\":3};', '0:0:0:0:0:0:0:1', '2019-01-08 15:13:10');
INSERT INTO `tb_log` VALUES (832, 'admin', '更新商品信息', '/goods/update', '{\"id\":1,\"goodsType\":7,\"name\":\"西瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test1\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test1\",\"suppliersId\":3};', '0:0:0:0:0:0:0:1', '2019-01-08 15:13:33');
INSERT INTO `tb_log` VALUES (833, 'admin', '更新商品信息', '/goods/update', '{\"id\":2,\"goodsType\":5,\"name\":\"test1\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"123456\",\"suppliersId\":3};', '0:0:0:0:0:0:0:1', '2019-01-08 15:13:51');
INSERT INTO `tb_log` VALUES (834, 'admin', '更新商品信息', '/goods/update', '{\"id\":2,\"goodsType\":6,\"name\":\"test1\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"123456\",\"suppliersId\":3};', '0:0:0:0:0:0:0:1', '2019-01-08 15:14:04');
INSERT INTO `tb_log` VALUES (835, 'admin', '更新商品信息', '/goods/update', '{\"id\":2,\"goodsType\":5,\"name\":\"test1\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"123456\",\"suppliersId\":3};', '0:0:0:0:0:0:0:1', '2019-01-08 15:19:29');
INSERT INTO `tb_log` VALUES (836, 'admin', '添加供应商信息', '/supplier/save', '{\"id\":null,\"name\":\"供应商test2\",\"address\":\"双方都卡了水电费\",\"postCode\":\"23623\",\"phone\":\"18066117806\",\"contact\":\"test1\",\"contactPhone\":\"18066117806\",\"mail\":\"240250@qq.com\",\"bank\":\"中国银行\",\"account\":\"test1\"};', '0:0:0:0:0:0:0:1', '2019-01-08 15:20:14');
INSERT INTO `tb_log` VALUES (837, 'admin', '更新商品信息', '/goods/update', '{\"id\":2,\"goodsType\":5,\"name\":\"test1\",\"specifications\":\"test1\",\"batchNumber\":\"test1\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"123456\",\"suppliersId\":4};', '0:0:0:0:0:0:0:1', '2019-01-08 15:20:28');
INSERT INTO `tb_log` VALUES (838, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":75,\"title\":\"库存管理\",\"icon\":\"\",\"href\":\"stock/stockList\",\"perms\":\"\",\"spread\":null,\"parentId\":70,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";', '0:0:0:0:0:0:0:1', '2019-01-08 19:07:37');
INSERT INTO `tb_log` VALUES (839, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":6,\"name\":\"冬瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"123456\",\"suppliersId\":4};', '0:0:0:0:0:0:0:1', '2019-01-08 19:08:27');
INSERT INTO `tb_log` VALUES (840, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":7,\"name\":\"冬瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":0.03,\"packing\":\"test3\",\"suppliersId\":4};', '0:0:0:0:0:0:0:1', '2019-01-08 19:09:58');
INSERT INTO `tb_log` VALUES (841, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":5,\"name\":\"冬瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"中国\",\"price\":30,\"packing\":\"test3\",\"suppliersId\":4};', '0:0:0:0:0:0:0:1', '2019-01-08 19:18:11');
INSERT INTO `tb_log` VALUES (842, 'admin', '更新库存信息', '/stock/update', '{\"id\":1,\"goodsId\":null,\"price\":15.00,\"amount\":null,\"cordon\":0.00};', '0:0:0:0:0:0:0:1', '2019-01-08 19:45:05');
INSERT INTO `tb_log` VALUES (843, 'admin', '更新库存信息', '/stock/update', '{\"id\":1,\"goodsId\":null,\"price\":15,\"amount\":null,\"cordon\":0.00};', '0:0:0:0:0:0:0:1', '2019-01-08 19:46:34');
INSERT INTO `tb_log` VALUES (844, 'admin', '更新库存信息', '/stock/update', '{\"id\":1,\"goodsId\":null,\"price\":15.00,\"amount\":null,\"cordon\":0.00};', '0:0:0:0:0:0:0:1', '2019-01-08 19:46:56');
INSERT INTO `tb_log` VALUES (845, 'admin', '更新库存信息', '/stock/update', '{\"id\":1,\"goodsId\":null,\"price\":15,\"amount\":null,\"cordon\":0.00};', '0:0:0:0:0:0:0:1', '2019-01-08 19:48:00');
INSERT INTO `tb_log` VALUES (846, 'admin', '更新库存信息', '/stock/update', '{\"id\":1,\"goodsId\":3,\"price\":15,\"amount\":null,\"cordon\":0.00};', '0:0:0:0:0:0:0:1', '2019-01-08 19:51:45');
INSERT INTO `tb_log` VALUES (847, 'admin', '更新库存信息', '/stock/update', '{\"id\":1,\"goodsId\":3,\"price\":15,\"amount\":1.00,\"cordon\":0.00};', '0:0:0:0:0:0:0:1', '2019-01-08 19:55:16');
INSERT INTO `tb_log` VALUES (848, 'admin', '添加商品信息', '/goods/save', '{\"id\":null,\"goodsType\":7,\"name\":\"黄瓜\",\"specifications\":\"test1\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"home\":\"china\",\"price\":40,\"packing\":\"test1\",\"suppliersId\":4};', '0:0:0:0:0:0:0:1', '2019-01-09 11:45:32');
INSERT INTO `tb_log` VALUES (849, 'admin', '添加采购单', '/purchaseOrder/save', '{\"id\":null,\"number\":122,\"type\":4,\"price\":20,\"amount\":90,\"money\":2700,\"home\":\"中国\",\"supplier\":3,\"remark\":\"test\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-09 11:46:57');
INSERT INTO `tb_log` VALUES (850, 'admin', '添加采购单', '/purchaseOrder/saveReturnPurchaseOrder', '{\"id\":null,\"number\":122,\"type\":4,\"price\":40.00,\"amount\":30,\"money\":null,\"home\":\"china\",\"supplier\":3,\"remark\":\"退了30个\",\"batchNumber\":\"test3\",\"approvalNumber\":\"test3\",\"sticks\":null};', '0:0:0:0:0:0:0:1', '2019-01-09 11:47:49');
INSERT INTO `tb_log` VALUES (851, 'admin', '更新库存信息', '/stock/update', '{\"id\":2,\"goodsId\":4,\"price\":40.00,\"amount\":60.00,\"cordon\":60};', '0:0:0:0:0:0:0:1', '2019-01-09 14:21:31');
INSERT INTO `tb_log` VALUES (852, 'admin', '更新库存信息', '/stock/update', '{\"id\":2,\"goodsId\":4,\"price\":40.00,\"amount\":60.00,\"cordon\":80};', '0:0:0:0:0:0:0:1', '2019-01-09 14:24:27');
INSERT INTO `tb_log` VALUES (853, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":0,\"title\":\"销售额排行\",\"icon\":\"\",\"href\":\"saleOrder/statistics\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-10 18:02:37');
INSERT INTO `tb_log` VALUES (854, 'admin', '删除菜单信息', '/sys/delMenuById/78', '78;', '0:0:0:0:0:0:0:1', '2019-01-10 18:02:51');
INSERT INTO `tb_log` VALUES (855, 'admin', '维护菜单信息', '/sys/menuForm', '{\"menuId\":70,\"title\":\"销售额排行\",\"icon\":\"\",\"href\":\"saleOrder/statistics\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";', '0:0:0:0:0:0:0:1', '2019-01-10 18:03:11');
INSERT INTO `tb_log` VALUES (856, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":61,\"roleName\":\"管理员\",\"roleRemark\":\"普通管理员\"};\"1,9,10,33,11,34,35,36,37,14,15,42,43,44,45,57,58,61,62,63,64,59,60,65,66,67,68,69,71,72,70,73,74,75,79\";', '0:0:0:0:0:0:0:1', '2019-01-10 18:04:14');
INSERT INTO `tb_log` VALUES (857, 'admin', '更新角色信息', '/sys/updRole', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,61,62,63,64,59,60,65,66,67,68,77,69,71,72,70,73,74,75,79\";', '0:0:0:0:0:0:0:1', '2019-01-10 18:04:23');
INSERT INTO `tb_log` VALUES (858, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:29:04');
INSERT INTO `tb_log` VALUES (859, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:29:14');
INSERT INTO `tb_log` VALUES (860, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:29:22');
INSERT INTO `tb_log` VALUES (861, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:30:17');
INSERT INTO `tb_log` VALUES (862, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:34:27');
INSERT INTO `tb_log` VALUES (863, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:39:31');
INSERT INTO `tb_log` VALUES (864, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:40:43');
INSERT INTO `tb_log` VALUES (865, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:46:19');
INSERT INTO `tb_log` VALUES (866, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:49:42');
INSERT INTO `tb_log` VALUES (867, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:50:23');
INSERT INTO `tb_log` VALUES (868, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:50:49');
INSERT INTO `tb_log` VALUES (869, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:53:35');
INSERT INTO `tb_log` VALUES (870, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:58:38');
INSERT INTO `tb_log` VALUES (871, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '', '0:0:0:0:0:0:0:1', '2019-01-10 18:59:35');
INSERT INTO `tb_log` VALUES (872, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '2;', '0:0:0:0:0:0:0:1', '2019-01-10 19:15:24');
INSERT INTO `tb_log` VALUES (873, 'admin', '销售查询统计接口', '/saleOrder/queryStatistics', '1;', '0:0:0:0:0:0:0:1', '2019-01-10 19:15:24');

-- ----------------------------
-- Table structure for tb_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_menus`;
CREATE TABLE `tb_menus`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名',
  `icon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `href` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源地址',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `spread` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'true：展开，false：不展开',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  `sorting` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_menus
-- ----------------------------
INSERT INTO `tb_menus` VALUES (1, '后台首页', '', 'page/main.html', '', 'false', 0, 9999);
INSERT INTO `tb_menus` VALUES (2, '系统管理', '', '', '', 'false', 0, 998);
INSERT INTO `tb_menus` VALUES (3, '角色管理', '&#xe613;', 'sys/roleList', NULL, 'false', 2, NULL);
INSERT INTO `tb_menus` VALUES (4, '管理员列表', '&#xe613;', 'sys/adminList', NULL, 'false', 2, NULL);
INSERT INTO `tb_menus` VALUES (9, '用户管理', '&#xe61d;', NULL, NULL, 'false', 0, 997);
INSERT INTO `tb_menus` VALUES (10, '添加用户', '&#xe608;', 'user/addUser', NULL, 'false', 9, NULL);
INSERT INTO `tb_menus` VALUES (11, '管理用户', '&#xe60e;', 'user/userList', NULL, 'false', 9, NULL);
INSERT INTO `tb_menus` VALUES (14, '系统日志', '&#xe61d;', NULL, NULL, 'false', 0, 995);
INSERT INTO `tb_menus` VALUES (15, '日志管理', '&#xe642;', 'log/logList', NULL, 'false', 14, NULL);
INSERT INTO `tb_menus` VALUES (16, '查看', '', '', 'sys:role:list', 'false', 3, NULL);
INSERT INTO `tb_menus` VALUES (17, '新增', NULL, NULL, 'sys:role:save', 'false', 3, NULL);
INSERT INTO `tb_menus` VALUES (18, '修改', NULL, NULL, 'sys:role:update', 'false', 3, NULL);
INSERT INTO `tb_menus` VALUES (19, '删除', NULL, NULL, 'sys:role:delete', 'false', 3, NULL);
INSERT INTO `tb_menus` VALUES (20, '查看', NULL, NULL, 'sys:admin:list', 'false', 4, NULL);
INSERT INTO `tb_menus` VALUES (21, '新增', NULL, NULL, 'sys:admin:save', 'false', 4, NULL);
INSERT INTO `tb_menus` VALUES (22, '修改', NULL, NULL, 'sys:admin:update', 'false', 4, NULL);
INSERT INTO `tb_menus` VALUES (23, '删除', NULL, NULL, 'sys:admin:delete', 'false', 4, NULL);
INSERT INTO `tb_menus` VALUES (33, '新增', NULL, NULL, 'user:user:save', 'false', 10, NULL);
INSERT INTO `tb_menus` VALUES (34, '查看', NULL, NULL, 'user:user:list', 'false', 11, NULL);
INSERT INTO `tb_menus` VALUES (35, '新增', NULL, NULL, 'user:user:save', 'false', 11, NULL);
INSERT INTO `tb_menus` VALUES (36, '修改', NULL, NULL, 'user:user:update', 'false', 11, NULL);
INSERT INTO `tb_menus` VALUES (37, '删除', NULL, NULL, 'user:user:delete', 'false', 11, NULL);
INSERT INTO `tb_menus` VALUES (42, '查看', '', '', 'log:log:list', 'false', 15, NULL);
INSERT INTO `tb_menus` VALUES (43, 'SQL监控', '&#xe642;', NULL, NULL, 'false', 0, 996);
INSERT INTO `tb_menus` VALUES (44, 'SQL监控', '&#xe642;', 'sys/druid', NULL, 'false', 43, NULL);
INSERT INTO `tb_menus` VALUES (45, '查看', NULL, NULL, 'sys:druid:list', 'false', 44, NULL);
INSERT INTO `tb_menus` VALUES (46, '菜单管理', '&#xe642;', 'sys/menuList', NULL, 'false', 2, NULL);
INSERT INTO `tb_menus` VALUES (47, '查看', NULL, NULL, 'sys:menu:list', 'false', 46, NULL);
INSERT INTO `tb_menus` VALUES (48, '新增', NULL, NULL, 'sys:menu:save', 'false', 46, NULL);
INSERT INTO `tb_menus` VALUES (49, '修改', NULL, NULL, 'sys:menu:update', 'false', 46, NULL);
INSERT INTO `tb_menus` VALUES (50, '删除', NULL, NULL, 'sys:menu:delete', 'false', 46, NULL);
INSERT INTO `tb_menus` VALUES (51, '轮播管理', '', '', '', 'false', 0, 997);
INSERT INTO `tb_menus` VALUES (52, '轮播管理', '', 'carousel/carouselList', '', 'false', 51, NULL);
INSERT INTO `tb_menus` VALUES (53, '查看', '', '', 'carousel:carousel:list', 'false', 52, NULL);
INSERT INTO `tb_menus` VALUES (54, '删除', '', '', 'carousel:carousel:delete', 'false', 52, NULL);
INSERT INTO `tb_menus` VALUES (55, '修改', '', '', 'carousel:carousel:update', 'false', 52, NULL);
INSERT INTO `tb_menus` VALUES (56, '新增', '', '', 'carousel:carousel:save', 'false', 52, NULL);
INSERT INTO `tb_menus` VALUES (57, '基础信息管理', '', '', '', 'false', 0, NULL);
INSERT INTO `tb_menus` VALUES (58, '商品信息', '', 'goods/goodsList', '', 'false', 57, NULL);
INSERT INTO `tb_menus` VALUES (59, '供应商信息', '', 'supplier/supplierList', '', 'false', 57, NULL);
INSERT INTO `tb_menus` VALUES (60, '客户信息', '', 'customer/customerList', '', 'false', 57, NULL);
INSERT INTO `tb_menus` VALUES (61, '查看', '', '', 'goods:goods:list', 'false', 58, NULL);
INSERT INTO `tb_menus` VALUES (62, '删除', '', '', 'goods:goods:delete', 'false', 58, NULL);
INSERT INTO `tb_menus` VALUES (63, '修改', '', '', 'goods:goods:update', 'false', 58, NULL);
INSERT INTO `tb_menus` VALUES (64, '新增', '', '', 'goods:goods:save', 'false', 58, NULL);
INSERT INTO `tb_menus` VALUES (65, '查看', '', '', 'customer:customer:list', 'false', 60, NULL);
INSERT INTO `tb_menus` VALUES (66, '删除', '', '', 'customer:customer:delete', 'false', 60, NULL);
INSERT INTO `tb_menus` VALUES (67, '修改', '', '', 'customer:customer:update', 'false', 60, NULL);
INSERT INTO `tb_menus` VALUES (68, '新增', '', '', 'customer:customer:save', 'false', 60, NULL);
INSERT INTO `tb_menus` VALUES (69, '进货管理', '', '', '', 'false', 0, NULL);
INSERT INTO `tb_menus` VALUES (70, '销售管理', '', '', '', 'false', 0, NULL);
INSERT INTO `tb_menus` VALUES (71, '采购单管理', '', 'purchaseOrder/purchaseOrderList', '', 'false', 69, NULL);
INSERT INTO `tb_menus` VALUES (72, '采购退货单', '', 'purchaseReturnOrder/purchaseReturnOrderList', '', 'false', 69, NULL);
INSERT INTO `tb_menus` VALUES (73, '销售单', '', 'saleOrder/saleOrderList', '', 'false', 70, NULL);
INSERT INTO `tb_menus` VALUES (74, '销售退货单', '', 'saleReturnOrder/saleReturnOrderList', '', 'false', 70, NULL);
INSERT INTO `tb_menus` VALUES (75, '库存管理', '', 'stock/stockList', '', 'false', 70, NULL);
INSERT INTO `tb_menus` VALUES (77, '商品类型管理', '', 'goodsType/goodsTypeList', '', 'false', 57, NULL);
INSERT INTO `tb_menus` VALUES (79, '销售额排行', '', 'saleOrder/statistics', '', 'false', 70, NULL);

-- ----------------------------
-- Table structure for tb_purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_order`;
CREATE TABLE `tb_purchase_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NULL DEFAULT NULL,
  `type` int(11) NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier` int(11) NULL DEFAULT NULL COMMENT '供应商的id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `batch_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批号',
  `approval_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准文号',
  `sticks` int(11) NULL DEFAULT NULL COMMENT '经手人的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_purchase_order
-- ----------------------------
INSERT INTO `tb_purchase_order` VALUES (7, 123, 1, 0.03, 30, 90.00, '中国', 3, 'test', 'test3', 'test3', 19);
INSERT INTO `tb_purchase_order` VALUES (8, 122, 4, 20.00, 90, 2700.00, '中国', 3, 'test', 'test3', 'test3', 1);

-- ----------------------------
-- Table structure for tb_purchase_return_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_return_order`;
CREATE TABLE `tb_purchase_return_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NULL DEFAULT NULL,
  `type` int(11) NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier` int(11) NULL DEFAULT NULL COMMENT '供应商的id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `batch_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批号',
  `approval_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准文号',
  `sticks` int(11) NULL DEFAULT NULL COMMENT '经手人的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_purchase_return_order
-- ----------------------------
INSERT INTO `tb_purchase_return_order` VALUES (1, 1, 1, 0.03, 90, NULL, '中国', 3, 'test', 'test1', 'test1', 1);
INSERT INTO `tb_purchase_return_order` VALUES (2, 1, 1, 0.03, 90, NULL, '中国', 3, 'test', 'test1', 'test1', 1);
INSERT INTO `tb_purchase_return_order` VALUES (3, 122, 4, 40.00, 30, NULL, 'china', 3, '退了30个', 'test3', 'test3', 1);

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES (1, '超级管理员', '超级管理员');
INSERT INTO `tb_roles` VALUES (61, '管理员', '普通管理员');

-- ----------------------------
-- Table structure for tb_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles_menus`;
CREATE TABLE `tb_roles_menus`  (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`, `role_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `tb_roles_menus_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menus` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_roles_menus_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_roles_menus
-- ----------------------------
INSERT INTO `tb_roles_menus` VALUES (1, 1);
INSERT INTO `tb_roles_menus` VALUES (2, 1);
INSERT INTO `tb_roles_menus` VALUES (3, 1);
INSERT INTO `tb_roles_menus` VALUES (4, 1);
INSERT INTO `tb_roles_menus` VALUES (9, 1);
INSERT INTO `tb_roles_menus` VALUES (10, 1);
INSERT INTO `tb_roles_menus` VALUES (11, 1);
INSERT INTO `tb_roles_menus` VALUES (14, 1);
INSERT INTO `tb_roles_menus` VALUES (15, 1);
INSERT INTO `tb_roles_menus` VALUES (16, 1);
INSERT INTO `tb_roles_menus` VALUES (17, 1);
INSERT INTO `tb_roles_menus` VALUES (18, 1);
INSERT INTO `tb_roles_menus` VALUES (19, 1);
INSERT INTO `tb_roles_menus` VALUES (20, 1);
INSERT INTO `tb_roles_menus` VALUES (21, 1);
INSERT INTO `tb_roles_menus` VALUES (22, 1);
INSERT INTO `tb_roles_menus` VALUES (23, 1);
INSERT INTO `tb_roles_menus` VALUES (33, 1);
INSERT INTO `tb_roles_menus` VALUES (34, 1);
INSERT INTO `tb_roles_menus` VALUES (35, 1);
INSERT INTO `tb_roles_menus` VALUES (36, 1);
INSERT INTO `tb_roles_menus` VALUES (37, 1);
INSERT INTO `tb_roles_menus` VALUES (42, 1);
INSERT INTO `tb_roles_menus` VALUES (43, 1);
INSERT INTO `tb_roles_menus` VALUES (44, 1);
INSERT INTO `tb_roles_menus` VALUES (45, 1);
INSERT INTO `tb_roles_menus` VALUES (46, 1);
INSERT INTO `tb_roles_menus` VALUES (47, 1);
INSERT INTO `tb_roles_menus` VALUES (48, 1);
INSERT INTO `tb_roles_menus` VALUES (49, 1);
INSERT INTO `tb_roles_menus` VALUES (50, 1);
INSERT INTO `tb_roles_menus` VALUES (51, 1);
INSERT INTO `tb_roles_menus` VALUES (52, 1);
INSERT INTO `tb_roles_menus` VALUES (53, 1);
INSERT INTO `tb_roles_menus` VALUES (54, 1);
INSERT INTO `tb_roles_menus` VALUES (55, 1);
INSERT INTO `tb_roles_menus` VALUES (56, 1);
INSERT INTO `tb_roles_menus` VALUES (57, 1);
INSERT INTO `tb_roles_menus` VALUES (58, 1);
INSERT INTO `tb_roles_menus` VALUES (59, 1);
INSERT INTO `tb_roles_menus` VALUES (60, 1);
INSERT INTO `tb_roles_menus` VALUES (61, 1);
INSERT INTO `tb_roles_menus` VALUES (62, 1);
INSERT INTO `tb_roles_menus` VALUES (63, 1);
INSERT INTO `tb_roles_menus` VALUES (64, 1);
INSERT INTO `tb_roles_menus` VALUES (65, 1);
INSERT INTO `tb_roles_menus` VALUES (66, 1);
INSERT INTO `tb_roles_menus` VALUES (67, 1);
INSERT INTO `tb_roles_menus` VALUES (68, 1);
INSERT INTO `tb_roles_menus` VALUES (69, 1);
INSERT INTO `tb_roles_menus` VALUES (70, 1);
INSERT INTO `tb_roles_menus` VALUES (71, 1);
INSERT INTO `tb_roles_menus` VALUES (72, 1);
INSERT INTO `tb_roles_menus` VALUES (73, 1);
INSERT INTO `tb_roles_menus` VALUES (74, 1);
INSERT INTO `tb_roles_menus` VALUES (75, 1);
INSERT INTO `tb_roles_menus` VALUES (77, 1);
INSERT INTO `tb_roles_menus` VALUES (79, 1);
INSERT INTO `tb_roles_menus` VALUES (1, 61);
INSERT INTO `tb_roles_menus` VALUES (9, 61);
INSERT INTO `tb_roles_menus` VALUES (10, 61);
INSERT INTO `tb_roles_menus` VALUES (11, 61);
INSERT INTO `tb_roles_menus` VALUES (14, 61);
INSERT INTO `tb_roles_menus` VALUES (15, 61);
INSERT INTO `tb_roles_menus` VALUES (33, 61);
INSERT INTO `tb_roles_menus` VALUES (34, 61);
INSERT INTO `tb_roles_menus` VALUES (35, 61);
INSERT INTO `tb_roles_menus` VALUES (36, 61);
INSERT INTO `tb_roles_menus` VALUES (37, 61);
INSERT INTO `tb_roles_menus` VALUES (42, 61);
INSERT INTO `tb_roles_menus` VALUES (43, 61);
INSERT INTO `tb_roles_menus` VALUES (44, 61);
INSERT INTO `tb_roles_menus` VALUES (45, 61);
INSERT INTO `tb_roles_menus` VALUES (57, 61);
INSERT INTO `tb_roles_menus` VALUES (58, 61);
INSERT INTO `tb_roles_menus` VALUES (59, 61);
INSERT INTO `tb_roles_menus` VALUES (60, 61);
INSERT INTO `tb_roles_menus` VALUES (61, 61);
INSERT INTO `tb_roles_menus` VALUES (62, 61);
INSERT INTO `tb_roles_menus` VALUES (63, 61);
INSERT INTO `tb_roles_menus` VALUES (64, 61);
INSERT INTO `tb_roles_menus` VALUES (65, 61);
INSERT INTO `tb_roles_menus` VALUES (66, 61);
INSERT INTO `tb_roles_menus` VALUES (67, 61);
INSERT INTO `tb_roles_menus` VALUES (68, 61);
INSERT INTO `tb_roles_menus` VALUES (69, 61);
INSERT INTO `tb_roles_menus` VALUES (70, 61);
INSERT INTO `tb_roles_menus` VALUES (71, 61);
INSERT INTO `tb_roles_menus` VALUES (72, 61);
INSERT INTO `tb_roles_menus` VALUES (73, 61);
INSERT INTO `tb_roles_menus` VALUES (74, 61);
INSERT INTO `tb_roles_menus` VALUES (75, 61);
INSERT INTO `tb_roles_menus` VALUES (79, 61);

-- ----------------------------
-- Table structure for tb_sale_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_sale_order`;
CREATE TABLE `tb_sale_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier_id` int(11) NULL DEFAULT NULL COMMENT '供应商id',
  `sticks` int(11) NULL DEFAULT NULL COMMENT '经手员工id',
  `batch_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `approval_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准文号',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '购买客户的id',
  `amount` int(11) NULL DEFAULT NULL COMMENT '购买的数量',
  `sale_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售价格',
  `real_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_sale_order
-- ----------------------------
INSERT INTO `tb_sale_order` VALUES (1, 1, 1, '中国', 3, 1, 'test3', 'test3', 1, 90, 30.00, 60.00);
INSERT INTO `tb_sale_order` VALUES (3, 123, 1, 'china', 3, 1, 'test3', 'test2', 1, 30, 30.00, 60.00);

-- ----------------------------
-- Table structure for tb_sale_return_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_sale_return_order`;
CREATE TABLE `tb_sale_return_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplier_id` int(11) NULL DEFAULT NULL COMMENT '供应商id',
  `sticks` int(11) NULL DEFAULT NULL COMMENT '经手员工id',
  `batch_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `approval_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准文号',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '购买客户的id',
  `amount` int(11) NULL DEFAULT NULL COMMENT '购买的数量',
  `sale_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_search
-- ----------------------------
DROP TABLE IF EXISTS `tb_search`;
CREATE TABLE `tb_search`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_amount` decimal(10, 2) NOT NULL,
  `sale_money` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock`;
CREATE TABLE `tb_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL COMMENT '货物的id',
  `price` decimal(10, 2) NOT NULL COMMENT '商品的价格',
  `amount` decimal(10, 2) NOT NULL COMMENT '商品的数量',
  `cordon` decimal(10, 2) UNSIGNED NULL DEFAULT 0.00 COMMENT '库存的警戒线',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `goodsid`(`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_stock
-- ----------------------------
INSERT INTO `tb_stock` VALUES (1, 3, 15.00, 1.00, 0.00);
INSERT INTO `tb_stock` VALUES (2, 4, 40.00, 60.00, 80.00);

-- ----------------------------
-- Table structure for tb_supplier
-- ----------------------------
DROP TABLE IF EXISTS `tb_supplier`;
CREATE TABLE `tb_supplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_supplier
-- ----------------------------
INSERT INTO `tb_supplier` VALUES (3, '供应商test1', '深刻的法律考试的风景', '23623', '18066117806', 'test1', '18066117806', '240250@qq.com', '中国银行', '240252729@qq.com');
INSERT INTO `tb_supplier` VALUES (4, '供应商test2', '双方都卡了水电费', '23623', '18066117806', 'test1', '18066117806', '240250@qq.com', '中国银行', 'test1');

-- ----------------------------
-- Table structure for tb_test
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users`  (
  `uid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称：唯一',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0:女，1:男，2：保密',
  `birthday` date NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:未激活，1，正常，2，禁用',
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES (27, 'isduxd@qq.com', 'test', '96e79218965eb72c92a549dd5a330112', '0', '2018-03-25', '北京通州科创十四街区', '17693109923', 'b3f28566dac54f86bd4f4c2ce36e23d8019', '1', '2018-03-25 14:48:48');
INSERT INTO `tb_users` VALUES (28, '123@qq.com', '2113', '96e79218965eb72c92a549dd5a330112', '1', '2018-07-26', '123123', '17693109997', 'c6411671821c43ca926c032e51ded16a897', '1', '2018-07-27 09:59:16');
INSERT INTO `tb_users` VALUES (29, 'sdf@163.com', '123123', '96e79218965eb72c92a549dd5a330112', '2', '2018-07-27', '123123', '17111111111', '92197e8f8a5647ae8be96fe2db555575147', '1', '2018-07-27 14:23:55');
INSERT INTO `tb_users` VALUES (30, '240252729@qq.com', 'test4', '0e7b3b8e27087ad2566ac12ea55d1074', '1', '2019-01-05', '深刻的法律考试的风景', '18066117806', 'a89467c8770a4705b2b6cdea4b9c5fbb931', '1', '2019-01-05 17:29:58');

SET FOREIGN_KEY_CHECKS = 1;

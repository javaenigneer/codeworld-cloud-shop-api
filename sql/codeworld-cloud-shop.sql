/*
 Navicat MySQL Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : codeworld-cloud-shop

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 22/01/2021 16:28:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for codeworld_attribute
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_attribute`;
CREATE TABLE `codeworld_attribute`  (
  `t_attribute_id` bigint(20) NOT NULL COMMENT '属性主键Id',
  `t_attribute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `t_category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_attribute_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_attribute
-- ----------------------------
INSERT INTO `codeworld_attribute` VALUES (225185, '主体', 500117, '2020-12-18 10:31:03', '2020-12-18 10:31:03');
INSERT INTO `codeworld_attribute` VALUES (513162, '基本信息', 500117, '2020-12-18 10:31:03', '2020-12-18 10:31:03');
INSERT INTO `codeworld_attribute` VALUES (709554, '基本信息', 500117, '2020-12-18 10:30:57', '2020-12-18 10:30:57');

-- ----------------------------
-- Table structure for codeworld_carouse
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_carouse`;
CREATE TABLE `codeworld_carouse`  (
  `t_carouse_id` bigint(20) NOT NULL COMMENT '轮播图Id',
  `t_carouse_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图标题',
  `t_carouse_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图图片',
  `t_carouse_status` int(1) NULL DEFAULT NULL COMMENT '轮播图状态 1--启用 0--未启用',
  `t_carouse_start_time` datetime(0) NULL DEFAULT NULL COMMENT '轮播图开始时间',
  `t_carouse_end_time` datetime(0) NULL DEFAULT NULL COMMENT '轮播图结束时间',
  `t_carouse_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`t_carouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_carouse
-- ----------------------------

-- ----------------------------
-- Table structure for codeworld_cart
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_cart`;
CREATE TABLE `codeworld_cart`  (
  `t_cart_id` bigint(20) NOT NULL COMMENT '购物车主键id',
  `t_cart_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `t_cart_product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `t_cart_product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Skuid',
  `t_cart_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_cart_product_price` int(10) NULL DEFAULT NULL COMMENT '商品价格',
  `t_cart_product_count` int(10) NULL DEFAULT NULL COMMENT '商品数量',
  `t_cart_product_status` int(1) NULL DEFAULT NULL COMMENT '购物车中商品的状态 1--未删除 0--删除',
  `t_cart_product_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `t_cart_product_sku` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品Sku',
  `t_cart_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户编号',
  `t_cart_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_cart_status` int(1) NULL DEFAULT 1 COMMENT '0--删除 1--未删除',
  PRIMARY KEY (`t_cart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_cart
-- ----------------------------
INSERT INTO `codeworld_cart` VALUES (181936, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-01-07 17:18:49', 0);
INSERT INTO `codeworld_cart` VALUES (225098, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', NULL, '2020-12-27 15:55:54', 1);
INSERT INTO `codeworld_cart` VALUES (228646, 838395, 897175, 189609, '小米MIX2 绿色 20G', 9999, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\",\"price\":9999,\"id\":189609,\"title\":\"小米MIX2 绿色 20G\"}', NULL, '2020-12-28 10:39:36', 0);
INSERT INTO `codeworld_cart` VALUES (229182, 838395, 897175, 756668, '小米MIX2 绿色 20G', 99, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg\",\"price\":99,\"id\":756668,\"title\":\"小米MIX2 红色 20G\"}', NULL, '2020-12-27 16:22:59', 0);
INSERT INTO `codeworld_cart` VALUES (257928, 838395, 711211, 129735, 'VivoX100 红色 1000G', 1, 1, 1, NULL, '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\",\"price\":1,\"id\":129735,\"title\":\"VivoX100 红色 1000G\"}', '21181611095746339', '2021-01-07 17:36:45', 1);
INSERT INTO `codeworld_cart` VALUES (629957, 838395, 668339, 185457, 'Iphone20 绿色 1000G', 3, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/58571609919598472.jpg\",\"price\":3,\"id\":185457,\"title\":\"Iphone20 绿色 1000G\"}', '21181608848696318', '2021-01-06 17:03:00', 0);
INSERT INTO `codeworld_cart` VALUES (719696, 838395, 897175, 756668, '小米MIX2 绿色 20G', 99, 1, 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '{\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg\",\"price\":99,\"id\":756668,\"title\":\"小米MIX2 红色 20G\"}', NULL, '2020-12-27 15:54:34', 1);

-- ----------------------------
-- Table structure for codeworld_category
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_category`;
CREATE TABLE `codeworld_category`  (
  `t_category_id` bigint(20) NOT NULL COMMENT '分类主键Id',
  `t_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `t_category_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级Id',
  `t_category_sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `t_category_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类类型',
  `t_category_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图片',
  `t_category_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_category_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_category
-- ----------------------------
INSERT INTO `codeworld_category` VALUES (45623, '礼品鲜花', 0, 1, 'menu', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/23201608200053876.jpg', '2020-12-17 18:14:23', '2020-12-17 18:14:23');
INSERT INTO `codeworld_category` VALUES (279618, '礼品', 45623, 1, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/25161608200181837.jpg', '2020-12-17 18:16:28', '2021-01-20 15:29:27');
INSERT INTO `codeworld_category` VALUES (500117, '运营商', 863188, 2, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/42261608199892187.jpg', '2020-12-17 18:11:44', '2021-01-20 15:31:06');
INSERT INTO `codeworld_category` VALUES (843201, '手机通信', 863188, 1, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/28481608199773295.jpg', '2020-12-17 18:09:40', '2021-01-20 15:31:02');
INSERT INTO `codeworld_category` VALUES (863188, '手机数码', 0, 1, 'menu', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/81721608199750719.jpg', '2020-12-17 18:09:17', '2020-12-17 18:09:17');
INSERT INTO `codeworld_category` VALUES (944899, '鲜花', 45623, 2, 'button', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/17/48561608200240683.jpg', '2020-12-17 18:17:27', '2021-01-20 15:29:53');

-- ----------------------------
-- Table structure for codeworld_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_category_attribute`;
CREATE TABLE `codeworld_category_attribute`  (
  `t_category_attribute_id` bigint(20) NOT NULL COMMENT '分类属性主键id',
  `t_category_id` bigint(20) NULL DEFAULT NULL COMMENT '分类id',
  `t_attribute_id` bigint(20) NULL DEFAULT NULL COMMENT '属性id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_category_attribute_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_category_attribute
-- ----------------------------
INSERT INTO `codeworld_category_attribute` VALUES (128070, 500117, 709554, '2020-12-18 10:30:57', '2020-12-18 10:30:57');
INSERT INTO `codeworld_category_attribute` VALUES (232737, 500117, 513162, '2020-12-18 10:31:03', '2020-12-18 10:31:03');
INSERT INTO `codeworld_category_attribute` VALUES (368983, 500117, 225185, '2020-12-18 10:31:03', '2020-12-18 10:31:03');

-- ----------------------------
-- Table structure for codeworld_dept
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_dept`;
CREATE TABLE `codeworld_dept`  (
  `t_dept_id` bigint(20) NOT NULL COMMENT '部门主键Id',
  `t_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '部门上级Id',
  `t_dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `t_dept_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `t_dept_remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '部门简介',
  `t_dept_sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_dept
-- ----------------------------
INSERT INTO `codeworld_dept` VALUES (1, 0, '系统部', 'menu', '系统部门', 1, '2020-10-13 14:34:00', '2020-11-06 11:47:44');
INSERT INTO `codeworld_dept` VALUES (2, 1, '人事部', 'button', '人事部门', 2, '2020-10-13 14:34:34', '2020-11-06 11:48:47');
INSERT INTO `codeworld_dept` VALUES (34763, 603358, 'Java开发部', NULL, 'Java开发', 1, '2020-11-06 11:49:24', '2020-11-06 11:49:24');
INSERT INTO `codeworld_dept` VALUES (295974, 2, '333', NULL, '333', 1, '2020-10-13 16:45:00', '2020-10-13 16:45:00');
INSERT INTO `codeworld_dept` VALUES (603358, 1, '开发部', NULL, '开发部门', 1, '2020-11-06 11:49:11', '2020-11-06 11:49:11');
INSERT INTO `codeworld_dept` VALUES (731841, 1, '222', NULL, '222', 2, '2020-10-13 16:44:29', '2020-10-13 16:44:29');
INSERT INTO `codeworld_dept` VALUES (999440, 1, '人员管理', NULL, '管理基本人员', 1, '2020-10-13 16:40:37', '2020-11-06 11:48:13');

-- ----------------------------
-- Table structure for codeworld_member
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_member`;
CREATE TABLE `codeworld_member`  (
  `t_member_id` bigint(20) NOT NULL COMMENT '会员主键Id',
  `t_member_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员名',
  `t_member_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员密码',
  `t_member_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员手机号码',
  `t_member_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_member_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_member
-- ----------------------------
INSERT INTO `codeworld_member` VALUES (838395, 'CodeWorld', '123456', '15281223316', '2020-12-22 14:33:06', '2020-12-22 14:33:06');

-- ----------------------------
-- Table structure for codeworld_member_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_member_detail`;
CREATE TABLE `codeworld_member_detail`  (
  `t_member_id` bigint(20) NOT NULL COMMENT '会员id',
  `t_member_avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员头像',
  `t_member_sex` int(1) NULL DEFAULT NULL COMMENT '会员性别 1--男 0--女',
  `t_member_create_time` datetime(0) NULL DEFAULT NULL,
  `t_member_update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`t_member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_member_detail
-- ----------------------------
INSERT INTO `codeworld_member_detail` VALUES (838395, 'https://codewrold-community-1300450814.cos.ap-chengdu.myqcloud.com/2020/11/19/64741605768753169.jpg', 1, '2020-12-25 14:51:08', '2020-12-25 14:51:11');

-- ----------------------------
-- Table structure for codeworld_member_receiver_address
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_member_receiver_address`;
CREATE TABLE `codeworld_member_receiver_address`  (
  `t_address_id` bigint(20) NOT NULL COMMENT '地址主键Id',
  `t_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `t_receiver_name` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `t_receiver_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `t_address_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人区域',
  `t_address_detailed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `t_receiver_house_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人门牌号',
  `t_address_status` int(1) NULL DEFAULT NULL COMMENT '收货地址状态 1--默认 0--其他',
  `t_address_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_address_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_address_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_member_receiver_address
-- ----------------------------
INSERT INTO `codeworld_member_receiver_address` VALUES (1000, 838395, '飞飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 1, '2020-12-23 17:59:20', '2020-12-28 17:37:39');
INSERT INTO `codeworld_member_receiver_address` VALUES (1002, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-24 10:10:13', '2020-12-25 11:30:13');
INSERT INTO `codeworld_member_receiver_address` VALUES (146427, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-25 10:58:14', '2020-12-25 11:30:13');
INSERT INTO `codeworld_member_receiver_address` VALUES (566156, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-25 10:58:15', '2020-12-25 11:30:13');
INSERT INTO `codeworld_member_receiver_address` VALUES (996640, 838395, '王若飞', '15281223316', '四川省-眉山市-仁寿县', '龙马镇', '五组', 0, '2020-12-25 11:03:47', '2020-12-25 11:30:13');

-- ----------------------------
-- Table structure for codeworld_menu
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_menu`;
CREATE TABLE `codeworld_menu`  (
  `t_menu_id` bigint(20) NOT NULL COMMENT '菜单主键Id',
  `t_parent_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单上级Id',
  `t_menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `t_menu_resources` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `t_menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `t_menu_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `t_menu_remarks` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '菜单简介',
  `t_menu_sort_no` int(10) NULL DEFAULT NULL COMMENT '排序',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_menu
-- ----------------------------
INSERT INTO `codeworld_menu` VALUES (1000, 0, '/system-mamage', 'systemManage', '系统管理', 'menu', '系统管理', 1, '2020-09-18 17:05:59', '2020-09-18 17:06:01');
INSERT INTO `codeworld_menu` VALUES (1001, 1000, '/system-role', 'role', '角色管理', 'menu', '角色管理', 1, '2020-09-18 17:46:46', '2020-09-18 17:46:48');
INSERT INTO `codeworld_menu` VALUES (1002, 1000, '/system-menu', 'menu', '菜单管理', 'menu', '菜单管理', 1, '2020-09-18 17:48:41', '2020-09-18 17:48:43');
INSERT INTO `codeworld_menu` VALUES (1003, 1002, '/system-menu/add-menu', 'menu:add', '添加菜单', 'button', '添加菜单', 1, '2020-09-18 17:50:09', '2020-09-18 17:50:11');
INSERT INTO `codeworld_menu` VALUES (85834, 431133, '/system-user/delete-user', 'user:delete', '删除用户', 'button', '删除一个用户', 5, '2020-09-20 10:33:56', '2020-09-20 10:33:56');
INSERT INTO `codeworld_menu` VALUES (142731, 911538, '/codeworld-order/get-order-info-id', 'order:view', '查看订单', 'button', '查看订单', 2, '2021-01-08 17:05:08', '2021-01-08 17:05:08');
INSERT INTO `codeworld_menu` VALUES (183517, 934228, '/codeworld-marketing/get-page-index-carouse', 'index-carouse', '首页轮播图', 'menu', '首页轮播图', 1, '2021-01-13 14:25:45', '2021-01-13 15:43:12');
INSERT INTO `codeworld_menu` VALUES (192975, 0, '/system-goods', 'systemGoods', '商品管理', 'menu', '商品管理', 1, '2020-11-27 17:09:00', '2020-11-27 17:09:00');
INSERT INTO `codeworld_menu` VALUES (248235, 718023, '/codeworld-goods/category/update-category', 'category:update', '修改分类', 'button', '修改分类', 2, '2020-11-28 22:06:38', '2020-11-28 22:07:06');
INSERT INTO `codeworld_menu` VALUES (373292, 911538, '/codeworld-order/get-page-order', 'order:get', '订单列表', 'button', '订单列表', 1, '2021-01-08 16:01:42', '2021-01-08 16:01:42');
INSERT INTO `codeworld_menu` VALUES (399716, 431133, '/system-user/enable-user', 'user:enable', '启用用户', 'button', '启用用户', 2, '2020-09-19 14:39:10', '2020-09-19 14:39:10');
INSERT INTO `codeworld_menu` VALUES (414011, 1002, '/system-menu/delete-menu', 'menu:delete', '删除菜单', 'button', '删除菜单', 2, '2020-09-21 15:44:09', '2020-09-21 15:44:09');
INSERT INTO `codeworld_menu` VALUES (422057, 192975, '/codeworld-goods/product', 'product', '商品信息', 'menu', '商品信息', 1, '2020-11-28 22:14:12', '2020-11-28 22:14:12');
INSERT INTO `codeworld_menu` VALUES (431133, 1000, '/system-user', 'user', '用户管理', 'menu', '用户管理', 1, '2020-09-19 14:36:18', '2020-09-19 14:36:18');
INSERT INTO `codeworld_menu` VALUES (453077, 422057, '/codeworld-system/product/update-product-status', 'product:onSale', '上架商品', 'button', '上架商品信息', 1, '2021-01-06 09:28:22', '2021-01-06 09:28:22');
INSERT INTO `codeworld_menu` VALUES (482527, 422057, '/codeworld-goods/product/add-product', 'product:add', '添加商品', 'button', '添加商品', 1, '2020-11-28 22:15:20', '2020-11-28 22:15:20');
INSERT INTO `codeworld_menu` VALUES (483295, 103177, '/system-job/add-delete', 'job:delete', '添加任务', 'button', '添加任务', 1, '2020-09-22 17:07:14', '2020-09-22 17:07:14');
INSERT INTO `codeworld_menu` VALUES (506283, 1000, '/system-dept', 'dept', '部门管理', 'menu', '部门管理', 1, '2020-10-13 10:20:45', '2020-10-13 10:21:22');
INSERT INTO `codeworld_menu` VALUES (523925, 718023, '/codeworld-goods/category/add-category', 'category:add', '添加分类', 'button', '添加分类', 1, '2020-11-28 21:44:13', '2020-11-28 21:44:13');
INSERT INTO `codeworld_menu` VALUES (639590, 1001, '/system-user/delete-user', 'role:delete', '删除角色', 'button', '删除角色', 3, '2020-09-19 15:21:10', '2020-09-19 15:21:10');
INSERT INTO `codeworld_menu` VALUES (652737, 192975, '/codeworld-goods/category-attribute', 'category-attribute', '分类属性', 'menu', '分类属性', 1, '2020-12-03 14:40:00', '2020-12-03 14:40:00');
INSERT INTO `codeworld_menu` VALUES (652906, 422057, '/codeworld-system/product/update-product-status ', 'product:offSale', '下架商品', 'button', '下架商品信息', 2, '2021-01-06 09:29:07', '2021-01-06 09:29:07');
INSERT INTO `codeworld_menu` VALUES (712174, 911538, '/codeworld-order/order-delivery', 'order:delivery', '订单发货', 'button', '订单发货', 4, '2021-01-10 12:31:52', '2021-01-10 12:31:52');
INSERT INTO `codeworld_menu` VALUES (718023, 192975, '/codeworld-goods/category', 'category', '分类管理', 'menu', '分类管理', 1, '2020-11-28 21:37:45', '2020-11-28 21:37:45');
INSERT INTO `codeworld_menu` VALUES (731821, 177739, '/system-login-log/delete-login-log', 'login-log:delete', '删除登录日志', 'button', '删除登录日志', 1, '2020-10-10 15:34:23', '2020-10-10 15:34:23');
INSERT INTO `codeworld_menu` VALUES (751273, 183517, '/codeworld-marketing/carouse/add-carouse', 'carouse:add', '添加轮播图', 'button', '添加轮播图', 1, '2021-01-13 15:41:25', '2021-01-13 15:41:25');
INSERT INTO `codeworld_menu` VALUES (759155, 1000, '/systemManage-chat', 'chat', '聊天室', 'menu', '聊天室', 1, '2020-09-25 11:04:05', '2020-09-25 11:04:05');
INSERT INTO `codeworld_menu` VALUES (767865, 1001, '/system-role/update-role', 'role:edit', '编辑角色', 'button', '编辑角色', 2, '2020-09-18 17:53:37', '2020-09-18 17:53:37');
INSERT INTO `codeworld_menu` VALUES (789006, 431133, '/system-user/update-user', 'user:edit', '编辑用户', 'button', '编辑用户', 4, '2020-09-19 22:22:35', '2020-09-19 22:22:35');
INSERT INTO `codeworld_menu` VALUES (806101, 911538, '/codeworld-order/delete-order', 'order:delete', '删除订单', 'button', '删除订单', 1, '2021-01-08 17:07:55', '2021-01-08 17:07:55');
INSERT INTO `codeworld_menu` VALUES (854257, 1001, '/system-role/add-role', 'role:add', '添加角色', 'button', '添加角色', 1, '2020-09-18 17:51:28', '2020-09-18 17:51:28');
INSERT INTO `codeworld_menu` VALUES (887057, 431133, '/system-user/add-user', 'user:add', '添加用户', 'button', '添加用户', 1, '2020-09-19 14:36:56', '2020-09-19 14:36:56');
INSERT INTO `codeworld_menu` VALUES (906682, 0, '/system-metchant', 'systemMerchant', '商户管理', 'menu', '商户管理', 1, '2021-01-04 15:37:34', '2021-01-04 15:37:34');
INSERT INTO `codeworld_menu` VALUES (911538, 0, '/codeworld-order', 'systemOrder', '订单管理', 'menu', '订单管理', 1, '2021-01-08 16:00:59', '2021-01-08 16:00:59');
INSERT INTO `codeworld_menu` VALUES (926053, 301087, '/system-monitor/offline-user-id', 'active:offline', '剔除用户', 'button', '将用户剔除下线', 1, '2020-10-20 11:38:20', '2020-10-20 11:38:20');
INSERT INTO `codeworld_menu` VALUES (934228, 0, '/codeworld-marketing', 'systemMarketing', '营销管理', 'menu', '营销管理', 1, '2021-01-13 14:22:48', '2021-01-13 14:27:28');
INSERT INTO `codeworld_menu` VALUES (940513, 906682, '/codeworld-merchant/get-page-merchant', 'merchant:view', '商户列表', 'button', '商户列表', 1, '2021-01-13 14:21:28', '2021-01-13 14:21:28');
INSERT INTO `codeworld_menu` VALUES (948807, 1002, '/system-menu/update-menu', 'menu:edit', '编辑菜单', 'button', '编辑菜单', 3, '2020-09-21 15:44:43', '2020-09-21 15:44:43');
INSERT INTO `codeworld_menu` VALUES (982791, 1001, '/system-role/set-role', 'roleSetting', '权限设置', 'button', '权限设置', 3, '2020-09-18 17:54:37', '2020-09-18 17:54:37');

-- ----------------------------
-- Table structure for codeworld_merchant
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_merchant`;
CREATE TABLE `codeworld_merchant`  (
  `t_merchant_id` bigint(20) NOT NULL COMMENT '商户id',
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  `t_merchant_nick_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户昵称',
  `t_merchant_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户手机',
  `t_merchant_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户登录密码',
  `t_merchant_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`t_merchant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_merchant
-- ----------------------------
INSERT INTO `codeworld_merchant` VALUES (1608851327, '21181611095746339', 'codeworld', '15281223317', '123456', '2021-01-07 17:04:35');
INSERT INTO `codeworld_merchant` VALUES (1609046703, '21181608848696318', 'code', '15281223316', '123456', '2021-01-05 16:42:14');

-- ----------------------------
-- Table structure for codeworld_merchant_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_merchant_detail`;
CREATE TABLE `codeworld_merchant_detail`  (
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户号',
  `t_merchant_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名称',
  `t_merchant_id_card_front` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证正面',
  `t_merchant_id_card_back` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证反面',
  `t_merchant_license` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照',
  `t_merchant_type` int(1) NULL DEFAULT NULL COMMENT '入驻类型 1--包月 2--包季 3--包年',
  `t_merchant_status` int(1) NULL DEFAULT NULL COMMENT '状态 1--已审核，且审核，2--未审核 0--审核失败 3--未入驻',
  `t_merchant_set_create_time` datetime(0) NULL DEFAULT NULL COMMENT '入驻时间',
  PRIMARY KEY (`t_merchant_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_merchant_detail
-- ----------------------------
INSERT INTO `codeworld_merchant_detail` VALUES ('21181608848696318', '测试商户入驻', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 1, 1, '2021-01-05 16:58:15');
INSERT INTO `codeworld_merchant_detail` VALUES ('21181611095746339', '测试商户入驻2', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/04/41881609743943658.jpg', 1, 1, '2021-01-07 17:05:19');

-- ----------------------------
-- Table structure for codeworld_order
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order`;
CREATE TABLE `codeworld_order`  (
  `t_order_id` bigint(20) NOT NULL COMMENT '订单主键Id',
  `t_order_total_pay` bigint(20) NULL DEFAULT NULL COMMENT '订单总金额',
  `t_order_actual_pay` bigint(20) NULL DEFAULT NULL COMMENT '实付金额',
  `t_order_pay_type` int(1) NULL DEFAULT NULL COMMENT '支付类型 1--在线支付 2--货到付款',
  `t_order_post_fee` bigint(20) NULL DEFAULT NULL COMMENT '邮费',
  `t_order_member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `t_order_address_id` bigint(20) NULL DEFAULT NULL COMMENT '地址Id',
  `t_order_buyer_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家备注信息',
  `t_order_buyer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家会员名',
  `t_order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  PRIMARY KEY (`t_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order
-- ----------------------------
INSERT INTO `codeworld_order` VALUES (21048671759173696, 4, 4, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-01-07 17:36:57');
INSERT INTO `codeworld_order` VALUES (21048732140963904, 10000, 10000, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-01-07 17:52:18');
INSERT INTO `codeworld_order` VALUES (21069524015122496, 99, 99, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-01-11 09:59:58');
INSERT INTO `codeworld_order` VALUES (21069544944699456, 1, 1, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-01-11 10:05:17');
INSERT INTO `codeworld_order` VALUES (21093808600385600, 10002, 10002, NULL, NULL, 838395, 1000, NULL, 'CodeWorld', '2021-01-15 16:55:51');

-- ----------------------------
-- Table structure for codeworld_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order_detail`;
CREATE TABLE `codeworld_order_detail`  (
  `t_order_detail_id` bigint(20) NOT NULL COMMENT '订单详情主键Id',
  `t_order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `t_product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Skuid',
  `t_product_count` int(10) NULL DEFAULT NULL COMMENT '商品购买数量',
  `t_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_sku_detail` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品Sku信息',
  `t_product_price` bigint(20) NULL DEFAULT NULL COMMENT '商品价格',
  `t_product_image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `t_order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_merchant_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户号',
  PRIMARY KEY (`t_order_detail_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order_detail
-- ----------------------------
INSERT INTO `codeworld_order_detail` VALUES (3338, 21093808600385600, 185457, 1, 'Iphone20 绿色 1000G', '{\"id\":185457,\"price\":3,\"title\":\"绿色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/58571609919598472.jpg\"}', 3, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-01-15 16:55:51', '21181608848696318');
INSERT INTO `codeworld_order_detail` VALUES (168022, 21048671759173696, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-01-07 17:36:57', '21181611095746339');
INSERT INTO `codeworld_order_detail` VALUES (187813, 21069544944699456, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, NULL, '2021-01-11 10:05:17', '21181611095746339');
INSERT INTO `codeworld_order_detail` VALUES (201337, 21048732140963904, 129735, 1, 'VivoX100 红色 1000G', '{\"id\":129735,\"price\":1,\"title\":\"红色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg\"}', 1, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-01-07 17:52:18', '21181611095746339');
INSERT INTO `codeworld_order_detail` VALUES (322880, 21048671759173696, 185457, 1, 'Iphone20 绿色 1000G', '{\"id\":185457,\"price\":3,\"title\":\"绿色 1000G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/58571609919598472.jpg\"}', 3, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-01-07 17:36:57', '21181608848696318');
INSERT INTO `codeworld_order_detail` VALUES (421855, 21093808600385600, 189609, 1, '小米MIX2 绿色 20G', '{\"id\":189609,\"price\":9999,\"title\":\"绿色 20G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\"}', 9999, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '2021-01-15 16:55:51', NULL);
INSERT INTO `codeworld_order_detail` VALUES (450272, 21069524015122496, 756668, 1, '小米MIX2 红色 20G', '{\"id\":756668,\"price\":99,\"title\":\"红色 20G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg\"}', 99, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '2021-01-11 09:59:58', NULL);
INSERT INTO `codeworld_order_detail` VALUES (755418, 21048732140963904, 189609, 1, '小米MIX2 绿色 20G', '{\"id\":189609,\"price\":9999,\"title\":\"绿色 20G\",\"images\":\"https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg\"}', 9999, 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '2021-01-07 17:52:18', '21181608848696318');

-- ----------------------------
-- Table structure for codeworld_order_status
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_order_status`;
CREATE TABLE `codeworld_order_status`  (
  `t_order_id` bigint(20) NOT NULL COMMENT '订单id',
  `t_order_status` int(1) NULL DEFAULT NULL COMMENT '订单状态 1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价 7、失效订单',
  `t_order_create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `t_order_pay_time` datetime(0) NULL DEFAULT NULL COMMENT '订单付款时间',
  `t_order_consign_time` datetime(0) NULL DEFAULT NULL COMMENT '订单发货时间',
  `t_order_end_time` datetime(0) NULL DEFAULT NULL COMMENT '订单结束时间',
  `t_order_close_time` datetime(0) NULL DEFAULT NULL COMMENT '订单关闭时间',
  PRIMARY KEY (`t_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_order_status
-- ----------------------------
INSERT INTO `codeworld_order_status` VALUES (21048671759173696, 2, '2021-01-07 17:36:57', '2021-01-07 17:36:59', NULL, NULL, NULL);
INSERT INTO `codeworld_order_status` VALUES (21048732140963904, 2, '2021-01-07 17:52:18', '2021-01-07 17:52:19', NULL, NULL, NULL);
INSERT INTO `codeworld_order_status` VALUES (21069524015122496, 2, '2021-01-11 09:59:58', '2021-01-11 10:02:37', NULL, NULL, NULL);
INSERT INTO `codeworld_order_status` VALUES (21069544944699456, 2, '2021-01-11 10:05:17', '2021-01-11 10:05:19', NULL, NULL, NULL);
INSERT INTO `codeworld_order_status` VALUES (21093808600385600, 3, '2021-01-15 16:55:51', '2021-01-15 16:56:26', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for codeworld_param
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_param`;
CREATE TABLE `codeworld_param`  (
  `t_param_id` bigint(20) NOT NULL COMMENT '参数主键Id',
  `t_param_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `t_special_param` int(1) NULL DEFAULT NULL COMMENT '是否是特殊属性 1--是，0--不是',
  `t_attribute_id` bigint(20) NULL DEFAULT NULL COMMENT '属性Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_param_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_param
-- ----------------------------
INSERT INTO `codeworld_param` VALUES (671913, 'CPU型号', 0, 513162, '2020-12-18 10:32:01', '2020-12-18 10:32:01');
INSERT INTO `codeworld_param` VALUES (833900, '操作系统', 0, 513162, '2020-12-18 10:32:08', '2020-12-18 10:32:08');
INSERT INTO `codeworld_param` VALUES (878010, '颜色', 1, 513162, '2020-12-18 10:31:43', '2020-12-18 10:31:43');
INSERT INTO `codeworld_param` VALUES (879798, '内存', 1, 513162, '2020-12-18 10:31:54', '2020-12-18 10:31:54');

-- ----------------------------
-- Table structure for codeworld_product
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_product`;
CREATE TABLE `codeworld_product`  (
  `t_product_id` bigint(20) NOT NULL COMMENT '商品主键Id',
  `t_product_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品二级标题',
  `t_product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类id',
  `t_product_brand_id` bigint(20) NULL DEFAULT NULL COMMENT '商品品牌id',
  `t_product_saleable` int(1) NULL DEFAULT NULL COMMENT '商品状态 1-上架 0-下架',
  `t_product_merchant_id` bigint(20) NULL DEFAULT NULL COMMENT '商户Id',
  `t_product_create_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `t_product_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_product
-- ----------------------------
INSERT INTO `codeworld_product` VALUES (668339, 'Iphone20', NULL, 500117, NULL, 1, 1609046703, '2021-01-06 15:53:36', '2021-01-06 15:53:41');
INSERT INTO `codeworld_product` VALUES (711211, 'VivoX100', NULL, 500117, NULL, 1, 1608851327, '2021-01-07 17:10:59', '2021-01-08 16:59:27');
INSERT INTO `codeworld_product` VALUES (897175, '小米MIX2', NULL, 500117, NULL, 1, 1609046703, '2020-12-18 10:33:54', '2020-12-18 10:33:56');

-- ----------------------------
-- Table structure for codeworld_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_product_detail`;
CREATE TABLE `codeworld_product_detail`  (
  `t_product_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT '商品id',
  `t_product_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述信息',
  `t_product_generic_param` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品通用参数',
  `t_product_special_param` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品特殊参数',
  `t_product_packing_list` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品包装信息',
  `t_product_after_service` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品售后服务',
  `t_product_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_product_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_product_detail
-- ----------------------------
INSERT INTO `codeworld_product_detail` VALUES (00000000000000668339, 'iPhone20又大又好看，还终身包换', '{\"671913\":\"A20\",\"833900\":\"iPhone\"}', '{\"878010\":[\"红色\",\"绿色\"],\"879798\":[\"1000G\",\"2000G\"]}', '1个IPhone20手机', '终生包换', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_detail` VALUES (00000000000000711211, 'Vivo手机终生包换', '{\"671913\":\"骁龙1000\",\"833900\":\"Android\"}', '{\"878010\":[\"红色\"],\"879798\":[\"1000G\"]}', '一个手机', '终生包换', '2021-01-07 17:10:59', '2021-01-07 17:10:59');
INSERT INTO `codeworld_product_detail` VALUES (00000000000000897175, '小米值得信赖', '{\"671913\":\"骁龙10000\",\"833900\":\"Android\"}', '{\"878010\":[\"红色\",\"绿色\"],\"879798\":[\"10G\",\"20G\"]}', '一个手机', '终身包换', '2020-12-18 10:33:54', '2020-12-18 10:33:54');

-- ----------------------------
-- Table structure for codeworld_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_product_sku`;
CREATE TABLE `codeworld_product_sku`  (
  `t_product_sku_id` bigint(20) NOT NULL COMMENT '商品Sku主键Id',
  `t_product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品Id',
  `t_product_sku_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `t_product_sku_price` int(10) NULL DEFAULT NULL COMMENT '商品价格',
  `t_product_sku_own_spec` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品规格参数',
  `t_product_sku_images` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品图片',
  `t_product_sku_create_time` datetime(0) NULL DEFAULT NULL COMMENT '商品创建时间',
  `t_product_sku_update_time` datetime(0) NULL DEFAULT NULL COMMENT '商品更新时间',
  PRIMARY KEY (`t_product_sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_product_sku
-- ----------------------------
INSERT INTO `codeworld_product_sku` VALUES (86869, 668339, 'Iphone20 红色 1000G', 1, '{\"878010\":\"红色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/96101609919575712.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (129735, 711211, 'VivoX100 红色 1000G', 1, '{\"878010\":\"红色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/07/8381610010655296.jpg', '2021-01-07 17:10:59', '2021-01-07 17:10:59');
INSERT INTO `codeworld_product_sku` VALUES (177905, 668339, 'Iphone20 绿色 2000G', 4, '{\"878010\":\"绿色\",\"879798\":\"2000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/76471609919611150.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (185457, 668339, 'Iphone20 绿色 1000G', 3, '{\"878010\":\"绿色\",\"879798\":\"1000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/58571609919598472.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (189609, 897175, '小米MIX2 绿色 20G', 9999, '{\"878010\":\"绿色\",\"879798\":\"20G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/20121608258832021.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');
INSERT INTO `codeworld_product_sku` VALUES (430732, 897175, '小米MIX2 绿色 10G', 999, '{\"878010\":\"绿色\",\"879798\":\"10G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/95801608258823988.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');
INSERT INTO `codeworld_product_sku` VALUES (451278, 897175, '小米MIX2 红色 10G', 9, '{\"878010\":\"红色\",\"879798\":\"10G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39141608258804944.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');
INSERT INTO `codeworld_product_sku` VALUES (465882, 668339, 'Iphone20 红色 2000G', 2, '{\"878010\":\"红色\",\"879798\":\"2000G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2021/01/06/87311609919589441.jpg', '2021-01-06 15:53:36', '2021-01-06 15:53:36');
INSERT INTO `codeworld_product_sku` VALUES (756668, 897175, '小米MIX2 红色 20G', 99, '{\"878010\":\"红色\",\"879798\":\"20G\"}', 'https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/2020/12/18/39601608258814803.jpg', '2020-12-18 10:33:54', '2020-12-18 10:33:54');

-- ----------------------------
-- Table structure for codeworld_role
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_role`;
CREATE TABLE `codeworld_role`  (
  `t_role_id` bigint(20) NOT NULL COMMENT '角色主键Id',
  `t_role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `t_role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `t_role_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_role
-- ----------------------------
INSERT INTO `codeworld_role` VALUES (1, 'admin', '系统管理员', '拥有最高权限', '2020-09-16 20:10:33', '2020-10-20 09:36:20');
INSERT INTO `codeworld_role` VALUES (127341, 'default', '默认用户', '只有查看权限', '2020-11-06 09:26:01', '2020-11-06 09:43:06');
INSERT INTO `codeworld_role` VALUES (853858, 'merchant', '商户', '商户用户', '2021-01-04 15:39:53', '2021-01-04 15:39:53');
INSERT INTO `codeworld_role` VALUES (982301, 'register', '注册用户', '只有一般的查看权限', '2020-09-21 16:06:21', '2020-11-06 09:13:43');

-- ----------------------------
-- Table structure for codeworld_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_role_menu`;
CREATE TABLE `codeworld_role_menu`  (
  `t_role_menu_id` bigint(20) NOT NULL COMMENT '角色菜单主键Id',
  `t_role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色Id',
  `t_menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_role_menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_role_menu
-- ----------------------------
INSERT INTO `codeworld_role_menu` VALUES (25560, 1, 934228, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (26670, 853858, 911538, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (33293, 853858, 887057, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (61297, 127341, 1002, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (65239, 982301, 887057, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (87793, 853858, 506283, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (88058, 1, 482527, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (92725, 853858, 1001, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (104192, 127341, 1001, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (131377, 853858, 982791, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (137984, 1, 1002, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (149449, 1, 906682, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (183353, 853858, 806101, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (196364, 1, 431133, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (211434, 1, 940513, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (216704, 853858, 142731, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (230093, 853858, 431133, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (260067, 1, 652737, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (262096, 1, 85834, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (262834, 1, 948807, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (265431, 1, 422057, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (267067, 1, 982791, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (272336, 853858, 652906, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (283839, 982301, 1001, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (297487, 1, 652906, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (307599, 1, 248235, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (319000, 1, 887057, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (328428, 1, 399716, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (337363, 1, 183517, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (353700, 127341, 759155, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (361259, 1, 789006, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (393265, 982301, 854257, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (405391, 853858, 192975, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (420738, 853858, 399716, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (448385, 853858, 948807, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (472503, 1, 759155, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (482728, 1, 373292, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (483883, 1, 854257, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (493235, 1, 1001, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (499029, 853858, 759155, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (548258, 853858, 453077, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (585919, 1, 506283, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (590295, 982301, 483295, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (594825, 127341, 506283, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (608214, 1, 142731, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (612354, 853858, 482527, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (629691, 853858, 767865, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (630491, 1, 718023, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (635203, 1, 639590, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (644426, 982301, 431133, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (656538, 982301, 1000, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (660793, 1, 523925, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (701856, 982301, 506283, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (709127, 853858, 523925, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (742871, 853858, 85834, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (755549, 1, 1000, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (756381, 1, 192975, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (774729, 853858, 1003, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (783101, 853858, 639590, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (799065, 1, 806101, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (805040, 853858, 373292, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (810543, 1, 453077, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (813463, 853858, 712174, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (840329, 1, 767865, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (887992, 853858, 854257, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (892825, 982301, 1003, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (908468, 982301, 759155, '2020-11-06 09:15:01', '2020-11-06 09:15:01');
INSERT INTO `codeworld_role_menu` VALUES (910197, 1, 414011, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (920762, 127341, 431133, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (927562, 853858, 422057, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (933230, 1, 1003, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (949335, 127341, 1000, '2020-11-06 09:26:38', '2020-11-06 09:26:38');
INSERT INTO `codeworld_role_menu` VALUES (949959, 853858, 789006, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (960705, 1, 751273, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (967601, 853858, 414011, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (983574, 1, 911538, '2021-01-13 15:42:21', '2021-01-13 15:42:21');
INSERT INTO `codeworld_role_menu` VALUES (985573, 853858, 1002, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (995763, 853858, 248235, '2021-01-10 12:36:22', '2021-01-10 12:36:22');
INSERT INTO `codeworld_role_menu` VALUES (999579, 982301, 1002, '2020-11-06 09:15:01', '2020-11-06 09:15:01');

-- ----------------------------
-- Table structure for codeworld_stock
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_stock`;
CREATE TABLE `codeworld_stock`  (
  `t_product_sku_id` bigint(20) NOT NULL COMMENT '商品skuId',
  `t_product_stock` int(10) NULL DEFAULT NULL COMMENT '商品库存',
  PRIMARY KEY (`t_product_sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_stock
-- ----------------------------

-- ----------------------------
-- Table structure for codeworld_user
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_user`;
CREATE TABLE `codeworld_user`  (
  `t_user_id` bigint(20) NOT NULL COMMENT '用户主键Id',
  `t_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `t_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `t_user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `t_user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `t_user_status` int(1) NULL DEFAULT NULL COMMENT '用户状态 1--启用 0--禁用',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '加入时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_user
-- ----------------------------
INSERT INTO `codeworld_user` VALUES (434870, '1111', NULL, '1692454247@qq.com', '15281223316', 1, '2020-11-05 10:13:02', '2020-11-05 16:59:35');
INSERT INTO `codeworld_user` VALUES (714564, 'FC', NULL, '1692454247@qq.com', '15281223316', 1, '2020-11-06 09:21:02', '2021-01-04 15:40:40');
INSERT INTO `codeworld_user` VALUES (722708, 'code', NULL, '1692454247@qq.com', '15281223316', 1, '2020-11-05 17:01:13', '2020-11-05 17:01:13');

-- ----------------------------
-- Table structure for codeworld_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_user_dept`;
CREATE TABLE `codeworld_user_dept`  (
  `t_user_dept_id` bigint(20) NOT NULL COMMENT '用户部门主键Id',
  `t_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户Id',
  `t_dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_user_dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_user_dept
-- ----------------------------
INSERT INTO `codeworld_user_dept` VALUES (8986, 714564, 2, '2021-01-04 15:40:40', '2021-01-04 15:40:40');
INSERT INTO `codeworld_user_dept` VALUES (246857, 434870, 2, '2020-11-05 16:59:36', '2020-11-05 16:59:36');
INSERT INTO `codeworld_user_dept` VALUES (434744, 722708, 1, '2020-11-05 17:01:13', '2020-11-05 17:01:13');

-- ----------------------------
-- Table structure for codeworld_user_role
-- ----------------------------
DROP TABLE IF EXISTS `codeworld_user_role`;
CREATE TABLE `codeworld_user_role`  (
  `t_user_role_id` bigint(20) NOT NULL COMMENT '用户角色表主键Id',
  `t_role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色Id',
  `t_user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户Id',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`t_user_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of codeworld_user_role
-- ----------------------------
INSERT INTO `codeworld_user_role` VALUES (125360, 853858, 1608851327, '2021-01-07 17:04:35', '2021-01-07 17:04:35');
INSERT INTO `codeworld_user_role` VALUES (442284, 982301, 722708, '2020-11-05 17:01:12', '2020-11-05 17:01:12');
INSERT INTO `codeworld_user_role` VALUES (609142, 853858, 714564, '2021-01-04 15:40:40', '2021-01-04 15:40:40');
INSERT INTO `codeworld_user_role` VALUES (828303, 1, 434870, '2020-11-05 16:59:35', '2020-11-05 16:59:35');
INSERT INTO `codeworld_user_role` VALUES (840122, 853858, 1609046703, '2021-01-05 16:42:14', '2021-01-05 16:42:14');

SET FOREIGN_KEY_CHECKS = 1;

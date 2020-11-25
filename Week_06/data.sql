-- ----------------------------
-- 用户表
-- ----------------------------
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL COMMENT '主键id 用户id',
  `username` varchar(32) NOT NULL COMMENT '用户名 用户名',
  `password` varchar(64) NOT NULL COMMENT '密码 密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称 昵称',
  `realname` varchar(128) DEFAULT NULL COMMENT '真实姓名',
  `face` varchar(1024) NOT NULL COMMENT '头像',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号 手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱地址 邮箱地址',
  `sex` int(11) DEFAULT NULL COMMENT '性别 性别 1:男  0:女  2:保密',
  `birthday` date DEFAULT NULL COMMENT '生日 生日',
  `created_time` datetime NOT NULL COMMENT '创建时间 创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间 更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表 ';

SET FOREIGN_KEY_CHECKS = 1;



-- ----------------------------
-- 订单表 （还差订单状态表）
-- ----------------------------
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL COMMENT '订单主键;同时也是订单编号',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `receiver_name` varchar(32) NOT NULL COMMENT '收货人快照',
  `receiver_mobile` varchar(32) NOT NULL COMMENT '收货人手机号快照',
  `receiver_address` varchar(128) NOT NULL COMMENT '收货地址快照',
  `total_amount` int(11) NOT NULL COMMENT '订单总价格',
  `real_pay_amount` int(11) NOT NULL COMMENT '实际支付总价格',
  `post_amount` int(11) NOT NULL COMMENT '邮费;默认可以为零，代表包邮',
  `pay_method` int(11) NOT NULL COMMENT '支付方式',
  `left_msg` varchar(128) DEFAULT NULL COMMENT '买家留言',
  `extend` varchar(32) DEFAULT NULL COMMENT '扩展字段',
  `is_comment` int(11) NOT NULL COMMENT '买家是否评价;1：已评价，0：未评价',
  `is_delete` int(11) NOT NULL COMMENT '逻辑删除状态;1: 删除 0:未删除',
  `created_time` datetime NOT NULL COMMENT '创建时间（成交时间）',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表;';

SET FOREIGN_KEY_CHECKS = 1;



-- ----------------------------
-- 商品表
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` varchar(64) NOT NULL COMMENT '商品主键id',
  `item_name` varchar(32) NOT NULL COMMENT '商品名称 商品名称',
  `cat_id` int(11) NOT NULL COMMENT '分类外键id 分类id',
  `root_cat_id` int(11) NOT NULL COMMENT '一级分类外键id',
  `sell_counts` int(11) NOT NULL COMMENT '累计销售 累计销售',
  `on_off_status` int(11) NOT NULL COMMENT '上下架状态 上下架状态,1:上架 2:下架',
  `content` text NOT NULL COMMENT '商品内容 商品内容',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表';

SET FOREIGN_KEY_CHECKS = 1;


-- ----------------------------
-- 商品分类表
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '分类名称',
  `type` int(11) NOT NULL COMMENT '分类类型',
  `father_id` int(11) NOT NULL COMMENT '父id',
  `logo` varchar(64) DEFAULT NULL COMMENT '图标',
  `slogan` varchar(64) DEFAULT NULL COMMENT '口号',
  `cat_image` varchar(64) DEFAULT NULL COMMENT '分类图',
  `bg_color` varchar(32) DEFAULT NULL COMMENT '背景颜色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品分类 ';

SET FOREIGN_KEY_CHECKS = 1;


-- ----------------------------
-- 商品参数表
-- ----------------------------
DROP TABLE IF EXISTS `items_param`;
CREATE TABLE `items_param` (
  `id` varchar(64) NOT NULL COMMENT '商品参数id',
  `item_id` varchar(32) NOT NULL COMMENT '商品外键id',
  `produce_place` varchar(32) NOT NULL COMMENT '产地 产地，例：中国江苏',
  `foot_period` varchar(32) NOT NULL COMMENT '保质期 保质期，例：180天',
  `brand` varchar(32) NOT NULL COMMENT '品牌名 品牌名，例：三只大灰狼',
  `factory_name` varchar(32) NOT NULL COMMENT '生产厂名 生产厂名，例：大灰狼工厂',
  `factory_address` varchar(32) NOT NULL COMMENT '生产厂址 生产厂址，例：大灰狼生产基地',
  `packaging_method` varchar(32) NOT NULL COMMENT '包装方式 包装方式，例：袋装',
  `weight` varchar(32) NOT NULL COMMENT '规格重量 规格重量，例：35g',
  `storage_method` varchar(32) NOT NULL COMMENT '存储方法 存储方法，例：常温5~25°',
  `eat_method` varchar(32) NOT NULL COMMENT '食用方式 食用方式，例：开袋即食',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品参数 ';

SET FOREIGN_KEY_CHECKS = 1;
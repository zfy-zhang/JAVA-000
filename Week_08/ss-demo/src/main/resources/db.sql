create database if not exists `d_order_0` default character set utf8mb4 collate utf8mb4_unicode_ci;

use `d_order_0`;

create table if not exists `orders_0`
(
    `pk_id`              bigint(20) unsigned     not null default 0 primary key comment '主键',
    `order_no`           varchar(200)            not null default '' comment '订单编号',
    `order_status`       varchar(100)            not null default '' comment '订单状态',
    `buyer_id`           bigint(20) unsigned     not null default 0 comment '买家id',
    `receiver_name`      varchar(200)            not null default '' comment '收件人姓名',
    `receiver_telephone` varchar(200)            not null default '' comment '收件人电话',
    `receiver_address`   varchar(200)            not null default '' comment '收件人地址',
    `receiver_postcode`  varchar(10)             not null default '' comment '收件人邮编',
    `sku_id`             bigint(20) unsigned     not null default 0 comment 'SKU id',
    `sku_price`          decimal(10, 2) unsigned not null default 0 comment 'SKU价格',
    `order_time`         datetime                not null default current_timestamp comment '下单时间',
    `pay_time`           datetime                not null default current_timestamp comment '支付时间',
    `dispatch_time`      datetime                not null default current_timestamp comment '发货时间',
    `receive_time`       datetime                not null default current_timestamp comment '收货时间',
    `create_time`        datetime                not null default current_timestamp comment '创建时间',
    `update_time`        datetime                not null default current_timestamp on update current_timestamp comment '修改时间',
    `is_deleted`         tinyint(2)              not null default 0 comment '逻辑删除标识，未删除(0)，已删除(1)'
) engine = InnoDB
  default charset = utf8mb4
  collate = utf8mb4_unicode_ci comment '订单表';

create table `orders_1` like `orders_0`;
create table `orders_2` like `orders_0`;
create table `orders_3` like `orders_0`;
create table `orders_4` like `orders_0`;
create table `orders_5` like `orders_0`;
create table `orders_6` like `orders_0`;
create table `orders_7` like `orders_0`;
create table `orders_8` like `orders_0`;
create table `orders_9` like `orders_0`;
create table `orders_10` like `orders_0`;
create table `orders_11` like `orders_0`;
create table `orders_12` like `orders_0`;
create table `orders_13` like `orders_0`;
create table `orders_14` like `orders_0`;
create table `orders_15` like `orders_0`;

create database if not exists `orders_1` default character set utf8mb4 collate utf8mb4_unicode_ci;

use `orders_1`;

CREATE TABLE if not exists `orders` (
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
    `extand` varchar(32) DEFAULT NULL COMMENT '扩展字段',
    `is_comment` int(11) NOT NULL COMMENT '买家是否评价;1：已评价，0：未评价',
    `is_delete` int(11) NOT NULL COMMENT '逻辑删除状态;1: 删除 0:未删除',
    `created_time` datetime NOT NULL COMMENT '创建时间（成交时间）',
    `updated_time` datetime NOT NULL COMMENT '更新时间',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表;';

create table `orders_1` like `orders_0`;
create table `orders_2` like `orders_0`;
create table `orders_3` like `orders_0`;
create table `orders_4` like `orders_0`;
create table `orders_5` like `orders_0`;
create table `orders_6` like `orders_0`;
create table `orders_7` like `orders_0`;
create table `orders_8` like `orders_0`;
create table `orders_9` like `orders_0`;
create table `orders_10` like `orders_0`;
create table `orders_11` like `orders_0`;
create table `orders_12` like `orders_0`;
create table `orders_13` like `orders_0`;
create table `orders_14` like `orders_0`;
create table `orders_15` like `orders_0`;
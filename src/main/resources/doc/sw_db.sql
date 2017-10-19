/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.19-log : Database - sw_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sw_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sw_db`;

/*Table structure for table `sw_company_info` */

DROP TABLE IF EXISTS `sw_company_info`;

CREATE TABLE `sw_company_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `comp_no` varchar(32) DEFAULT NULL COMMENT '公司编码',
  `comp_name` varchar(128) DEFAULT NULL COMMENT '公司名称',
  `contact_name` varchar(64) DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机',
  `telphone` varchar(32) DEFAULT NULL COMMENT '电话',
  `tax` varchar(32) DEFAULT NULL COMMENT '传真',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `addr` varchar(128) DEFAULT NULL COMMENT '地址',
  `is_self` char(1) DEFAULT 'N' COMMENT '是否本公司 Y:是 N:否',
  `is_valid` char(1) DEFAULT 'N' COMMENT '是否生效 Y:是 N:否',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司信息表';

/*Data for the table `sw_company_info` */

/*Table structure for table `sw_deliver_base` */

DROP TABLE IF EXISTS `sw_deliver_base`;

CREATE TABLE `sw_deliver_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `deilver_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deilver_date` date DEFAULT NULL COMMENT '发货日期',
  `deilver_way` varchar(16) DEFAULT NULL COMMENT '运货方式',
  `send_name` varchar(32) DEFAULT NULL COMMENT '发货人',
  `if_gurant` char(1) DEFAULT 'N' COMMENT '是否保价 Y:是 N:否',
  `deilver_status` varchar(16) DEFAULT NULL COMMENT '发货状态',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `cust_comp_no` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `cust_comp_name` varchar(128) DEFAULT NULL COMMENT '客户名称',
  `cust_contact_name` varchar(64) DEFAULT NULL COMMENT '客户联系人',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '客户手机',
  `custt_phone` varchar(16) DEFAULT NULL COMMENT '客户电话',
  `cust_tax` varchar(16) DEFAULT NULL COMMENT '客户传真',
  `cust_addr` varchar(256) DEFAULT NULL COMMENT '客户地址',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发货单总表';

/*Data for the table `sw_deliver_base` */

/*Table structure for table `sw_deliver_detail` */

DROP TABLE IF EXISTS `sw_deliver_detail`;

CREATE TABLE `sw_deliver_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `deilver_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deilver_seq_no` varchar(32) DEFAULT NULL COMMENT '发货单序号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '订单序号',
  `box_no` varchar(16) DEFAULT NULL COMMENT '箱号',
  `prod_no` varchar(32) DEFAULT NULL COMMENT '编码',
  `prod_name` varchar(32) DEFAULT NULL COMMENT '品名',
  `prod_type` varchar(32) DEFAULT NULL COMMENT '品种',
  `prod_form` varchar(32) DEFAULT NULL COMMENT '形状',
  `prod_long` decimal(20,2) DEFAULT NULL COMMENT '长',
  `prod_width` decimal(20,2) DEFAULT NULL COMMENT '宽',
  `prod_num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `prod_price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发货单明细表';

/*Data for the table `sw_deliver_detail` */

/*Table structure for table `sw_depart_employee` */

DROP TABLE IF EXISTS `sw_depart_employee`;

CREATE TABLE `sw_depart_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `depart_no` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `user_no` varchar(32) DEFAULT NULL COMMENT '员工编号',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门员工表';

/*Data for the table `sw_depart_employee` */

/*Table structure for table `sw_depart_info` */

DROP TABLE IF EXISTS `sw_depart_info`;

CREATE TABLE `sw_depart_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `depart_no` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `depart_name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `fh_depart_no` varchar(32) DEFAULT NULL COMMENT '上级部门编号',
  `comp_no` varchar(32) DEFAULT NULL COMMENT '公司编码',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

/*Data for the table `sw_depart_info` */

/*Table structure for table `sw_formular_info` */

DROP TABLE IF EXISTS `sw_formular_info`;

CREATE TABLE `sw_formular_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `formular_no` varchar(32) DEFAULT NULL COMMENT '公式编码',
  `formular_name` varchar(32) DEFAULT NULL COMMENT '公式名称',
  `formular_value` varchar(32) DEFAULT NULL COMMENT '公式',
  `formular_type` varchar(32) DEFAULT NULL COMMENT '公式类别 ',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公式信息表';

/*Data for the table `sw_formular_info` */

/*Table structure for table `sw_material_info` */

DROP TABLE IF EXISTS `sw_material_info`;

CREATE TABLE `sw_material_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `material_name` varchar(32) DEFAULT NULL COMMENT '物料名称',
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `pattern` varchar(100) DEFAULT NULL COMMENT '型号',
  `unit` varchar(12) DEFAULT NULL COMMENT '单位',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物料信息表';

/*Data for the table `sw_material_info` */

/*Table structure for table `sw_order_base` */

DROP TABLE IF EXISTS `sw_order_base`;

CREATE TABLE `sw_order_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_date` date DEFAULT NULL COMMENT '订单日期',
  `pay_way` varchar(16) DEFAULT NULL COMMENT '付款方式',
  `good_date` date DEFAULT NULL COMMENT '订货日期',
  `finish_date` date DEFAULT NULL COMMENT '交货日期',
  `order_type` varchar(16) DEFAULT NULL COMMENT '单据类型',
  `sale_type` varchar(16) DEFAULT NULL COMMENT '销售类型',
  `order_status` varchar(16) DEFAULT NULL COMMENT '订单状态',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `cust_comp_no` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `cust_comp_name` varchar(128) DEFAULT NULL COMMENT '客户名称',
  `cust_contact_name` varchar(64) DEFAULT NULL COMMENT '客户联系人',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '客户手机',
  `custt_phone` varchar(16) DEFAULT NULL COMMENT '客户电话',
  `cust_tax` varchar(16) DEFAULT NULL COMMENT '客户传真',
  `cust_addr` varchar(256) DEFAULT NULL COMMENT '客户地址',
  `supply_comp_no` varchar(32) DEFAULT NULL COMMENT '供货方编号',
  `supply_comp_name` varchar(128) DEFAULT NULL COMMENT '供货方名称',
  `supply_contact_name` varchar(64) DEFAULT NULL COMMENT '供货方联系人',
  `supply_mobile` varchar(16) DEFAULT NULL COMMENT '供货方手机',
  `supply_phone` varchar(16) DEFAULT NULL COMMENT '供货方电话',
  `supply_tax` varchar(16) DEFAULT NULL COMMENT '供货方传真',
  `supply_addr` varchar(256) DEFAULT NULL COMMENT '供货方地址',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单总表';

/*Data for the table `sw_order_base` */

/*Table structure for table `sw_order_detail` */

DROP TABLE IF EXISTS `sw_order_detail`;

CREATE TABLE `sw_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '订单序号',
  `prod_no` varchar(32) DEFAULT NULL COMMENT '编码',
  `prod_name` varchar(32) DEFAULT NULL COMMENT '品名',
  `prod_type` varchar(32) DEFAULT NULL COMMENT '品种',
  `prod_form` varchar(32) DEFAULT NULL COMMENT '形状',
  `prod_long` decimal(20,2) DEFAULT NULL COMMENT '长',
  `prod_width` decimal(20,2) DEFAULT NULL COMMENT '宽',
  `prod_num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `prod_unit` varchar(4) DEFAULT NULL COMMENT '单位',
  `prod_price_no` varchar(32) DEFAULT NULL COMMENT '单价公式编码',
  `prod_price_express` varchar(32) DEFAULT NULL COMMENT '单价公式',
  `prod_price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `prod_amt` decimal(20,2) DEFAULT NULL COMMENT '金额',
  `area` varchar(64) DEFAULT NULL COMMENT '区域',
  `material_no` varchar(32) DEFAULT NULL COMMENT '面料品号',
  `material_name` varchar(64) DEFAULT NULL COMMENT '面料品名',
  `material_width` decimal(20,2) DEFAULT NULL COMMENT '有效幅宽',
  `material_price_no` varchar(32) DEFAULT NULL COMMENT '面料公式代码',
  `material_price_express` varchar(64) DEFAULT NULL COMMENT '面料公式',
  `material_num` decimal(20,2) DEFAULT NULL COMMENT '面料需求',
  `material_price` decimal(20,2) DEFAULT NULL COMMENT '面料基础价',
  `tech_no` varchar(32) DEFAULT NULL COMMENT '工艺编码',
  `tech_name` varchar(64) DEFAULT NULL COMMENT '工艺名称',
  `tech_price` decimal(20,2) DEFAULT NULL COMMENT '工艺单价',
  `tech_price_express` varchar(32) DEFAULT NULL COMMENT '工艺公式',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `prod_price1` decimal(20,2) DEFAULT NULL COMMENT '成品定价',
  `if_prod` char(1) DEFAULT 'N' COMMENT '是否定价品 Y:是 N:否',
  `cate_type` varchar(32) DEFAULT NULL COMMENT '分类',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

/*Data for the table `sw_order_detail` */

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `dict_type` varchar(32) DEFAULT NULL COMMENT '类型',
  `dict_code` varchar(32) DEFAULT NULL COMMENT '编码',
  `dict_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `dict_value` varchar(128) DEFAULT NULL COMMENT '值',
  `dict_desc` varchar(128) DEFAULT NULL COMMENT '描述',
  `fh_dict_code` varchar(32) DEFAULT NULL COMMENT '上级编码',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sys_dict` */

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `source_no` varchar(32) DEFAULT NULL COMMENT '资源编号',
  `source_name` varchar(64) DEFAULT NULL COMMENT '资源名称',
  `fh_source_no` varchar(32) DEFAULT NULL COMMENT '上级资源编号',
  `source_type` varchar(16) DEFAULT 'MENU' COMMENT '资源类型 MENU:菜单 BUTTON:按钮',
  `req_url` varchar(512) DEFAULT NULL COMMENT '地址路径',
  `rsource_icon` varchar(64) DEFAULT NULL COMMENT '资源图标',
  `sort_order` int(11) DEFAULT NULL COMMENT '排序规则',
  `if_visible` char(1) DEFAULT 'Y' COMMENT '是否显示 Y:显示 N:不显示',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_resource` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `status` char(1) DEFAULT 'Y' COMMENT '状态 Y:有效 N:无效',
  `if_admin` char(1) DEFAULT 'N' COMMENT '是否超级角色',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `source_no` varchar(32) DEFAULT NULL COMMENT '资源编号',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `sys_role_resource` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `phone_num` int(11) DEFAULT NULL COMMENT '手机号',
  `email_addr` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(128) DEFAULT NULL COMMENT '登录密码',
  `status` char(1) DEFAULT NULL COMMENT '状态 Y:有效 N:无效',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_userNo` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_no`,`user_name`,`nick_name`,`phone_num`,`email_addr`,`password`,`status`,`memo`,`last_login_time`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (6,'zhangsan',NULL,'张三',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-19 17:40:51','system','2017-10-19 17:40:51',0),(10,'zhangsan1',NULL,'张三',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-19 17:46:49','system','2017-10-19 17:46:49',0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `sys_user_role` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

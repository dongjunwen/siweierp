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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='公司信息表';

/*Data for the table `sw_company_info` */

insert  into `sw_company_info`(`id`,`comp_no`,`comp_name`,`contact_name`,`mobile`,`telphone`,`tax`,`email`,`addr`,`is_self`,`is_valid`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'SWFZ','山东思维纺织','山东思维纺织','0631-5769674','0631-5769674','0631-5769674','1221888','山东省威海市环翠区羊亭裕林工业园5号','Y','Y',NULL,'system','2017-10-20 15:41:10','wangfangfang','2017-11-10 16:11:04',0),(3,'BJHY','北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','1221888@q.com','北京市中关村5号','N','Y',NULL,'system','2017-10-20 15:44:39','system','2017-11-10 16:12:27',0),(4,'ASDJ','ASDJ科技有限公司','齐威王','1233444','12122112','1221','1221','12122222222222','N','Y',NULL,'system','2017-10-20 15:44:44','system','2017-12-09 15:23:14',0),(5,'ABCD','ABCD科技有限公司','张三','12333','1','111','XX@qq.com','广兰路','N','Y',NULL,'system','2017-10-20 16:36:20','system','2017-12-09 15:22:49',0),(6,'SHKJ','SHJK业科技有限公司','张三','12333','1','111','XX@qq.com','广兰路','N','Y',NULL,'system','2017-10-20 16:36:30','system','2017-12-09 15:22:55',0),(7,'SDJJ','SDJJ科技有限公司','张三','12333','1','111','XX@qq.com','广兰路','N','Y',NULL,'system','2017-10-20 16:36:35','system','2017-12-09 15:23:00',0);

/*Table structure for table `sw_deliver_base` */

DROP TABLE IF EXISTS `sw_deliver_base`;

CREATE TABLE `sw_deliver_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `deliver_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deliver_date` date DEFAULT NULL COMMENT '发货日期',
  `deliver_way` varchar(16) DEFAULT NULL COMMENT '运货方式',
  `send_name` varchar(32) DEFAULT NULL COMMENT '发货人',
  `if_gurant` char(1) DEFAULT 'N' COMMENT '是否保价 Y:是 N:否',
  `deliver_status` varchar(16) DEFAULT NULL COMMENT '发货状态',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `cust_comp_no` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `cust_comp_name` varchar(128) DEFAULT NULL COMMENT '客户名称',
  `cust_contact_name` varchar(64) DEFAULT NULL COMMENT '客户联系人',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '客户手机',
  `cust_phone` varchar(16) DEFAULT NULL COMMENT '客户电话',
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
  `deliver_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `deliver_seq_no` varchar(32) DEFAULT NULL COMMENT '发货单序号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '订单序号',
  `box_no` varchar(16) DEFAULT NULL COMMENT '箱号',
  `prod_no` varchar(32) DEFAULT NULL COMMENT '编码',
  `prod_name` varchar(32) DEFAULT NULL COMMENT '品名',
  `prod_type` varchar(32) DEFAULT NULL COMMENT '品种',
  `prod_form` varchar(32) DEFAULT NULL COMMENT '形状',
  `prod_unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `prod_long` decimal(20,2) DEFAULT NULL COMMENT '长',
  `prod_width` decimal(20,2) DEFAULT NULL COMMENT '宽',
  `prod_num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `prod_price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `tech_no` varchar(32) DEFAULT NULL COMMENT '工艺编号',
  `tech_name` varchar(64) DEFAULT NULL COMMENT '工艺名称',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='部门员工表';

/*Data for the table `sw_depart_employee` */

insert  into `sw_depart_employee`(`id`,`depart_no`,`user_no`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'swBusi','wangfangfang',NULL,'2017-10-30 14:13:57',NULL,'2017-10-30 14:13:55',0),(2,'swManager','admin',NULL,'2017-12-09 15:19:46',NULL,'2017-12-09 15:19:50',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='部门信息表';

/*Data for the table `sw_depart_info` */

insert  into `sw_depart_info`(`id`,`depart_no`,`depart_name`,`fh_depart_no`,`comp_no`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'swBusi','业务部','swManager','SWFZ',NULL,NULL,NULL,NULL,'2017-11-18 12:24:37',0),(2,'swFinance','财务部','swManager','SWFZ',NULL,NULL,NULL,NULL,'2017-11-18 12:24:37',0),(3,'swPhurchace','采购部','swManager','SWFZ',NULL,NULL,NULL,NULL,'2017-11-18 12:24:38',0),(4,'swManager','总经理办公室',NULL,'SWFZ',NULL,NULL,NULL,NULL,'2017-11-18 12:24:39',0),(5,'swProduce','制造部','swManager','SWFZ',NULL,NULL,NULL,NULL,'2017-11-18 12:24:38',0);

/*Table structure for table `sw_formular_info` */

DROP TABLE IF EXISTS `sw_formular_info`;

CREATE TABLE `sw_formular_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `formular_no` varchar(32) DEFAULT NULL COMMENT '公式编码',
  `formular_name` varchar(32) DEFAULT NULL COMMENT '公式名称',
  `formular_value` varchar(32) DEFAULT NULL COMMENT '公式',
  `formular_price` decimal(20,2) DEFAULT NULL COMMENT '价格',
  `formular_type` varchar(32) DEFAULT NULL COMMENT '公式类别 ',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='公式信息表';

/*Data for the table `sw_formular_info` */

insert  into `sw_formular_info`(`id`,`formular_no`,`formular_name`,`formular_value`,`formular_price`,`formular_type`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'aab','aa','2','222.00','CRAFTS','dddddddd',NULL,NULL,'wangfangfang','2017-11-29 14:47:17',0),(2,'aac','a','3','2.00','PROD','dddddddd',NULL,NULL,NULL,'2017-11-29 14:47:47',0),(3,'aad','ddd','4','2.00','CRAFTS','d',NULL,NULL,NULL,'2017-11-29 14:47:53',0),(4,'TB002','3.2米以上台布','(c+0.04)*s1+s1*2/333','2.00','CRAFTS','d',NULL,NULL,NULL,'2017-11-29 14:47:57',0);

/*Table structure for table `sw_material_info` */

DROP TABLE IF EXISTS `sw_material_info`;

CREATE TABLE `sw_material_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `material_name` varchar(32) DEFAULT NULL COMMENT '物料名称',
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类 SYS_DICT中的MATERIAL_TYPE',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `pattern` varchar(100) DEFAULT NULL COMMENT '型号',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `unit` varchar(12) DEFAULT NULL COMMENT '单位',
  `material_long` decimal(20,2) DEFAULT NULL COMMENT '长',
  `material_width` decimal(20,2) DEFAULT NULL COMMENT '宽',
  `material_stock` varchar(32) DEFAULT NULL COMMENT '所属仓库',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='物料信息表';

/*Data for the table `sw_material_info` */

insert  into `sw_material_info`(`id`,`material_no`,`material_name`,`material_type`,`spec`,`pattern`,`price`,`unit`,`material_long`,`material_width`,`material_stock`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'TBYD','圆底台布','PROD','超棉文艺复兴','圆','100.00','米','10.00','20.00','PROD_STOCK','测试','admin','2017-10-24 14:41:09','admin','2017-11-08 10:36:57',4),(2,'KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','12.00','米','3.00','3.00','PROD_STOCK','string','admin','2017-10-24 14:41:57','admin','2017-11-13 14:31:07',0),(3,'TBYD1','台布','PROD','超棉文艺复兴','圆','3.00','米','3.00','3.00','PROD_STOCK','sd','wangfangfang','2017-11-01 11:31:20','wangfangfang','2017-11-13 14:32:26',0),(4,'TBYD2','圆底台布','PROD','超棉文艺复兴','圆','3.00','米','3.00','3.00','COTTON_STOCK',NULL,'wangfangfang','2017-11-01 11:31:57','wangfangfang','2017-11-13 14:32:28',0),(5,'TBYD3','圆底台布','PROD','超棉文艺复兴','圆','3.00','米','3.00','3.00','COTTON_STOCK','fff','wangfangfang','2017-11-05 14:16:52','wangfangfang','2017-11-13 14:32:30',0),(7,'TBYD4','圆底台布','PROD','超棉文艺复兴','圆','3.00','米','4.00','5.00','COTTON_STOCK','随便','wangfangfang','2017-11-05 15:14:54','wangfangfang','2017-11-13 14:32:32',0),(8,'TBYD5','圆底台布','PROD','超棉文艺复兴','圆','3.00','米','5.00','6.00','COTTON_STOCK',NULL,'wangfangfang','2017-11-05 15:17:18','wangfangfang','2017-11-13 14:32:33',0),(9,'TBYD6','圆底台布','CRAFTS','超棉文艺复兴','圆','3.00','米','1.00','2.00','PROD_STOCK',NULL,'wangfangfang','2017-11-05 15:22:49','wangfangfang','2017-11-13 14:32:35',0),(10,'TBYD7','圆底台布','COTTON','超棉文艺复兴','圆','3.00','米','1.00','3.00','COTTON_STOCK',NULL,'wangfangfang','2017-11-05 15:25:10','wangfangfang','2017-11-13 14:32:37',0);

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
  `order_status` varchar(16) DEFAULT NULL COMMENT '订单状态 sys_dict中的ORDER_STATUS',
  `memo` varchar(32) DEFAULT NULL COMMENT '备注',
  `cust_comp_no` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `cust_comp_name` varchar(128) DEFAULT NULL COMMENT '客户名称',
  `cust_contact_name` varchar(64) DEFAULT NULL COMMENT '客户联系人',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '客户手机',
  `cust_phone` varchar(16) DEFAULT NULL COMMENT '客户电话',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单总表';

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
  `material_price_name` varchar(64) DEFAULT NULL COMMENT '面料公式名称',
  `material_price_express` varchar(64) DEFAULT NULL COMMENT '面料公式',
  `material_spec` varchar(100) DEFAULT NULL COMMENT '面料规格',
  `material_pattern` varchar(100) DEFAULT NULL COMMENT '面料型号',
  `material_unit` varchar(32) DEFAULT NULL COMMENT '面料单位',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单详情表';

/*Data for the table `sw_order_detail` */

/*Table structure for table `sw_purchase_base` */

DROP TABLE IF EXISTS `sw_purchase_base`;

CREATE TABLE `sw_purchase_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `pur_no` varchar(32) DEFAULT NULL COMMENT '采购单号',
  `pur_date` date DEFAULT NULL COMMENT '申购日期',
  `expect_date` date DEFAULT NULL COMMENT '预计到货日期',
  `resp_name` varchar(32) DEFAULT NULL COMMENT '业务负责人',
  `supply_comp_no` varchar(32) DEFAULT NULL COMMENT '供货方编号',
  `supply_comp_name` varchar(128) DEFAULT NULL COMMENT '供货方名称',
  `supply_contact_name` varchar(64) DEFAULT NULL COMMENT '供货方联系人',
  `supply_mobile` varchar(16) DEFAULT NULL COMMENT '供货方手机',
  `supply_phone` varchar(16) DEFAULT NULL COMMENT '供货方电话',
  `supply_tax` varchar(16) DEFAULT NULL COMMENT '供货方传真',
  `supply_addr` varchar(256) DEFAULT NULL COMMENT '供货方地址',
  `pur_amt` decimal(20,2) DEFAULT NULL COMMENT '采购金额',
  `pur_num` decimal(20,2) DEFAULT NULL COMMENT '采购数量',
  `pur_status` varchar(32) DEFAULT NULL COMMENT '采购状态',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='采购单总表';

/*Data for the table `sw_purchase_base` */

/*Table structure for table `sw_purchase_detail` */

DROP TABLE IF EXISTS `sw_purchase_detail`;

CREATE TABLE `sw_purchase_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `pur_no` varchar(32) DEFAULT NULL COMMENT '采购单号',
  `pur_seq_no` varchar(32) DEFAULT NULL COMMENT '采购单序号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '订单序号',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `material_name` varchar(32) DEFAULT NULL COMMENT '物料名称',
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类',
  `material_long` decimal(20,2) DEFAULT NULL COMMENT '面料长度',
  `material_width` decimal(20,2) DEFAULT NULL COMMENT '面料宽度',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `pattern` varchar(100) DEFAULT NULL COMMENT '型号',
  `unit` varchar(12) DEFAULT NULL COMMENT '单位',
  `num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `amt` decimal(20,2) DEFAULT NULL COMMENT '金额',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='采购单明细表';

/*Data for the table `sw_purchase_detail` */

/*Table structure for table `sw_receive_base` */

DROP TABLE IF EXISTS `sw_receive_base`;

CREATE TABLE `sw_receive_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `recv_no` varchar(32) DEFAULT NULL COMMENT '领料单号',
  `recv_date` date DEFAULT NULL COMMENT '领料单日期',
  `recver` varchar(32) DEFAULT NULL COMMENT '领料人',
  `recv_status` varchar(16) DEFAULT NULL COMMENT '状态',
  `use_way` varchar(512) DEFAULT NULL COMMENT '用途',
  `num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `memo` varchar(1024) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='领料单总表';

/*Data for the table `sw_receive_base` */

/*Table structure for table `sw_receive_detail` */

DROP TABLE IF EXISTS `sw_receive_detail`;

CREATE TABLE `sw_receive_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `recv_no` varchar(32) DEFAULT NULL COMMENT '领料单号',
  `recv_seq_no` varchar(32) DEFAULT NULL COMMENT '领料单序号',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `material_name` varchar(32) DEFAULT NULL COMMENT '物料名称',
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `pattern` varchar(100) DEFAULT NULL COMMENT '型号',
  `unit` varchar(12) DEFAULT NULL COMMENT '单位',
  `num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='领料单明细表';

/*Data for the table `sw_receive_detail` */

/*Table structure for table `sw_return_base` */

DROP TABLE IF EXISTS `sw_return_base`;

CREATE TABLE `sw_return_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `return_no` varchar(32) DEFAULT NULL COMMENT '退货单号',
  `return_date` date DEFAULT NULL COMMENT '退货日期',
  `resp_name` varchar(32) DEFAULT NULL COMMENT '业务负责人',
  `supply_comp_no` varchar(32) DEFAULT NULL COMMENT '供货方编号',
  `supply_comp_name` varchar(128) DEFAULT NULL COMMENT '供货方名称',
  `supply_contact_name` varchar(64) DEFAULT NULL COMMENT '供货方联系人',
  `supply_mobile` varchar(16) DEFAULT NULL COMMENT '供货方手机',
  `supply_phone` varchar(16) DEFAULT NULL COMMENT '供货方电话',
  `supply_tax` varchar(16) DEFAULT NULL COMMENT '供货方传真',
  `supply_addr` varchar(256) DEFAULT NULL COMMENT '供货方地址',
  `return_amt` decimal(20,2) DEFAULT NULL COMMENT '退货金额',
  `return_num` decimal(20,2) DEFAULT NULL COMMENT '退货数量',
  `return_reason` varchar(256) DEFAULT NULL COMMENT '退货原因',
  `return_status` varchar(32) DEFAULT NULL COMMENT '退货状态',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退货单总表';

/*Data for the table `sw_return_base` */

/*Table structure for table `sw_return_detail` */

DROP TABLE IF EXISTS `sw_return_detail`;

CREATE TABLE `sw_return_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `return_no` varchar(32) DEFAULT NULL COMMENT '退货单号',
  `return_seq_no` varchar(32) DEFAULT NULL COMMENT '退货单序号',
  `pur_no` varchar(32) DEFAULT NULL COMMENT '采购单号',
  `pur_seq_no` varchar(32) DEFAULT NULL COMMENT '采购单序号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '订单序号',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `material_name` varchar(32) DEFAULT NULL COMMENT '物料名称',
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `pattern` varchar(100) DEFAULT NULL COMMENT '型号',
  `unit` varchar(12) DEFAULT NULL COMMENT '单位',
  `num` decimal(20,2) DEFAULT NULL COMMENT '数量',
  `price` decimal(20,2) DEFAULT NULL COMMENT '单价',
  `amt` decimal(20,2) DEFAULT NULL COMMENT '金额',
  `return_reason` varchar(256) DEFAULT NULL COMMENT '退货原因',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退货明细表';

/*Data for the table `sw_return_detail` */

/*Table structure for table `sw_stock_info` */

DROP TABLE IF EXISTS `sw_stock_info`;

CREATE TABLE `sw_stock_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `num` decimal(20,2) DEFAULT '0.00' COMMENT '有效数量',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='库存表';

/*Data for the table `sw_stock_info` */

/*Table structure for table `sw_stock_verify` */

DROP TABLE IF EXISTS `sw_stock_verify`;

CREATE TABLE `sw_stock_verify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `stk_in_no` varchar(32) DEFAULT NULL COMMENT '入库单编号',
  `source_type` varchar(32) DEFAULT NULL COMMENT '单据类型',
  `source_no` varchar(32) DEFAULT NULL COMMENT '来源单号',
  `source_seq_no` varchar(32) DEFAULT NULL COMMENT '来源单序号',
  `order_no` varchar(32) DEFAULT NULL COMMENT '单据编号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '单据序号',
  `supply_comp_no` varchar(32) DEFAULT NULL COMMENT '供货方编号',
  `supply_comp_name` varchar(128) DEFAULT NULL COMMENT '供货方名称',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `material_name` varchar(32) DEFAULT NULL COMMENT '物料名称',
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类',
  `spec` varchar(100) DEFAULT NULL COMMENT '规格',
  `pattern` varchar(100) DEFAULT NULL COMMENT '型号',
  `unit` varchar(12) DEFAULT NULL COMMENT '单位',
  `material_stock` varchar(32) DEFAULT NULL COMMENT '所属仓库',
  `num` decimal(20,2) DEFAULT NULL COMMENT '入库数量',
  `stand_num` decimal(20,2) DEFAULT NULL COMMENT '合格数量',
  `mois_rate` varchar(64) DEFAULT NULL COMMENT '含潮率',
  `weight` varchar(64) DEFAULT NULL COMMENT '重量',
  `quality` varchar(64) DEFAULT NULL COMMENT '品质',
  `status` varchar(32) DEFAULT NULL COMMENT '检测状态',
  `reason` varchar(100) DEFAULT NULL COMMENT '不合格原因',
  `refuse_type` varchar(32) DEFAULT NULL COMMENT '不合格后续操作',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='入库单校验信息表';

/*Data for the table `sw_stock_verify` */

/*Table structure for table `sw_work_detail` */

DROP TABLE IF EXISTS `sw_work_detail`;

CREATE TABLE `sw_work_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `work_no` varchar(32) DEFAULT NULL COMMENT '工时编号',
  `work_date` date DEFAULT NULL COMMENT '工作日期',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `order_seq_no` varchar(32) DEFAULT NULL COMMENT '订单序号',
  `user_no` varchar(32) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `step_no` varchar(32) DEFAULT NULL COMMENT '步骤编号',
  `step_name` varchar(64) DEFAULT NULL COMMENT '步骤流程',
  `process_no` varchar(32) DEFAULT NULL COMMENT '工艺编号',
  `process_name` varchar(64) DEFAULT NULL COMMENT '工艺名称',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `num` varchar(32) DEFAULT NULL COMMENT '数量',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工时详情表';

/*Data for the table `sw_work_detail` */

/*Table structure for table `sys_audit_config` */

DROP TABLE IF EXISTS `sys_audit_config`;

CREATE TABLE `sys_audit_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `audit_no` varchar(64) DEFAULT NULL COMMENT '审批配置编号=类型_动作_当前阶段',
  `audit_type` varchar(32) DEFAULT NULL COMMENT '审核类型',
  `audit_type_name` varchar(64) DEFAULT NULL COMMENT '审核类型名称',
  `audit_action` varchar(32) DEFAULT NULL COMMENT '审核动作',
  `audit_action_name` varchar(64) DEFAULT NULL COMMENT '审核动作名称',
  `current_stage` varchar(32) DEFAULT NULL COMMENT '当前阶段',
  `next_stage` varchar(32) DEFAULT NULL COMMENT '下一阶段',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='审核配置表';

/*Data for the table `sys_audit_config` */

insert  into `sys_audit_config`(`id`,`audit_no`,`audit_type`,`audit_type_name`,`audit_action`,`audit_action_name`,`current_stage`,`next_stage`,`create_time`,`modi_time`) values (1,'ORDER&APPLY&WAIT_APPLY','ORDER','订单审核','APPLY','发起申请','WAIT_APPLY','AUDIT01_SUCCESS','2017-10-25 16:08:34','2017-10-25 16:08:36'),(2,'ORDER&AUDIT_PASS&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_PASS','终审成功','AUDIT01_SUCCESS','AUDIT_SUCCESS','2017-10-25 16:11:12','2017-10-25 16:11:14'),(3,'ORDER&AUDIT_REFUSE&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_REFUSE','拒绝','AUDIT01_SUCCESS','WAIT_APPLY','2017-10-25 16:11:16','2017-10-25 16:13:28'),(4,'DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','2017-10-26 15:51:51','2017-10-26 15:51:53'),(5,'DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','2017-10-26 15:51:56','2017-10-26 15:51:58'),(6,'DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','2017-10-26 15:53:12','2017-10-26 15:53:13'),(7,'DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','2017-10-26 15:53:40','2017-10-26 15:53:42'),(8,'DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','终审拒绝','AUDIT01_SUCCESS','WAIT_APPLY','2017-10-26 15:54:46','2017-10-26 15:54:48'),(9,'DELIVER&CANCEL&WAIT_APPLY','DELIVER','发货单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','2017-10-26 15:55:55','2017-10-26 15:55:57'),(10,'PURCHASE&APPLY&WAIT_APPLY','PURCHASE','采购单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','2017-11-02 17:30:38','2017-11-02 17:30:38'),(11,'PURCHASE&AUDIT_PASS&WAIT_AUDIT','PURCHASE','采购单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','2017-11-02 17:30:38','2017-11-02 17:30:38'),(12,'PURCHASE&AUDIT_REFUSE&WAIT_AUDIT','PURCHASE','采购单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','2017-11-02 17:30:38','2017-11-02 17:30:38'),(13,'PURCHASE&AUDIT_PASS&AUDIT01_SUCCESS','PURCHASE','采购单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','2017-11-02 17:30:38','2017-11-02 17:30:38'),(14,'PURCHASE&AUDIT_REFUSE&WAIT_AUDIT','PURCHASE','采购单审核','AUDIT_REFUSE','终审拒绝','AUDIT01_SUCCESS','WAIT_APPLY','2017-11-02 17:30:38','2017-11-02 17:30:38'),(15,'PURCHASE&CANCEL&WAIT_APPLY','PURCHASE','采购单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','2017-11-02 17:30:38','2017-11-02 17:30:38'),(16,'RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','2017-11-06 19:38:01','2017-11-06 19:38:02'),(17,'RETURN&AUDIT_PASS&WAIT_AUDIT','RETURN','退货单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','AUDIT01_SUCCESS','2017-11-06 19:39:32','2017-11-06 19:39:36'),(18,'RETURN&AUDIT_REFUSE&WAIT_AUDIT','RETURN','退货单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','2017-11-06 19:42:34','2017-11-06 19:42:32'),(19,'RETURN&AUDIT_PASS&AUDIT01_SUCCESS','RETURN','退货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','2017-11-06 19:42:36','2017-11-06 19:42:31'),(20,'RETURN&AUDIT_REFUSE&WAIT_AUDIT','RETURN','退货单审核','AUDIT_REFUSE','终审拒绝','AUDIT01_SUCCESS','WAIT_APPLY','2017-11-06 19:42:38','2017-11-06 19:42:29'),(21,'RETURN&CANCEL&WAIT_APPLY','RETURN','退货单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','2017-11-06 19:42:26','2017-11-06 19:42:28'),(22,'STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','2017-11-10 14:24:38','2017-11-10 14:24:39'),(23,'ORDER&CANCEL&WAIT_APPLY','ORDER','订单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','2017-11-19 10:37:58','2017-11-19 10:38:01'),(24,'RECIEVE&APPLY&WAIT_APPLY','RECEIVE','领料单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT',NULL,NULL),(25,'RECIEVE&AUDIT_PASS&WAIT_AUDIT','RECEIVE','领料单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','AUDIT01_SUCCESS',NULL,NULL),(26,'RECIEVE&AUDIT_REFUSE&WAIT_AUDIT','RECEIVE','领料单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY',NULL,NULL),(27,'RECIEVE&AUDIT_PASS&AUDIT01_SUCCESS','RECEIVE','领料单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS',NULL,NULL),(28,'RECIEVE&AUDIT_REFUSE&WAIT_AUDIT','RECEIVE','领料单审核','AUDIT_REFUSE','终审拒绝','AUDIT01_SUCCESS','WAIT_APPLY',NULL,NULL),(29,'RECIEVE&CANCEL&WAIT_APPLY','RECEIVE','领料单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL',NULL,NULL);

/*Table structure for table `sys_audit_log` */

DROP TABLE IF EXISTS `sys_audit_log`;

CREATE TABLE `sys_audit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `source_no` varchar(64) DEFAULT NULL COMMENT '来源编号',
  `audit_no` varchar(64) DEFAULT NULL COMMENT '审核编号',
  `audit_type` varchar(32) DEFAULT NULL COMMENT '审核类型',
  `audit_type_name` varchar(64) DEFAULT NULL COMMENT '审核类型名称',
  `audit_action` varchar(32) DEFAULT NULL COMMENT '审核动作',
  `audit_action_name` varchar(64) DEFAULT NULL COMMENT '审核动作名称',
  `current_stage` varchar(32) DEFAULT NULL COMMENT '当前阶段',
  `next_stage` varchar(32) DEFAULT NULL COMMENT '下一阶段',
  `audit_user_no` varchar(32) DEFAULT NULL COMMENT '审核人编号',
  `audit_user_name` varchar(64) DEFAULT NULL COMMENT '审核人姓名',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_desc` varchar(128) DEFAULT NULL COMMENT '审核描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8 COMMENT='审核日志表';

/*Data for the table `sys_audit_log` */

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`dict_type`,`dict_code`,`dict_name`,`dict_value`,`dict_desc`,`fh_dict_code`,`memo`) values (1,'ORDER_TYPE','SIMPLE_ORDER','样品单','SIMPLE_ORDER','样品单','','订单类型'),(2,'ORDER_TYPE','NORMAL_ORDER','正常单','NORMAL_ORDER','正常单','','订单类型'),(3,'ORDER_TYPE','ADD_ORDER','补单','ADD_ORDER','补单','','订单类型'),(4,'ORDER_TYPE','GIFT_ORDER','赠品','GIFT_ORDER','赠品','','订单类型'),(5,'ORDER_TYPE','ENGIN_ORDER','工程单','ENGIN_ORDER','工程单','','订单类型'),(6,'SALE_TYPE','INNER_SALE','内销','INNER_SALE','内销','','销售类型'),(7,'SALE_TYPE','OUT_SALE','外销','OUT_SALE','外销','','销售类型'),(8,'MATERIAL_TYPE','PROD','成品布','PROD','成品布','','物料类型'),(9,'MATERIAL_TYPE','COTTON ','面料','COTTON ','面料','','物料类型'),(11,'PAY_WAY','TEL_PAY','电汇','TEL_PAY','电汇','','付款方式'),(12,'PAY_WAY','CASH','现金','CASH','现金','','付款方式'),(13,'PAY_WAY','CHEQUE','支票','CHEQUE','支票','','付款方式'),(14,'PAY_WAY','POS','POS','POS','POS','','付款方式'),(15,'ORDER_STATUS','WAIT_APPLY','待初审','WAIT_APPLY','待初审','','订单状态'),(16,'ORDER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功','','订单状态'),(17,'ORDER_STATUS','AUDIT_SUCCESS','终审成功','AUDIT_SUCCESS','终审成功','','订单状态'),(18,'ORDER_STATUS','ORDER_FINISH','订单结束','ORDER_FINISH','订单结束','','订单状态'),(19,'FORMULAR_TYPE','PROD','成品布公式','PROD','成品布公式',NULL,'公式类型'),(20,'FORMULAR_TYPE','COTTON ','面料公式','COTTON ','面料公式',NULL,'公式类型'),(21,'FORMULAR_TYPE','CRAFTS','工艺公式','CRAFTS','工艺公式',NULL,'公式类型'),(22,'MATERIAL_STOCK','PROD_STOCK','成品库','PROD_STOCK','成品库',NULL,'所属仓库'),(23,'MATERIAL_STOCK','COTTON_STOCK','面料库','COTTON_STOCK','面料库',NULL,'所属仓库'),(24,'REFUSE_TYPE','RETURN','退货','RETURN','退货',NULL,'校验不合格后续操作'),(25,'REFUSE_TYPE','BUJI','补给','BUJI','补给',NULL,'校验不合格后续操作'),(26,'REFUSE_TYPE','FANXIU','返修','FANXIU','返修',NULL,'校验不合格后续操作'),(27,'DELIVER_WAY','ZHOGNTONG','中通','ZHOGNTONG','中通',NULL,'运货方式'),(28,'DELIVER_WAY','SHENGONG','申通','SHENGONG','申通',NULL,'运货方式'),(29,'DELIVER_WAY','YUNDA','韵达','YUNDA','韵达',NULL,'运货方式'),(30,'DELIVER_WAY','YUANTONG','圆通','YUANTONG','圆通',NULL,'运货方式'),(31,'DELIVER_WAY','SHUNFENG','顺丰','SHUNFENG','顺丰',NULL,'运货方式'),(32,'ORDER_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'订单状态'),(33,'DELIVER_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'发货状态'),(34,'DELIVER_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'发货状态'),(35,'DELIVER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'发货状态'),(36,'DELIVER_STATUS','AUDIT_SUCCESS','已发货','AUDIT_SUCCESS','已发货',NULL,'发货状态'),(37,'DELIVER_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'发货状态'),(38,'PUR_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'采购状态'),(39,'PUR_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'采购状态'),(40,'PUR_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'采购状态'),(41,'PUR_STATUS','AUDIT_SUCCESS','已送货','AUDIT_SUCCESS','已送货',NULL,'采购状态'),(42,'PUR_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'采购状态'),(43,'RECV_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'领料状态'),(44,'RECV_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'领料状态'),(45,'RECV_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'领料状态'),(46,'RECV_STATUS','AUDIT_SUCCESS','已领料','AUDIT_SUCCESS','已领料',NULL,'领料状态'),(47,'RECV_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'领料状态'),(48,'RETURN_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'退货单状态'),(49,'RETURN_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'退货单状态'),(50,'RETURN_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'退货单状态'),(51,'RETURN_STATUS','AUDIT_SUCCESS','已退货','AUDIT_SUCCESS','已退货',NULL,'退货单状态'),(52,'RETURN_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'退货单状态'),(53,'VERIFY_STATUS','WAIT_VERIFY','等待校验','WAIT_VERIFY','等待校验',NULL,'校验状态'),(54,'VERIFY_STATUS','STOCK_FINISH','已校验','STOCK_FINISH','已校验',NULL,'校验状态');

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
  `level` int(11) DEFAULT NULL COMMENT '资源级别',
  `if_visible` char(1) DEFAULT 'Y' COMMENT '是否显示 Y:显示 N:不显示',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`source_no`,`source_name`,`fh_source_no`,`source_type`,`req_url`,`rsource_icon`,`sort_order`,`level`,`if_visible`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'order','业务订单',NULL,'MENU',NULL,NULL,1,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:40',0),(2,'purchase','采购管理',NULL,'MENU',NULL,NULL,2,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:09',0),(3,'produce','生产制造',NULL,'MENU',NULL,NULL,4,1,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:37:57',0),(4,'stock','仓库管理',NULL,'MENU',NULL,NULL,3,1,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:38:01',0),(5,'base','基础资料',NULL,'MENU',NULL,NULL,5,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:41',0),(6,'system','系统管理',NULL,'MENU',NULL,NULL,6,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:43',0),(7,'orderCreate','创建订单合同','order','MENU','/createOrder',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(8,'orderApply','订单初审','order','MENU','/orderApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(9,'orderAudit','订单终审','order','MENU','/orderAudit',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(10,'orderQuery','订单查询','order','MENU','/orderList',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(11,'deliverCreate','创建发货单','order','MENU','/deliverCreate',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(12,'deliverApply','发货单申请','order','MENU','/deliverApply',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 14:23:31',0),(14,'deliverQuery','发货单查询','order','MENU','/deliverList',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(15,'materialInfo','物料信息','base','MENU','/material',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(16,'formularInfo','公式信息','base','MENU','/formular',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(17,'compInfo','公司资料','base','MENU','/comp',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(18,'departInfo','部门信息','base','MENU','/depart',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(19,'dashboard','管理中心',NULL,'MENU','/dashboard',NULL,0,1,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(20,'purchaseCreate','采购单创建','purchase','MENU','/purchaseCreate',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(21,'purchaseApply','采购单申请','purchase','MENU','/purchaseApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(22,'purchaseAudit','采购单终审','purchase','MENU','/purchaseAudit',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:12',0),(23,'purchaseQuery','采购单查询','purchase','MENU','/purchaseQuery',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:13',0),(24,'returnCreate','退货单创建','purchase','MENU','/returnCreate',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:14',0),(25,'returnApply','退货单申请','purchase','MENU','/returnApply',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:16',0),(26,'returnAudit','退货单审核','purchase','MENU','/returnAudit',NULL,9,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:39:57',0),(27,'returnList','退货单查询','purchase','MENU','/returnList',NULL,10,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:40:01',0),(28,'stockVerify','入库校验','stock','MENU','/stockVerify',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(29,'stockVerifyQuery','校验记录查询','stock','MENU','/stockVerifyQuery',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(30,'stockQuery','库存查询','stock','MENU','/stockQuery',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(31,'receiveAudit','领料单终审','stock','MENU','/receiveAudit',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(32,'deliverAudit','发货单终审','stock','MENU','/deliverAudit',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(33,'receiveCreate','领料单创建','produce','MENU','/receiveCreate',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(34,'receiveApply','领料单申请','produce','MENU','/receiveApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(35,'receiveList','领料单查询','produce','MENU','/receiveList',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-12-19 15:07:12',0),(36,'workCreate','工时导入','produce','MENU','/workCreate',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:32:41',0),(37,'workQuery','工时查询','produce','MENU','/workQuery',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:32:48',0),(38,'deliverAudit01','发货单初审','order','MENU','/deliverAudit01',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 15:08:22',0),(39,'userManager','账户管理','system','MENU','/userManager',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:48',0),(40,'roleInfo','角色信息','system','MENU','/roleInfo',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:49',0),(41,'rolePermit','角色权限','system','MENU','/rolePermit',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:50',0),(42,'purchaseAudit01','采购单初审','purchase','MENU','/purchaseAudit01',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:30',0),(43,'returnAudit01','退货单初审','purchase','MENU','/returnAudit01',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:40:05',0),(44,'receiveAudit01','领料单初审','produce','MENU','/receiveAudit01',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:33:13',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_code`,`role_name`,`status`,`if_admin`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','超级管理员','Y','Y',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-30 14:12:31',0),(2,'busi','业务员','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-30 14:12:31',0),(3,'phurchase','采购员','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-23 17:08:50',0),(4,'produceManger','生产主管','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-23 17:08:50',0),(5,'producer','生产员工','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-23 17:08:50',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=295 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`id`,`role_code`,`source_no`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (252,'admin','order',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(253,'admin','purchase',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(254,'admin','produce',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(255,'admin','stock',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(256,'admin','base',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(257,'admin','system',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(258,'admin','orderCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(259,'admin','orderApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(260,'admin','orderAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(261,'admin','orderQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(262,'admin','deliverCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(263,'admin','deliverApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(264,'admin','deliverQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(265,'admin','materialInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(266,'admin','formularInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(267,'admin','compInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(268,'admin','departInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(269,'admin','dashboard',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(270,'admin','purchaseCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(271,'admin','purchaseApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(272,'admin','purchaseAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(273,'admin','purchaseQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(274,'admin','returnCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(275,'admin','returnApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(276,'admin','returnAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(277,'admin','returnList',NULL,NULL,NULL,'2017-12-10 16:50:08',0),(278,'admin','stockVerify',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(279,'admin','stockVerifyQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(280,'admin','stockQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(281,'admin','receiveAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(282,'admin','deliverAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(283,'admin','receiveCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(284,'admin','receiveApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(285,'admin','receiveList',NULL,NULL,NULL,'2017-12-10 17:33:45',0),(286,'admin','workCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(287,'admin','workQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(288,'admin','deliverAudit01',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(289,'admin','userManager',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(290,'admin','roleInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(291,'admin','rolePermit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(292,'admin','purchaseAudit01',NULL,NULL,NULL,'2017-12-05 22:14:14',0),(293,'admin','returnAudit01',NULL,NULL,NULL,'2017-12-10 16:33:20',0),(294,'admin','receiveAudit01',NULL,NULL,NULL,'2017-12-10 17:34:02',0);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `phone_num` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email_addr` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(128) DEFAULT NULL COMMENT '登录密码',
  `status` char(1) DEFAULT 'Y' COMMENT '状态 Y:有效 N:无效',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_userNo` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_no`,`user_name`,`nick_name`,`phone_num`,`email_addr`,`password`,`status`,`memo`,`last_login_time`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (11,'wangfangfang','王芳芳','王芳芳','15166119377','XXX@qq.com','e10adc3949ba59abbe56e057f20f883e','Y','test',NULL,'system','2017-10-20 11:14:18','system','2017-10-30 11:24:50',0),(13,'admin','管理员','管理员','15222222876','XXX@qq.com','e10adc3949ba59abbe56e057f20f883e','Y','test',NULL,'system','2017-10-20 11:14:34','system','2017-12-09 15:20:53',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_no`,`role_code`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','admin',NULL,'2017-10-30 14:13:00',NULL,'2017-10-30 14:13:02',0),(2,'wangfangfang','admin',NULL,'2017-10-30 14:13:02',NULL,'2017-11-19 11:14:10',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

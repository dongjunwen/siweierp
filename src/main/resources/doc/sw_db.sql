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

insert  into `sw_company_info`(`id`,`comp_no`,`comp_name`,`contact_name`,`mobile`,`telphone`,`tax`,`email`,`addr`,`is_self`,`is_valid`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'XXXhjjjj','艾弗森的','齐威王','1233444','12122112','1221','1221','12122222222222','N','N',NULL,'system','2017-10-20 15:41:10','system','2017-10-20 15:41:10',0),(2,'aaaaaa','艾弗森的','齐威王','1233444','12122112','1221','1221','12122222222222','N','N',NULL,'system','2017-10-20 15:44:33','system','2017-10-20 15:44:33',0),(3,'asd','艾弗森的','齐威王','1233444','12122112','1221','1221','12122222222222','N','N',NULL,'system','2017-10-20 15:44:39','system','2017-10-20 15:44:39',0),(4,'asd12','艾弗森的','齐威王','1233444','12122112','1221','1221','12122222222222','N','N',NULL,'system','2017-10-20 15:44:44','system','2017-10-20 15:44:44',0),(5,'XXXx1122222','XX实业科技有限公司','张三','12333','1','111','XX@qq.com','广兰路','N','N',NULL,'system','2017-10-20 16:36:20','system','2017-10-20 16:36:20',0),(6,'XXXx1121222','XX实业科技有限公司','张三','12333','1','111','XX@qq.com','广兰路','N','N',NULL,'system','2017-10-20 16:36:30','system','2017-10-20 16:36:30',0),(7,'XXXx11212333','XX实业科技有限公司','张三','12333','1','111','XX@qq.com','广兰路','N','N',NULL,'system','2017-10-20 16:36:35','system','2017-10-20 16:36:35',0);

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
  `cust_phone` varchar(16) DEFAULT NULL COMMENT '客户电话',
  `cust_tax` varchar(16) DEFAULT NULL COMMENT '客户传真',
  `cust_addr` varchar(256) DEFAULT NULL COMMENT '客户地址',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='发货单总表';

/*Data for the table `sw_deliver_base` */

insert  into `sw_deliver_base`(`id`,`deilver_no`,`deilver_date`,`deilver_way`,`send_name`,`if_gurant`,`deilver_status`,`memo`,`cust_comp_no`,`cust_comp_name`,`cust_contact_name`,`cust_mobile`,`cust_phone`,`cust_tax`,`cust_addr`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (2,'F-20171026154553-22138','2017-10-26','shunfeng','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:45:53','admin','2017-10-26 16:09:36',2),(3,'F-20171026154711-55147','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:11','admin','2017-10-26 16:05:52',0),(4,'F-20171026154714-06687','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:14','admin','2017-10-26 16:05:53',0),(5,'F-20171026154714-91297','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:14','admin','2017-10-26 16:05:53',0),(6,'F-20171026154714-96550','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-10-26 16:05:54',0),(7,'F-20171026154714-53180','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-10-26 16:05:54',0),(8,'F-20171026154714-96068','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-10-26 16:05:55',0),(9,'F-20171026154715-71237','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-10-26 16:05:55',0),(10,'F-20171026154715-56910','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-10-26 16:05:56',0),(11,'F-20171026154715-02658','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-10-26 16:05:56',0),(12,'F-20171026154715-05630','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-10-26 16:05:57',0),(13,'F-20171026154715-81678','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-10-26 16:05:57',0),(14,'F-20171026154715-77046','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-10-26 16:05:58',0),(15,'F-20171026154716-07382','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-10-26 16:05:58',0),(16,'F-20171026154716-82480','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-10-26 16:05:59',0),(17,'F-20171026154716-25468','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-10-26 16:05:59',0),(18,'F-20171026154716-65105','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:17','admin','2017-10-26 16:06:00',0),(19,'F-20171026154716-62065','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:17','admin','2017-10-26 16:06:00',0),(20,'F-20171026154716-27297','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:17','admin','2017-10-26 16:06:01',0),(21,'F-20171026155944-36948','2017-10-26','shunfeng','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='发货单明细表';

/*Data for the table `sw_deliver_detail` */

insert  into `sw_deliver_detail`(`id`,`deilver_no`,`deilver_seq_no`,`order_no`,`order_seq_no`,`box_no`,`prod_no`,`prod_name`,`prod_type`,`prod_form`,`prod_long`,`prod_width`,`prod_num`,`prod_price`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'F-20171026154553-22138','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:45:53','admin','2017-10-26 15:45:53',NULL),(2,'F-20171026154711-55147','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:11','admin','2017-10-26 15:47:11',NULL),(3,'F-20171026154711-55147','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:11','admin','2017-10-26 15:47:11',NULL),(4,'F-20171026154711-55147','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:11','admin','2017-10-26 15:47:11',NULL),(5,'F-20171026154714-06687','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(6,'F-20171026154714-06687','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(7,'F-20171026154714-06687','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(8,'F-20171026154714-91297','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(9,'F-20171026154714-91297','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(10,'F-20171026154714-91297','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(11,'F-20171026154714-96550','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(12,'F-20171026154714-96550','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(13,'F-20171026154714-96550','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(14,'F-20171026154714-53180','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(15,'F-20171026154714-53180','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(16,'F-20171026154714-53180','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(17,'F-20171026154714-96068','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(18,'F-20171026154714-96068','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(19,'F-20171026154714-96068','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(20,'F-20171026154715-71237','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(21,'F-20171026154715-71237','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(22,'F-20171026154715-71237','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(23,'F-20171026154715-56910','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(24,'F-20171026154715-56910','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(25,'F-20171026154715-56910','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(26,'F-20171026154715-02658','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(27,'F-20171026154715-02658','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(28,'F-20171026154715-02658','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(29,'F-20171026154715-05630','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(30,'F-20171026154715-05630','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(31,'F-20171026154715-05630','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(32,'F-20171026154715-81678','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(33,'F-20171026154715-81678','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(34,'F-20171026154715-81678','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(35,'F-20171026154715-77046','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(36,'F-20171026154715-77046','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(37,'F-20171026154715-77046','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(38,'F-20171026154716-07382','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(39,'F-20171026154716-07382','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(40,'F-20171026154716-07382','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(41,'F-20171026154716-82480','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(42,'F-20171026154716-82480','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(43,'F-20171026154716-82480','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(44,'F-20171026154716-25468','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(45,'F-20171026154716-25468','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(46,'F-20171026154716-25468','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(47,'F-20171026154716-65105','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(48,'F-20171026154716-65105','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(49,'F-20171026154716-65105','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(50,'F-20171026154716-62065','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(51,'F-20171026154716-62065','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(52,'F-20171026154716-62065','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(53,'F-20171026154716-27297','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(54,'F-20171026154716-27297','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(55,'F-20171026154716-27297','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(56,'F-20171026155944-36948','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0),(57,'F-20171026155944-36948','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0),(58,'F-20171026155944-36948','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0);

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
  `material_type` varchar(32) DEFAULT NULL COMMENT '物料分类 SYS_DICT中的MATERIAL_TYPE',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='物料信息表';

/*Data for the table `sw_material_info` */

insert  into `sw_material_info`(`id`,`material_no`,`material_name`,`material_type`,`spec`,`pattern`,`unit`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'TBYD','圆底台布','PROD','超棉文艺复兴','圆','米','string','admin','2017-10-24 14:41:09','admin','2017-10-24 14:43:06',0),(2,'KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','string','admin','2017-10-24 14:41:57','admin','2017-10-24 14:43:08',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='订单总表';

/*Data for the table `sw_order_base` */

insert  into `sw_order_base`(`id`,`order_no`,`order_date`,`pay_way`,`good_date`,`finish_date`,`order_type`,`sale_type`,`order_status`,`memo`,`cust_comp_no`,`cust_comp_name`,`cust_contact_name`,`cust_mobile`,`custt_phone`,`cust_tax`,`cust_addr`,`supply_comp_no`,`supply_comp_name`,`supply_contact_name`,`supply_mobile`,`supply_phone`,`supply_tax`,`supply_addr`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (80,'D-20171025142941-01700','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','AUDIT_SUCCESS','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:42','string','2017-10-25 17:51:34',NULL),(81,'D-20171025142942-34918','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(82,'D-20171025142942-17265','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(83,'D-20171025142942-03027','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(84,'D-20171025142942-13612','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(85,'D-20171025142942-84467','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(86,'D-20171025142943-90935','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(87,'D-20171025142943-77480','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(88,'D-20171025142943-01443','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(89,'D-20171025142943-31701','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(90,'D-20171025142943-20706','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(91,'D-20171025142943-75119','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(92,'D-20171025142944-52321','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(93,'D-20171025142944-77057','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(94,'D-20171025142944-64124','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_AUDIT','喂喂喂','001','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8 COMMENT='订单详情表';

/*Data for the table `sw_order_detail` */

insert  into `sw_order_detail`(`id`,`order_no`,`order_seq_no`,`prod_no`,`prod_name`,`prod_type`,`prod_form`,`prod_long`,`prod_width`,`prod_num`,`prod_unit`,`prod_price_no`,`prod_price_express`,`prod_price`,`prod_amt`,`area`,`material_no`,`material_name`,`material_width`,`material_price_no`,`material_price_express`,`material_num`,`material_price`,`tech_no`,`tech_name`,`tech_price`,`tech_price_express`,`memo`,`prod_price1`,`if_prod`,`cate_type`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (148,'D-20171025142941-01700','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(149,'D-20171025142941-01700','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(150,'D-20171025142942-34918','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(151,'D-20171025142942-34918','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(152,'D-20171025142942-17265','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(153,'D-20171025142942-17265','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-10-25 14:29:42',NULL),(154,'D-20171025142942-03027','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(155,'D-20171025142942-03027','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(156,'D-20171025142942-13612','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(157,'D-20171025142942-13612','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(158,'D-20171025142942-84467','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(159,'D-20171025142942-84467','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(160,'D-20171025142943-90935','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(161,'D-20171025142943-90935','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(162,'D-20171025142943-77480','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(163,'D-20171025142943-77480','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(164,'D-20171025142943-01443','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(165,'D-20171025142943-01443','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-10-25 14:29:43',NULL),(166,'D-20171025142943-31701','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(167,'D-20171025142943-31701','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(168,'D-20171025142943-20706','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(169,'D-20171025142943-20706','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(170,'D-20171025142943-75119','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(171,'D-20171025142943-75119','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(172,'D-20171025142944-52321','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(173,'D-20171025142944-52321','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(174,'D-20171025142944-77057','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(175,'D-20171025142944-77057','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(176,'D-20171025142944-64124','1','sdddxxx','台布','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL),(177,'D-20171025142944-64124','2','dfdfdf','dfdfd','df','ddd','10.00','0.00','0.00','米','df','df','0.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf','33434','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-10-25 14:29:44',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='审核配置表';

/*Data for the table `sys_audit_config` */

insert  into `sys_audit_config`(`id`,`audit_no`,`audit_type`,`audit_type_name`,`audit_action`,`audit_action_name`,`current_stage`,`next_stage`,`create_time`,`modi_time`) values (1,'ORDER&AUDIT_PASS&WAIT_AUDIT','ORDER','订单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','2017-10-25 16:08:34','2017-10-25 16:08:36'),(2,'ORDER&AUDIT_PASS&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_PASS','终审成功','AUDIT01_SUCCESS','AUDIT_SUCCESS','2017-10-25 16:11:12','2017-10-25 16:11:14'),(3,'ORDER&AUDIT_REFUSE&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_REFUSE','拒绝','AUDIT01_SUCCESS','WAIT_AUDIT','2017-10-25 16:11:16','2017-10-25 16:13:28'),(4,'DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','2017-10-26 15:51:51','2017-10-26 15:51:53'),(5,'DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','2017-10-26 15:51:56','2017-10-26 15:51:58'),(6,'DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','2017-10-26 15:53:12','2017-10-26 15:53:13'),(7,'DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','2017-10-26 15:53:40','2017-10-26 15:53:42'),(8,'DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','终审拒绝','AUDIT01_SUCCESS','WAIT_APPLY','2017-10-26 15:54:46','2017-10-26 15:54:48'),(9,'DELIVER&CANCEL&WAIT_APPLY','DELIVER','发货单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','2017-10-26 15:55:55','2017-10-26 15:55:57');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='审核日志表';

/*Data for the table `sys_audit_log` */

insert  into `sys_audit_log`(`id`,`source_no`,`audit_no`,`audit_type`,`audit_type_name`,`audit_action`,`audit_action_name`,`current_stage`,`next_stage`,`audit_user_no`,`audit_user_name`,`audit_time`,`audit_desc`) values (1,'D-20171025142941-01700','ORDER&AUDIT_PASS&WAIT_AUDIT','ORDER','订单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','string','string','2017-10-25 17:50:53','测试'),(2,'D-20171025142941-01700','ORDER&AUDIT_PASS&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_PASS','终审成功','AUDIT01_SUCCESS','AUDIT_SUCCESS','string','string','2017-10-25 17:51:34','测试'),(3,'F-20171026154553-22138','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin',NULL,'2017-10-26 16:05:05','测试'),(4,'F-20171026154553-22138','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin',NULL,'2017-10-26 16:08:28','测试'),(5,'F-20171026154553-22138','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin',NULL,'2017-10-26 16:09:36','测试');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`dict_type`,`dict_code`,`dict_name`,`dict_value`,`dict_desc`,`fh_dict_code`,`memo`) values (1,'ORDER_TYPE','SIMPLE_ORDER','样品单','SIMPLE_ORDER','样品单','','订单类型'),(2,'ORDER_TYPE','NORMAL_ORDER','正常单','NORMAL_ORDER','正常单','','订单类型'),(3,'ORDER_TYPE','ADD_ORDER','补单','ADD_ORDER','补单','','订单类型'),(4,'ORDER_TYPE','GIFT_ORDER','赠品','GIFT_ORDER','赠品','','订单类型'),(5,'ORDER_TYPE','ENGIN_ORDER','工程单','ENGIN_ORDER','工程单','','订单类型'),(6,'SALE_TYPE','INNER_SALE','内销','INNER_SALE','内销','','销售类型'),(7,'SALE_TYPE','OUT_SALE','外销','OUT_SALE','外销','','销售类型'),(8,'MATERIAL_TYPE','PROD','成品布','PROD','成品布','','物料类型'),(9,'MATERIAL_TYPE','COTTON ','面料','COTTON ','面料','','物料类型'),(10,'MATERIAL_TYPE','CRAFTS','工艺','CRAFTS','工艺','','物料类型'),(11,'PAY_WAY','TEL_PAY','电汇','TEL_PAY','电汇','','付款方式'),(12,'PAY_WAY','CASH','现金','CASH','现金','','付款方式'),(13,'PAY_WAY','CHEQUE','支票','CHEQUE','支票','','付款方式'),(14,'PAY_WAY','POS','POS','POS','POS','','付款方式'),(15,'ORDER_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审','','订单状态'),(16,'ORDER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功','','订单状态'),(17,'ORDER_STATUS','AUDIT_SUCCESS','终审成功','AUDIT_SUCCESS','终审成功','','订单状态'),(18,'ORDER_STATUS','ORDER_FINISH','订单结束','ORDER_FINISH','订单结束','','订单状态');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`source_no`,`source_name`,`fh_source_no`,`source_type`,`req_url`,`rsource_icon`,`sort_order`,`level`,`if_visible`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'order','业务订单',NULL,'MENU',NULL,NULL,1,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:40',0),(2,'stock','仓采管理',NULL,'MENU',NULL,NULL,2,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:40',0),(3,'produce','生产制造',NULL,'MENU',NULL,NULL,4,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:41',0),(4,'coloring','染色管理',NULL,'MENU',NULL,NULL,5,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:42',0),(5,'base','基础资料',NULL,'MENU',NULL,NULL,6,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:42',0),(6,'system','系统管理',NULL,'MENU',NULL,NULL,7,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:43',0),(7,'orderCreate','创建订单合同','order','MENU','XXXX',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:44',0),(8,'orderAudit01','订单初审','order','MENU','XXXX',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:45',0),(9,'orderAudit02','订单终审','order','MENU','XXXX',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:45',0),(10,'orderQuery','订单查询','order','MENU','XXXX',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:46',0),(11,'deliverCreate','创建发货单','order','MENU','XXXX',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:46',0),(12,'deliverAudit01','发货单初审','order','MENU','XXXX',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:47',0),(13,'deliverAudit02','发货单终审','order','MENU','XXXX',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:47',0),(14,'deliverQuery','发货单查询','order','MENU','XXXX',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:48',0),(15,'materialInfo','物料信息','base','MENU','XXXX',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:48',0),(16,'formularInfo','公式信息','base','MENU','XXXX',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:49',0),(17,'compInfo','公司资料','base','MENU','XXXX',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:49',0),(18,'departInfo','部门信息','base','MENU','XXXX',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:50',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_code`,`role_name`,`status`,`if_admin`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','超级管理员','Y','Y',NULL,NULL,NULL,NULL,'2017-10-23 17:08:50',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`id`,`role_code`,`source_no`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','order',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(2,'admin','stock',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(3,'admin','produce',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(4,'admin','coloring',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(5,'admin','base',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(6,'admin','system',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(7,'admin','orderCreate',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(8,'admin','orderAudit01',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(9,'admin','orderAudit02',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(10,'admin','orderQuery',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(11,'admin','deliverCreate',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(12,'admin','deliverAudit01',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(13,'admin','deliverAudit02',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(14,'admin','deliverQuery',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(15,'admin','materialInfo',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(16,'admin','formularInfo',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(17,'admin','compInfo',NULL,NULL,NULL,'2017-10-23 17:10:39',0),(18,'admin','departInfo',NULL,NULL,NULL,'2017-10-23 17:10:39',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_no`,`user_name`,`nick_name`,`phone_num`,`email_addr`,`password`,`status`,`memo`,`last_login_time`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (11,'zhangsan1',NULL,'张三',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:14:18','system','2017-10-20 11:14:18',0),(12,'zhangsan',NULL,'张三',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:14:26','system','2017-10-20 11:14:26',0),(13,'admin',NULL,'管理员',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:14:34','system','2017-10-20 11:14:34',0),(14,'admin1',NULL,'管理员1',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:14:40','system','2017-10-20 11:14:40',0),(15,'admin2',NULL,'管理员2',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:14:45','system','2017-10-20 11:14:45',0),(16,'admin3',NULL,'管理员3',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:14:51','system','2017-10-20 11:14:51',0),(17,'admin4',NULL,'管理员4',15222222,'XXX@qq.com','e10adc3949ba59abbe56e057f20f883e',NULL,'test',NULL,'system','2017-10-20 11:16:59','system','2017-10-20 11:16:59',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_no`,`role_code`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','admin',NULL,NULL,NULL,'2017-10-23 17:11:40',0);

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

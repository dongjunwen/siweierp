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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='发货单总表';

/*Data for the table `sw_deliver_base` */

insert  into `sw_deliver_base`(`id`,`deliver_no`,`deliver_date`,`deliver_way`,`send_name`,`if_gurant`,`deliver_status`,`memo`,`cust_comp_no`,`cust_comp_name`,`cust_contact_name`,`cust_mobile`,`cust_phone`,`cust_tax`,`cust_addr`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (2,'F-20171026154553-22138','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:45:53','admin','2017-11-19 10:47:49',2),(3,'F-20171026154711-55147','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:11','admin','2017-12-09 16:29:27',3),(4,'F-20171026154714-06687','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:14','admin','2017-12-09 16:29:27',3),(5,'F-20171026154714-91297','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:14','admin','2017-12-09 16:29:33',3),(6,'F-20171026154714-96550','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-12-09 16:29:33',3),(7,'F-20171026154714-53180','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-12-10 17:39:08',3),(8,'F-20171026154714-96068','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-12-10 17:39:08',3),(9,'F-20171026154715-71237','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT01_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-12-09 16:27:22',2),(10,'F-20171026154715-56910','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT01_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-12-09 16:27:22',2),(11,'F-20171026154715-02658','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT01_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:15','admin','2017-12-09 16:27:22',2),(12,'F-20171026154715-05630','2017-10-26','SHUNFENG','ssssssss','Y','AUDIT01_SUCCESS','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-12-09 16:27:22',2),(13,'F-20171026154715-81678','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','wangfangfang','2017-12-10 11:34:58',2),(14,'F-20171026154715-77046','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','wangfangfang','2017-12-10 11:35:48',2),(15,'F-20171026154716-07382','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_APPLY','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','wangfangfang','2017-12-10 11:48:34',2),(16,'F-20171026154716-82480','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_AUDIT','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-12-09 16:20:39',1),(17,'F-20171026154716-25468','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_AUDIT','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:16','admin','2017-12-09 16:20:39',1),(18,'F-20171026154716-65105','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_AUDIT','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:17','admin','2017-12-09 16:20:39',1),(19,'F-20171026154716-62065','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_AUDIT','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:17','admin','2017-12-09 16:20:39',1),(20,'F-20171026154716-27297','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_AUDIT','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:47:17','admin','2017-12-09 16:20:39',1),(21,'F-20171026155944-36948','2017-10-26','SHUNFENG','ssssssss','Y','WAIT_AUDIT','ssssssss','乎001','XX科技有限公司','张三','125666666',NULL,'33333','上海张江科技园','admin','2017-10-26 15:59:45','admin','2017-12-09 16:20:39',1),(22,'F-20171209162027-04330','2017-12-09','ZHOGNTONG',NULL,'N','WAIT_AUDIT',NULL,NULL,'BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','admin','2017-12-09 16:20:27','admin','2017-12-09 16:20:39',1),(23,'F-20171209210152-33286','2017-12-09','ZHOGNTONG','ddfadsf','N','WAIT_APPLY',NULL,NULL,'BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(24,'F-20171210112231-93177','2017-12-10','ZHOGNTONG',NULL,'N','WAIT_APPLY',NULL,NULL,'BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','admin','2017-12-10 11:22:31','admin','2017-12-10 11:22:31',0),(25,'F-20171210112323-34701','2017-12-10','ZHOGNTONG','管理员测试','N','WAIT_APPLY',NULL,NULL,'BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','admin','2017-12-10 11:23:24','admin','2017-12-10 11:23:24',0),(26,'F-20171210122347-28412','2017-12-10','ZHOGNTONG','填写','N','WAIT_APPLY',NULL,NULL,'BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','wangfangfang','2017-12-10 12:23:48','wangfangfang','2017-12-10 12:50:40',0),(27,'F-20171210142907-78186','2017-12-10','ZHOGNTONG',NULL,'N','WAIT_APPLY',NULL,NULL,'BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','wangfangfang','2017-12-10 14:29:08','wangfangfang','2017-12-10 14:29:08',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='发货单明细表';

/*Data for the table `sw_deliver_detail` */

insert  into `sw_deliver_detail`(`id`,`deliver_no`,`deliver_seq_no`,`order_no`,`order_seq_no`,`box_no`,`prod_no`,`prod_name`,`prod_type`,`prod_form`,`prod_long`,`prod_width`,`prod_num`,`prod_price`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'F-20171026154553-22138','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:45:53','admin','2017-10-26 15:45:53',NULL),(2,'F-20171026154711-55147','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:11','admin','2017-10-26 15:47:11',NULL),(3,'F-20171026154711-55147','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:11','admin','2017-10-26 15:47:11',NULL),(4,'F-20171026154711-55147','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:11','admin','2017-10-26 15:47:11',NULL),(5,'F-20171026154714-06687','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(6,'F-20171026154714-06687','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(7,'F-20171026154714-06687','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(8,'F-20171026154714-91297','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(9,'F-20171026154714-91297','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(10,'F-20171026154714-91297','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:14','admin','2017-10-26 15:47:14',NULL),(11,'F-20171026154714-96550','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(12,'F-20171026154714-96550','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(13,'F-20171026154714-96550','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(14,'F-20171026154714-53180','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(15,'F-20171026154714-53180','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(16,'F-20171026154714-53180','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(17,'F-20171026154714-96068','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(18,'F-20171026154714-96068','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(19,'F-20171026154714-96068','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(20,'F-20171026154715-71237','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(21,'F-20171026154715-71237','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(22,'F-20171026154715-71237','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(23,'F-20171026154715-56910','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(24,'F-20171026154715-56910','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(25,'F-20171026154715-56910','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(26,'F-20171026154715-02658','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(27,'F-20171026154715-02658','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(28,'F-20171026154715-02658','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:15','admin','2017-10-26 15:47:15',NULL),(29,'F-20171026154715-05630','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(30,'F-20171026154715-05630','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(31,'F-20171026154715-05630','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(32,'F-20171026154715-81678','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(33,'F-20171026154715-81678','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(34,'F-20171026154715-81678','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(35,'F-20171026154715-77046','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(36,'F-20171026154715-77046','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(37,'F-20171026154715-77046','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(38,'F-20171026154716-07382','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(39,'F-20171026154716-07382','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(40,'F-20171026154716-07382','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(41,'F-20171026154716-82480','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(42,'F-20171026154716-82480','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(43,'F-20171026154716-82480','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(44,'F-20171026154716-25468','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(45,'F-20171026154716-25468','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(46,'F-20171026154716-25468','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:16','admin','2017-10-26 15:47:16',NULL),(47,'F-20171026154716-65105','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(48,'F-20171026154716-65105','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(49,'F-20171026154716-65105','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(50,'F-20171026154716-62065','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(51,'F-20171026154716-62065','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(52,'F-20171026154716-62065','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(53,'F-20171026154716-27297','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(54,'F-20171026154716-27297','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(55,'F-20171026154716-27297','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:47:17','admin','2017-10-26 15:47:17',NULL),(56,'F-20171026155944-36948','1','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0),(57,'F-20171026155944-36948','2','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0),(58,'F-20171026155944-36948','3','x222222222222','1','444','eeeeeeeeeee','eeeeeeeeee','ddddddddddd','2222','0.00','0.00','0.00','0.00','2222','admin','2017-10-26 15:59:45','admin','2017-10-26 15:59:45',0),(59,'F-20171209162027-04330',NULL,'D-20171025142941-01700','1',NULL,'sdddxxx','台布','df','ddd','10.00','3.00','148.00','0.00','ddfdf','admin','2017-12-09 16:20:27','admin','2017-12-09 16:20:27',0),(60,'F-20171209162027-04330',NULL,'D-20171025142941-01700','2',NULL,'dfdfdf','dfdfd','df','ddd','10.00','3.00','149.00','0.00','ddfdf','admin','2017-12-09 16:20:27','admin','2017-12-09 16:20:27',0),(61,'F-20171209210152-33286',NULL,'D-20171025142941-01700','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','148.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(62,'F-20171209210152-33286',NULL,'D-20171025142941-01700','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','149.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(63,'F-20171209210152-33286',NULL,'D-20171025142942-34918','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','150.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(64,'F-20171209210152-33286',NULL,'D-20171025142942-34918','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','151.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(65,'F-20171209210152-33286',NULL,'D-20171025142942-17265','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','152.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(66,'F-20171209210152-33286',NULL,'D-20171025142942-17265','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','153.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(67,'F-20171209210152-33286',NULL,'D-20171025142942-03027','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','154.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(68,'F-20171209210152-33286',NULL,'D-20171025142942-03027','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','155.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(69,'F-20171209210152-33286',NULL,'D-20171025142942-13612','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','156.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(70,'F-20171209210152-33286',NULL,'D-20171025142942-13612','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','157.00','100.00','ddfdf','wangfangfang','2017-12-09 21:01:52','wangfangfang','2017-12-09 21:01:52',0),(71,'F-20171210112231-93177','1','D-20171025142941-01700','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','148.00','100.00','ddfdf','admin','2017-12-10 11:22:31','admin','2017-12-10 11:22:31',0),(72,'F-20171210112231-93177','2','D-20171025142941-01700','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','149.00','100.00','ddfdf','admin','2017-12-10 11:22:31','admin','2017-12-10 11:22:31',0),(73,'F-20171210112323-34701','1','D-20171025142941-01700','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','148.00','100.00','ddfdf','admin','2017-12-10 11:23:24','admin','2017-12-10 11:23:24',0),(74,'F-20171210112323-34701','2','D-20171025142941-01700','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','149.00','100.00','ddfdf','admin','2017-12-10 11:23:24','admin','2017-12-10 11:23:24',0),(78,'F-20171210122347-28412','1','D-20171025142941-01700','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','1.00','100.00','ddfdf','wangfangfang','2017-12-10 12:50:40','wangfangfang','2017-12-10 12:50:40',NULL),(79,'F-20171210122347-28412','2','D-20171025142942-34918','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','2.00','100.00','ddfdf','wangfangfang','2017-12-10 12:50:40','wangfangfang','2017-12-10 12:50:40',NULL),(80,'F-20171210122347-28412','3','D-20171025142942-34918','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','3.00','100.00','ddfdf','wangfangfang','2017-12-10 12:50:40','wangfangfang','2017-12-10 12:50:40',NULL),(81,'F-20171210122347-28412','4','D-20171025142942-34918','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','4.00','100.00','ddfdf','wangfangfang','2017-12-10 12:50:40','wangfangfang','2017-12-10 12:50:40',NULL),(82,'F-20171210122347-28412','5','D-20171025142942-34918','2',NULL,'dfdfdf','dfdfd','df','圆','10.00','3.00','5.00','100.00','ddfdf','wangfangfang','2017-12-10 12:50:40','wangfangfang','2017-12-10 12:50:40',NULL),(83,'F-20171210142907-78186','1','D-20171025142941-01700','1',NULL,'sdddxxx','台布','df','圆','10.00','3.00','23.00','100.00','ddfdf','wangfangfang','2017-12-10 14:29:08','wangfangfang','2017-12-10 14:29:08',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='订单总表';

/*Data for the table `sw_order_base` */

insert  into `sw_order_base`(`id`,`order_no`,`order_date`,`pay_way`,`good_date`,`finish_date`,`order_type`,`sale_type`,`order_status`,`memo`,`cust_comp_no`,`cust_comp_name`,`cust_contact_name`,`cust_mobile`,`cust_phone`,`cust_tax`,`cust_addr`,`supply_comp_no`,`supply_comp_name`,`supply_contact_name`,`supply_mobile`,`supply_phone`,`supply_tax`,`supply_addr`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (80,'D-20171025142941-01700','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','AUDIT_SUCCESS','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:42','admin','2017-12-09 16:16:19',NULL),(81,'D-20171025142942-34918','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','HAS_CANCEL','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:42','admin','2017-12-09 16:16:19',NULL),(82,'D-20171025142942-17265','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','AUDIT_SUCCESS','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:42','admin','2017-12-10 11:21:49',NULL),(83,'D-20171025142942-03027','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','AUDIT_SUCCESS','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-12-10 11:21:52',NULL),(84,'D-20171025142942-13612','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-12-09 16:16:19',NULL),(85,'D-20171025142942-84467','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-12-09 16:16:19',NULL),(86,'D-20171025142943-90935','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-12-09 16:16:19',NULL),(87,'D-20171025142943-77480','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-12-09 16:16:19',NULL),(88,'D-20171025142943-01443','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:43','admin','2017-12-09 16:16:19',NULL),(89,'D-20171025142943-31701','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-12-09 16:16:19',NULL),(90,'D-20171025142943-20706','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','wangfangfang','2017-12-10 13:08:00',NULL),(91,'D-20171025142943-75119','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-12-09 16:16:19',NULL),(92,'D-20171025142944-52321','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-12-09 16:16:19',NULL),(93,'D-20171025142944-77057','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-12-09 16:16:19',NULL),(94,'D-20171025142944-64124','2017-10-25','TEL_PAY','2017-02-01','2017-05-01','SIMPLE_ORDER','INNER_SALE','WAIT_APPLY','喂喂喂','BJHY','XX科技有限公司','XX张三','1246666',NULL,'13333','上海宝山','DDDOOO','XXX贸易有限公司','李四XXX','15555555','1233333','322222','北京五里屯','admin','2017-10-25 14:29:44','admin','2017-12-09 16:16:19',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8 COMMENT='订单详情表';

/*Data for the table `sw_order_detail` */

insert  into `sw_order_detail`(`id`,`order_no`,`order_seq_no`,`prod_no`,`prod_name`,`prod_type`,`prod_form`,`prod_long`,`prod_width`,`prod_num`,`prod_unit`,`prod_price_no`,`prod_price_express`,`prod_price`,`prod_amt`,`area`,`material_no`,`material_name`,`material_width`,`material_price_no`,`material_price_name`,`material_price_express`,`material_spec`,`material_pattern`,`material_unit`,`material_num`,`material_price`,`tech_no`,`tech_name`,`tech_price`,`tech_price_express`,`memo`,`prod_price1`,`if_prod`,`cate_type`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (148,'D-20171025142941-01700','1','sdddxxx','台布','COTTON','圆','10.00','3.00','148.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-12-10 15:21:12',NULL),(149,'D-20171025142941-01700','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','149.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-12-10 15:21:13',NULL),(150,'D-20171025142942-34918','1','sdddxxx','台布','COTTON','圆','10.00','3.00','150.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-12-10 15:21:14',NULL),(151,'D-20171025142942-34918','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','151.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-12-10 15:21:14',NULL),(152,'D-20171025142942-17265','1','sdddxxx','台布','COTTON','圆','10.00','3.00','152.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-12-10 15:21:15',NULL),(153,'D-20171025142942-17265','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','153.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:42','admin','2017-12-10 15:21:15',NULL),(154,'D-20171025142942-03027','1','sdddxxx','台布','COTTON','圆','10.00','3.00','154.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:16',NULL),(155,'D-20171025142942-03027','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','155.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:16',NULL),(156,'D-20171025142942-13612','1','sdddxxx','台布','COTTON','圆','10.00','3.00','156.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:17',NULL),(157,'D-20171025142942-13612','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','157.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:17',NULL),(158,'D-20171025142942-84467','1','sdddxxx','台布','COTTON','圆','10.00','3.00','158.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:17',NULL),(159,'D-20171025142942-84467','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','159.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:18',NULL),(160,'D-20171025142943-90935','1','sdddxxx','台布','COTTON','圆','10.00','3.00','160.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:18',NULL),(161,'D-20171025142943-90935','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','161.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:19',NULL),(162,'D-20171025142943-77480','1','sdddxxx','台布','COTTON','圆','10.00','3.00','162.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:19',NULL),(163,'D-20171025142943-77480','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','163.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:20',NULL),(164,'D-20171025142943-01443','1','sdddxxx','台布','COTTON','圆','10.00','3.00','164.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:20',NULL),(165,'D-20171025142943-01443','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','165.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:43','admin','2017-12-10 15:21:20',NULL),(166,'D-20171025142943-31701','1','sdddxxx','台布','COTTON','圆','10.00','3.00','166.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:21',NULL),(167,'D-20171025142943-31701','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','167.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:21',NULL),(170,'D-20171025142943-75119','1','sdddxxx','台布','COTTON','圆','10.00','3.00','170.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:22',NULL),(171,'D-20171025142943-75119','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','171.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:22',NULL),(172,'D-20171025142944-52321','1','sdddxxx','台布','COTTON','圆','10.00','3.00','172.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:23',NULL),(173,'D-20171025142944-52321','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','173.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:23',NULL),(174,'D-20171025142944-77057','1','sdddxxx','台布','COTTON','圆','10.00','3.00','174.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:23',NULL),(175,'D-20171025142944-77057','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','175.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:24',NULL),(176,'D-20171025142944-64124','1','sdddxxx','台布','COTTON','圆','10.00','3.00','176.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:24',NULL),(177,'D-20171025142944-64124','2','dfdfdf','dfdfd','COTTON','圆','10.00','3.00','177.00','米','df','df','100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','admin','2017-10-25 14:29:44','admin','2017-12-10 15:21:25',NULL),(178,'D-20171025142943-20706','1','TBYD2','圆底台布','COTTON','圆','3.00','3.00','168.00','米',NULL,NULL,'3.00','504.00','门窗','TBYD7','圆底台布','0.00','TB002','3.2米以上台布','(c+0.04)*s1+s1*2/333','5*5','圆','米','100.00','2.00','fdfd','df','1.00','string','ddfdf','0.00','N','ddd','wangfangfang','2017-12-10 13:08:00','wangfangfang','2017-12-10 15:21:26',NULL),(179,'D-20171025142943-20706','2','TBYD2','圆底台布','COTTON','圆','10.00','3.00','169.00','米',NULL,NULL,'100.00','2220.00','门窗','XXX0000','布料','0.00','dfdfdf',NULL,'33434','5*5','圆','米','100.00','0.00','fdfd','df','0.00','string','ddfdf','0.00','N','ddd','wangfangfang','2017-12-10 13:08:00','wangfangfang','2017-12-10 15:21:40',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='采购单总表';

/*Data for the table `sw_purchase_base` */

insert  into `sw_purchase_base`(`id`,`pur_no`,`pur_date`,`expect_date`,`resp_name`,`supply_comp_no`,`supply_comp_name`,`supply_contact_name`,`supply_mobile`,`supply_phone`,`supply_tax`,`supply_addr`,`pur_amt`,`pur_num`,`pur_status`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (58,'C-20171107172541-23612','2017-11-07','2017-10-01','张三','BJHY','XX科技有限公司','李四','12536666','13644444','021-099333','山东即墨','600.00','60.00','WAIT_APPLY','测试demo','admin','2017-11-07 17:25:42','admin','2017-12-10 14:58:46',0),(59,'C-20171209175935-52986','2017-12-09','2017-12-30',NULL,'BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','22200.00','1525.00','HAS_CANCEL',NULL,'wangfangfang','2017-12-09 17:59:35','wangfangfang','2017-12-10 14:58:47',0),(60,'C-20171209180233-87981','2017-12-09','2017-12-30','顾倩影','BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','22200.00','1525.00','WAIT_APPLY',NULL,'wangfangfang','2017-12-09 18:02:33','wangfangfang','2017-12-10 14:58:48',0),(61,'C-20171209180714-62746','2017-12-09','2017-12-30','路桥区','BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','22200.00','1525.00','WAIT_APPLY',NULL,'wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 14:58:49',0),(62,'C-20171209203632-11830','2017-12-09','2017-12-31','采购单修改2','BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','6864.00','520.00','WAIT_APPLY',NULL,'wangfangfang','2017-12-09 20:36:32','wangfangfang','2017-12-10 14:58:50',0),(63,'C-20171210111222-66159','2017-12-10','2017-12-31','aaa','BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','4740.00','397.00','WAIT_APPLY',NULL,'admin','2017-12-10 11:12:23','wangfangfang','2017-12-10 14:58:52',0),(64,'C-20171210150025-33704','2017-12-10','2017-12-16','张三','ABCD','ABCD ABCD科技有限公司','张三','12333','1','111','广兰路','13320.00','911.00','WAIT_APPLY','测试采购单','admin','2017-12-10 15:00:26','admin','2017-12-10 15:02:38',0),(65,'C-20171210150038-63345','2017-12-10','2017-12-16','张三','ABCD','ABCD ABCD科技有限公司','张三','12333','1','111','广兰路','13320.00','911.00','WAIT_APPLY','测试采购单','admin','2017-12-10 15:00:38','admin','2017-12-10 15:02:40',0),(66,'C-20171210150054-60104','2017-12-10','2017-12-16','张三','ABCD','ABCD ABCD科技有限公司','张三','12333','1','111','广兰路','13320.00','911.00','WAIT_APPLY','测试采购单','admin','2017-12-10 15:00:55','admin','2017-12-10 15:02:41',0),(67,'C-20171210150108-70455','2017-12-10','2017-12-16','张三','ABCD','ABCD ABCD科技有限公司','张三','12333','1','111','广兰路','13320.00','911.00','WAIT_APPLY','测试采购单','admin','2017-12-10 15:01:09','admin','2017-12-10 15:02:42',0),(68,'C-20171210150138-56393','2017-12-10','2017-12-16','张三','ABCD','ABCD ABCD科技有限公司','张三','12333','1','111','广兰路','4440.00','297.00','WAIT_APPLY','测试采购单','admin','2017-12-10 15:01:38','admin','2017-12-10 15:02:44',0),(69,'C-20171210150156-73839','2017-12-10','2017-12-16','张三','BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','4440.00','302.00','WAIT_APPLY','测试采购单','admin','2017-12-10 15:01:57','admin','2017-12-10 15:05:37',0),(70,'C-20171210150357-96633','2017-12-10','2018-01-05','刘鞥','BJHY','BJHY 北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','15540.00','1060.00','WAIT_APPLY',NULL,'admin','2017-12-10 15:03:58','admin','2017-12-10 15:05:43',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8 COMMENT='采购单明细表';

/*Data for the table `sw_purchase_detail` */

insert  into `sw_purchase_detail`(`id`,`pur_no`,`pur_seq_no`,`order_no`,`order_seq_no`,`material_no`,`material_name`,`material_type`,`material_long`,`material_width`,`spec`,`pattern`,`unit`,`num`,`price`,`amt`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (97,'C-20171107172541-23612','1','D-20171025142941-01700','1','KBLT-DZ-54','口布雨','PROD',NULL,NULL,'超棉文艺复兴','方','米','50.00','10.00','500.00','测试','admin','2017-11-07 17:25:42','admin','2017-11-07 17:25:42',0),(98,'C-20171107172541-23612','2','D-20171025142941-01700','1','TBYD','圆底台布11','COTTON',NULL,NULL,'超棉文艺复兴','方','米','10.00','10.00','100.00','测试','admin','2017-11-07 17:25:42','admin','2017-11-07 17:25:42',0),(99,'C-20171209180714-62746','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:19:58',0),(100,'C-20171209180714-62746','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:19:59',0),(101,'C-20171209180714-62746','3','D-20171025142942-34918','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','150.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:02',0),(102,'C-20171209180714-62746','4','D-20171025142942-34918','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','151.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:01',0),(103,'C-20171209180714-62746','5','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:03',0),(104,'C-20171209180714-62746','6','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:04',0),(105,'C-20171209180714-62746','7','D-20171025142942-03027','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','154.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:05',0),(106,'C-20171209180714-62746','8','D-20171025142942-03027','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','155.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:06',0),(107,'C-20171209180714-62746','9','D-20171025142942-13612','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','156.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:07',0),(108,'C-20171209180714-62746','10','D-20171025142942-13612','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','157.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 18:07:15','wangfangfang','2017-12-10 15:20:08',0),(109,'C-20171209203632-11830','1',NULL,NULL,'TBYD1',NULL,'PROD','3.00','3.00',NULL,NULL,'米','45.00','3.00','135.00','随便文字','wangfangfang','2017-12-09 20:36:32','wangfangfang','2017-12-09 23:39:20',0),(110,'C-20171209203632-11830','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 20:36:32','wangfangfang','2017-12-10 15:20:09',0),(111,'C-20171209203632-11830','3','D-20171025142942-34918','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','151.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 20:36:32','wangfangfang','2017-12-10 15:20:18',0),(112,'C-20171209203632-11830','4','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','wangfangfang','2017-12-09 20:36:32','wangfangfang','2017-12-10 15:20:11',0),(120,'C-20171210111222-66159','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 11:16:17','admin','2017-12-10 15:20:12',NULL),(121,'C-20171210111222-66159','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 11:16:17','admin','2017-12-10 15:20:13',NULL),(122,'C-20171210111222-66159','3',NULL,NULL,'TBYD1',NULL,'PROD','3.00','3.00',NULL,NULL,'米','100.00','3.00','300.00','ada','admin','2017-12-10 11:16:17','admin','2017-12-10 11:16:17',NULL),(123,'C-20171210150025-33704','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:26','admin','2017-12-10 15:20:38',0),(124,'C-20171210150025-33704','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:26','admin','2017-12-10 15:20:19',0),(125,'C-20171210150025-33704','3','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:26','admin','2017-12-10 15:20:19',0),(126,'C-20171210150025-33704','4','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:26','admin','2017-12-10 15:20:20',0),(127,'C-20171210150025-33704','5','D-20171025142942-03027','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','154.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:26','admin','2017-12-10 15:20:20',0),(128,'C-20171210150025-33704','6','D-20171025142942-03027','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','155.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:26','admin','2017-12-10 15:20:21',0),(129,'C-20171210150038-63345','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:38','admin','2017-12-10 15:20:21',0),(130,'C-20171210150038-63345','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:38','admin','2017-12-10 15:20:22',0),(131,'C-20171210150038-63345','3','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:38','admin','2017-12-10 15:20:22',0),(132,'C-20171210150038-63345','4','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:38','admin','2017-12-10 15:20:23',0),(133,'C-20171210150038-63345','5','D-20171025142942-03027','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','154.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:38','admin','2017-12-10 15:20:23',0),(134,'C-20171210150038-63345','6','D-20171025142942-03027','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','155.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:38','admin','2017-12-10 15:20:23',0),(135,'C-20171210150054-60104','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:55','admin','2017-12-10 15:20:24',0),(136,'C-20171210150054-60104','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:55','admin','2017-12-10 15:20:24',0),(137,'C-20171210150054-60104','3','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:55','admin','2017-12-10 15:20:25',0),(138,'C-20171210150054-60104','4','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:55','admin','2017-12-10 15:20:25',0),(139,'C-20171210150054-60104','5','D-20171025142942-03027','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','154.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:55','admin','2017-12-10 15:20:25',0),(140,'C-20171210150054-60104','6','D-20171025142942-03027','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','155.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:00:55','admin','2017-12-10 15:20:26',0),(141,'C-20171210150108-70455','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:09','admin','2017-12-10 15:20:26',0),(142,'C-20171210150108-70455','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:09','admin','2017-12-10 15:20:27',0),(143,'C-20171210150108-70455','3','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:09','admin','2017-12-10 15:20:27',0),(144,'C-20171210150108-70455','4','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:09','admin','2017-12-10 15:20:28',0),(145,'C-20171210150108-70455','5','D-20171025142942-03027','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','154.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:09','admin','2017-12-10 15:20:28',0),(146,'C-20171210150108-70455','6','D-20171025142942-03027','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','155.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:09','admin','2017-12-10 15:20:28',0),(147,'C-20171210150138-56393','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:38','admin','2017-12-10 15:20:29',0),(148,'C-20171210150138-56393','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:38','admin','2017-12-10 15:20:29',0),(149,'C-20171210150156-73839','1','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:57','admin','2017-12-10 15:20:30',0),(150,'C-20171210150156-73839','2','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:01:57','admin','2017-12-10 15:20:30',0),(151,'C-20171210150357-96633','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','148.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:30',0),(152,'C-20171210150357-96633','2','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:31',0),(153,'C-20171210150357-96633','3','D-20171025142942-17265','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','152.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:32',0),(154,'C-20171210150357-96633','4','D-20171025142942-17265','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','153.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:33',0),(155,'C-20171210150357-96633','5','D-20171025142942-03027','1','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','154.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:33',0),(156,'C-20171210150357-96633','6','D-20171025142942-03027','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','155.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:33',0),(157,'C-20171210150357-96633','7','D-20171025142941-01700','2','XXX0000','布料','COTTON','10.00','3.00','5*5','圆','米','149.00','100.00','2220.00','ddfdf','admin','2017-12-10 15:03:58','admin','2017-12-10 15:20:35',0);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领料单总表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领料单明细表';

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='退货单总表';

/*Data for the table `sw_return_base` */

insert  into `sw_return_base`(`id`,`return_no`,`return_date`,`resp_name`,`supply_comp_no`,`supply_comp_name`,`supply_contact_name`,`supply_mobile`,`supply_phone`,`supply_tax`,`supply_addr`,`return_amt`,`return_num`,`return_reason`,`return_status`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (22,'T-20171110171414-41681','2017-11-10',NULL,'BJHY','北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674',NULL,'0.00','70.00','校验不合格退货','AUDIT_SUCCESS',NULL,'admin','2017-11-10 17:14:14','wangfangfang','2017-12-10 17:07:03',0),(23,'T-20171110174336-81599','2017-11-10',NULL,'BJHY','北京好友科技','北京好友科技','0631-5769674','0631-5769674','0631-5769674',NULL,'0.00','30.00','校验不合格退货','HAS_CANCEL',NULL,'admin','2017-11-10 17:43:36','wangfangfang','2017-12-10 16:46:07',0),(24,'T-20171210153238-96618','2017-12-10','第一','BJHY 北京好友科技','北京好友科技',NULL,'0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','6030.00','603.00','外置','HAS_CANCEL',NULL,'wangfangfang','2017-12-10 15:32:39','wangfangfang','2017-12-10 16:43:17',0),(25,'T-20171210170746-96142','2017-12-10','全权','BJHY 北京好友科技','北京好友科技',NULL,'0631-5769674','0631-5769674','0631-5769674','北京市中关村5号','2820.00','208.00','测试账单','AUDIT_SUCCESS',NULL,'wangfangfang','2017-12-10 17:07:46','wangfangfang','2017-12-10 17:14:16',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='退货明细表';

/*Data for the table `sw_return_detail` */

insert  into `sw_return_detail`(`id`,`return_no`,`return_seq_no`,`pur_no`,`pur_seq_no`,`order_no`,`order_seq_no`,`material_no`,`material_name`,`material_type`,`spec`,`pattern`,`unit`,`num`,`price`,`amt`,`return_reason`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (41,'T-20171110171414-41681','1','C-20171107172541-23612','2','D-20171025142941-01700','1','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','20.00',NULL,NULL,NULL,NULL,'admin','2017-11-10 17:14:14','admin','2017-11-10 17:14:14',0),(42,'T-20171110171414-41681','2','C-20171107172541-23612','1','D-20171025142941-01700','1','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','50.00',NULL,NULL,NULL,NULL,'admin','2017-11-10 17:14:14','admin','2017-11-10 17:14:14',0),(43,'T-20171110174336-81599','1','C-20171107172541-23612','1','D-20171025142941-01700','1','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','10.00',NULL,NULL,NULL,NULL,'admin','2017-11-10 17:43:36','admin','2017-11-10 17:43:36',0),(44,'T-20171110174336-81599','2','C-20171107172541-23612','2','D-20171025142941-01700','1','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','20.00',NULL,NULL,NULL,NULL,'admin','2017-11-10 17:43:36','admin','2017-11-10 17:43:36',0),(47,'T-20171210153238-96618','1','C-20171107172541-23612','1','D-20171025142941-01700','1','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','501.00','10.00','5010.00','文字','测试','wangfangfang','2017-12-10 16:36:50','wangfangfang','2017-12-10 16:36:50',NULL),(48,'T-20171210153238-96618','2','C-20171107172541-23612','2','D-20171025142941-01700','1','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','102.00','10.00','1020.00','最后','测试','wangfangfang','2017-12-10 16:36:50','wangfangfang','2017-12-10 16:36:50',NULL),(49,'T-20171210170746-96142','1','C-20171107172541-23612','1','D-20171025142941-01700','1','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','50.00','10.00','500.00','第一','测试','wangfangfang','2017-12-10 17:07:46','wangfangfang','2017-12-10 17:07:46',0),(50,'T-20171210170746-96142','2','C-20171107172541-23612','2','D-20171025142941-01700','1','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','10.00','10.00','100.00','第二','测试','wangfangfang','2017-12-10 17:07:46','wangfangfang','2017-12-10 17:07:46',0),(51,'T-20171210170746-96142','3','C-20171209180714-62746','1','D-20171025142941-01700','1','XXX0000','布料','COTTON','5*5','圆','米','148.00','100.00','2220.00','第三','ddfdf','wangfangfang','2017-12-10 17:07:46','wangfangfang','2017-12-10 17:07:46',0);

/*Table structure for table `sw_stock_info` */

DROP TABLE IF EXISTS `sw_stock_info`;

CREATE TABLE `sw_stock_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `material_no` varchar(32) DEFAULT NULL COMMENT '物料编号',
  `num` decimal(20,2) DEFAULT '0.00' COMMENT '有效数量',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='库存表';

/*Data for the table `sw_stock_info` */

insert  into `sw_stock_info`(`id`,`material_no`,`num`,`modi_time`,`version`) values (11,'KBLT-DZ-54','340.00','2017-11-10 17:43:36',3),(12,'TBYD','260.00','2017-11-10 17:43:36',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='入库单校验信息表';

/*Data for the table `sw_stock_verify` */

insert  into `sw_stock_verify`(`id`,`stk_in_no`,`source_type`,`source_no`,`source_seq_no`,`order_no`,`order_seq_no`,`supply_comp_no`,`supply_comp_name`,`material_no`,`material_name`,`material_type`,`spec`,`pattern`,`unit`,`material_stock`,`num`,`stand_num`,`mois_rate`,`weight`,`quality`,`status`,`reason`,`refuse_type`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (21,'S-20171110160522-61502','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','100.00','100.00','合格','246','300','STOCK_FINISH',NULL,NULL,'admin','2017-11-10 16:05:23','admin','2017-11-10 17:14:14',0),(22,'S-20171110160522-39639','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','100.00','80.00','合格','246','300','STOCK_FINISH',NULL,'RETURN','admin','2017-11-10 16:05:23','admin','2017-11-10 17:14:14',0),(23,'S-20171110160523-45798','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','100.00','50.00','合格','246','300','STOCK_FINISH',NULL,'RETURN','admin','2017-11-10 16:05:24','admin','2017-11-10 17:14:14',0),(24,'S-20171110160523-68162','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','100.00','100.00','合格','246','300','STOCK_FINISH',NULL,'RETURN','admin','2017-11-10 16:05:24','admin','2017-11-10 17:43:36',0),(25,'S-20171110160523-80219','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','100.00','100.00','合格','246','300','STOCK_FINISH',NULL,'RETURN','admin','2017-11-10 16:05:24','admin','2017-11-10 17:43:36',0),(26,'S-20171110160523-50111','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','100.00','80.00','合格','246','300','STOCK_FINISH',NULL,'RETURN','admin','2017-11-10 16:05:24','admin','2017-11-10 17:43:36',0),(27,'S-20171110160524-89403','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','100.00','90.00','合格','246','300','STOCK_FINISH',NULL,'RETURN','admin','2017-11-10 16:05:24','admin','2017-11-10 17:43:36',0),(28,'S-20171110160524-90301','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','10.00','10.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:24','admin','2017-11-10 16:18:36',0),(29,'S-20171110160524-21422','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','50.00','50.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:24','admin','2017-11-10 16:18:36',0),(30,'S-20171110160524-82064','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','10.00','10.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:24','admin','2017-11-10 16:18:36',0),(31,'S-20171110160524-72413','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','50.00','50.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:25','admin','2017-11-10 16:18:36',0),(32,'S-20171110160524-24808','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','10.00','10.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:25','admin','2017-11-10 16:18:36',0),(33,'S-20171110160524-19419','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','50.00','50.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:25','admin','2017-11-10 16:18:36',0),(34,'S-20171110160524-43938','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','10.00','10.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:25','admin','2017-11-10 16:18:36',0),(35,'S-20171110160524-24601','C','C-20171107172541-23612','1','D-20171025142941-01700','1','BJHY','北京好友科技','KBLT-DZ-54','口布雨','PROD','超棉文艺复兴','方','米','tt','50.00','50.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:25','admin','2017-11-10 16:18:36',0),(36,'S-20171110160524-15079','C','C-20171107172541-23612','2','D-20171025142941-01700','1','BJHY','北京好友科技','TBYD','圆底台布11','COTTON','超棉文艺复兴','方','米','PROD_STOCK','10.00','10.00',NULL,NULL,NULL,'WAIT_VERIFY',NULL,NULL,'admin','2017-11-10 16:05:25','admin','2017-11-10 16:18:36',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='审核日志表';

/*Data for the table `sys_audit_log` */

insert  into `sys_audit_log`(`id`,`source_no`,`audit_no`,`audit_type`,`audit_type_name`,`audit_action`,`audit_action_name`,`current_stage`,`next_stage`,`audit_user_no`,`audit_user_name`,`audit_time`,`audit_desc`) values (1,'D-20171025142941-01700','ORDER&AUDIT_PASS&WAIT_AUDIT','ORDER','订单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','string','string','2017-10-25 17:50:53','测试'),(2,'D-20171025142941-01700','ORDER&AUDIT_PASS&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_PASS','终审成功','AUDIT01_SUCCESS','AUDIT_SUCCESS','string','string','2017-10-25 17:51:34','测试'),(3,'F-20171026154553-22138','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin',NULL,'2017-10-26 16:05:05','测试'),(4,'F-20171026154553-22138','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin',NULL,'2017-10-26 16:08:28','测试'),(5,'F-20171026154553-22138','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin',NULL,'2017-10-26 16:09:36','测试'),(6,'C-20171106193618-21522','RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin',NULL,'2017-11-06 20:12:23','string'),(7,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:35:39',NULL),(8,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:38:48',NULL),(9,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:42:14',NULL),(10,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:43:46',NULL),(11,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:44:07',NULL),(12,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:49:00',NULL),(13,'S-20171110142206-00400','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:49:18',NULL),(14,'S-20171110142206-11914','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:49:32',NULL),(15,'S-20171110145000-17486','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:51:38',NULL),(16,'S-20171110145000-03423','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:51:38',NULL),(17,'S-20171110145003-25064','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','合格入库','WAIT_VERIFY','STOCK_SUCCESS',NULL,NULL,'2017-11-10 14:51:38',NULL),(18,'S-20171110145004-87154','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL',NULL,NULL,'2017-11-10 14:54:07','产品不合格'),(19,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:09:46','含潮率不合格'),(20,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:09:46','含潮率不合格'),(21,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:09:46','含潮率不合格'),(22,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:15:49','含潮率不合格'),(23,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:15:49','含潮率不合格'),(24,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:15:49','含潮率不合格'),(25,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:16:07','含潮率不合格'),(26,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:16:08','含潮率不合格'),(27,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:16:08','含潮率不合格'),(40,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:24:59','含潮率不合格'),(41,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:24:59','含潮率不合格'),(42,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:24:59','含潮率不合格'),(43,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:27:17','含潮率不合格'),(44,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:27:17','含潮率不合格'),(45,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:27:17','含潮率不合格'),(46,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:31:17','含潮率不合格'),(47,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:31:23','含潮率不合格'),(48,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:31:28','含潮率不合格'),(49,'S-20171110160522-61502','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:32:32','含潮率不合格'),(50,'S-20171110160522-39639','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:32:35','含潮率不合格'),(51,'S-20171110160523-45798','STOCKVERIFY&AUDIT_REFUSE&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_REFUSE','不合格','WAIT_VERIFY','STOCK_FAIL','admin',NULL,'2017-11-10 16:32:40','含潮率不合格'),(52,'S-20171110160522-61502','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:12:50',NULL),(53,'S-20171110160522-39639','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:12:51',NULL),(54,'S-20171110160523-45798','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:12:51',NULL),(55,'S-20171110160522-61502','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:14:14',NULL),(56,'S-20171110160522-39639','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:14:14',NULL),(57,'S-20171110160523-45798','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:14:14',NULL),(58,'S-20171110160524-89403','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:43:36',NULL),(59,'S-20171110160523-50111','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:43:36',NULL),(60,'S-20171110160523-80219','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:43:36',NULL),(61,'S-20171110160523-68162','STOCKVERIFY&AUDIT_PASS&WAIT_VERIFY','STOCKVERIFY','入库单校验','AUDIT_PASS','校验完毕','WAIT_VERIFY','STOCK_FINISH','admin',NULL,'2017-11-10 17:43:36',NULL),(62,'D-20171025142942-34918','ORDER&CANCEL&WAIT_APPLY','ORDER','订单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','admin','管理员','2017-11-19 10:46:22','拒绝'),(63,'F-20171026154711-55147','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:35',NULL),(64,'F-20171026154714-06687','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(65,'F-20171026154714-91297','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(66,'F-20171026154714-96550','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(67,'F-20171026154714-53180','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(68,'F-20171026154714-96068','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(69,'F-20171026154715-71237','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(70,'F-20171026154715-56910','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(71,'F-20171026154715-02658','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(72,'F-20171026154715-05630','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:36',NULL),(73,'F-20171026154715-81678','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(74,'F-20171026154715-77046','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(75,'F-20171026154716-07382','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(76,'F-20171026154716-82480','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(77,'F-20171026154716-25468','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(78,'F-20171026154716-65105','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(79,'F-20171026154716-62065','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(80,'F-20171026154716-27297','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(81,'F-20171026155944-36948','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(82,'F-20171209162027-04330','DELIVER&APPLY&WAIT_APPLY','DELIVER','发货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','admin','管理员','2017-12-09 16:20:39',NULL),(83,'F-20171026154711-55147','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(84,'F-20171026154714-06687','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(85,'F-20171026154714-91297','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(86,'F-20171026154714-96550','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(87,'F-20171026154714-53180','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(88,'F-20171026154714-96068','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(89,'F-20171026154715-71237','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(90,'F-20171026154715-56910','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(91,'F-20171026154715-02658','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(92,'F-20171026154715-05630','DELIVER&AUDIT_PASS&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_PASS','初审成功','WAIT_AUDIT','AUDIT01_SUCCESS','admin','管理员','2017-12-09 16:27:22',NULL),(93,'F-20171026154711-55147','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-09 16:29:27',NULL),(94,'F-20171026154714-06687','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-09 16:29:27',NULL),(95,'F-20171026154714-96550','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-09 16:29:33',NULL),(96,'F-20171026154714-91297','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-09 16:29:33',NULL),(97,'D-20171025142942-03027','ORDER&APPLY&WAIT_APPLY','ORDER','订单审核','APPLY','发起申请','WAIT_APPLY','AUDIT01_SUCCESS','admin','管理员','2017-12-10 11:21:40',NULL),(98,'D-20171025142942-17265','ORDER&APPLY&WAIT_APPLY','ORDER','订单审核','APPLY','发起申请','WAIT_APPLY','AUDIT01_SUCCESS','admin','管理员','2017-12-10 11:21:40',NULL),(99,'D-20171025142942-17265','ORDER&AUDIT_PASS&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_PASS','终审成功','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-10 11:21:49',NULL),(100,'D-20171025142942-03027','ORDER&AUDIT_PASS&AUDIT01_SUCCESS','ORDER','订单审核','AUDIT_PASS','终审成功','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-10 11:21:52',NULL),(101,'C-20171209175935-52986','PURCHASE&CANCEL&WAIT_APPLY','PURCHASE','采购单审核','CANCEL','作废','WAIT_APPLY','HAS_CANCEL','wangfangfang','王芳芳','2017-12-10 11:26:49',NULL),(102,'F-20171026154715-81678','DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','wangfangfang','王芳芳','2017-12-10 11:34:58','测试意见'),(103,'F-20171026154715-77046','DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','wangfangfang','王芳芳','2017-12-10 11:35:47','批量拒绝'),(104,'F-20171026154716-07382','DELIVER&AUDIT_REFUSE&WAIT_AUDIT','DELIVER','发货单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','wangfangfang','王芳芳','2017-12-10 11:48:34','一大堆拒绝的理由是否还能够正常显示？'),(105,'C-20171210111222-66159','PURCHASE&APPLY&WAIT_APPLY','PURCHASE','采购单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','wangfangfang','王芳芳','2017-12-10 11:55:52',NULL),(106,'C-20171210111222-66159','PURCHASE&AUDIT_REFUSE&WAIT_AUDIT','PURCHASE','采购单审核','AUDIT_REFUSE','初审拒绝','WAIT_AUDIT','WAIT_APPLY','wangfangfang','王芳芳','2017-12-10 11:56:05','重置数据库'),(107,'T-20171210153238-96618','RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','wangfangfang','王芳芳','2017-12-10 16:37:02',NULL),(108,'T-20171210153238-96618','RETURN&AUDIT_PASS&WAIT_AUDIT','RETURN','退货单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','HAS_CANCEL','wangfangfang','王芳芳','2017-12-10 16:43:17',NULL),(109,'T-20171110174336-81599','RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','wangfangfang','王芳芳','2017-12-10 16:46:04',NULL),(110,'T-20171110174336-81599','RETURN&AUDIT_PASS&WAIT_AUDIT','RETURN','退货单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','HAS_CANCEL','wangfangfang','王芳芳','2017-12-10 16:46:07',NULL),(111,'T-20171110171414-41681','RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','wangfangfang','王芳芳','2017-12-10 16:47:59',NULL),(112,'T-20171110171414-41681','RETURN&AUDIT_PASS&WAIT_AUDIT','RETURN','退货单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','AUDIT01_SUCCESS','wangfangfang','王芳芳','2017-12-10 16:48:02',NULL),(113,'T-20171110171414-41681','RETURN&AUDIT_REFUSE&WAIT_AUDIT','RETURN','退货单审核','AUDIT_REFUSE','终审拒绝','AUDIT01_SUCCESS','WAIT_APPLY','wangfangfang','王芳芳','2017-12-10 16:48:25','从头再来'),(114,'T-20171110171414-41681','RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','wangfangfang','王芳芳','2017-12-10 16:48:50',NULL),(115,'T-20171110171414-41681','RETURN&AUDIT_PASS&WAIT_AUDIT','RETURN','退货单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','AUDIT01_SUCCESS','wangfangfang','王芳芳','2017-12-10 17:06:57',NULL),(116,'T-20171110171414-41681','RETURN&AUDIT_PASS&AUDIT01_SUCCESS','RETURN','退货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','wangfangfang','王芳芳','2017-12-10 17:07:03',NULL),(117,'T-20171210170746-96142','RETURN&APPLY&WAIT_APPLY','RETURN','退货单审核','APPLY','发起申请','WAIT_APPLY','WAIT_AUDIT','wangfangfang','王芳芳','2017-12-10 17:07:55',NULL),(118,'T-20171210170746-96142','RETURN&AUDIT_PASS&WAIT_AUDIT','RETURN','退货单审核','AUDIT_PASS','初审通过','WAIT_AUDIT','AUDIT01_SUCCESS','wangfangfang','王芳芳','2017-12-10 17:08:02',NULL),(119,'T-20171210170746-96142','RETURN&AUDIT_PASS&AUDIT01_SUCCESS','RETURN','退货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','wangfangfang','王芳芳','2017-12-10 17:14:16',NULL),(120,'F-20171026154714-53180','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-10 17:39:08',''),(121,'F-20171026154714-96068','DELIVER&AUDIT_PASS&AUDIT01_SUCCESS','DELIVER','发货单审核','AUDIT_PASS','终审通过','AUDIT01_SUCCESS','AUDIT_SUCCESS','admin','管理员','2017-12-10 17:39:08','');

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

insert  into `sys_dict`(`id`,`dict_type`,`dict_code`,`dict_name`,`dict_value`,`dict_desc`,`fh_dict_code`,`memo`) values (1,'ORDER_TYPE','SIMPLE_ORDER','样品单','SIMPLE_ORDER','样品单','','订单类型'),(2,'ORDER_TYPE','NORMAL_ORDER','正常单','NORMAL_ORDER','正常单','','订单类型'),(3,'ORDER_TYPE','ADD_ORDER','补单','ADD_ORDER','补单','','订单类型'),(4,'ORDER_TYPE','GIFT_ORDER','赠品','GIFT_ORDER','赠品','','订单类型'),(5,'ORDER_TYPE','ENGIN_ORDER','工程单','ENGIN_ORDER','工程单','','订单类型'),(6,'SALE_TYPE','INNER_SALE','内销','INNER_SALE','内销','','销售类型'),(7,'SALE_TYPE','OUT_SALE','外销','OUT_SALE','外销','','销售类型'),(8,'MATERIAL_TYPE','PROD','成品布','PROD','成品布','','物料类型'),(9,'MATERIAL_TYPE','COTTON ','面料','COTTON ','面料','','物料类型'),(11,'PAY_WAY','TEL_PAY','电汇','TEL_PAY','电汇','','付款方式'),(12,'PAY_WAY','CASH','现金','CASH','现金','','付款方式'),(13,'PAY_WAY','CHEQUE','支票','CHEQUE','支票','','付款方式'),(14,'PAY_WAY','POS','POS','POS','POS','','付款方式'),(15,'ORDER_STATUS','WAIT_APPLY','待初审','WAIT_APPLY','待初审','','订单状态'),(16,'ORDER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功','','订单状态'),(17,'ORDER_STATUS','AUDIT_SUCCESS','终审成功','AUDIT_SUCCESS','终审成功','','订单状态'),(18,'ORDER_STATUS','ORDER_FINISH','订单结束','ORDER_FINISH','订单结束','','订单状态'),(19,'FORMULAR_TYPE','PROD','成品布公式','PROD','成品布公式',NULL,'公式类型'),(20,'FORMULAR_TYPE','COTTON ','面料公式','COTTON ','面料公式',NULL,'公式类型'),(21,'FORMULAR_TYPE','CRAFTS','工艺公式','CRAFTS','工艺公式',NULL,'公式类型'),(22,'MATERIAL_STOCK','PROD_STOCK','成品库','PROD_STOCK','成品库',NULL,'所属仓库'),(23,'MATERIAL_STOCK','COTTON_STOCK','面料库','COTTON_STOCK','面料库',NULL,'所属仓库'),(24,'REFUSE_TYPE','RETURN','退货','RETURN','退货',NULL,'校验不合格后续操作'),(25,'REFUSE_TYPE','BUJI','补给','BUJI','补给',NULL,'校验不合格后续操作'),(26,'REFUSE_TYPE','FANXIU','返修','FANXIU','返修',NULL,'校验不合格后续操作'),(27,'DELIVER_WAY','ZHOGNTONG','中通','ZHOGNTONG','中通',NULL,'运货方式'),(28,'DELIVER_WAY','SHENGONG','申通','SHENGONG','申通',NULL,'运货方式'),(29,'DELIVER_WAY','YUNDA','韵达','YUNDA','韵达',NULL,'运货方式'),(30,'DELIVER_WAY','YUANTONG','圆通','YUANTONG','圆通',NULL,'运货方式'),(31,'DELIVER_WAY','SHUNFENG','顺丰','SHUNFENG','顺丰',NULL,'运货方式'),(32,'ORDER_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'订单状态'),(33,'DELIVER_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'发货状态'),(34,'DELIVER_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'发货状态'),(35,'DELIVER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'发货状态'),(36,'DELIVER_STATUS','AUDIT_SUCCESS','已发货','AUDIT_SUCCESS','已发货',NULL,'发货状态'),(37,'DELIVER_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'发货状态'),(38,'PUR_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'采购状态'),(39,'PUR_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'采购状态'),(40,'PUR_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'采购状态'),(41,'PUR_STATUS','AUDIT_SUCCESS','已送货','AUDIT_SUCCESS','已送货',NULL,'采购状态'),(42,'PUR_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'采购状态'),(43,'RECV_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'领料状态'),(44,'RECV_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'领料状态'),(45,'RECV_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'领料状态'),(46,'RECV_STATUS','AUDIT_SUCCESS','已领料','AUDIT_SUCCESS','已领料',NULL,'领料状态'),(47,'RECV_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'领料状态'),(48,'RETURN_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'退货单状态'),(49,'RETURN_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'退货单状态'),(50,'RETURN_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'退货单状态'),(51,'RETURN_STATUS','AUDIT_SUCCESS','已退货','AUDIT_SUCCESS','已退货',NULL,'退货单状态'),(52,'RETURN_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'退货单状态');

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

insert  into `sys_resource`(`id`,`source_no`,`source_name`,`fh_source_no`,`source_type`,`req_url`,`rsource_icon`,`sort_order`,`level`,`if_visible`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'order','业务订单',NULL,'MENU',NULL,NULL,1,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:40',0),(2,'purchase','采购管理',NULL,'MENU',NULL,NULL,2,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:09',0),(3,'produce','生产制造',NULL,'MENU',NULL,NULL,4,1,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:37:57',0),(4,'stock','仓库管理',NULL,'MENU',NULL,NULL,3,1,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:38:01',0),(5,'base','基础资料',NULL,'MENU',NULL,NULL,5,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:41',0),(6,'system','系统管理',NULL,'MENU',NULL,NULL,6,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:43',0),(7,'orderCreate','创建订单合同','order','MENU','/createOrder',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(8,'orderApply','订单初审','order','MENU','/orderApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(9,'orderAudit','订单终审','order','MENU','/orderAudit',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(10,'orderQuery','订单查询','order','MENU','/orderList',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(11,'deliverCreate','创建发货单','order','MENU','/deliverCreate',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(12,'deliverApply','发货单申请','order','MENU','/deliverApply',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 14:23:31',0),(14,'deliverQuery','发货单查询','order','MENU','/deliverList',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(15,'materialInfo','物料信息','base','MENU','/material',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(16,'formularInfo','公式信息','base','MENU','/formular',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(17,'compInfo','公司资料','base','MENU','/comp',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(18,'departInfo','部门信息','base','MENU','/depart',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(19,'dashboard','管理中心',NULL,'MENU','/dashboard',NULL,0,1,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(20,'purchaseCreate','采购单创建','purchase','MENU','/purchaseCreate',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(21,'purchaseApply','采购单申请','purchase','MENU','/purchaseApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(22,'purchaseAudit','采购单终审','purchase','MENU','/purchaseAudit',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:12',0),(23,'purchaseQuery','采购单查询','purchase','MENU','/purchaseQuery',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:13',0),(24,'returnCreate','退货单创建','purchase','MENU','/returnCreate',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:14',0),(25,'returnApply','退货单申请','purchase','MENU','/returnApply',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:16',0),(26,'returnAudit','退货单审核','purchase','MENU','/returnAudit',NULL,9,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:39:57',0),(27,'returnList','退货单查询','purchase','MENU','/returnList',NULL,10,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:40:01',0),(28,'stockVerify','入库校验','stock','MENU','/stockVerify',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(29,'stockVerifyQuery','校验记录查询','stock','MENU','/stockVerifyQuery',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(30,'stockQuery','库存查询','stock','MENU','/stockQuery',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(31,'receiveAudit','领料单终审','stock','MENU','/receiveAudit',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(32,'deliverAudit','发货单终审','stock','MENU','/deliverAudit',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(33,'receiveCreate','领料单创建','produce','MENU','/receiveCreate',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(34,'receiveApply','领料单申请','produce','MENU','/receiveApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(35,'receiveQuery','领料单查询','produce','MENU','/receiveList',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:32:40',0),(36,'workCreate','工时导入','produce','MENU','/workCreate',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:32:41',0),(37,'workQuery','工时查询','produce','MENU','/workQuery',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:32:48',0),(38,'deliverAudit01','发货单初审','order','MENU','/deliverAudit01',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 15:08:22',0),(39,'userManager','账户管理','system','MENU','/userManager',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:48',0),(40,'roleInfo','角色信息','system','MENU','/roleInfo',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:49',0),(41,'rolePermit','角色权限','system','MENU','/rolePermit',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:50',0),(42,'purchaseAudit01','采购单初审','purchase','MENU','/purchaseAudit01',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:30',0),(43,'returnAudit01','退货单初审','purchase','MENU','/returnAudit01',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:40:05',0),(44,'receiveAudit01','领料单初审','produce','MENU','/receiveAudit01',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:33:13',0);

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

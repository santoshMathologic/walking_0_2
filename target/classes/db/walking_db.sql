/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.1.13-MariaDB : Database - walking_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`walking_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `walking_db`;

/*Table structure for table `company_details` */

DROP TABLE IF EXISTS `company_details`;

CREATE TABLE `company_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `walkingdetails_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm4ydr8ygvmhynvq47o84yrkyu` (`walkingdetails_id`),
  CONSTRAINT `FKm4ydr8ygvmhynvq47o84yrkyu` FOREIGN KEY (`walkingdetails_id`) REFERENCES `walking_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `company_details` */

insert  into `company_details`(`id`,`city`,`company_address`,`company_name`,`country`,`state`,`walkingdetails_id`) values (1,'BANGALORE','6TH BLOCK 100 FEET ROAD NEAR SONY WORLD SIGNAL JUNCTION,OPP TO RIYA KODALI SHOWROOM, KORMANGALA','Ionidea Enterprise Solutions Private Limited ','india','KA',1),(2,'BANGALORE','#32/A,1st Floor,9th Main','Hinduja global Solutions -','india','KA',2),(3,'BANGALORE','Brickwork India Pvt. Ltd., 3rd Floor, Raj Alkaa Park, 29/3, & 32/2,','Brickwork India Pvt Ltd.','india','KA',1),(4,'BANGALORE','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road, Bangalore','CERNOBIA TECHNOLOGIES - ','india','KA',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'admin'),(2,'super');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activation_key` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `employee_no` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_active` bit(1) DEFAULT b'0',
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone_no` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`activation_key`,`email`,`employee_no`,`extension`,`first_name`,`is_active`,`last_name`,`mobile_no`,`password`,`telephone_no`,`username`,`role_id`) values (1,NULL,'abc@yahoo.com','123456',NULL,'santosh','\0',NULL,NULL,NULL,NULL,'santosh',1),(2,NULL,'abc@gmail.com',NULL,NULL,'kk','\0',NULL,NULL,NULL,NULL,'lll',1),(6,NULL,'ac@gmail.com',NULL,NULL,'kk','\0',NULL,NULL,NULL,NULL,'pp',1),(7,NULL,'c@gmail.com',NULL,NULL,'kk','\0',NULL,NULL,NULL,NULL,'ooo',1);

/*Table structure for table `walking_details` */

DROP TABLE IF EXISTS `walking_details`;

CREATE TABLE `walking_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `venu` varchar(255) DEFAULT NULL,
  `walkingdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `walking_details` */

insert  into `walking_details`(`id`,`venu`,`walkingdate`) values (1,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-28'),(2,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-23'),(3,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-06'),(4,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-09'),(5,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

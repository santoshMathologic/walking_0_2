/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.36-community : Database - walking_db
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Data for the table `company_details` */

insert  into `company_details`(`id`,`city`,`company_address`,`company_name`,`country`,`state`,`walkingdetails_id`) values (1,'BANGALORE','6TH BLOCK 100 FEET ROAD NEAR SONY WORLD SIGNAL JUNCTION,OPP TO RIYA KODALI SHOWROOM, KORMANGALA','Ionidea Enterprise Solutions Private Limited ','India','KA',1),(2,'MANGALORE','#32/A,1st Floor,9th Main','Hinduja global Solutions -','India','SA',2),(3,'KOLKATTA','Brickwork India Pvt. Ltd., 3rd Floor, Raj Alkaa Park, 29/3, & 32/2,','Brickwork India Pvt Ltd.','India','TN',1),(4,'DELHI','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road, Bangalore','CERNOBIA TECHNOLOGIES - ','India','KA',1),(6,'BANGALORE','No. 264/75, 36th Cross, 2nd Main','CADEM Technologies Pvt. Ltd.','India','KA',3),(7,'Bangalore','Dharwad Bye Pass (Next to Airtech)','Crane-Bel International Pvt. Ltd.','India','TN',3),(8,'DELHI','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','CERNOBIA TECHNOLOGIES ','India','Delhi',5),(9,'Bangalore','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road, Bangalore\r\n\r\n','CERNOBIA TECHNOLOGIES ','INDIA','KA',5),(12,'Bangalore','6TH BLOCK 100 FEET ROAD NEAR SONY WORLD SIGNAL JUNCTION,OPP TO RIYA KODALI SHOWROOM, KORMANGALA','CADEM Technologies Pvt. Ltd.','INDIA','KA',7),(13,'MANGALORE','#32/A,1st Floor,9th Main','Hinduja global Solutions -','INDIA','KA',7),(14,'MANGALORE','#32/A,1st Floor,9th Main','Hinduja global Solutions -','INDIA','KA',9),(15,'MANGALORE','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','Hinduja global Solutions -','INDIA','KA',9),(16,'MANGALORE','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','CERNOBIA TECHNOLOGIES - ','INDIA','KA',31),(17,'Bangalore','#32/A,1st Floor,9th Main','CADEM Technologies Pvt. Ltd.','INDIA','KA',55),(18,'Bangalore','No. 264/75, 36th Cross, 2nd Main','Hinduja global Solutions -','INDIA','KA',12),(19,'KOLKATTA','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','CERNOBIA TECHNOLOGIES - ','INDIA','KA',26),(20,'Bangalore','No. 264/75, 36th Cross, 2nd Main','CADEM Technologies Pvt. Ltd.','INDIA','KA',24),(21,'Bangalore','#32/A,1st Floor,9th Main','Hinduja global Solutions -','INDIA','TN',24),(22,'Bangalore','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','CERNOBIA TECHNOLOGIES - ','INDIA','TN',25),(23,'Bangalore','No. 264/75, 36th Cross, 2nd Main','CADEM Technologies Pvt. Ltd.','INDIA','TN',11),(24,'KOLKATTA','#32/A,1st Floor,9th Main','Hinduja global Solutions -','INDIA','TN',11),(25,'Bangalore','No. 264/75, 36th Cross, 2nd Main','CERNOBIA TECHNOLOGIES - ','INDIA','TN',11),(26,'Bangalore','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','CADEM Technologies Pvt. Ltd.','INDIA','TN',11),(27,'Bangalore','No. 264/75, 36th Cross, 2nd Main','Hinduja global Solutions -','INDIA','TN',5),(28,'Bangalore','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','CERNOBIA TECHNOLOGIES - ','INDIA','TN',5),(29,'Bangalore','#32/A,1st Floor,9th Main','CADEM Technologies Pvt. Ltd.','INDIA','MP',5),(30,'Bangalore','No. 264/75, 36th Cross, 2nd Main','Hinduja global Solutions -','INDIA','MP',5),(31,'KOLKATTA','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','Brickwork India Pvt Ltd.','INDIA','MP',15),(32,'KOLKATTA','#32/A,1st Floor,9th Main','Brickwork India Pvt Ltd.','INDIA','MP',15),(33,'KOLKATTA','No. 264/75, 36th Cross, 2nd Main','Brickwork India Pvt Ltd.','INDIA','MP',15),(34,'KOLKATTA','No. 264/75, 36th Cross, 2nd Main','Hinduja global Solutions -','INDIA','MP',20),(35,'KOLKATTA','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','Brickwork India Pvt Ltd.','INDIA','MP',20),(36,'KOLKATTA','#32/A,1st Floor,9th Main','Brickwork India Pvt Ltd.','INDIA','MP',20),(37,'Bangalore',NULL,'Hinduja global Solutions -','INDIA','MP',20),(38,'Bangalore','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road','Brickwork India Pvt Ltd.','INDIA','MP',32),(39,'Bangalore','#32/A,1st Floor,9th Main','Hinduja global Solutions -','INDIA','MP',32);

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
  `walking_time` time DEFAULT NULL,
  `walking_rep_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

/*Data for the table `walking_details` */

insert  into `walking_details`(`id`,`venu`,`walkingdate`,`walking_time`,`walking_rep_time`) values (1,' IonIdea Pvt. Ltd, # 38-40, EPIP, Whitefield, Bangalore 560 066. Besides SAP LABS Landmark: KTPO Stop, Near Ginger Hotel ','2016-11-28','12:22:00','12:22:00'),(2,'3rd Main Road, Ashwini Layout, Ejipura','2016-11-23','14:24:00','12:22:00'),(3,'6th Floor, Gold Hill Square Software Park,, No. 690, Bommanahalli,, Hosur Rd, Garvebhavi Palya, Bengaluru, Karnataka 560068','2016-11-06','00:00:00','12:22:00'),(4,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-09','23:41:58','12:22:00'),(5,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-04','19:14:00','12:22:00'),(7,'Gauge House67, Hadapsar Industrial Estate','2016-11-09','23:41:58','12:22:00'),(8,'Peenya Industrial Area','2016-11-23','23:41:58','12:22:00'),(9,'Peenya Industrial Area','2016-11-09','23:41:58','12:22:00'),(10,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-09','14:24:00','12:22:00'),(11,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-09','14:24:00','12:22:00'),(12,'Peenya Industrial Area','2016-11-23','14:24:00','12:22:00'),(13,'Peenya Industrial Area','2016-11-23','14:24:00','12:22:00'),(14,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-04','14:24:00','12:22:00'),(15,'No. 264/75, 36th Cross, 2nd Main,8th Block, Jayanagar','2016-11-09','19:14:00','12:22:00'),(16,'Peenya Industrial Area','2016-11-09','19:14:00','12:22:00'),(17,'Gauge House67, Hadapsar Industrial Estate','2016-11-09','19:14:00','12:22:00'),(18,'Peenya Industrial Area','2016-11-09','19:14:00','12:22:00'),(19,'Gauge House67, Hadapsar Industrial Estate','2016-11-02','19:14:00','12:22:00'),(20,'No. 264/75, 36th Cross, 2nd Main,8th Block, Jayanagar','2016-11-12','19:14:00','12:22:00'),(21,'Peenya Industrial Area','2016-11-13','19:14:00','12:22:00'),(22,'Gauge House67, Hadapsar Industrial Estate','2016-11-21','19:14:00','12:22:00'),(23,'No. 264/75, 36th Cross, 2nd Main,8th Block, Jayanagar','2016-11-26','23:41:58','12:22:00'),(24,'Peenya Industrial Area','2016-11-14','23:41:58','12:22:00'),(25,'Gauge House67, Hadapsar Industrial Estate','2016-11-24','23:41:58','12:22:00'),(26,'No. 264/75, 36th Cross, 2nd Main,8th Block, Jayanagar','2016-11-26','23:41:58','12:22:00'),(27,'Peenya Industrial Area','2016-11-13','14:24:00','12:22:00'),(28,'Gauge House67, Hadapsar Industrial Estate','2016-11-13','14:24:00','12:22:00'),(29,'Gauge House67, Hadapsar Industrial Estate','2016-11-13','23:41:58','12:22:00'),(30,'Peenya Industrial Area','2016-11-13','14:24:00','12:22:00'),(31,'Peenya Industrial Area','2016-11-13','23:41:58','12:22:00'),(32,NULL,NULL,NULL,'12:22:00'),(33,NULL,NULL,NULL,'12:22:00'),(34,NULL,NULL,NULL,'12:22:00'),(35,NULL,NULL,NULL,'12:22:00'),(36,NULL,NULL,NULL,'12:22:00'),(37,NULL,NULL,NULL,'12:22:00'),(38,NULL,NULL,NULL,'12:22:00'),(39,NULL,NULL,NULL,'12:22:00'),(40,NULL,NULL,NULL,'12:22:00'),(41,NULL,NULL,NULL,'12:22:00'),(42,NULL,NULL,NULL,'12:22:00'),(43,NULL,NULL,NULL,'12:22:00'),(44,NULL,NULL,NULL,'12:22:00'),(45,NULL,NULL,NULL,'12:22:00'),(46,NULL,NULL,NULL,'12:22:00'),(47,NULL,NULL,NULL,'12:22:00'),(48,NULL,NULL,NULL,'12:22:00'),(49,NULL,NULL,NULL,'12:22:00'),(50,NULL,NULL,NULL,'12:22:00'),(55,NULL,NULL,NULL,'12:22:00'),(56,NULL,'2016-11-13','14:24:00',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

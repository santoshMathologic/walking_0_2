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

insert  into `company_details`(`id`,`city`,`company_address`,`company_name`,`country`,`state`,`walkingdetails_id`) values (1,'BANGALORE','6TH BLOCK 100 FEET ROAD NEAR SONY WORLD SIGNAL JUNCTION,OPP TO RIYA KODALI SHOWROOM, KORMANGALA','Ionidea Enterprise Solutions Private Limited ','India','KA',1),(2,'MANGALORE','#32/A,1st Floor,9th Main','Hinduja global Solutions -','India','SA',2),(3,'KOLKATTA','Brickwork India Pvt. Ltd., 3rd Floor, Raj Alkaa Park, 29/3, & 32/2,','Brickwork India Pvt Ltd.','India','TN',1),(4,'DELHI','Marks & Spencer, Kormangla, Opposite Oasis Centre, Inner Ring Road, Bangalore','CERNOBIA TECHNOLOGIES - ','India','KA',1),(6,'BANGALORE','No. 264/75, 36th Cross, 2nd Main','CADEM Technologies Pvt. Ltd.','India','KA',3),(7,'Bangalore','Dharwad Bye Pass (Next to Airtech)','Crane-Bel International Pvt. Ltd.','India','TN',3),(8,'DELHI','Kanta Vikas Gruh Road','Pinnacle Engineering Enterprise','India','Delhi',5),(9,'Bangalore','Pune Satara Road','PMT Machines Ltd.','INDIA','KA',5),(12,'Bangalore','Bommasandra Industrial Estate','Pragati Automation Pvt Ltd','INDIA','KA',7),(13,'MANGALORE','2816 Jammu Colony, St No 1','Premier Ltd','INDIA','KA',7),(14,'MANGALORE','201, Karma Stambh','Nugen Machineries Ltd','INDIA','KA',9),(15,'MANGALORE','Raheja Palmspring Centre','Nagel Special Machines Pvt. Ltd','INDIA','KA',9),(16,'MANGALORE','New Link Road, Malad (W)','Miven Mayfran Conveyors Pvt. Ltd.','INDIA','KA',31),(17,'Bangalore','G. T. Road, Suranussi','Mistry Laxman Kadva Machines (P) Ltd.','INDIA','KA',55),(18,'Bangalore','G-506 Lodhika GIDC','Micromatic Grinding Technologies Ltd','INDIA','KA',12),(19,'KOLKATTA','Kalawad Road, P.O. Khirasara','Mercury Pneumatics Pvt. Ltd.','INDIA','KA',26),(20,'Bangalore','10/2 Bhaktinagar Station Plot','Liebherr Machine Tools India Pvt Ltd','INDIA','KA',24),(21,'Bangalore','8 / 9th Mile, Tumkur Road','Krystal Elmec','INDIA','TN',24),(22,'Bangalore','Hinjawadi MIDC, Phase 2, At Post - Maan','Klad On Design Pvt. Ltd','INDIA','TN',25),(23,'Bangalore','Plot No. 8A, Raisoni Industrial Park','Kirpekar Engineering Pvt. Ltd','INDIA','TN',11),(24,'KOLKATTA','No. 5 & 6, Survey No - 38/2','Khushbu Engineers','INDIA','TN',11),(25,'Bangalore','Nadakerappa Industrial Estate','Kennametal India Ltd.','INDIA','TN',11),(26,'Bangalore','353-354 9th Cross, 4th Main','Kawa Press Systems Pvt Ltd','INDIA','TN',11),(27,'Bangalore','IV Phase, Peenya Industrial Area','Jash Precision Tools Ltd','INDIA','TN',5),(28,'Bangalore','B-29, EEIE, Stage-II,','ITL Industries Ltd.','INDIA','TN',5),(29,'Bangalore','D-134, Ansa Indl. Estate','HMT Machine Tools Ltd.','INDIA','MP',5),(30,'Bangalore','Saki Vihar Road, Sakinaka','Hindustan Hydraulics Pvt. Ltd.','INDIA','MP',5),(31,'KOLKATTA','C-27, 28, Industrial Area,','Harve Machinentecniq Pvt. Ltd.','INDIA','MP',15),(32,'KOLKATTA','Sri Sri Gaushala Compound','Gujarat Lathe Manufacturing Co. Pvt. Ltd','INDIA','MP',15),(33,'KOLKATTA','Jintan Udhyognagar,','Gedee Weiler Pvt. Ltd.','INDIA','MP',15),(34,'KOLKATTA','26C/27A, 2nd Phase, Peenya Industrial Area','Gahir Industries (Regd.)','INDIA','MP',20),(35,'KOLKATTA','17, Changodar Industrial Estate','G. W. Precision Tools India Pvt Ltd','INDIA','MP',20),(36,'KOLKATTA','Sarkhej-Bawla Highway, Changodar','Electropneumatics & Hydraulics (I) Pvt. Ltd.','INDIA','MP',20),(37,'Bangalore','Taluka Sanand, Changodar','Electronica Machine Tools Ltd.','INDIA','MP',20),(38,'Bangalore','32/34, Jintan Udyognagar,','Divine Machines Pvt. Ltd.','INDIA','MP',32),(39,'Bangalore','Behind Gas Godown','Dahanukar Machine Tools','INDIA','MP',32);

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

insert  into `walking_details`(`id`,`venu`,`walkingdate`,`walking_time`,`walking_rep_time`) values (1,' IonIdea Pvt. Ltd, # 38-40, EPIP, Whitefield, Bangalore 560 066. Besides SAP LABS Landmark: KTPO Stop, Near Ginger Hotel ','2016-11-28','12:22:00','12:22:00'),(2,'3rd Main Road, Ashwini Layout, Ejipura','2016-11-23','14:24:00','12:22:00'),(3,'6th Floor, Gold Hill Square Software Park,, No. 690, Bommanahalli,, Hosur Rd, Garvebhavi Palya, Bengaluru, Karnataka 560068','2016-11-06','00:00:00','12:22:00'),(4,'45/4, Tumkur Road, Yeshwanthpur Metro Station, Opposite to More Hypermarket, Yeshwantpu','2016-11-09','23:41:58','12:22:00'),(5,'College Road, Vadkun,','2016-11-04','19:14:00','12:22:00'),(7,'Gauge House67, Hadapsar Industrial Estate','2016-11-09','23:41:58','12:22:00'),(8,'Peenya Industrial Area','2016-11-23','23:41:58','12:22:00'),(9,'Kanta Vikas Gruh Road','2016-11-09','23:41:58','12:22:00'),(10,'Kharabe Wadi, Gat No 254/255','2016-11-09','14:24:00','12:22:00'),(11,'Chakan -Talegaon Road\r','2016-11-09','14:24:00','12:22:00'),(12,'Bommasandra Industrial Estate','2016-11-23','14:24:00','12:22:00'),(13,'2816 Jammu Colony, St No 1','2016-11-23','14:24:00','12:22:00'),(14,'Vellalore Road,','2016-11-04','14:24:00','12:22:00'),(15,'No. 264/75, 36th Cross, 2nd Main,8th Block, Jayanagar','2016-11-09','19:14:00','12:22:00'),(16,'B-14, Ambattur Industrial Estate','2016-11-09','19:14:00','12:22:00'),(17,'GF 1, 6th Main, KSSIDC Building','2016-11-09','19:14:00','12:22:00'),(18,'Peenya Industrial Area','2016-11-09','19:14:00','12:22:00'),(19,'Whitefield','2016-11-02','19:14:00','12:22:00'),(20,'418, Industrial Area \'A\'\r','2016-11-12','19:14:00','12:22:00'),(21,'B - 1/976, Rajpura Road,','2016-11-13','19:14:00','12:22:00'),(22,'Plot No. C 16, M.I.D.C.','2016-11-21','19:14:00','12:22:00'),(23,'Opp. MTNL Office, L.B.S. Marg','2016-11-26','23:41:58','12:22:00'),(24,'201, Karma Stambh,','2016-11-14','23:41:58','12:22:00'),(25,'292, D D Marg,','2016-11-24','23:41:58','12:22:00'),(26,'Chhani Road','2016-11-26','23:41:58','12:22:00'),(27,'W 401-TTC Industrial Area,','2016-11-13','14:24:00','12:22:00'),(28,'MIDC, Rabale,','2016-11-13','14:24:00','12:22:00'),(29,'No.130/6B, Petechennappa Industrial Estate','2016-11-13','23:41:58','12:22:00'),(30,'Magadi Main Road','2016-11-13','14:24:00','12:22:00'),(31,'Kamakshipalya','2016-11-13','23:41:58','12:22:00'),(32,'P.O. Chachoki,','2016-10-18','19:14:00','12:22:00'),(33,'No. 120, Bommasandra Industrial Area,','2016-10-20','19:14:00','12:22:00'),(34,'Tata Motors Campus','2016-12-21','19:14:00','12:22:00'),(35,'D-105, First Main Road,','2014-06-09','19:14:00','12:22:00'),(36,'Annanagar East,','2016-11-23','19:14:00','12:22:00'),(37,'No. 1-C, Plot No. 467, 468 & 469','2016-10-19','19:14:00','12:22:00'),(38,'12th Cross, 4th Phase','2016-10-19','19:14:00','12:22:00'),(39,'B-8, KSSIDC, Indl Estate','2016-10-19','19:14:00','12:22:00'),(40,'Bommasandra','2016-10-19','19:14:00','12:22:00'),(41,'Shed-8, F-II Block,','2016-10-19','19:14:00','12:22:00'),(42,'Dhebarbhai Road (South),','2016-10-19','19:14:00','12:22:00'),(43,'69 / 70, Sipcot Industrial Complex','2016-10-06','19:14:00','12:22:00'),(44,'Whitefield Road','2016-10-06','19:14:00','12:22:00'),(45,'19/4, Molacha Odha','2016-10-06','19:14:00','12:22:00'),(46,'67, Hadapsar Industrial Estate','2016-10-06','19:14:00','12:22:00'),(47,'Plot No. 467 to 469, 4th Phase','2016-10-06','14:24:00','12:22:00'),(48,'472-A, 12th Cross','2016-10-06','14:24:00','12:22:00'),(49,'5th K.M. National Highway No.4,','2016-11-13','14:24:00','12:22:00'),(50,'8, Gaiwadi Industrial Estate','2016-11-13','14:24:00','12:22:00'),(55,'S.V. Road, Goregaon (W),','2016-11-13','14:24:00','12:22:00'),(56,'A-16, H-Block, MIDC','2016-11-13','14:24:00','12:22:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

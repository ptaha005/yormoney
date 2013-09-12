# Host: localhost  (Version: 5.6.12)
# Date: 2013-07-05 17:02:28
# Generator: MySQL-Front 5.3  (Build 4.4)

/*!40101 SET NAMES utf8 */;

#
# Source for table "account_type"
#

DROP TABLE IF EXISTS `account_type`;
CREATE TABLE `account_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "account_type"
#


#
# Source for table "bank"
#

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bank"
#


#
# Source for table "banner"
#

DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "banner"
#


#
# Source for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



#
# Source for table "expenditure_type"
#

DROP TABLE IF EXISTS `expenditure_type`;
CREATE TABLE `expenditure_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_92` (`category_id`),
  CONSTRAINT `expenditure_type_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#
# Source for table "family"
#

DROP TABLE IF EXISTS `family`;
CREATE TABLE `family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "family"
#

INSERT INTO `family` VALUES (1,'test_family');

#
# Source for table "income_type"
#

DROP TABLE IF EXISTS `income_type`;
CREATE TABLE `income_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#
# Source for table "page"
#

DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(60) DEFAULT NULL,
  `url` varchar(60) DEFAULT NULL,
  `banner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_100` (`banner_id`),
  CONSTRAINT `page_ibfk_1` FOREIGN KEY (`banner_id`) REFERENCES `banner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "page"
#


#
# Source for table "relationship"
#

DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



#
# Source for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postcode` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `activation_code` varchar(25) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `dateOFBirth` date DEFAULT NULL,
  `occupation` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_106` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#
# Source for table "member"
#

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_birth` char(18) DEFAULT NULL,
  `account_holder` tinyint(1) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `relationship_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `family_id` int(11) NOT NULL,
  `occupation` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_83` (`relationship_id`),
  KEY `R_101` (`user_id`),
  KEY `R99` (`family_id`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`relationship_id`) REFERENCES `relationship` (`id`),
  CONSTRAINT `member_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `member_ibfk_3` FOREIGN KEY (`family_id`) REFERENCES `family` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#
# Source for table "bank_account"
#

DROP TABLE IF EXISTS `bank_account`;
CREATE TABLE `bank_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purpose` varchar(50) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `account_type_id` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_86` (`member_id`),
  KEY `R_87` (`account_type_id`),
  KEY `R_88` (`bank_id`),
  CONSTRAINT `bank_account_ibfk_3` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`),
  CONSTRAINT `bank_account_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `bank_account_ibfk_2` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bank_account"
#


#
# Source for table "transaction"
#

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_account` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_84` (`user_id`),
  KEY `R_85` (`bank_account`),
  CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`bank_account`) REFERENCES `bank_account` (`id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "transaction"
#


#
# Source for table "income"
#

DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `income_source` varchar(30) DEFAULT NULL,
  `paid_date_day` int(11) DEFAULT NULL,
  `frequency` varchar(30) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `paid_A_C` varchar(30) DEFAULT NULL,
  `income_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_80` (`income_type_id`),
  KEY `R_81` (`user_id`),
  KEY `R_82` (`member_id`),
  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`income_type_id`) REFERENCES `income_type` (`id`),
  CONSTRAINT `income_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `income_ibfk_3` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


#
# Source for table "expenditure"
#

DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `Company_name` varchar(30) DEFAULT NULL,
  `paid_date_day` int(11) DEFAULT NULL,
  `frequency` varchar(30) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `paid_from_A_C` varchar(30) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `expenditure_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_93` (`member_id`),
  KEY `R_94` (`user_id`),
  KEY `R_96` (`expenditure_type_id`),
  CONSTRAINT `expenditure_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `expenditure_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `expenditure_ibfk_3` FOREIGN KEY (`expenditure_type_id`) REFERENCES `expenditure_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



#
# Source for table "event"
#

DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `expenditure_item` char(18) DEFAULT NULL,
  `agreed_spend` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_91` (`user_id`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "event"
#


#
# Source for table "eventevent"
#

DROP TABLE IF EXISTS `eventevent`;
CREATE TABLE `eventevent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id1` int(11) DEFAULT NULL,
  `event_id2` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `event_id1` (`event_id1`),
  KEY `event_id2` (`event_id2`),
  CONSTRAINT `eventevent_ibfk_2` FOREIGN KEY (`event_id2`) REFERENCES `event` (`id`),
  CONSTRAINT `eventevent_ibfk_1` FOREIGN KEY (`event_id1`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "eventevent"
#


#
# Source for table "event_type"
#

DROP TABLE IF EXISTS `event_type`;
CREATE TABLE `event_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_90` (`event_id`),
  CONSTRAINT `event_type_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "event_type"
#


#
# Data for table "category"
#

INSERT INTO `category` VALUES (1,'home'),(2,'car');

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'regular'),(2,'premium');

#
# Data for table "relationship"
#

INSERT INTO `relationship` VALUES (1,'son'),(2,'mother'),(3,'father');


#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,2222,'test@text.ru','yormoney','9108dcca5861fbb4ecc43f8fa71ea34b','0000-0000-0000-0000','test','test','sfsf',1,'2002-02-02','test');

#
# Data for table "member"
#

INSERT INTO `member` VALUES (1,'2002-02-02',0,'test','test','testadd',1,1,1,'4ert'),(2,'2002-02-02',1,'test2','test2','test2add',2,1,1,'sffs');


#
# Data for table "income_type"
#

INSERT INTO `income_type` VALUES (1,'salary'),(2,'securities'),(3,'investment');

#
# Data for table "income"
#

INSERT INTO `income` VALUES (1,0,'work',20,'MONTH',1000,'paid',1,1,1),(2,1,'codex',12,'WEEK',200,'paid',1,1,2),(3,0,'work',15,'MONTH',800,'paid',2,1,2);

#
# Data for table "expenditure_type"
#

INSERT INTO `expenditure_type` VALUES (1,'light',1),(2,'petrol',2);

#
# Data for table "expenditure"
#

INSERT INTO `expenditure` VALUES (1,0,'codexsoft',20,'MONTH',1000,'paid',1,1,1);




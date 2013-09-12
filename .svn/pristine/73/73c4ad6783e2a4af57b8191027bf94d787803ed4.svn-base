-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: localhost    Database: yormoney
-- ------------------------------------------------------
-- Server version	5.6.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_562ovss2fxuslx3ad2ld0wr9x` (`company_id`),
  CONSTRAINT `FK_562ovss2fxuslx3ad2ld0wr9x` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'dasd',NULL,NULL),(2,'dasd',NULL,NULL),(3,'dasd',NULL,NULL),(4,'dasd',NULL,NULL),(5,'dasd',NULL,NULL),(6,'dasd',NULL,NULL),(7,'dasd',NULL,NULL),(8,'dasd',8,NULL),(9,'dsdf',NULL,'sdff'),(12,'423432',9,'dfsdf');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purpose` varchar(50) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `account_type_id` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_86` (`member_id`),
  KEY `R_87` (`account_type_id`),
  KEY `R_88` (`bank_id`),
  KEY `FK_ss4uej5gx2a07srb540l15s21` (`user_id`),
  CONSTRAINT `FK_ss4uej5gx2a07srb540l15s21` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `bank_account_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `bank_account_ibfk_2` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`id`),
  CONSTRAINT `bank_account_ibfk_3` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
INSERT INTO `bank_account` VALUES (1,NULL,NULL,NULL,NULL,NULL,1),(2,'dsfsfs',2443,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(120) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_89057uwi3bmq313qs1qo308us` (`page_id`),
  CONSTRAINT `FK_89057uwi3bmq313qs1qo308us` FOREIGN KEY (`page_id`) REFERENCES `page` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (1,'/resources/upload/banner.jpg',NULL,'banner for home 1','data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSEBQUEhIUFBQVFBUVFBcXFRYXFRQXFBUVFRQVFBQXHCYeFxkjGRUUHy8gIycpLCwsFR4xNTAqNSYrLCkBCQoKDgwOFA8PFykcHBwpKSkpKSkpKSkpKSkpKSkpKSwpLCksKSkpKSkpKSkpKSkpKSwpKSkpKSkpNSwsKSkuKf/AABEIAMIBBAMBIgACEQEDEQH/',NULL,9),(2,'/resources/upload/banner.jpg',NULL,'banner for home 2','data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSEBQUEhIUFBQVFBUVFBcXFRYXFRQXFBUVFRQVFBQXHCYeFxkjGRUUHy8gIycpLCwsFR4xNTAqNSYrLCkBCQoKDgwOFA8PFykcHBwpKSkpKSkpKSkpKSkpKSkpKSwpLCksKSkpKSkpKSkpKSkpKSwpKSkpKSkpNSwsKSkuKf/AABEIAMIBBAMBIgACEQEDEQH/',NULL,9),(3,'/resources/upload/banner.jpg',NULL,'banner for proIngo3','data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSEBQUEhIUFBQVFBUVFBcXFRYXFRQXFBUVFRQVFBQXHCYeFxkjGRUUHy8gIycpLCwsFR4xNTAqNSYrLCkBCQoKDgwOFA8PFykcHBwpKSkpKSkpKSkpKSkpKSkpKSwpLCksKSkpKSkpKSkpKSkpKSwpKSkpKSkpNSwsKSkuKf/AABEIAMIBBAMBIgACEQEDEQH/',NULL,10),(4,'/resources/upload/banner.jpg',NULL,'banner for proIngo2','data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSEBQUEhIUFBQVFBUVFBcXFRYXFRQXFBUVFRQVFBQXHCYeFxkjGRUUHy8gIycpLCwsFR4xNTAqNSYrLCkBCQoKDgwOFA8PFykcHBwpKSkpKSkpKSkpKSkpKSkpKSwpLCksKSkpKSkpKSkpKSkpKSwpKSkpKSkpNSwsKSkuKf/AABEIAMIBBAMBIgACEQEDEQH/',NULL,10),(5,'/resources/upload/banner.jpg',NULL,'banner for proIngo','data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBhQSEBQUEhIUFBQVFBUVFBcXFRYXFRQXFBUVFRQVFBQXHCYeFxkjGRUUHy8gIycpLCwsFR4xNTAqNSYrLCkBCQoKDgwOFA8PFykcHBwpKSkpKSkpKSkpKSkpKSkpKSwpLCksKSkpKSkpKSkpKSkpKSwpKSkpKSkpNSwsKSkuKf/AABEIAMIBBAMBIgACEQEDEQH/',NULL,10);
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendar_event`
--

DROP TABLE IF EXISTS `calendar_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendar_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pgrw26os0rc304m1ujh1gugge` (`user_id`),
  CONSTRAINT `FK_pgrw26os0rc304m1ujh1gugge` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar_event`
--

LOCK TABLES `calendar_event` WRITE;
/*!40000 ALTER TABLE `calendar_event` DISABLE KEYS */;
INSERT INTO `calendar_event` VALUES (1,'2013-07-19 00:00:00','2013-07-19 00:00:00','nochnie',1,0,'http://yahoo.com/',0),(2,'2013-07-29 00:00:00','2013-07-29 00:00:00','Work',1,0,'http://yahoo.com/',0),(3,'2013-07-05 00:00:00','2013-07-05 00:00:00','R5',1,1,'http://yahoo.com/',0),(4,'2013-07-08 00:00:00','2013-07-08 00:00:00','R10',1,2,'http://yahoo.com/',0),(5,'2013-07-12 00:00:00','2013-07-12 00:00:00','R15',1,2,'http://yahoo.com/',0),(6,'2013-07-24 00:00:00','2013-07-24 00:00:00','R20',1,1,'http://yahoo.com/',0),(7,'2013-07-25 00:00:00','2013-07-25 00:00:00','R25',1,3,'http://yahoo.com/',0),(8,'2013-07-14 00:00:00','2013-07-14 00:00:00','R30',1,3,'http://yahoo.com/',0),(9,'2013-07-01 00:00:00','2013-07-01 00:00:00','L1',1,0,'http://yahoo.com/',0),(10,'2013-07-09 00:00:00','2013-07-09 00:00:00','L2',1,0,'http://yahoo.com/',0),(11,'2013-07-01 00:00:00','2013-07-01 00:00:00','L3',1,1,'http://yahoo.com/',0),(12,'2013-07-10 00:00:00','2013-07-10 00:00:00','L4',1,2,'http://yahoo.com/',0),(13,'2013-07-01 00:00:00','2013-07-01 00:00:00','L5',1,2,'http://yahoo.com/',0),(14,'2013-07-10 00:00:00','2013-07-10 00:00:00','L6',1,1,'http://yahoo.com/',0),(15,'2013-07-01 00:00:00','2013-07-01 00:00:00','L7',1,3,'http://yahoo.com/',0),(16,'2013-07-09 00:00:00','2013-07-09 00:00:00','L8',1,3,'http://yahoo.com/',0),(17,'2013-06-19 00:00:00','2013-06-15 00:00:00','Last month',1,0,'http://yahoo.com/',0),(18,'2013-06-29 00:00:00','2013-06-25 00:00:00','Last month2',1,0,'http://yahoo.com/',0),(19,'2013-06-05 00:00:00','2013-06-04 00:00:00','Last month3',1,1,'http://yahoo.com/',0),(20,'2013-06-08 00:00:00','2013-06-05 00:00:00','Last month3',1,2,'http://yahoo.com/',0),(21,'2013-06-12 00:00:00','2013-06-07 00:00:00','Last month4',1,2,'http://yahoo.com/',0),(22,'2013-06-24 00:00:00','2013-07-09 00:00:00','Last month5',1,1,'http://yahoo.com/',0),(23,'2013-06-25 00:00:00','2013-07-15 00:00:00','Last month6',1,3,'http://yahoo.com/',0),(24,'2013-06-17 00:00:00','2013-07-14 00:00:00','Last month7',1,3,'http://yahoo.com/',0),(25,'2013-07-29 00:00:00','2013-07-22 00:00:00','nochnie',1,0,'http://yahoo.com/',0),(26,'2013-07-29 00:00:00','2013-07-23 00:00:00','Work',1,0,'http://yahoo.com/',0);
/*!40000 ALTER TABLE `calendar_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'home'),(2,'car');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `insurance_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ey41ljphkekyodtm6n7pcj6tu` (`insurance_id`),
  CONSTRAINT `FK_ey41ljphkekyodtm6n7pcj6tu` FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'adad',NULL),(2,'adad',NULL),(3,'adad',NULL),(4,'adad',NULL),(5,'adad',NULL),(6,'adad',NULL),(7,'adad',NULL),(8,'adad',NULL),(9,NULL,NULL),(10,NULL,NULL),(11,NULL,NULL),(12,NULL,NULL),(13,NULL,NULL),(14,NULL,NULL),(15,NULL,NULL),(16,NULL,NULL),(17,NULL,NULL),(18,NULL,NULL),(19,NULL,NULL),(20,NULL,NULL),(21,NULL,NULL),(22,NULL,NULL),(23,NULL,NULL),(24,NULL,NULL),(25,NULL,NULL),(26,NULL,NULL),(27,NULL,NULL),(28,NULL,NULL),(29,NULL,NULL),(30,NULL,NULL),(31,NULL,NULL),(32,NULL,NULL),(33,NULL,NULL),(34,NULL,NULL),(35,NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_address`
--

DROP TABLE IF EXISTS `company_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_address` (
  `company_id` bigint(20) NOT NULL,
  `addresses_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_srjpewpvwh81vmcgkdywxt1y3` (`addresses_id`),
  KEY `FK_srjpewpvwh81vmcgkdywxt1y3` (`addresses_id`),
  KEY `FK_2da3xscp9prbnb537ahvjbj3c` (`company_id`),
  CONSTRAINT `FK_2da3xscp9prbnb537ahvjbj3c` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `FK_srjpewpvwh81vmcgkdywxt1y3` FOREIGN KEY (`addresses_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_address`
--

LOCK TABLES `company_address` WRITE;
/*!40000 ALTER TABLE `company_address` DISABLE KEYS */;
INSERT INTO `company_address` VALUES (4,4),(5,5),(6,6),(7,7);
/*!40000 ALTER TABLE `company_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(80) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fotopath` varchar(200) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `webaddress` varchar(80) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8puwpm02t2968gph4mr0my034` (`user_id`),
  CONSTRAINT `FK_8puwpm02t2968gph4mr0my034` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `folder_id` bigint(20) DEFAULT NULL,
  `system_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5e9aqqhuel3k11ii305m6siaa` (`folder_id`),
  KEY `FK_esb799ihho7ek44mndbsvmyit` (`user_id`),
  CONSTRAINT `FK_5e9aqqhuel3k11ii305m6siaa` FOREIGN KEY (`folder_id`) REFERENCES `folder` (`id`),
  CONSTRAINT `FK_esb799ihho7ek44mndbsvmyit` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (19,'images.jpg','/home/andrew/projects/codex/yormoney/src/main/webapp/file/1/',5,1,'po',6,'bde615c3-3264-44ab-a993-6ed737f93f26.jpg'),(20,'images.jpg','/home/andrew/projects/codex/yormoney/src/main/webapp/file/1/',5,1,'po',6,'bb943005-2607-4ffc-8b8d-6337d30627bc.jpg');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `expenditure_item` char(18) DEFAULT NULL,
  `agreed_spend` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `event_expenditure_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_91` (`user_id`),
  KEY `FK_p3fccve32bwmf1997cpf3y8n1` (`event_expenditure_type`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_p3fccve32bwmf1997cpf3y8n1` FOREIGN KEY (`event_expenditure_type`) REFERENCES `event_expenditure_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (13,NULL,NULL,324,'2013-07-01',1,1),(14,NULL,NULL,234,'2013-07-02',1,2),(15,NULL,NULL,234,'2013-07-10',1,3),(16,NULL,NULL,234234,NULL,1,4),(17,NULL,NULL,234,'2013-07-09',1,10),(18,NULL,NULL,234234,'2013-07-02',1,11),(19,NULL,NULL,32432,NULL,1,12),(20,NULL,NULL,3243234,'2013-07-09',1,13);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_expenditure_level`
--

DROP TABLE IF EXISTS `event_expenditure_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_expenditure_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `order_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_expenditure_level`
--

LOCK TABLES `event_expenditure_level` WRITE;
/*!40000 ALTER TABLE `event_expenditure_level` DISABLE KEYS */;
INSERT INTO `event_expenditure_level` VALUES (0,NULL,NULL),(1,'first',1),(2,'second',2),(3,'third',3),(4,'fourth',4);
/*!40000 ALTER TABLE `event_expenditure_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_expenditure_type`
--

DROP TABLE IF EXISTS `event_expenditure_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_expenditure_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `level_id` bigint(20) NOT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t4il1jsn5xtuec3k6whix9hfk` (`level_id`),
  KEY `FK_svbx7s76lbi8o46xi2wt4nyju` (`type_id`),
  CONSTRAINT `FK_svbx7s76lbi8o46xi2wt4nyju` FOREIGN KEY (`type_id`) REFERENCES `event_expenditure_type` (`id`),
  CONSTRAINT `FK_t4il1jsn5xtuec3k6whix9hfk` FOREIGN KEY (`level_id`) REFERENCES `event_expenditure_level` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_expenditure_type`
--

LOCK TABLES `event_expenditure_type` WRITE;
/*!40000 ALTER TABLE `event_expenditure_type` DISABLE KEYS */;
INSERT INTO `event_expenditure_type` VALUES (0,NULL,0,NULL),(1,'Christmas',1,0),(2,'Birthdays',1,0),(3,'Holidays',1,0),(4,'Home',1,0),(5,'Holiday deposit',2,3),(6,'Holiday final payment',2,3),(7,'Spending Money',2,3),(8,'Travel transfer cost',2,3),(9,'Closing',2,3),(10,'Gift for self and partner',2,1),(11,'Gift for children',2,1),(12,'Gift for other family members',2,1),(13,'Christmas parties',2,1),(14,'Parents',3,12),(15,'Brothers and Sisters',3,12),(16,'Grandparents',3,12),(17,'Cousins',3,12),(18,'Ben',4,15),(19,'Mark',4,15),(20,'Susan',4,15);
/*!40000 ALTER TABLE `event_expenditure_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_type`
--

DROP TABLE IF EXISTS `event_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_90` (`event_id`),
  CONSTRAINT `event_type_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_type`
--

LOCK TABLES `event_type` WRITE;
/*!40000 ALTER TABLE `event_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventevent`
--

DROP TABLE IF EXISTS `eventevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventevent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id1` int(11) DEFAULT NULL,
  `event_id2` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `event_id1` (`event_id1`),
  KEY `event_id2` (`event_id2`),
  CONSTRAINT `eventevent_ibfk_1` FOREIGN KEY (`event_id1`) REFERENCES `event` (`id`),
  CONSTRAINT `eventevent_ibfk_2` FOREIGN KEY (`event_id2`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventevent`
--

LOCK TABLES `eventevent` WRITE;
/*!40000 ALTER TABLE `eventevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenditure`
--

DROP TABLE IF EXISTS `expenditure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expenditure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `Company_name` varchar(30) DEFAULT NULL,
  `paid_date_day` int(11) DEFAULT NULL,
  `frequency` varchar(30) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `expenditure_type_id` int(11) DEFAULT NULL,
  `paid_day` int(11) DEFAULT NULL,
  `paid_on` datetime DEFAULT NULL,
  `paid_on_day` tinyint(1) DEFAULT NULL,
  `question` varchar(30) DEFAULT NULL,
  `paid_from_a_c` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_93` (`member_id`),
  KEY `R_94` (`user_id`),
  KEY `R_96` (`expenditure_type_id`),
  KEY `FK_8ykpclb9oh4w7a8dx03wgfnya` (`paid_from_a_c`),
  CONSTRAINT `FK_8ykpclb9oh4w7a8dx03wgfnya` FOREIGN KEY (`paid_from_a_c`) REFERENCES `bank_account` (`id`),
  CONSTRAINT `expenditure_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `expenditure_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `expenditure_ibfk_3` FOREIGN KEY (`expenditure_type_id`) REFERENCES `expenditure_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenditure`
--

LOCK TABLES `expenditure` WRITE;
/*!40000 ALTER TABLE `expenditure` DISABLE KEYS */;
INSERT INTO `expenditure` VALUES (1,0,'codexsoft',NULL,'MONTH',1000,1,1,NULL,NULL,NULL,NULL,NULL,NULL),(2,0,'codex',NULL,'WEEK',500,1,1,NULL,NULL,NULL,NULL,NULL,NULL),(10,0,'gfdgfd',NULL,NULL,443535,1,1,NULL,NULL,NULL,NULL,NULL,NULL),(13,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `expenditure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenditure_type`
--

DROP TABLE IF EXISTS `expenditure_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expenditure_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_92` (`category_id`),
  CONSTRAINT `expenditure_type_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenditure_type`
--

LOCK TABLES `expenditure_type` WRITE;
/*!40000 ALTER TABLE `expenditure_type` DISABLE KEYS */;
INSERT INTO `expenditure_type` VALUES (1,'light',NULL),(2,'petrol',NULL);
/*!40000 ALTER TABLE `expenditure_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES (1,'test_family');
/*!40000 ALTER TABLE `family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `folder`
--

DROP TABLE IF EXISTS `folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `folder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e8vb15i8rcevy60pmffv3mgln` (`user_id`),
  CONSTRAINT `FK_e8vb15i8rcevy60pmffv3mgln` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folder`
--

LOCK TABLES `folder` WRITE;
/*!40000 ALTER TABLE `folder` DISABLE KEYS */;
INSERT INTO `folder` VALUES (6,'po',1),(8,'asqq',1),(9,'jk',1),(10,'po1',1);
/*!40000 ALTER TABLE `folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT NULL,
  `income_source` varchar(30) DEFAULT NULL,
  `paid_date_day` int(11) DEFAULT NULL,
  `frequency` varchar(30) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `income_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `paid_day` int(11) DEFAULT NULL,
  `paid_on` datetime DEFAULT NULL,
  `paid_on_day` tinyint(1) DEFAULT NULL,
  `question` varchar(30) DEFAULT NULL,
  `paid_ac_id` int(11) DEFAULT NULL,
  `paid_A_C` int(11) DEFAULT NULL,
  `banlAccount` tinyblob,
  `paid_ac` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_80` (`income_type_id`),
  KEY `R_81` (`user_id`),
  KEY `R_82` (`member_id`),
  KEY `paid_ac_id` (`paid_ac_id`),
  KEY `FK_84efs6m7j2cjip156i1h3ljg3` (`paid_A_C`),
  CONSTRAINT `FK_84efs6m7j2cjip156i1h3ljg3` FOREIGN KEY (`paid_A_C`) REFERENCES `bank_account` (`id`),
  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`income_type_id`) REFERENCES `income_type` (`id`),
  CONSTRAINT `income_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `income_ibfk_3` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `income_ibfk_4` FOREIGN KEY (`paid_ac_id`) REFERENCES `bank_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income_type`
--

DROP TABLE IF EXISTS `income_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `income_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income_type`
--

LOCK TABLES `income_type` WRITE;
/*!40000 ALTER TABLE `income_type` DISABLE KEYS */;
INSERT INTO `income_type` VALUES (1,'salary'),(2,'securities'),(3,'investment');
/*!40000 ALTER TABLE `income_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `insurance_company` bigint(20) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `payment_date` varchar(100) DEFAULT NULL,
  `policy_number` varchar(255) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `bank_account_id` int(11) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `insurance_company_id` bigint(20) DEFAULT NULL,
  `lifeAssuarence` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_j9jipi6y0cblgr7i55xn9y4bc` (`insurance_company`),
  KEY `FK_kh28cc5u8ka8clcp2pe2oawft` (`company_id`),
  KEY `FK_96buwq0cuv8g8nx9imiym1ua8` (`insurance_company_id`),
  KEY `FK_i98a95p714oufe5qj7l8es048` (`bank_account_id`),
  KEY `FK_errqpou9u3x4k1schpdvw55q0` (`user_id`),
  CONSTRAINT `FK_96buwq0cuv8g8nx9imiym1ua8` FOREIGN KEY (`insurance_company_id`) REFERENCES `insurance_company` (`id`),
  CONSTRAINT `FK_errqpou9u3x4k1schpdvw55q0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_i98a95p714oufe5qj7l8es048` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_account` (`id`),
  CONSTRAINT `FK_kh28cc5u8ka8clcp2pe2oawft` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES (18,NULL,'124124','2013-07-17 00:00:00',1,'1','214','14124','2013-07-02 00:00:00',1,35,1,'fdgdf',1,214);
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_company`
--

DROP TABLE IF EXISTS `insurance_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `path_file_policy` varchar(255) DEFAULT NULL,
  `path_image_brend` varchar(255) DEFAULT NULL,
  `payment_monthly` varchar(255) DEFAULT NULL,
  `payment_changes` tinyint(1) DEFAULT NULL,
  `policy_features` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_company`
--

LOCK TABLES `insurance_company` WRITE;
/*!40000 ALTER TABLE `insurance_company` DISABLE KEYS */;
INSERT INTO `insurance_company` VALUES (1,'Company 1','c://image.jpg','/pages/img/scott.png','200',1,'<p><img src=\"/pages/img/done.png\">Pays on diagnosis of terminal illness</p> <p><img src=\"/pages/img/done.png\">Can be amended if circumstances change'),(2,'Company 2','c://image.jpg','/pages/img/aviva.png','200',0,' <p><img src=\"/pages/img/done.png\">Pays on diagnosis of terminal illness</p> <p><img src=\"/pages/img/done.png\">Can be amended if circumstances change</p>');
/*!40000 ALTER TABLE `insurance_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manual`
--

DROP TABLE IF EXISTS `manual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manual` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(120) DEFAULT NULL,
  `page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mi8rf5lxe8pg3ksm214h8sc8i` (`page_id`),
  CONSTRAINT `FK_mi8rf5lxe8pg3ksm214h8sc8i` FOREIGN KEY (`page_id`) REFERENCES `page` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manual`
--

LOCK TABLES `manual` WRITE;
/*!40000 ALTER TABLE `manual` DISABLE KEYS */;
INSERT INTO `manual` VALUES (1,'s','s1',1),(2,'sss','s2',2),(3,'ssss','s3',3),(4,'sssss','s4',4),(5,'ssssss','s5',5),(6,'sssssss','s6',6),(7,'ssssssss','s7',7),(8,'sssssssss','s8',8);
/*!40000 ALTER TABLE `manual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_83` (`relationship_id`),
  KEY `R_101` (`user_id`),
  KEY `R99` (`family_id`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`relationship_id`) REFERENCES `relationship` (`id`),
  CONSTRAINT `member_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `member_ibfk_3` FOREIGN KEY (`family_id`) REFERENCES `family` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'2002-02-02',0,'test','test','testadd',1,1,1,'4ert',NULL),(2,'2002-02-02',1,'test2','test2','test2add',2,1,1,'sffs',NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `contact_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `insurance_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9nf4q42xtwcuwiu0yf4uvfgqq` (`contact_id`),
  KEY `FK_2ttst170j8w7crlovb2fh7kda` (`task_id`),
  KEY `FK_cbb09bm0unqfcomjy7h1o9ql8` (`insurance_id`),
  KEY `FK_7strs0d8haoaf5fswi40yh5j7` (`user_id`),
  CONSTRAINT `FK_7strs0d8haoaf5fswi40yh5j7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_2ttst170j8w7crlovb2fh7kda` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_9nf4q42xtwcuwiu0yf4uvfgqq` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (3,'2000-01-03 02:00:00','11111',NULL,NULL,NULL,NULL,NULL),(4,'2000-01-13 02:00:00','22222',NULL,NULL,NULL,NULL,NULL),(5,'2000-01-03 02:00:00','11111',NULL,NULL,NULL,NULL,NULL),(6,'2000-01-13 02:00:00','22222',NULL,NULL,NULL,NULL,NULL),(7,'2000-01-03 02:00:00','11111',NULL,NULL,NULL,NULL,NULL),(8,'2000-01-13 02:00:00','22222',NULL,NULL,NULL,NULL,NULL),(9,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,NULL),(10,'2000-01-01 02:00:00','uuututut',NULL,NULL,NULL,NULL,NULL),(13,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,NULL),(14,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,NULL),(15,'2000-01-01 02:00:00','sdfsdfsdf',NULL,NULL,NULL,NULL,NULL),(16,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,NULL),(17,'2000-01-01 02:00:00','ewfewfewf',NULL,NULL,NULL,NULL,NULL),(18,'2000-01-01 02:00:00','ewfewfewf',NULL,NULL,NULL,NULL,NULL),(19,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,NULL),(20,'2000-01-01 02:00:00','ewfewfewf',NULL,NULL,NULL,NULL,NULL),(21,'2000-01-01 02:00:00','dsfffsdf',NULL,NULL,NULL,NULL,NULL),(22,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,NULL),(23,'2000-01-01 02:00:00','dfsfsgg',NULL,NULL,NULL,NULL,NULL),(24,'2000-01-01 02:00:00','dfsfsgg',NULL,NULL,NULL,NULL,NULL),(25,'2000-01-01 02:00:00','dfsfsgg',NULL,NULL,NULL,NULL,1),(26,'2000-01-01 02:00:00','gsggs',NULL,NULL,NULL,NULL,NULL),(27,'2000-01-01 02:00:00','',NULL,NULL,NULL,NULL,1),(28,'2000-01-01 02:00:00','uuututut',NULL,NULL,1,NULL,NULL),(29,'2013-07-30 03:00:00','dsfdsfs',NULL,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(60) DEFAULT NULL,
  `url` varchar(60) DEFAULT NULL,
  `banner_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_100` (`banner_id`),
  CONSTRAINT `page_ibfk_1` FOREIGN KEY (`banner_id`) REFERENCES `banner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
INSERT INTO `page` VALUES (1,'register1',NULL,NULL,'register1'),(2,'welcome',NULL,NULL,'welcome'),(3,'register2',NULL,NULL,'register2'),(4,'bankaccounts',NULL,NULL,'bankaccountsada'),(5,'income',NULL,NULL,'income'),(6,'expenditure',NULL,NULL,'expenditure'),(7,'events',NULL,NULL,'events'),(8,'summary',NULL,NULL,'summary'),(9,'home',NULL,NULL,'home'),(10,'productInfo',NULL,NULL,'productInfo');
/*!40000 ALTER TABLE `page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c54u4is8ol1c85ciarbnxkbj3` (`company_id`),
  CONSTRAINT `FK_c54u4is8ol1c85ciarbnxkbj3` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (7,'424235',9,'silva');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_feature`
--

DROP TABLE IF EXISTS `policy_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy_feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `line` varchar(255) DEFAULT NULL,
  `insurance_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7ut41cu8p7l3o93l0xmrjcm1` (`insurance_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_feature`
--

LOCK TABLES `policy_feature` WRITE;
/*!40000 ALTER TABLE `policy_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship`
--

DROP TABLE IF EXISTS `relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship`
--

LOCK TABLES `relationship` WRITE;
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` VALUES (1,'son'),(2,'mother'),(3,'father');
/*!40000 ALTER TABLE `relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Regular'),(2,'Premium'),(3,'regRegular'),(4,'regPremium');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `complete` int(11) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `linkTo` varchar(50) DEFAULT NULL,
  `reminder` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4fmjedju7b35tb5cr71n3ntb0` (`user_id`),
  CONSTRAINT `FK_4fmjedju7b35tb5cr71n3ntb0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,30,'2014-07-02 03:00:00',NULL,2,'2014-04-06 03:00:00','343563456',1),(2,30,'2014-04-06 03:00:00',NULL,2,'2014-04-06 03:00:00','343563456',1),(3,30,'2014-04-06 03:00:00',NULL,2,'2014-04-06 03:00:00','343563456',1),(4,30,'2014-04-06 03:00:00',NULL,2,'2014-04-06 03:00:00','343563456',1),(5,30,'2013-06-06 03:00:00',NULL,2,'2013-06-06 03:00:00','test',1),(6,20,'2013-07-25 03:00:00',NULL,2,'2013-07-22 03:00:00','sdfdf',1),(7,30,'2013-07-25 03:00:00',NULL,6,'2013-07-24 03:00:00','gfgf',1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_account` int(11) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_84` (`user_id`),
  KEY `R_85` (`bank_account`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`bank_account`) REFERENCES `bank_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2013-07-22','insurance',1,NULL,200,'Insurance'),(2,'2013-07-23','insurance',1,NULL,200,'Insurance'),(3,'2013-07-24','insurance',1,NULL,200,NULL),(4,'2013-07-25','insurance',1,NULL,200,NULL),(5,'2013-07-22','insurance',1,NULL,200,NULL),(6,'2013-07-31','insurance',1,NULL,200,NULL);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postcode` varchar(30) DEFAULT NULL,
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
  `state` int(11) DEFAULT NULL,
  `describeState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `R_106` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2222','test@test.ru','yormoney','9108dcca5861fbb4ecc43f8fa71ea34b','0000-0000-0000-0000','test','test','sfsf',2,'2002-02-02','test',3,'register1'),(2,'23234','maxcd@mail.ru','sdfsf','fe5ad3556cc62105b8422bf25a07e507','48f7b-18cca-c34f5-4a175','ewr','wer','werwerwer',1,'2013-07-18','rewrwe',1,NULL),(3,'dgdgdfgd','iquira2@mail.ru','reeee','758e2391d2e3e33cb7adcd686f7c7ad3','5f6fe-abe17-ef440-48f63','gdfgfd','gdfg','gdfgdfgdgdfgd',1,'2013-07-03','rewww',1,'register1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `page_id` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_emcvkjbd910m79w2xr913r56a` (`page_id`),
  CONSTRAINT `FK_emcvkjbd910m79w2xr913r56a` FOREIGN KEY (`page_id`) REFERENCES `page` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'s1','http://www.youtube.com/embed/XGSy3_Czz8k',1,NULL,NULL),(2,'s2','http://www.youtube.com/embed/XGSy3_Czz8k',2,NULL,NULL),(3,'s3','http://www.youtube.com/embed/XGSy3_Czz8k',3,NULL,NULL),(4,'s5','http://www.youtube.com/embed/XGSy3_Czz8k',4,NULL,NULL),(5,'s5','http://www.youtube.com/embed/XGSy3_Czz8k',5,NULL,NULL),(6,'s6','http://www.youtube.com/embed/XGSy3_Czz8k',6,NULL,NULL),(7,'s7','http://www.youtube.com/embed/XGSy3_Czz8k',7,NULL,NULL),(8,'s8','http://www.youtube.com/embed/XGSy3_Czz8k',8,NULL,NULL);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-30 15:51:27

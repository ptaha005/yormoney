# Host: localhost  (Version: 5.6.12)
# Date: 2013-07-22 16:36:56
# Generator: MySQL-Front 5.3  (Build 4.4)

/*!40101 SET NAMES utf8 */;

#
# Data for table "insurance_company"
#

DELETE FROM insurance_company where id >0;

INSERT INTO `insurance_company` (`id`,`name`,`path_file_policy`,`path_image_brend`,`payment_monthly`,`payment_changes`,`policy_features`) VALUES (1,'Company 1','c://image.jpg','/pages/img/scott.png','200',1,'<p><img src=\"/pages/img/done.png\">Pays on diagnosis of terminal illness</p> <p><img src=\"/pages/img/done.png\">Can be amended if circumstances change'),(2,'Company 2' ,'c://image.jpg','/pages/img/aviva.png','200', 0,' <p><img src=\"/pages/img/done.png\">Pays on diagnosis of terminal illness</p> <p><img src=\"/pages/img/done.png\">Can be amended if circumstances change</p>');

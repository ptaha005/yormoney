DROP TABLE IF EXISTS `family`;
CREATE TABLE `family` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`description` varchar(150) NOT NULL, 
	PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `member` ADD COLUMN `family_id` int(11) NOT NULL;

ALTER TABLE `member` ADD FOREIGN KEY R99 (family_id) REFERENCES `family` (id);

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
-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server versie:                8.0.12 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Versie:              9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Databasestructuur van travelmore wordt geschreven
DROP DATABASE IF EXISTS `travelmore`;
CREATE DATABASE IF NOT EXISTS `travelmore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `travelmore`;


-- Structuur van  tabel travelmore.betaling wordt geschreven
CREATE TABLE IF NOT EXISTS `betaling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` datetime NOT NULL,
  `betalingstypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `betalingstypeId` (`betalingstypeId`),
  CONSTRAINT `betaling_ibfk_2` FOREIGN KEY (`betalingstypeId`) REFERENCES `betalingstype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Structuur van  tabel travelmore.betalingstype wordt geschreven
CREATE TABLE IF NOT EXISTS `betalingstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `betalingstype` (`id`, `naam`) VALUES
	(1, 'bancontact'),
	(2, 'paypal'),
	(3, 'visa');

-- Structuur van  tabel travelmore.boeking wordt geschreven
CREATE TABLE IF NOT EXISTS `boeking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gebruiker_id` int(11) NOT NULL,
  `reis_id` int(11) NOT NULL,
  `aantalPersonen` int(11) NOT NULL,
  `opmerking` varchar(255) DEFAULT NULL,
  `betaling_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `gebruikerId` (`gebruiker_id`),
  KEY `reisId` (`reis_id`),
  KEY `betalingId` (`betaling_id`),
  CONSTRAINT `boeking_ibfk_1` FOREIGN KEY (`gebruiker_id`) REFERENCES `gebruiker` (`id`),
  CONSTRAINT `boeking_ibfk_2` FOREIGN KEY (`reis_id`) REFERENCES `reis` (`id`),
  CONSTRAINT `boeking_ibfk_3` FOREIGN KEY (`betaling_id`) REFERENCES `betaling` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Structuur van  tabel travelmore.gebruiker wordt geschreven
CREATE TABLE IF NOT EXISTS `gebruiker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolId` int(11) NOT NULL,
  `naam` varchar(255) NOT NULL,
  `adres` varchar(255) NOT NULL,
  `woonplaats` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `wachtwoord` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `rolId` (`rolId`),
  CONSTRAINT `gebruiker_ibfk_1` FOREIGN KEY (`rolId`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Structuur van  tabel travelmore.locatie wordt geschreven
CREATE TABLE IF NOT EXISTS `locatie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumpen data van tabel travelmore.locatie: ~4 rows (ongeveer)
INSERT INTO `locatie` (`id`, `naam`) VALUES
	(1, 'Geel'),
	(2, 'Parijs'),
	(3, 'Brussel'),
	(4, 'Berlijn'),
	(5, 'Brugge'),
	(6, 'Antwerpen');
/*!40000 ALTER TABLE `locatie` ENABLE KEYS */;


-- Structuur van  tabel travelmore.reis wordt geschreven
CREATE TABLE IF NOT EXISTS `reis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) NOT NULL,
  `afbeelding` varchar(255),
  `vertrek_id` int(11) NOT NULL,
  `bestemming_id` int(11) NOT NULL,
  `aantalPlaatsen` int(11) NOT NULL,
  `kostprijs` double NOT NULL,
  `startdatum` datetime NOT NULL,
  `einddatum` datetime NOT NULL,
  `transportmiddel_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `transportmiddelId` (`transportmiddel_id`),
  KEY `vertrekId` (`vertrek_id`),
  KEY `bestemmingId` (`bestemming_id`),
  CONSTRAINT `reis_ibfk_1` FOREIGN KEY (`transportmiddel_id`) REFERENCES `transportmiddel` (`id`),
  CONSTRAINT `reis_ibfk_2` FOREIGN KEY (`vertrek_id`) REFERENCES `locatie` (`id`),
  CONSTRAINT `reis_ibfk_3` FOREIGN KEY (`bestemming_id`) REFERENCES `locatie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumpen data van tabel travelmore.reis: ~3 rows (ongeveer)
INSERT INTO `reis` (`id`, `naam`, `afbeelding`, `vertrek_id`, `bestemming_id`, `aantalPlaatsen`, `kostprijs`, `startdatum`, `einddatum`, `transportmiddel_id`) VALUES
	(2, 'Reis naar Parijs', 'parijs.jpg', 2, 2, 10, 249, '2018-01-01 00:00:00', '2018-01-07 00:00:00', 1),
	(3, 'Driedaagse naar Berlijn', 'berlijn.jpg', 3, 4, 25, 399, '2018-01-08 00:00:00', '2018-01-11 00:00:00', 2),
	(4, 'Reis naar Geel', 'geel.jpg', 1, 1, 5, 150, '2018-01-23 00:00:00', '2018-01-25 00:00:00', 3);
	(5, 'Fietstocht naar Brugge', NULL , 6, 5, 36, 254, '2018-11-05 00:00:00', '2018-11-06 00:00:00', 4);
/*!40000 ALTER TABLE `reis` ENABLE KEYS */;


-- Structuur van  tabel travelmore.rol wordt geschreven
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Structuur van  tabel travelmore.transportmiddel wordt geschreven
CREATE TABLE IF NOT EXISTS `transportmiddel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `transportmiddel` (`id`, `naam`) VALUES
	(1, 'Auto'),
	(2, 'Vliegtuig'),
	(3, 'Bus'),
	(4, 'Fiets');
/*!40000 ALTER TABLE `transportmiddel` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

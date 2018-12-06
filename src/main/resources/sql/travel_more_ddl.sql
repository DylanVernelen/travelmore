SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+01:00";

DROP DATABASE IF EXISTS travelmore;
CREATE DATABASE IF NOT EXISTS travelmore;

USE travelmore;

CREATE TABLE gebruiker (
  id int(11) NOT NULL AUTO_INCREMENT,
  rolId int(11) NOT NULL,
  naam varchar(255) NOT NULL,
  adres varchar(255) NOT NULL,
  woonplaats varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  wachtwoord varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE rol (
  id  int(11) NOT NULL AUTO_INCREMENT,
  naam varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE gebruiker
  ADD KEY rolId (rolId);

ALTER TABLE gebruiker
  ADD CONSTRAINT gebruiker_ibfk_1 FOREIGN KEY
  (rolId) REFERENCES rol (id);

CREATE TABLE reis (
  id  int(11) NOT NULL AUTO_INCREMENT,
  naam varchar(255) NOT NULL,
  afbeelding varchar(255) DEFAULT NULL,
  vertrek_id int(11) NOT NULL,
  bestemming_id int(11) NOT NULL,
  aantalPlaatsen int(11) NOT NULL,
  kostprijs double NOT NULL,
  startdatum datetime NOT NULL,
  einddatum datetime NOT NULL,
  transportmiddel_id int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE transportmiddel (
  id  int(11) NOT NULL AUTO_INCREMENT,
  naam varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE locatie (
  id  int(11) NOT NULL AUTO_INCREMENT,
  naam varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE reis
  ADD KEY transportmiddel_id (transportmiddel_id),
  ADD KEY vertrek_id (vertrek_id),
  ADD KEY bestemming_id (bestemming_id);

ALTER TABLE reis
  ADD CONSTRAINT reis_ibfk_1 FOREIGN KEY
  (transportmiddel_id) REFERENCES transportmiddel (id),
  ADD CONSTRAINT reis_ibfk_2 FOREIGN KEY
  (vertrek_id) REFERENCES locatie (id),
  ADD CONSTRAINT reis_ibfk_3 FOREIGN KEY
  (bestemming_id) REFERENCES  locatie (id);

CREATE TABLE boeking (
  id  int(11) NOT NULL AUTO_INCREMENT,
  gebruikerId int(11) NOT NULL,
  reisId int(11) NOT NULL,
  aantalPersonen int(11) NOT NULL,
  opmerking varchar(255) DEFAULT NULL,
  betalingId int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE betaling (
  id  int(11) NOT NULL AUTO_INCREMENT,
  datum DATETIME NOT NULL,
  betalingsType_id int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE boeking
  ADD KEY gebruikerId (gebruikerId),
  ADD KEY reisId (reisId),
  ADD KEY betalingId (betalingId);

ALTER TABLE boeking
  ADD CONSTRAINT boeking_ibfk_1 FOREIGN KEY
  (gebruikerId) REFERENCES gebruiker (id),
  ADD CONSTRAINT boeking_ibfk_2 FOREIGN KEY
  (reisId) REFERENCES reis (id),
  ADD CONSTRAINT boeking_ibfk_3 FOREIGN KEY
  (betalingId) REFERENCES  betaling (id);

CREATE TABLE betalingstype (
  id  int(11) NOT NULL AUTO_INCREMENT,
  naam varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE betaling
  ADD KEY betalingsType_id (betalingsType_id);

ALTER TABLE betaling
  ADD CONSTRAINT betaling_ibfk_2 FOREIGN KEY
  (betalingsType_id) REFERENCES betalingstype (id);

INSERT INTO `betalingstype` (`id`, `naam`) VALUES
	(1, 'bancontact'),
	(2, 'paypal'),
	(3, 'visa');

INSERT INTO `locatie` (`id`, `naam`) VALUES
	(1, 'Geel'),
	(2, 'Parijs'),
	(3, 'Brussel'),
	(4, 'Berlijn');

INSERT INTO `transportmiddel` (`id`, `naam`) VALUES
	(1, 'Auto'),
	(2, 'Vliegtuig'),
	(3, 'Bus');

INSERT INTO `rol` (`id`, `naam`) VALUES
	(1, 'Gebruiker'),
	(2, 'Admin'),
	(3, 'Bezoeker');


INSERT INTO `gebruiker` (`id`, `rolId`, `naam`, `adres`, `woonplaats`, `email`, `wachtwoord`) VALUES
	(1, 1, 'Dylan', 'Kleinhoefstraat', 'Geel', 'dylanver@live.be', 'test'),
	(7, 1, 'User', 'Kleinhoefstraat', 'Geel', 'user@travelmore.be', 'ThomasMore1'),
  (2, 1, 'Sander', 'Pauwbroekstraat 45', 'Ham', 'sander.philipsen@hotmail.com', 'ThomasMore1'),
  (5, 1, 'Tom', 'Dorpstraat 10', 'Ham', 'tom@gmail.com', 'test') ,
  (6, 1, 'Sander', 'Pauwbroekstraat 45', 'Ham', 'sander.philipsen@hotmail.com', 'test'),
  (3, 2, 'admin', 'Dorpstraat 45', 'Geel', 'admin@travelmore.be', 'ThomasMore1'),
  (4, 2, 'admin2', 'Kleinhoefstraat 4', 'Geel', 'admin2@travelmore.be', 'ThomasMore1');

INSERT INTO `reis` (`id`, `naam`, `afbeelding`, `vertrek_id`, `bestemming_id`, `aantalPlaatsen`, `kostprijs`, `startdatum`, `einddatum`, `transportmiddel_id`) VALUES
	(2, 'Reis naar Parijs', 'parijs.jpg', 2, 2, 10, 249, '2018-01-01 00:00:00', '2018-01-07 00:00:00', 1),
	(3, 'Driedaagse naar Berlijn', 'berlijn.jpg', 3, 4, 25, 399, '2018-01-08 00:00:00', '2018-01-11 00:00:00', 2),
	(4, 'Reis naar Geel', 'geel.jpg', 1, 1, 5, 150, '2018-01-23 00:00:00', '2018-01-25 00:00:00', 3);


COMMIT;

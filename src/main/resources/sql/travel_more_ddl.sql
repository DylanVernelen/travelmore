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
  vertrekId int(11) NOT NULL,
  bestemmingId int(11) NOT NULL,
  aantalPlaatsen int(11) NOT NULL,
  kostprijs double NOT NULL,
  startdatum datetime NOT NULL,
  einddatum datetime NOT NULL,
  transportmiddelId int(11) NOT NULL,
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
  ADD KEY transportmiddelId (transportmiddelId),
  ADD KEY vertrekId (vertrekId),
  ADD KEY bestemmingId (bestemmingId);

ALTER TABLE reis
  ADD CONSTRAINT reis_ibfk_1 FOREIGN KEY
  (transportmiddelId) REFERENCES transportmiddel (id),
  ADD CONSTRAINT reis_ibfk_2 FOREIGN KEY
  (vertrekId) REFERENCES locatie (id),
  ADD CONSTRAINT reis_ibfk_3 FOREIGN KEY
  (bestemmingId) REFERENCES  locatie (id);

CREATE TABLE boeking (
  id  int(11) NOT NULL AUTO_INCREMENT,
  gebruikersId int(11) NOT NULL,
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
  betalingstypeId int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE boeking
  ADD KEY gebruikersId (gebruikersId),
  ADD KEY reisId (reisId),
  ADD KEY betalingId (betalingId);

ALTER TABLE boeking
  ADD CONSTRAINT boeking_ibfk_1 FOREIGN KEY
  (gebruikersId) REFERENCES gebruiker (id),
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
  ADD KEY betalingstypeId (betalingstypeId);

ALTER TABLE betaling
  ADD CONSTRAINT betaling_ibfk_1 FOREIGN KEY
  (boekingId) REFERENCES boeking (id),
  ADD CONSTRAINT betaling_ibfk_2 FOREIGN KEY
  (betalingstypeId) REFERENCES betalingstype (id);

COMMIT;

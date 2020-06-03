-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema grupo-8-bdd-oo2-2020
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema grupo-8-bdd-oo2-2020
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grupo-8-bdd-oo2-2020` DEFAULT CHARACTER SET latin1 ;
USE `grupo-8-bdd-oo2-2020` ;

-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`store` (
  `id_store` BIGINT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `latitude` DOUBLE NULL DEFAULT NULL,
  `longitude` DOUBLE NULL DEFAULT NULL,
  `phone` BIGINT NULL DEFAULT NULL,
  `distance` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id_store`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`product` (
  `id_product` BIGINT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `size` VARCHAR(255) NULL DEFAULT NULL,
  `start_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`batch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`batch` (
  `id_batch` BIGINT NOT NULL AUTO_INCREMENT,
  `active` BIT(1) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `quantities` INT NULL DEFAULT NULL,
  `quantity` INT NULL DEFAULT NULL,
  `product_id_product` BIGINT NULL DEFAULT NULL,
  `store_id` BIGINT NOT NULL,
  PRIMARY KEY (`id_batch`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`person` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `date_birth` DATE NULL DEFAULT NULL,
  `dni` BIGINT NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `surname` VARCHAR(255) NULL DEFAULT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`client` (
  `mail` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`employee` (
  `basic_salary` DOUBLE NOT NULL,
  `commission` DOUBLE NOT NULL,
  `end_time` TIME NULL DEFAULT NULL,
  `manager` BIT(1) NOT NULL,
  `start_time` TIME NULL DEFAULT NULL,
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`pedido` (
  `id_pedido` BIGINT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `product_id_product` BIGINT NULL DEFAULT NULL,
  `store_id_store` BIGINT NULL DEFAULT NULL,
   `aceptado` BOOLEAN not null,
  
  PRIMARY KEY (`id_pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `grupo-8-bdd-oo2-2020`.`stock_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-8-bdd-oo2-2020`.`stock_request` (
  `id_stock_request` BIGINT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `id_collaborator` BIGINT NULL DEFAULT NULL,
  `employee_id` BIGINT NULL DEFAULT NULL,
  `product_id_product` BIGINT NULL DEFAULT NULL,
  `store1_id_store` BIGINT NULL DEFAULT NULL,
  `store2_id_store` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_stock_request`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES(1,'zapatilla Air max',3500.0,'41','2011-12-18'),(2,'Ojotas Crocs',3500.0,'41','2011-12-18'),(3,'Gorra Jordan',3200.0,'41','2011-12-18'),(4,'buzo dri-fit',1500.0,'l','2011-12-18'),(5,'remera slim-fit',950.0,'l','2011-12-18');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM product;

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'2011-12-18 13:17:16','1991-01-19',36363056,'facundo','cusato','2011-12-18 13:17:16'),(2,'2011-12-18 13:20:16','1989-03-19',34363156,'marianela','cusato','2011-12-18 13:20:16'),(3,'2011-12-18 20:17:16','1992-08-29',34380056,'yuliana','cusato','2011-12-18 20:17:16'),(4,'2011-12-18 20:20:16','1994-08-29',34215056,' Juan Roman','Riquelme','2011-12-18 20:17:16'),(5,'2012-01-18 13:27:16','1991-01-19',38243056,'Martin','Palermo','2012-01-18 13:27:16'),(6,'2012-02-18 13:17:16','1994-01-19',31263058,'Oscar','Cordoba','2012-02-18 13:17:16'),(7,'2012-03-18 13:27:16','1993-11-19',36133056,'Mauricio','Serna','2012-03-18 13:27:16'),(8,'2012-08-18 13:25:16','1991-01-19',31353028,'Sebastian','Bataglia','2012-08-18 13:25:16');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM person;


LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('facundocusato@hotmail.com',1),('marianelacusato@gmail.com',2);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM client;


LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'Tucuman 2398',35,31,1124369587,0),(2,'Pergamino 2410',34,28,1128569587,0),(3,'29 de Septiembre',34.6,31.5,1128587500,0);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM store;


LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (42000.0,1900.0,'18:00:00',TRUE,'06:00:00',3,1),(64000.0,1400.0,'19:00:00',TRUE,'06:00:00',4,2),(74000.0,1400.0,'19:00:00',TRUE,'07:00:00',5,3),(24000.0,2400.0,'18:00:00',FALSE,'08:00:00',6,1),(28000.0,1800.0,'19:30:00',FALSE,'07:30:00',7,2),(30000.0,2200.0,'18:30:00',FALSE,'06:30:00',8,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM employee;

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (1,TRUE,'2011-12-18',20,20,1,1),(2,TRUE,'2011-12-24',18,18,2,1),(3,TRUE,'2011-12-18',7,7,3,1),(4,TRUE,'2011-12-24',8,8,4,2),(5,TRUE,'2012-01-24',28,28,1,2),(6,TRUE,'2012-08-24',15,15,1,1),(7,TRUE,'2012-02-21',24,24,2,2),(8,TRUE,'2012-10-23',58,58,1,3);
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM batch;

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,18,1,1,true);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

SELECT *FROM pedido;
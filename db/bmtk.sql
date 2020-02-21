-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bmtkdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bmtkdb` ;

-- -----------------------------------------------------
-- Schema bmtkdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bmtkdb` DEFAULT CHARACTER SET utf8 ;
USE `bmtkdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(10) NULL,
  `payment_method` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `active` TINYINT NOT NULL,
  `role` ENUM('customer', 'employee', 'manager') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `type` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task` ;

CREATE TABLE IF NOT EXISTS `task` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `due_date` VARCHAR(20) NOT NULL,
  `paid` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task_detail` ;

CREATE TABLE IF NOT EXISTS `task_detail` (
  `id` INT NOT NULL,
  `start_date` VARCHAR(45) NULL,
  `complete_date` VARCHAR(45) NULL,
  `status` ENUM('not-assigned', 'assigned', 'in-progress', 'complete') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `user` (`id`, `name`, `address`, `email`, `phone`, `payment_method`, `username`, `password`, `active`, `role`) VALUES (1, 'admin', NULL, 'admin@admin.com', NULL, NULL, 'admin', 'admin', 1, 'manager');

COMMIT;


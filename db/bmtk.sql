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
-- Table `user_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_detail` ;

CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `zipcode` VARCHAR(5) NULL,
  `country` VARCHAR(45) NULL,
  `phone` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `active` TINYINT NOT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `user_detail_id` INT NOT NULL,
  `role` ENUM('admin', 'user') NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_user_user_detail1_idx` (`user_detail_id` ASC),
  CONSTRAINT `fk_user_user_detail1`
    FOREIGN KEY (`user_detail_id`)
    REFERENCES `user_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `payment_method` VARCHAR(45) NULL,
  `user_detail_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_user_detail1_idx` (`user_detail_id` ASC),
  CONSTRAINT `fk_customer_user_detail1`
    FOREIGN KEY (`user_detail_id`)
    REFERENCES `user_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `company` ;

CREATE TABLE IF NOT EXISTS `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `description` VARCHAR(500) NULL,
  `company_url` VARCHAR(500) NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project` ;

CREATE TABLE IF NOT EXISTS `project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `customer_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_project_customer1_idx` (`customer_id` ASC),
  INDEX `fk_project_company1_idx` (`company_id` ASC),
  CONSTRAINT `fk_project_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task` ;

CREATE TABLE IF NOT EXISTS `task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(1000) NULL,
  `due_date` VARCHAR(20) NULL,
  `paid` TINYINT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `template` TINYINT NULL,
  `start_date` VARCHAR(45) NULL,
  `complete_date` VARCHAR(45) NULL,
  `status` ENUM('NOTASSIGNED', 'ASSIGNED', 'INPROGRESS', 'COMPLETE') NULL,
  `type` VARCHAR(45) NULL,
  `priority` VARCHAR(45) NULL,
  `payment_detail` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `project_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_task_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_task_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee` ;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_detail_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_user_detail1_idx` (`user_detail_id` ASC),
  INDEX `fk_employee_company1_idx` (`company_id` ASC),
  CONSTRAINT `fk_employee_user_detail1`
    FOREIGN KEY (`user_detail_id`)
    REFERENCES `user_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_item` ;

CREATE TABLE IF NOT EXISTS `inventory_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `quantity` INT NULL,
  `value` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `owner` ;

CREATE TABLE IF NOT EXISTS `owner` (
  `company_id` INT NOT NULL,
  `user_detail_id` INT NOT NULL,
  PRIMARY KEY (`company_id`, `user_detail_id`),
  INDEX `fk_company_has_user_detail_user_detail1_idx` (`user_detail_id` ASC),
  INDEX `fk_company_has_user_detail_company1_idx` (`company_id` ASC),
  CONSTRAINT `fk_company_has_user_detail_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_has_user_detail_user_detail1`
    FOREIGN KEY (`user_detail_id`)
    REFERENCES `user_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task_has_inventory_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task_has_inventory_item` ;

CREATE TABLE IF NOT EXISTS `task_has_inventory_item` (
  `task_id` INT NOT NULL,
  `inventory_item_id` INT NOT NULL,
  PRIMARY KEY (`task_id`, `inventory_item_id`),
  INDEX `fk_task_has_inventory_item_inventory_item1_idx` (`inventory_item_id` ASC),
  INDEX `fk_task_has_inventory_item_task1_idx` (`task_id` ASC),
  CONSTRAINT `fk_task_has_inventory_item_task1`
    FOREIGN KEY (`task_id`)
    REFERENCES `task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_has_inventory_item_inventory_item1`
    FOREIGN KEY (`inventory_item_id`)
    REFERENCES `inventory_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employee_has_task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employee_has_task` ;

CREATE TABLE IF NOT EXISTS `employee_has_task` (
  `employee_id` INT NOT NULL,
  `task_id` INT NOT NULL,
  PRIMARY KEY (`employee_id`, `task_id`),
  INDEX `fk_employee_has_task_task1_idx` (`task_id` ASC),
  INDEX `fk_employee_has_task_employee1_idx` (`employee_id` ASC),
  CONSTRAINT `fk_employee_has_task_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_has_task_task1`
    FOREIGN KEY (`task_id`)
    REFERENCES `task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `user_detail`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (1, 'adminFirst', 'adminLast', 'admin@admin.com', '12345', NULL, '80111', 'US', '5555555555');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (2, 'ownerFirst', 'ownerLast', 'owner@owner.com', '123456', 'denver', '80111', 'US', '5555555555');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (3, 'empFirst', 'empLast', 'emp@emp.com', '1234567', 'denver', '80237', 'US', '3333333333');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (4, 'userFirst', 'userLast', 'user@user.com', '123', 'denver', '80111', 'US', '2222222222');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (5, 'Mary', 'Sanders', 'marysanders@gmail.com', '5944 round rock street', 'boulder', '80301', 'US', '8546733211');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (6, 'Mark', 'Wayside', 'markwayside@gmail.com', '8711 hay street', 'dallas', '75001', 'US', '8176819021');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (7, 'Bill', 'Jacobs', 'billjacobs@gmail.com', '3498 mill street', 'denver', '80111', 'US', '2543618355');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (8, 'John', 'Pine', 'johnpine@gmail.com', ' 5341 north street', 'denver', '80111', 'US', '6537912333');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (9, 'Ann', 'Good', 'anngood@gmail.com', '7834 bell street', 'denver', '80111', 'US', '9325812312');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (10, 'Sarah', 'Walker', 'sarahwalker@gmail.com', '321 high street', 'denver', '80111', 'US', '6234117553');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (11, 'Gary', 'Newland', 'garynewland@gmail.com', '734 dryer street', 'denver', '80111', 'US', '8745557433');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (12, 'Joe', 'Keppler', 'joekeppler@gmail.com', '632 green street', 'denver', '80111', 'US', '2546719233');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (13, 'Sam', 'Miller', 'sammiller@gmail.com', '7822 hill street', 'denver', '80111', 'US', '6234778211');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (14, 'Diane', 'Weller', 'dianeweller@gmail.com', '7188 bell street', 'denver', '80111', 'US', '6123776399');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (15, 'Matt', 'Simmons', 'mattsimmons@gmail.com', '832 elm street', 'denver', '80111', 'US', '6234517288');
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `street`, `city`, `zipcode`, `country`, `phone`) VALUES (16, 'Harold', 'Mole', 'haroldmole@gmail.com', '8732 copper street', 'denver', '80111', 'US', '9345612544');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (1, 'admin', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 1, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (2, 'testowner', '$2a$10$MEf8iCwCd8acksi2w6Vgw./gIFv4qXpjUfv3EwNF6AFFHPqECgi/a', 1, NULL, NULL, 2, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (3, 'testemp', '$2a$10$jNuLJEvyoH5gNB7QkEPYveqetgbFKI..2ghUH0/kniY3hZ/QgSD0.', 1, NULL, NULL, 3, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (4, 'testuser', '$2a$10$gvjch3eQpa.sPm2Z0wcG9e4CDuk0YdjUl3dKIGOpnyeM.fHYoEraO', 1, NULL, NULL, 4, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (5, 'killbill', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 5, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (6, 'killbill2', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 6, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (7, 'killbill3', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 7, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (8, 'killbill4', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 8, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (9, 'killbill5', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 9, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (10, 'killbill6', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 10, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (11, 'killbill7', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 11, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (12, 'killbill8', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 12, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (13, 'killbill9', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 13, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (14, 'killbill10', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 14, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (15, 'killbill11', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 15, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `active`, `created_at`, `updated_at`, `user_detail_id`, `role`) VALUES (16, 'killbill12', '$2a$10$3jkVrSRhKouYOYrvIhBLOeWCFOxw6a/nIyId8xRSYB42YWHWVQ8ke', 1, NULL, NULL, 16, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (1, 'paypal', 4, 1);
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (2, 'paypal', 11, 1);
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (3, 'paypal', 12, 1);
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (4, 'paypal', 13, 1);
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (5, 'paypal', 14, 1);
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (6, 'paypal', 15, 1);
INSERT INTO `customer` (`id`, `payment_method`, `user_detail_id`, `active`) VALUES (7, 'paypal', 16, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `company`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (1, 'Test Company', 'Construction', '12345 test st', '5554443333', 'test description', NULL, DEFAULT);
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (2, 'Bob\'s Plumbing', 'Plumbing', '34 pipe st, Denver, CO,  80014', '8176534591', 'All residential plumbing work from new construction to remodeling to repairs. Free estimates. We supply fixtures. ', 'bobsplumbing.com', 1);
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (3, 'Fast Action Painting', 'Painting', '571 white street, Dallas, TX, 75001', '6239456789', 'All residential painting, interior or exterior, new construction or remodeling.  Barns, houses, workshops. ', 'fastactionpainting.com', 1);
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (4, 'County HVAC Service', 'HVAC', '9231 snow street, Alma, CO, 80420', '3256718324', 'Residential and commercial HVAC repair. We install new units. $75 estimate fee is applied towards work order. All of our work is guaranteed. ', 'countyhvac.com', 1);
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (5, 'Long Valley Surveying', 'Surveying', '7541 west street,  Broomfield , CO 80020 ', '4578934581', 'Land surveys, property lines verified, land subdivided. We can handle all of your surveying needs. ', 'longvalleysurveying.com', 1);
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (6, 'Hot Switch Electric', 'Electrician', '6324 cherry street, Georgetown, CO, 80444', '9514359111', 'Licensed electricians. Commercial and Residential. Repairs, Remodeling, New Construction. Call to schedule an estimate. ', 'hotswitchelectic.com', 1);
INSERT INTO `company` (`id`, `name`, `type`, `address`, `phone`, `description`, `company_url`, `active`) VALUES (7, 'Uptown Catering', 'Catering', '89324 Hill Street, Boulder, CO,  80301', '5678213733', 'Catering for events, parties, and business meetings. ', 'uptowncatering.com', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `project`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (1, 'Test Project', 1, 1, 1);
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (2, 'new bathroom', 2, 2, 1);
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (3, 'paint house exterior', 3, 3, 1);
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (4, 'new compressor', 4, 4, 1);
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (5, 'land survey', 5, 5, 1);
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (6, 'breaker box in workshop', 6, 6, 1);
INSERT INTO `project` (`id`, `name`, `customer_id`, `company_id`, `active`) VALUES (7, 'birthday party', 7, 7, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `task`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (1, 'test task', 'task description', '02-29-2020', 0, NULL, NULL, NULL, NULL, NULL, 'ASSIGNED', NULL, 'high', NULL, 1000.00, 1, 1);
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (2, 'bathroom remodel', 'total bathroom remodel. New toilet, sink and shower stall. Location: 654 Beverly Street Denver CO 80111', '03-05-2020', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 50000.00, 2, 1);
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (3, 'paint house exterior', 'Paint all of house exterior. Customer not supplying any materials. Location: 3285 Stone Street Denver CO 80111 ', '03-10-2020', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3500.00, 3, 1);
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (4, 'HVAC unit new compressor', 'Trane Model 588A year 2001 needs new compressor. Location: 544 Hill Street, Denver CO. 80111', '03-01-2020', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 850.00, 4, 1);
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (5, 'subdiving lot', 'residental lot subdivision. 576 gaylord street. 5 acres to be divided into 7 lots. Drawings on location. ', '03-05-2020', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2500.00, 5, 1);
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (6, 'new breaker box', 'Workshop at 5699 elm street needs a larger breaker box so that additional relays may be installed. ', '03-08-2020', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 900.00, 6, 1);
INSERT INTO `task` (`id`, `name`, `description`, `due_date`, `paid`, `created_at`, `updated_at`, `template`, `start_date`, `complete_date`, `status`, `type`, `priority`, `payment_detail`, `price`, `project_id`, `active`) VALUES (7, 'birthday party', 'sweet 16 party. Location: 6500 Grand Plaza suite 400 Denver CO. 25 guests. American food and cake. ', '03-07-2020', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 375.00, 7, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `employee` (`id`, `user_detail_id`, `company_id`, `active`) VALUES (1, 3, 1, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `inventory_item` (`id`, `name`, `quantity`, `value`) VALUES (1, 'test item', 10, 20.00);

COMMIT;


-- -----------------------------------------------------
-- Data for table `owner`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (1, 2);
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (2, 5);
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (3, 6);
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (4, 7);
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (5, 8);
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (6, 9);
INSERT INTO `owner` (`company_id`, `user_detail_id`) VALUES (7, 10);

COMMIT;


-- -----------------------------------------------------
-- Data for table `task_has_inventory_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `task_has_inventory_item` (`task_id`, `inventory_item_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `employee_has_task`
-- -----------------------------------------------------
START TRANSACTION;
USE `bmtkdb`;
INSERT INTO `employee_has_task` (`employee_id`, `task_id`) VALUES (1, 1);

COMMIT;


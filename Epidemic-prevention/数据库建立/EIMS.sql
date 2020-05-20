CREATE SCHEMA `eims` ;
CREATE TABLE `eims`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `id_type` SMALLINT(3) NOT NULL,
  `id_num` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `sex` TINYINT NULL,
  `birthday` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `isAdmin` TINYINT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
COMMENT = '		';

CREATE TABLE `eims`.`symp` (
  `symptom_id` INT NOT NULL,
  `symptom_name` VARCHAR(45) NULL,
  PRIMARY KEY (`symptom_id`))
COMMENT = '		';
CREATE TABLE `eims`.`health_report` (
  `report_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `city` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `detail_ad` VARCHAR(45) NULL,
  `organization` VARCHAR(45) NULL,
  `personelType` SMALLINT(8) NULL,
  `isolate` TINYINT NULL,
  `residentType` SMALLINT(8) NULL,
  `symptom_id` INT NULL,
  `description` VARCHAR(45) NULL,
  `isfever` TINYINT NULL,
  `isChecked` TINYINT NULL,
  `isNeedHelp` VARCHAR(45) NULL,
  `report_time` DATETIME NULL,
  PRIMARY KEY (`report_id`, `user_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `eims`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `eims`.`health_report` 
ADD INDEX `ddd_idx` (`symptom_id` ASC) VISIBLE;
;
ALTER TABLE `eims`.`health_report` 
ADD CONSTRAINT `symptom_id`
  FOREIGN KEY (`symptom_id`)
  REFERENCES `eims`.`symp` (`symptom_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `eims`.`symp_report` (
  `symptom_id` INT NOT NULL,
  `report_id` INT NOT NULL,
  PRIMARY KEY (`symptom_id`, `report_id`),
  INDEX `r_idx` (`report_id` ASC) VISIBLE,
  CONSTRAINT `s`
    FOREIGN KEY (`symptom_id`)
    REFERENCES `eims`.`symp` (`symptom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `r`
    FOREIGN KEY (`report_id`)
    REFERENCES `eims`.`health_report` (`report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `eims`.`trip` (
  `trip_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `from` VARCHAR(45) NULL,
  `depart_date` DATETIME NULL,
  `destination` VARCHAR(45) NULL,
  `arrive_date` DATETIME NULL,
  `transportation` VARCHAR(45) NULL,
  `trans_no` VARCHAR(45) NULL,
  `stayday` INT NULL,
  `resident` VARCHAR(45) NULL,
  PRIMARY KEY (`trip_id`, `user_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id1`
    FOREIGN KEY (`user_id`)
    REFERENCES `eims`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `eims`.`contact` (
  `contact_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `id_num` VARCHAR(45) NULL,
  `relationship` VARCHAR(45) NULL,
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`contact_id`, `user_id`),
  INDEX `user_id2_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id2`
    FOREIGN KEY (`user_id`)
    REFERENCES `eims`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    CREATE TABLE `eims`.`mask_order` (
  `order_id` INT NOT NULL,
  `store_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `id_type` SMALLINT(3) NULL,
  `id_number` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`order_id`));

CREATE TABLE `eims`.`store_info` (
  `store_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `order` INT NULL,
  PRIMARY KEY (`store_id`));

ALTER TABLE `eims`.`mask_order` 
ADD INDEX `store_id_idx` (`store_id` ASC) VISIBLE;
;
ALTER TABLE `eims`.`mask_order` 
ADD CONSTRAINT `store_id`
  FOREIGN KEY (`store_id`)
  REFERENCES `eims`.`store_info` (`store_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `eims`.`user` 
CHANGE COLUMN `birthday` `birthday` DATE NULL DEFAULT NULL ;
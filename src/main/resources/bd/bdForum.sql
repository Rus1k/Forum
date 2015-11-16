CREATE DATABASE forum;
CREATE USER 'forum_admin'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON forum.* TO 'forum_admin'@'localhost';
USE forum;

CREATE TABLE `account` (
  `id_account` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` int(20) NOT NULL,
  PRIMARY KEY (`id_account`))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `themes` (
  `id_theme` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `id_account_idx_theme` int(11) NOT NULL,
  PRIMARY KEY (`id_theme`),
  UNIQUE KEY `id_account_idx_theme` (`id_account_idx_theme`),
  CONSTRAINT `id_account_idx_theme`
  FOREIGN KEY (`id_account_idx_theme`)
  REFERENCES `account` (`id_account`) ON DELETE NO ACTION ON UPDATE NO ACTION)
  ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `id_user_info` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(64) NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `id_account` int(11) NOT NULL,
  PRIMARY KEY (`id_user_info`),
  KEY `id_account_idx` (`id_account`),
  CONSTRAINT `id_account`
  FOREIGN KEY (`id_account`)
  REFERENCES `account` (`id_account`) ON DELETE NO ACTION ON UPDATE NO ACTION)
  ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `posts` (
  `id_post` INT NOT NULL AUTO_INCREMENT,
  `text` BLOB NOT NULL,
  `date` DATE NOT NULL,
  `id_account_idx_post` INT NOT NULL,
  `id_theme_idx_post` INT NOT NULL,
  PRIMARY KEY (`id_post`),
  INDEX `id_theme_idx_post` (`id_theme_idx_post` ASC),
  INDEX `id_account_idx_post` (`id_account_idx_post` ASC),
  CONSTRAINT `id_theme_idx_post`
  FOREIGN KEY (`id_theme_idx_post`)
  REFERENCES `themes` (`id_theme`)ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_account_idx_post`
  FOREIGN KEY (`id_account_idx_post`)
  REFERENCES `account` (`id_account`)
  ON DELETE NO ACTION ON UPDATE NO ACTION)
  ENGINE = InnoDBDEFAULT CHARACTER SET = utf8;
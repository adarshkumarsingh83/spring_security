DROP TABLE IF EXISTS `user_role_mapping`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE  `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` datetime DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `firstName` varchar(24) NOT NULL,
  `lastName` varchar(24) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `userName` varchar(24) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  `user_role_mapping` (
  `users_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL,
  PRIMARY KEY (`users_id`,`roles_id`),
  KEY `FK5D9A9F9D34636D7` (`roles_id`),
  KEY `FK5D9A9F9492CD16` (`users_id`),
  CONSTRAINT `FK5D9A9F9492CD16` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK5D9A9F9D34636D7` FOREIGN KEY (`roles_id`) REFERENCES `user_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users`(`id`,`dob`,`email`,`enabled`,`firstName`,`lastName`,`password`,`phoneNumber`,`userName`)
VALUES(1,NULL,'Adarsh@Adarsh-1159',1,'adarsh','kumar','97d9de758e20f8e5a74c21ba389fb562','99999999999','adarsh'),
      (2,NULL,'admin@localhost.com',1,'amit','kumar','0cb1eb413b8f7cee17701a37a1d74dc3','99999999999','amit'),
      (3,NULL,'user@localhost.com',1,'radha','singh','0280a430e35fee634f01cbc5a8178864','99999999999','radha');

INSERT INTO `user_roles` (`id`,`name`)
VALUES (1,'ROLE_SUPERADMIN'),
       (2,'ROLE_ADMIN'),
       (3,'ROLE_USER');

INSERT INTO `user_role_mapping` (`users_id`,`roles_id`)
VALUES (1,1),
       (2,2),
       (3,3);

DROP TABLE IF EXISTS `employee_department_mapping`;
DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `department`;

CREATE TABLE  `employee` (
  `employeeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateOfJoining` datetime DEFAULT NULL,
  `employeeEmail` varchar(24) NOT NULL,
  `employeeName` varchar(24) NOT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeEmail_` (`employeeEmail`),
  UNIQUE KEY `employeeName_` (`employeeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  `department` (
  `departmentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(30) NOT NULL,
  `departmentLocation` varchar(40) NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  `employee_department_mapping` (
  `employee_employeeId` bigint(20) NOT NULL,
  `department_departmentId` bigint(20) NOT NULL,
  PRIMARY KEY (`employee_employeeId`,`department_departmentId`),
  KEY `FKE473E612F607A6E5` (`department_departmentId`),
  KEY `FKE473E612A9F42341` (`employee_employeeId`),
  CONSTRAINT `FKE473E612A9F42341` FOREIGN KEY (`employee_employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `FKE473E612F607A6E5` FOREIGN KEY (`department_departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `employee`(`employeeId`,`dateOfJoining`,`employeeEmail`,`employeeName`)
VALUES(1,'1983-09-13 00:00:00','Adarsh@Adarsh-1159','adarsh'),
      (2,'1986-01-04 00:00:00','admin@localhost.com','amit'),
      (3,'1986-04-05 00:00:00','radha@localhost.com','radha'),
      (4,'1983-09-13 00:00:00','user@localhost4.com','user4'),
      (5,'1983-09-13 00:00:00','user@localhost5.com','user5'),
      (6,'1983-09-13 00:00:00','user@localhost6.com','user6'),
      (7,'1983-09-13 00:00:00','user@localhost7.com','user7'),
      (8,'1983-09-13 00:00:00','user@localhost8.com','user8');

INSERT INTO `department` (`departmentId`,`departmentName`,`departmentLocation`)
VALUES (1,'IT','INDIA'),
       (2,'ACCOUNT','USA'),
       (3,'IT','UK');


INSERT INTO `employee_department_mapping` (`employee_employeeId`,`department_departmentId`)
VALUES (1,1),
       (2,2),
       (3,3),
       (4,1),
       (5,1),
       (6,2),
       (7,2),
       (8,3);

DROP TABLE IF EXISTS `espark`.`user_roles`;
DROP TABLE IF EXISTS `espark`.`users`;


CREATE TABLE  `espark`.`users` (
  `USER_ID` int(10) unsigned NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE  `espark`.`user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO espark.users (USER_ID, USERNAME,PASSWORD, ENABLED)
VALUES (100, 'adarsh', 'radha', TRUE);

INSERT INTO espark.users (USER_ID, USERNAME,PASSWORD, ENABLED)
VALUES (101, 'admin', 'admin', TRUE);

INSERT INTO espark.users (USER_ID, USERNAME,PASSWORD, ENABLED)
VALUES (102, 'user', 'user', TRUE);

INSERT INTO espark.user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (1, 100, 'ROLE_SUPERADMIN');

INSERT INTO espark.user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (2, 101, 'ROLE_ADMIN');

INSERT INTO espark.user_roles (USER_ROLE_ID, USER_ID,AUTHORITY)
VALUES (3, 102, 'ROLE_USER');
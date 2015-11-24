DROP TABLE IF EXISTS `user_role_mapping`;
DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE  `user_roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(40) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `firstName` varchar(24) NOT NULL,
  `lastName` varchar(24) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `userName` varchar(24) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UK_mmns67o5v4bfippoqitu4v3t6` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE  `user_role_mapping` (
  `users_userId` int(11) NOT NULL,
  `roles_roleId` int(11) NOT NULL,
  PRIMARY KEY (`users_userId`,`roles_roleId`),
  KEY `FK_cwm9kmdajdn9njtt2j0bs4ghd` (`roles_roleId`),
  CONSTRAINT `FK_25kxdm37fsuejm1d4rigomla9` FOREIGN KEY (`users_userId`) REFERENCES `users` (`userId`),
  CONSTRAINT `FK_cwm9kmdajdn9njtt2j0bs4ghd` FOREIGN KEY (`roles_roleId`) REFERENCES `user_roles` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `users`
(`userId`,`email`,`enabled`,`firstName`,`lastName`,`password`,`phoneNumber`,`userName`)
VALUES(1,'adarh@kumar',0,'Adarsh','kumar','adarsh','999999999','adarsh'),
      (2,'amti@kumar',0,'Amit','kumar','amit','999999999','amit'),
      (3,'radha@singh',0,'Radha','Singh','singh','8888888','radha');

INSERT INTO `user_roles`
(`roleId`,`roleName`)
VALUES( 1 ,'ROLE_ADMIN'),
       ( 2 ,'ROLE_USER');


INSERT INTO `user_role_mapping`
(`users_userId`,`roles_roleId`)
VALUES(1,1),
      (1,2),
      (2,2),
      (3,2),
	    (3,1);
DROP TABLE IF EXISTS `permission_group_permission`;
DROP TABLE IF EXISTS `user_permission_group`;
DROP TABLE IF EXISTS `permission_group`;
DROP TABLE IF EXISTS `permission`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE  `permission` (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_category` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  UNIQUE KEY `UK_permission_name` (`permission_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE  `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email_address` varchar(100) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `password` longtext,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE  `permission_group` (
  `permission_group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_group_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_group_id`),
  UNIQUE KEY `UK_permission_group_name` (`permission_group_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE  `permission_group_permission` (
  `permission_group_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  KEY `FK_permission_permission_id` (`permission_id`),
  KEY `FK_permission_group_permission_group_id` (`permission_group_id`),
  CONSTRAINT `FK_permission_group_permission_group_id` FOREIGN KEY (`permission_group_id`) REFERENCES `permission_group` (`permission_group_id`),
  CONSTRAINT `FK_permission_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE  `user_permission_group` (
  `user_id` bigint(20) NOT NULL,
  `permission_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`permission_group_id`,`user_id`),
  KEY `FK_user_user_id` (`user_id`),
  CONSTRAINT `FK_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_permissions_group_permissions_group_id` FOREIGN KEY (`permission_group_id`) REFERENCES `permission_group` (`permission_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permission (permission_name, permission_category)
VALUES ("ROLE_SUPERADMIN","USER")
       ,("ROLE_ADMIN","USER")
       ,("ROLE_USER","USER");
	   

INSERT INTO permission_group (permission_group_name) 
         VALUES  ("SUPERADMIN")
                ,("ADMIN")
                ,("USER");

INSERT INTO permission_group_permission (permission_group_id, permission_id)
VALUES ((SELECT permission_group_id FROM permission_group WHERE permission_group_name = "SUPERADMIN"),
	    (SELECT permission_id FROM permission WHERE permission_name = "ROLE_SUPERADMIN"));

INSERT INTO permission_group_permission (permission_group_id, permission_id) 
VALUES ((SELECT permission_group_id FROM permission_group WHERE permission_group_name = "ADMIN"),
	    (SELECT permission_id FROM permission WHERE permission_name = "ROLE_ADMIN"));	

INSERT INTO permission_group_permission (permission_group_id, permission_id)
VALUES ((SELECT permission_group_id FROM permission_group WHERE permission_group_name = "USER"),
	    (SELECT permission_id FROM permission WHERE permission_name = "ROLE_USER"));


INSERT INTO users (user_id, first_name, last_name, username, password, email_address)
 VALUES (1,  "Adarsh","Kumar","adarsh","adarsh","adarsh@kumar")
       ,(2,  "Radha","Singh","radha","radha","radha@singh")
       ,(3,  "Amit","Kumar","amit","amit","amit@kumar");

	
INSERT INTO user_permission_group (user_id, permission_group_id) VALUES (
    (SELECT user_id FROM users WHERE username = 'adarsh'),
    (SELECT permission_group_id FROM permission_group WHERE permission_group_name = 'SUPERADMIN'));

INSERT INTO user_permission_group (user_id, permission_group_id) VALUES (
    (SELECT user_id FROM users WHERE username = 'radha'),
    (SELECT permission_group_id FROM permission_group WHERE permission_group_name = 'ADMIN'));

INSERT INTO user_permission_group (user_id, permission_group_id) VALUES (
    (SELECT user_id FROM users WHERE username = 'amit'),
    (SELECT permission_group_id FROM permission_group WHERE permission_group_name = 'USER'));
CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256) NOT NULL,
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4000),
  autoapprove VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
);

CREATE TABLE IF NOT EXISTS oauth_code (
  code VARCHAR(256), authentication BLOB
);


INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, authorities, access_token_validity)
  VALUES ('espark-app', '{bcrypt}$2a$10$gPMrEzS0XiIXK.Fxvb9kceAQ0vEqBX4TijX5lBn.gmKTzKUsa1GuK', 'read,write', 'password,refresh_token,client_credentials', 'ROLE_CLIENT', 300);


CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(256) NOT NULL,
  password VARCHAR(256) NOT NULL,
  enabled TINYINT(1),
  UNIQUE KEY unique_username(username)
);

CREATE TABLE IF NOT EXISTS authorities (
  username VARCHAR(256) NOT NULL,
  authority VARCHAR(256) NOT NULL,
  PRIMARY KEY(username, authority)
);

INSERT INTO users (id, username, password, enabled) VALUES (1, 'adarsh', '{bcrypt}$2a$10$srocXYXb5Bfst1U2nSgoJOUT3FXDxWndwzzVnxTuxLiAuffhFU/LG', 1);
INSERT INTO users (id, username, password, enabled) VALUES (2, 'radha', '{bcrypt}$2a$10$zG8wDXX/hdywz.g.bFF7VOa4Lev8pEnMcygTuzQt18H0Ck7nJQf1S', 1);

INSERT INTO authorities (username, authority) VALUES ('adarsh', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('adarsh', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('radha', 'ROLE_USER');
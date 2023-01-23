DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (first_name, last_name, career) VALUES
  ('adarsh', 'kumar', 'It'),
  ('radha', 'singh', 'IT'),
  ('sonu', 'singh', 'IT'),
  ('amit', 'kumar', 'Finance');


DROP TABLE IF EXISTS userinfo;


CREATE TABLE userinfo (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  user_password VARCHAR(250) NOT NULL,
  user_role VARCHAR(250) DEFAULT NULL
);

-- INSERT INTO userinfo (user_name, user_password, user_role) VALUES
--  ('admin', '$2a$12$bWCcs.KexwuDk7QW8JmV7ecfv.D6psyI8tF0oRRK/5fx1N5dMGQt.', 'ROLE_ADMIN,ROLE_USER'),
--  ('user', '$2a$12$8gBmB5APZ2HQRBptB5rhjepMrm3p9/i1IYDCAZkoLHa69H61VeW/O', 'ROLE_USER');
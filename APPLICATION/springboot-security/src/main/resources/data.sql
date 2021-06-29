DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  profession VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (first_name, last_name,email, profession) VALUES
  ('adarsh', 'kumar','adarsh@kumar', 'It'),
  ('radha', 'singh','radha@singh', 'IT'),
  ('sonu', 'singh','sonu@singh', 'IT'),
  ('amit', 'kumar', 'amit@kumar','Finance');

CREATE DATABASE IF NOT EXISTS sample;

CREATE TABLE users (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  inquiry VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users (
  name,
  email,
  inquiry
) values (
  'aaa',
  'aa@aa.com',
  'aaaaa'
);